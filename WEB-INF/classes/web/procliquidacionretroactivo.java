package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procliquidacionretroactivo extends GXProcedure
{
   public procliquidacionretroactivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procliquidacionretroactivo.class ), "" );
   }

   public procliquidacionretroactivo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      procliquidacionretroactivo.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      procliquidacionretroactivo.this.AV10CliCod = aP0;
      procliquidacionretroactivo.this.AV12EmpCod = aP1;
      procliquidacionretroactivo.this.AV24LiqNro = aP2;
      procliquidacionretroactivo.this.AV21LegNumero = aP3;
      procliquidacionretroactivo.this.AV50daemonUUID = aP4;
      procliquidacionretroactivo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV19LegClase ;
      GXv_char2[0] = AV55LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, AV21LegNumero, GXv_int1, GXv_char2) ;
      procliquidacionretroactivo.this.AV19LegClase = GXv_int1[0] ;
      procliquidacionretroactivo.this.AV55LegModTra = GXv_char2[0] ;
      GXv_char2[0] = AV56LiqTipoTarifa ;
      new web.getlegtipotarifa(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, AV21LegNumero, GXv_char2) ;
      procliquidacionretroactivo.this.AV56LiqTipoTarifa = GXv_char2[0] ;
      AV51LiqModTra = AV55LegModTra ;
      AV52LiqFrecPag = AV19LegClase ;
      AV54LiqPerDes = GXutil.nullDate() ;
      AV53LiqPerHas = GXutil.nullDate() ;
      if ( AV19LegClase == 1 )
      {
         AV28LiquidacionClase = (byte)(0) ;
      }
      else
      {
         AV28LiquidacionClase = (byte)(1) ;
      }
      AV11collection_LegNumero.add((int)(AV21LegNumero), 0);
      AV16idOperando = "{retroactivo}" ;
      GXv_char2[0] = AV31retroPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV10CliCod, "{retroactivo}", false, true, GXv_char2) ;
      procliquidacionretroactivo.this.AV31retroPalabra = GXv_char2[0] ;
      GXv_int3[0] = AV40PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int3) ;
      procliquidacionretroactivo.this.AV40PaiCod = GXv_int3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( " &retroPalabra ", "")+AV31retroPalabra) ;
      AV60GXLvl28 = (byte)(0) ;
      lV31retroPalabra = GXutil.padr( GXutil.rtrim( AV31retroPalabra), 20, "%") ;
      /* Using cursor P01Z82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV24LiqNro), lV31retroPalabra});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A504LiqDForOrig = P01Z82_A504LiqDForOrig[0] ;
         A31LiqNro = P01Z82_A31LiqNro[0] ;
         A1EmpCod = P01Z82_A1EmpCod[0] ;
         A3CliCod = P01Z82_A3CliCod[0] ;
         A1073LiqDNovedad = P01Z82_A1073LiqDNovedad[0] ;
         A393DConDescrip = P01Z82_A393DConDescrip[0] ;
         A394DConCodigo = P01Z82_A394DConCodigo[0] ;
         A6LegNumero = P01Z82_A6LegNumero[0] ;
         A81LiqDSecuencial = P01Z82_A81LiqDSecuencial[0] ;
         AV60GXLvl28 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( " LiqDNovedad ", "")+GXutil.trim( GXutil.booltostr( A1073LiqDNovedad))) ;
         if ( ! A1073LiqDNovedad )
         {
            AV13error = httpContext.getMessage( "Concepto de liquidación automática ", "") + GXutil.trim( A393DConDescrip) + httpContext.getMessage( " no es compatible con cálculo de liquidación retroactiva", "") ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem4[0] = AV32sdt_liq_retroactivas ;
            GXv_char2[0] = AV13error ;
            new web.procesarformulaconretro(remoteHandle, context).execute( AV10CliCod, AV40PaiCod, "", AV15Fecha, AV16idOperando, A394DConCodigo, A504LiqDForOrig, AV31retroPalabra, false, true, GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem4, GXv_char2) ;
            AV32sdt_liq_retroactivas = GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem4[0] ;
            procliquidacionretroactivo.this.AV13error = GXv_char2[0] ;
            if ( ! (GXutil.strcmp("", AV13error)==0) )
            {
               AV13error = httpContext.getMessage( "Error al generar liquidación retroactiva: ", "") + GXutil.trim( AV13error) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV60GXLvl28 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "&sdt_liq_retroactivas ", "")+GXutil.trim( GXutil.str( AV32sdt_liq_retroactivas.size(), 9, 0))) ;
      AV61GXV1 = 1 ;
      while ( AV61GXV1 <= AV32sdt_liq_retroactivas.size() )
      {
         AV17item = (web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem)((web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem)AV32sdt_liq_retroactivas.elementAt(-1+AV61GXV1));
         AV35TLiqCod = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod() ;
         AV8AAAAMM = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo() ;
         AV26LiqPeriodo = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo() ;
         AV25LiqPerAno = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano() ;
         AV27LiqPerMes = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes() ;
         GXv_int3[0] = AV40PaiCod ;
         GXv_char2[0] = AV20LegConveCodigo ;
         GXv_char5[0] = "" ;
         new web.getconvenioycategorialegajo(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, 0, AV21LegNumero, GXv_int3, GXv_char2, GXv_char5) ;
         procliquidacionretroactivo.this.AV40PaiCod = GXv_int3[0] ;
         procliquidacionretroactivo.this.AV20LegConveCodigo = GXv_char2[0] ;
         AV18LegCatCodigo = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo() ;
         AV23LiqLegSueldo = AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "&LiqPerAno ", "")+GXutil.trim( GXutil.str( AV25LiqPerAno, 4, 0))+httpContext.getMessage( " &LiqPerMes ", "")+GXutil.trim( GXutil.str( AV27LiqPerMes, 2, 0))+httpContext.getMessage( " &AAAAMM ", "")+GXutil.trim( GXutil.str( AV8AAAAMM, 6, 0))+httpContext.getMessage( " &item.Periodo ", "")+GXutil.trim( GXutil.str( AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo(), 6, 0))+httpContext.getMessage( " &TLiqCod ", "")+AV35TLiqCod+httpContext.getMessage( " itemtliq ", "")+AV17item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod()) ;
         GXv_boolean6[0] = AV29originalExiste ;
         new web.hayliqorigdelegpertipo(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, AV21LegNumero, AV26LiqPeriodo, AV35TLiqCod, GXv_boolean6) ;
         procliquidacionretroactivo.this.AV29originalExiste = GXv_boolean6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "&originalExiste ", "")+GXutil.trim( GXutil.booltostr( AV29originalExiste))) ;
         if ( AV29originalExiste )
         {
            AV22LiqDescrip = httpContext.getMessage( "Liquidación retroactiva", "") ;
            GXv_char5[0] = AV46LiqPerPalabra ;
            new web.armaperpalabra(remoteHandle, context).execute( AV10CliCod, AV26LiqPeriodo, GXv_char5) ;
            procliquidacionretroactivo.this.AV46LiqPerPalabra = GXv_char5[0] ;
            GXv_char5[0] = AV46LiqPerPalabra ;
            GXv_char2[0] = AV45LiqNombre ;
            new web.armaliqnombre(remoteHandle, context).execute( AV10CliCod, AV26LiqPeriodo, GXv_char5, AV35TLiqCod, AV51LiqModTra, AV52LiqFrecPag, GXv_char2) ;
            procliquidacionretroactivo.this.AV46LiqPerPalabra = GXv_char5[0] ;
            procliquidacionretroactivo.this.AV45LiqNombre = GXv_char2[0] ;
            AV45LiqNombre = GXutil.trim( AV22LiqDescrip) + httpContext.getMessage( " a ", "") + GXutil.trim( AV45LiqNombre) ;
            GXt_int7 = AV42nueva_LiqNro ;
            GXv_int8[0] = GXt_int7 ;
            new web.obtnumliquidacion(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, GXv_int8) ;
            procliquidacionretroactivo.this.GXt_int7 = GXv_int8[0] ;
            AV42nueva_LiqNro = GXt_int7 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "guarda 1", "")) ;
            GXv_int1[0] = (byte)(AV47liquidaSac) ;
            GXv_char5[0] = AV48LiqSacLog ;
            new web.liquidar_sac(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, 0, AV35TLiqCod, AV26LiqPeriodo, GXv_int1, GXv_char5) ;
            procliquidacionretroactivo.this.AV47liquidaSac = GXv_int1[0] ;
            procliquidacionretroactivo.this.AV48LiqSacLog = GXv_char5[0] ;
            if ( AV47liquidaSac == 1 )
            {
               AV49LiqSac = true ;
            }
            else
            {
               AV49LiqSac = false ;
            }
            GXt_dtime9 = GXutil.resetTime( AV15Fecha );
            GXv_boolean6[0] = AV14errorHay ;
            new web.guardaliquidacion(remoteHandle, context).execute( AV10CliCod, AV12EmpCod, AV42nueva_LiqNro, AV15Fecha, AV15Fecha, AV22LiqDescrip, AV28LiquidacionClase, AV51LiqModTra, AV52LiqFrecPag, AV56LiqTipoTarifa, AV54LiqPerDes, AV53LiqPerHas, (byte)(1), AV35TLiqCod, httpContext.getMessage( "ALGUNOS", ""), AV11collection_LegNumero, "", AV15Fecha, (short)(0), AV43Mes, AV27LiqPerMes, AV25LiqPerAno, true, GXt_dtime9, "", AV45LiqNombre, AV24LiqNro, AV20LegConveCodigo, AV18LegCatCodigo, AV23LiqLegSueldo, "", AV49LiqSac, AV48LiqSacLog, AV50daemonUUID, false, GXv_boolean6) ;
            procliquidacionretroactivo.this.AV14errorHay = GXv_boolean6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "guarda &errorHay ", "")+GXutil.booltostr( AV14errorHay)) ;
            if ( AV14errorHay )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            AV13error = httpContext.getMessage( "No existe liquidación ", "") + GXutil.trim( AV35TLiqCod) + httpContext.getMessage( " en periodo ", "") + GXutil.trim( GXutil.str( AV8AAAAMM, 6, 0)) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV61GXV1 = (int)(AV61GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = procliquidacionretroactivo.this.AV13error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13error = "" ;
      AV55LegModTra = "" ;
      AV56LiqTipoTarifa = "" ;
      AV51LiqModTra = "" ;
      AV54LiqPerDes = GXutil.nullDate() ;
      AV53LiqPerHas = GXutil.nullDate() ;
      AV11collection_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV16idOperando = "" ;
      AV31retroPalabra = "" ;
      AV59Pgmname = "" ;
      lV31retroPalabra = "" ;
      scmdbuf = "" ;
      P01Z82_A504LiqDForOrig = new String[] {""} ;
      P01Z82_A31LiqNro = new int[1] ;
      P01Z82_A1EmpCod = new short[1] ;
      P01Z82_A3CliCod = new int[1] ;
      P01Z82_A1073LiqDNovedad = new boolean[] {false} ;
      P01Z82_A393DConDescrip = new String[] {""} ;
      P01Z82_A394DConCodigo = new String[] {""} ;
      P01Z82_A6LegNumero = new int[1] ;
      P01Z82_A81LiqDSecuencial = new int[1] ;
      A504LiqDForOrig = "" ;
      A393DConDescrip = "" ;
      A394DConCodigo = "" ;
      AV15Fecha = GXutil.nullDate() ;
      AV32sdt_liq_retroactivas = new GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem>(web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem.class, "sdt_liq_retroactivasItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem4 = new GXBaseCollection[1] ;
      AV17item = new web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem(remoteHandle, context);
      AV35TLiqCod = "" ;
      AV26LiqPeriodo = GXutil.nullDate() ;
      GXv_int3 = new short[1] ;
      AV20LegConveCodigo = "" ;
      AV18LegCatCodigo = "" ;
      AV23LiqLegSueldo = DecimalUtil.ZERO ;
      AV22LiqDescrip = "" ;
      AV46LiqPerPalabra = "" ;
      AV45LiqNombre = "" ;
      GXv_char2 = new String[1] ;
      GXv_int8 = new int[1] ;
      GXv_int1 = new byte[1] ;
      AV48LiqSacLog = "" ;
      GXv_char5 = new String[1] ;
      GXt_dtime9 = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean6 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procliquidacionretroactivo__default(),
         new Object[] {
             new Object[] {
            P01Z82_A504LiqDForOrig, P01Z82_A31LiqNro, P01Z82_A1EmpCod, P01Z82_A3CliCod, P01Z82_A1073LiqDNovedad, P01Z82_A393DConDescrip, P01Z82_A394DConCodigo, P01Z82_A6LegNumero, P01Z82_A81LiqDSecuencial
            }
         }
      );
      AV59Pgmname = "procLiquidacionRetroactivo" ;
      /* GeneXus formulas. */
      AV59Pgmname = "procLiquidacionRetroactivo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19LegClase ;
   private byte AV52LiqFrecPag ;
   private byte AV28LiquidacionClase ;
   private byte AV60GXLvl28 ;
   private byte AV27LiqPerMes ;
   private byte GXv_int1[] ;
   private byte AV43Mes ;
   private short AV12EmpCod ;
   private short AV40PaiCod ;
   private short A1EmpCod ;
   private short AV25LiqPerAno ;
   private short GXv_int3[] ;
   private short AV47liquidaSac ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV24LiqNro ;
   private int AV21LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int AV61GXV1 ;
   private int AV8AAAAMM ;
   private int AV42nueva_LiqNro ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private java.math.BigDecimal AV23LiqLegSueldo ;
   private String AV50daemonUUID ;
   private String AV55LegModTra ;
   private String AV56LiqTipoTarifa ;
   private String AV51LiqModTra ;
   private String AV16idOperando ;
   private String AV31retroPalabra ;
   private String AV59Pgmname ;
   private String lV31retroPalabra ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV35TLiqCod ;
   private String AV20LegConveCodigo ;
   private String AV18LegCatCodigo ;
   private String AV46LiqPerPalabra ;
   private String GXv_char2[] ;
   private String GXv_char5[] ;
   private java.util.Date GXt_dtime9 ;
   private java.util.Date AV54LiqPerDes ;
   private java.util.Date AV53LiqPerHas ;
   private java.util.Date AV15Fecha ;
   private java.util.Date AV26LiqPeriodo ;
   private boolean A1073LiqDNovedad ;
   private boolean returnInSub ;
   private boolean AV29originalExiste ;
   private boolean AV49LiqSac ;
   private boolean AV14errorHay ;
   private boolean GXv_boolean6[] ;
   private String A504LiqDForOrig ;
   private String AV13error ;
   private String A393DConDescrip ;
   private String AV22LiqDescrip ;
   private String AV45LiqNombre ;
   private String AV48LiqSacLog ;
   private GXSimpleCollection<Integer> AV11collection_LegNumero ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01Z82_A504LiqDForOrig ;
   private int[] P01Z82_A31LiqNro ;
   private short[] P01Z82_A1EmpCod ;
   private int[] P01Z82_A3CliCod ;
   private boolean[] P01Z82_A1073LiqDNovedad ;
   private String[] P01Z82_A393DConDescrip ;
   private String[] P01Z82_A394DConCodigo ;
   private int[] P01Z82_A6LegNumero ;
   private int[] P01Z82_A81LiqDSecuencial ;
   private GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem> AV32sdt_liq_retroactivas ;
   private GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem> GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem4[] ;
   private web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem AV17item ;
}

final  class procliquidacionretroactivo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z82", "SELECT LiqDForOrig, LiqNro, EmpCod, CliCod, LiqDNovedad, DConDescrip, DConCodigo, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (UPPER(LiqDForOrig) like '%' || UPPER(?)) ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

