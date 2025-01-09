package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadoedad extends GXProcedure
{
   public empleadoedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadoedad.class ), "" );
   }

   public empleadoedad( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      empleadoedad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      empleadoedad.this.AV16CliCod = aP0;
      empleadoedad.this.AV17empcod = aP1;
      empleadoedad.this.AV8LegNumero = aP2;
      empleadoedad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P004T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV17empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P004T2_A6LegNumero[0] ;
         A1EmpCod = P004T2_A1EmpCod[0] ;
         A3CliCod = P004T2_A3CliCod[0] ;
         A246LegFecNac = P004T2_A246LegFecNac[0] ;
         GXt_dtime1 = GXutil.resetTime( A246LegFecNac );
         AV15Edad = GXutil.trim( GXutil.str( GXutil.age( GXt_dtime1, GXutil.now( )), 10, 0)) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empleadoedad.this.AV15Edad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Edad = "" ;
      scmdbuf = "" ;
      P004T2_A6LegNumero = new int[1] ;
      P004T2_A1EmpCod = new short[1] ;
      P004T2_A3CliCod = new int[1] ;
      P004T2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      A246LegFecNac = GXutil.nullDate() ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadoedad__default(),
         new Object[] {
             new Object[] {
            P004T2_A6LegNumero, P004T2_A1EmpCod, P004T2_A3CliCod, P004T2_A246LegFecNac
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV15Edad ;
   private String scmdbuf ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date A246LegFecNac ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P004T2_A6LegNumero ;
   private short[] P004T2_A1EmpCod ;
   private int[] P004T2_A3CliCod ;
   private java.util.Date[] P004T2_A246LegFecNac ;
}

final  class empleadoedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004T2", "SELECT LegNumero, EmpCod, CliCod, LegFecNac FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

