package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getfecingreso extends GXProcedure
{
   public getfecingreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getfecingreso.class ), "" );
   }

   public getfecingreso( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 )
   {
      getfecingreso.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 )
   {
      getfecingreso.this.AV11CliCod = aP0;
      getfecingreso.this.AV10empcod = aP1;
      getfecingreso.this.AV8LegNumero = aP2;
      getfecingreso.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00VH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00VH2_A6LegNumero[0] ;
         A1EmpCod = P00VH2_A1EmpCod[0] ;
         A3CliCod = P00VH2_A3CliCod[0] ;
         A245LegFecIngreso = P00VH2_A245LegFecIngreso[0] ;
         AV9LegFecIngreso = A245LegFecIngreso ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getfecingreso.this.AV9LegFecIngreso;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LegFecIngreso = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00VH2_A6LegNumero = new int[1] ;
      P00VH2_A1EmpCod = new short[1] ;
      P00VH2_A3CliCod = new int[1] ;
      P00VH2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      A245LegFecIngreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getfecingreso__default(),
         new Object[] {
             new Object[] {
            P00VH2_A6LegNumero, P00VH2_A1EmpCod, P00VH2_A3CliCod, P00VH2_A245LegFecIngreso
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV9LegFecIngreso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00VH2_A6LegNumero ;
   private short[] P00VH2_A1EmpCod ;
   private int[] P00VH2_A3CliCod ;
   private java.util.Date[] P00VH2_A245LegFecIngreso ;
}

final  class getfecingreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VH2", "SELECT LegNumero, EmpCod, CliCod, LegFecIngreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

