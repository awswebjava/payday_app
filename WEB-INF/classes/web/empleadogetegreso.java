package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadogetegreso extends GXProcedure
{
   public empleadogetegreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadogetegreso.class ), "" );
   }

   public empleadogetegreso( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     String[] aP3 )
   {
      empleadogetegreso.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             java.util.Date[] aP4 )
   {
      empleadogetegreso.this.AV13CliCod = aP0;
      empleadogetegreso.this.AV14empcod = aP1;
      empleadogetegreso.this.AV8LegNumero = aP2;
      empleadogetegreso.this.aP3 = aP3;
      empleadogetegreso.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00UA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00UA2_A6LegNumero[0] ;
         A1EmpCod = P00UA2_A1EmpCod[0] ;
         A3CliCod = P00UA2_A3CliCod[0] ;
         A1583LegMegCodigo = P00UA2_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P00UA2_n1583LegMegCodigo[0] ;
         A244LegFecEgreso = P00UA2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P00UA2_n244LegFecEgreso[0] ;
         AV12MegCodigo = A1583LegMegCodigo ;
         AV15LegFecEgreso = A244LegFecEgreso ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empleadogetegreso.this.AV12MegCodigo;
      this.aP4[0] = empleadogetegreso.this.AV15LegFecEgreso;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12MegCodigo = "" ;
      AV15LegFecEgreso = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00UA2_A6LegNumero = new int[1] ;
      P00UA2_A1EmpCod = new short[1] ;
      P00UA2_A3CliCod = new int[1] ;
      P00UA2_A1583LegMegCodigo = new String[] {""} ;
      P00UA2_n1583LegMegCodigo = new boolean[] {false} ;
      P00UA2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P00UA2_n244LegFecEgreso = new boolean[] {false} ;
      A1583LegMegCodigo = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadogetegreso__default(),
         new Object[] {
             new Object[] {
            P00UA2_A6LegNumero, P00UA2_A1EmpCod, P00UA2_A3CliCod, P00UA2_A1583LegMegCodigo, P00UA2_n1583LegMegCodigo, P00UA2_A244LegFecEgreso, P00UA2_n244LegFecEgreso
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV12MegCodigo ;
   private String scmdbuf ;
   private String A1583LegMegCodigo ;
   private java.util.Date AV15LegFecEgreso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean n1583LegMegCodigo ;
   private boolean n244LegFecEgreso ;
   private java.util.Date[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00UA2_A6LegNumero ;
   private short[] P00UA2_A1EmpCod ;
   private int[] P00UA2_A3CliCod ;
   private String[] P00UA2_A1583LegMegCodigo ;
   private boolean[] P00UA2_n1583LegMegCodigo ;
   private java.util.Date[] P00UA2_A244LegFecEgreso ;
   private boolean[] P00UA2_n244LegFecEgreso ;
}

final  class empleadogetegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UA2", "SELECT LegNumero, EmpCod, CliCod, LegMegCodigo, LegFecEgreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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

