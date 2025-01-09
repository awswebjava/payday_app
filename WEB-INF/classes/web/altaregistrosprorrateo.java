package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class altaregistrosprorrateo extends GXProcedure
{
   public altaregistrosprorrateo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( altaregistrosprorrateo.class ), "" );
   }

   public altaregistrosprorrateo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           int aP4 ,
                           java.util.Date aP5 ,
                           String aP6 ,
                           String aP7 ,
                           String aP8 ,
                           String aP9 ,
                           String aP10 ,
                           boolean aP11 ,
                           String[] aP12 ,
                           String[] aP13 )
   {
      altaregistrosprorrateo.this.aP14 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        byte[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             byte[] aP14 )
   {
      altaregistrosprorrateo.this.AV8CliCod = aP0;
      altaregistrosprorrateo.this.AV16EmpCod = aP1;
      altaregistrosprorrateo.this.AV14LiqNro = aP2;
      altaregistrosprorrateo.this.AV49LiqRelNro = aP3;
      altaregistrosprorrateo.this.AV17LegNumero = aP4;
      altaregistrosprorrateo.this.AV18LiqPeriodo = aP5;
      altaregistrosprorrateo.this.AV19AplIIGGExenCon = aP6;
      altaregistrosprorrateo.this.AV38AplIIGGPrrtear = aP7;
      altaregistrosprorrateo.this.AV40ConCodigo = aP8;
      altaregistrosprorrateo.this.AV42altaCuotaIdOperando = aP9;
      altaregistrosprorrateo.this.AV26ProcesoLiquidacion = aP10;
      altaregistrosprorrateo.this.AV37insertandoConceptos = aP11;
      altaregistrosprorrateo.this.aP12 = aP12;
      altaregistrosprorrateo.this.aP13 = aP13;
      altaregistrosprorrateo.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &AplIIGGTrat ", "")+GXutil.trim( GXutil.str( AV9AplIIGGTrat, 2, 0))+httpContext.getMessage( " &AplIIGGPrrtear ", "")+GXutil.trim( AV38AplIIGGPrrtear)+httpContext.getMessage( " &ConCodigo ", "")+AV40ConCodigo) ;
      AV53GXLvl6 = (byte)(0) ;
      /* Using cursor P01752 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Byte.valueOf(AV9AplIIGGTrat), AV38AplIIGGPrrtear});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1121AplIIGGPrrtear = P01752_A1121AplIIGGPrrtear[0] ;
         A1120AplIIGGTrat = P01752_A1120AplIIGGTrat[0] ;
         A3CliCod = P01752_A3CliCod[0] ;
         A1112AplIIGG = P01752_A1112AplIIGG[0] ;
         AV53GXLvl6 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "AplIIGG ", "")+GXutil.trim( GXutil.str( A1112AplIIGG, 4, 0))) ;
         GXv_char1[0] = AV27calcExenError ;
         GXv_int2[0] = AV28calExenLiqDCalculado ;
         GXv_char3[0] = AV36excenLiqDLog ;
         GXv_boolean4[0] = AV43hay ;
         GXv_boolean5[0] = AV44existe ;
         GXv_decimal6[0] = AV46cuotaImportes ;
         new web.calcular_exentos(remoteHandle, context).execute( AV8CliCod, AV16EmpCod, AV14LiqNro, AV49LiqRelNro, AV17LegNumero, AV18LiqPeriodo, A1112AplIIGG, AV38AplIIGGPrrtear, "", AV42altaCuotaIdOperando, AV26ProcesoLiquidacion, AV37insertandoConceptos, GXv_char1, GXv_int2, GXv_char3, GXv_boolean4, GXv_boolean5, GXv_decimal6) ;
         altaregistrosprorrateo.this.AV27calcExenError = GXv_char1[0] ;
         altaregistrosprorrateo.this.AV28calExenLiqDCalculado = GXv_int2[0] ;
         altaregistrosprorrateo.this.AV36excenLiqDLog = GXv_char3[0] ;
         altaregistrosprorrateo.this.AV43hay = GXv_boolean4[0] ;
         altaregistrosprorrateo.this.AV44existe = GXv_boolean5[0] ;
         altaregistrosprorrateo.this.AV46cuotaImportes = GXv_decimal6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "&&cuotaImportes ", "")+GXutil.trim( GXutil.str( AV46cuotaImportes, 14, 2))) ;
         if ( AV28calExenLiqDCalculado == 0 )
         {
            AV30error = httpContext.getMessage( "falta calcular exentos", "") ;
            if ( ! (GXutil.strcmp("", AV27calcExenError)==0) )
            {
               AV30error += " (" + GXutil.trim( AV27calcExenError) + ")" ;
            }
            else
            {
               if ( ! (GXutil.strcmp("", AV36excenLiqDLog)==0) )
               {
                  AV30error += " (" + GXutil.trim( AV36excenLiqDLog) + ")" ;
               }
            }
            AV13LiqDCalculado = (byte)(0) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, AV30error) ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV31LiqDLog += AV36excenLiqDLog ;
         AV47darAltaCuota = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "&hay ", "")+GXutil.trim( GXutil.booltostr( AV43hay))) ;
         if ( GXutil.strcmp(AV38AplIIGGPrrtear, "FIJA") == 0 )
         {
            AV47darAltaCuota = true ;
            AV48LiqLegEsPrrGan = true ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "CuotaFija", "")) ;
         }
         else
         {
            AV48LiqLegEsPrrGan = false ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46cuotaImportes)==0) && ( AV43hay ) )
            {
               AV47darAltaCuota = true ;
            }
         }
         if ( AV47darAltaCuota )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "alta cuota", "")) ;
            GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char3[0] = AV45cuota_LiqDLog ;
            GXv_boolean5[0] = false ;
            new web.cuota_prorrateo_v2(remoteHandle, context).execute( AV8CliCod, AV16EmpCod, AV14LiqNro, AV17LegNumero, AV18LiqPeriodo, AV48LiqLegEsPrrGan, AV46cuotaImportes, AV26ProcesoLiquidacion, AV37insertandoConceptos, GXv_decimal6, GXv_char3, GXv_boolean5) ;
            altaregistrosprorrateo.this.AV45cuota_LiqDLog = GXv_char3[0] ;
            if ( ! (GXutil.strcmp("", AV45cuota_LiqDLog)==0) )
            {
               AV31LiqDLog += AV45cuota_LiqDLog ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV53GXLvl6 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV52Pgmname, httpContext.getMessage( "log ", "")+GXutil.trim( AV31LiqDLog)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = altaregistrosprorrateo.this.AV30error;
      this.aP13[0] = altaregistrosprorrateo.this.AV31LiqDLog;
      this.aP14[0] = altaregistrosprorrateo.this.AV13LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV30error = "" ;
      AV31LiqDLog = "" ;
      AV52Pgmname = "" ;
      scmdbuf = "" ;
      P01752_A1121AplIIGGPrrtear = new String[] {""} ;
      P01752_A1120AplIIGGTrat = new byte[1] ;
      P01752_A3CliCod = new int[1] ;
      P01752_A1112AplIIGG = new short[1] ;
      A1121AplIIGGPrrtear = "" ;
      AV27calcExenError = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new byte[1] ;
      AV36excenLiqDLog = "" ;
      GXv_boolean4 = new boolean[1] ;
      AV46cuotaImportes = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      AV45cuota_LiqDLog = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.altaregistrosprorrateo__default(),
         new Object[] {
             new Object[] {
            P01752_A1121AplIIGGPrrtear, P01752_A1120AplIIGGTrat, P01752_A3CliCod, P01752_A1112AplIIGG
            }
         }
      );
      AV52Pgmname = "altaRegistrosProrrateo" ;
      /* GeneXus formulas. */
      AV52Pgmname = "altaRegistrosProrrateo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte AV9AplIIGGTrat ;
   private byte AV53GXLvl6 ;
   private byte A1120AplIIGGTrat ;
   private byte AV28calExenLiqDCalculado ;
   private byte GXv_int2[] ;
   private short AV16EmpCod ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14LiqNro ;
   private int AV49LiqRelNro ;
   private int AV17LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV46cuotaImportes ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV19AplIIGGExenCon ;
   private String AV38AplIIGGPrrtear ;
   private String AV40ConCodigo ;
   private String AV42altaCuotaIdOperando ;
   private String AV26ProcesoLiquidacion ;
   private String AV52Pgmname ;
   private String scmdbuf ;
   private String A1121AplIIGGPrrtear ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private java.util.Date AV18LiqPeriodo ;
   private boolean AV37insertandoConceptos ;
   private boolean AV43hay ;
   private boolean GXv_boolean4[] ;
   private boolean AV44existe ;
   private boolean returnInSub ;
   private boolean AV47darAltaCuota ;
   private boolean AV48LiqLegEsPrrGan ;
   private boolean GXv_boolean5[] ;
   private String AV31LiqDLog ;
   private String AV36excenLiqDLog ;
   private String AV45cuota_LiqDLog ;
   private String AV30error ;
   private String AV27calcExenError ;
   private byte[] aP14 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private IDataStoreProvider pr_default ;
   private String[] P01752_A1121AplIIGGPrrtear ;
   private byte[] P01752_A1120AplIIGGTrat ;
   private int[] P01752_A3CliCod ;
   private short[] P01752_A1112AplIIGG ;
}

final  class altaregistrosprorrateo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01752", "SELECT AplIIGGPrrtear, AplIIGGTrat, CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE (CliCod = ?) AND (AplIIGGTrat = ?) AND (AplIIGGPrrtear = ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

