package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conveniogetimporte extends GXProcedure
{
   public conveniogetimporte( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniogetimporte.class ), "" );
   }

   public conveniogetimporte( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           String aP3 ,
                                           java.util.Date aP4 ,
                                           String aP5 )
   {
      conveniogetimporte.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      conveniogetimporte.this.AV11CliCod = aP0;
      conveniogetimporte.this.AV15EmpCod = aP1;
      conveniogetimporte.this.AV14LegNumero = aP2;
      conveniogetimporte.this.AV9ConveCodigo = aP3;
      conveniogetimporte.this.AV13LiqPeriodo = aP4;
      conveniogetimporte.this.AV17CliConveImpTipo = aP5;
      conveniogetimporte.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV10PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
      conveniogetimporte.this.GXt_int1 = GXv_int2[0] ;
      AV10PaiCod = GXt_int1 ;
      GXv_int3[0] = AV12CliConveVer ;
      new web.getversionconvenio(remoteHandle, context).execute( AV11CliCod, AV15EmpCod, AV14LegNumero, AV10PaiCod, AV9ConveCodigo, GXv_int3) ;
      conveniogetimporte.this.AV12CliConveVer = GXv_int3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&CliConveVer ", "")+GXutil.trim( GXutil.str( AV12CliConveVer, 6, 0))+httpContext.getMessage( " paicod ", "")+GXutil.trim( GXutil.str( AV10PaiCod, 4, 0))+httpContext.getMessage( " convecodigo ", "")+GXutil.trim( AV9ConveCodigo)+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV13LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CliConveImpTipo ", "")+GXutil.trim( AV17CliConveImpTipo)) ;
      /* Using cursor P00ZD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliConveVer), Short.valueOf(AV10PaiCod), AV9ConveCodigo, AV13LiqPeriodo, AV17CliConveImpTipo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00ZD2_A3CliCod[0] ;
         A1564CliPaiConve = P00ZD2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P00ZD2_A1565CliConvenio[0] ;
         A1588CliConveImpTipo = P00ZD2_A1588CliConveImpTipo[0] ;
         A1587CliConveImpVig = P00ZD2_A1587CliConveImpVig[0] ;
         A1589CliConveImporte = P00ZD2_A1589CliConveImporte[0] ;
         AV18CliConveImporte = A1589CliConveImporte ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "CliConveImporte  ", "")+GXutil.trim( GXutil.str( A1589CliConveImporte, 14, 2))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = conveniogetimporte.this.AV18CliConveImporte;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18CliConveImporte = DecimalUtil.ZERO ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new int[1] ;
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      P00ZD2_A3CliCod = new int[1] ;
      P00ZD2_A1564CliPaiConve = new short[1] ;
      P00ZD2_A1565CliConvenio = new String[] {""} ;
      P00ZD2_A1588CliConveImpTipo = new String[] {""} ;
      P00ZD2_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P00ZD2_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1565CliConvenio = "" ;
      A1588CliConveImpTipo = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniogetimporte__default(),
         new Object[] {
             new Object[] {
            P00ZD2_A3CliCod, P00ZD2_A1564CliPaiConve, P00ZD2_A1565CliConvenio, P00ZD2_A1588CliConveImpTipo, P00ZD2_A1587CliConveImpVig, P00ZD2_A1589CliConveImporte
            }
         }
      );
      AV21Pgmname = "ConvenioGetImporte" ;
      /* GeneXus formulas. */
      AV21Pgmname = "ConvenioGetImporte" ;
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV10PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV14LegNumero ;
   private int AV12CliConveVer ;
   private int GXv_int3[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV18CliConveImporte ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private String AV9ConveCodigo ;
   private String AV17CliConveImpTipo ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date A1587CliConveImpVig ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00ZD2_A3CliCod ;
   private short[] P00ZD2_A1564CliPaiConve ;
   private String[] P00ZD2_A1565CliConvenio ;
   private String[] P00ZD2_A1588CliConveImpTipo ;
   private java.util.Date[] P00ZD2_A1587CliConveImpVig ;
   private java.math.BigDecimal[] P00ZD2_A1589CliConveImporte ;
}

final  class conveniogetimporte__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ZD2", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpTipo, CliConveImpVig, CliConveImporte FROM clienteConvenio_importes WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig <= ?) AND (CliConveImpTipo = ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

