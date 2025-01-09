package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legingresoegresoypreaviso extends GXProcedure
{
   public legingresoegresoypreaviso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legingresoegresoypreaviso.class ), "" );
   }

   public legingresoegresoypreaviso( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     java.util.Date[] aP3 ,
                                     String[] aP4 ,
                                     java.util.Date[] aP5 )
   {
      legingresoegresoypreaviso.this.aP6 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 ,
                        String[] aP4 ,
                        java.util.Date[] aP5 ,
                        java.util.Date[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 ,
                             String[] aP4 ,
                             java.util.Date[] aP5 ,
                             java.util.Date[] aP6 )
   {
      legingresoegresoypreaviso.this.AV13CliCod = aP0;
      legingresoegresoypreaviso.this.AV14empcod = aP1;
      legingresoegresoypreaviso.this.AV8LegNumero = aP2;
      legingresoegresoypreaviso.this.aP3 = aP3;
      legingresoegresoypreaviso.this.aP4 = aP4;
      legingresoegresoypreaviso.this.aP5 = aP5;
      legingresoegresoypreaviso.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01F72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01F72_A6LegNumero[0] ;
         A1EmpCod = P01F72_A1EmpCod[0] ;
         A3CliCod = P01F72_A3CliCod[0] ;
         A245LegFecIngreso = P01F72_A245LegFecIngreso[0] ;
         A1583LegMegCodigo = P01F72_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P01F72_n1583LegMegCodigo[0] ;
         A244LegFecEgreso = P01F72_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P01F72_n244LegFecEgreso[0] ;
         A1531LegFecPreAviso = P01F72_A1531LegFecPreAviso[0] ;
         AV18LegFecIngreso = A245LegFecIngreso ;
         AV12MegCodigo = A1583LegMegCodigo ;
         AV17LegFecEgreso = A244LegFecEgreso ;
         AV16LegFecPreAviso = A1531LegFecPreAviso ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = legingresoegresoypreaviso.this.AV18LegFecIngreso;
      this.aP4[0] = legingresoegresoypreaviso.this.AV12MegCodigo;
      this.aP5[0] = legingresoegresoypreaviso.this.AV17LegFecEgreso;
      this.aP6[0] = legingresoegresoypreaviso.this.AV16LegFecPreAviso;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18LegFecIngreso = GXutil.nullDate() ;
      AV12MegCodigo = "" ;
      AV17LegFecEgreso = GXutil.nullDate() ;
      AV16LegFecPreAviso = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01F72_A6LegNumero = new int[1] ;
      P01F72_A1EmpCod = new short[1] ;
      P01F72_A3CliCod = new int[1] ;
      P01F72_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01F72_A1583LegMegCodigo = new String[] {""} ;
      P01F72_n1583LegMegCodigo = new boolean[] {false} ;
      P01F72_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01F72_n244LegFecEgreso = new boolean[] {false} ;
      P01F72_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A1583LegMegCodigo = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A1531LegFecPreAviso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legingresoegresoypreaviso__default(),
         new Object[] {
             new Object[] {
            P01F72_A6LegNumero, P01F72_A1EmpCod, P01F72_A3CliCod, P01F72_A245LegFecIngreso, P01F72_A1583LegMegCodigo, P01F72_n1583LegMegCodigo, P01F72_A244LegFecEgreso, P01F72_n244LegFecEgreso, P01F72_A1531LegFecPreAviso
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
   private java.util.Date AV18LegFecIngreso ;
   private java.util.Date AV17LegFecEgreso ;
   private java.util.Date AV16LegFecPreAviso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A1531LegFecPreAviso ;
   private boolean n1583LegMegCodigo ;
   private boolean n244LegFecEgreso ;
   private java.util.Date[] aP6 ;
   private java.util.Date[] aP3 ;
   private String[] aP4 ;
   private java.util.Date[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P01F72_A6LegNumero ;
   private short[] P01F72_A1EmpCod ;
   private int[] P01F72_A3CliCod ;
   private java.util.Date[] P01F72_A245LegFecIngreso ;
   private String[] P01F72_A1583LegMegCodigo ;
   private boolean[] P01F72_n1583LegMegCodigo ;
   private java.util.Date[] P01F72_A244LegFecEgreso ;
   private boolean[] P01F72_n244LegFecEgreso ;
   private java.util.Date[] P01F72_A1531LegFecPreAviso ;
}

final  class legingresoegresoypreaviso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01F72", "SELECT LegNumero, EmpCod, CliCod, LegFecIngreso, LegMegCodigo, LegFecEgreso, LegFecPreAviso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
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

