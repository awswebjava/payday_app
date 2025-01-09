package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocar_guardaliquidacion2 extends GXProcedure
{
   public invocar_guardaliquidacion2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocar_guardaliquidacion2.class ), "" );
   }

   public invocar_guardaliquidacion2( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( web.Sdtsdt_datos_liq aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( web.Sdtsdt_datos_liq aP0 ,
                             String aP1 )
   {
      invocar_guardaliquidacion2.this.AV35sdt_datos_liq = aP0;
      invocar_guardaliquidacion2.this.AV37daemonUUID = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV8CliCod ;
      GXv_int2[0] = AV9EmpCod ;
      GXv_int3[0] = AV10LiqNro ;
      GXv_date4[0] = AV11LiqFecha ;
      GXv_date5[0] = AV12LiqFecPago ;
      GXv_char6[0] = AV13LiqDescrip ;
      GXv_int7[0] = AV14LiqClase ;
      GXv_int8[0] = AV15LiqEstado ;
      GXv_char9[0] = AV16TLiqCod ;
      GXv_char10[0] = AV17AplicaA ;
      GXv_objcol_int11[0] = AV18collecion_LegNumero ;
      GXv_char12[0] = AV19LiqDepBanCod ;
      GXv_date13[0] = AV20LiqDepPrvFec ;
      GXv_int14[0] = AV21LiqDepPerAno ;
      GXv_int15[0] = AV22LiqDepPerMes ;
      GXv_int16[0] = AV23LiqPerMes ;
      GXv_int17[0] = AV24LiqPerAno ;
      GXv_boolean18[0] = AV25final ;
      GXv_dtime19[0] = AV26LiqFecImp ;
      GXv_char20[0] = AV27parmLiqPerPalabra ;
      GXv_char21[0] = AV28LiqNombre ;
      GXv_int22[0] = AV29LiqRelNro ;
      GXv_char23[0] = "" ;
      GXv_char24[0] = "" ;
      GXv_decimal25[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char26[0] = AV31ClientId ;
      GXv_boolean27[0] = AV32LiqSac ;
      GXv_char28[0] = AV33LiqSacLog ;
      GXv_boolean29[0] = AV38reLiquida ;
      GXv_char30[0] = AV39LiqModTra ;
      GXv_int31[0] = AV42LiqFrecPag ;
      GXv_date32[0] = AV40LiqPerDes ;
      GXv_date33[0] = AV41LiqPerHas ;
      GXv_char34[0] = AV43LiqTipoTarifa ;
      new web.armarparmdesdesdtdatosliq(remoteHandle, context).execute( AV35sdt_datos_liq, GXv_int1, GXv_int2, GXv_int3, GXv_date4, GXv_date5, GXv_char6, GXv_int7, GXv_int8, GXv_char9, GXv_char10, GXv_objcol_int11, GXv_char12, GXv_date13, GXv_int14, GXv_int15, GXv_int16, GXv_int17, GXv_boolean18, GXv_dtime19, GXv_char20, GXv_char21, GXv_int22, GXv_char23, GXv_char24, GXv_decimal25, GXv_char26, GXv_boolean27, GXv_char28, GXv_boolean29, GXv_char30, GXv_int31, GXv_date32, GXv_date33, GXv_char34) ;
      invocar_guardaliquidacion2.this.AV8CliCod = GXv_int1[0] ;
      invocar_guardaliquidacion2.this.AV9EmpCod = GXv_int2[0] ;
      invocar_guardaliquidacion2.this.AV10LiqNro = GXv_int3[0] ;
      invocar_guardaliquidacion2.this.AV11LiqFecha = GXv_date4[0] ;
      invocar_guardaliquidacion2.this.AV12LiqFecPago = GXv_date5[0] ;
      invocar_guardaliquidacion2.this.AV13LiqDescrip = GXv_char6[0] ;
      invocar_guardaliquidacion2.this.AV14LiqClase = GXv_int7[0] ;
      invocar_guardaliquidacion2.this.AV15LiqEstado = GXv_int8[0] ;
      invocar_guardaliquidacion2.this.AV16TLiqCod = GXv_char9[0] ;
      invocar_guardaliquidacion2.this.AV17AplicaA = GXv_char10[0] ;
      AV18collecion_LegNumero = GXv_objcol_int11[0] ;
      invocar_guardaliquidacion2.this.AV19LiqDepBanCod = GXv_char12[0] ;
      invocar_guardaliquidacion2.this.AV20LiqDepPrvFec = GXv_date13[0] ;
      invocar_guardaliquidacion2.this.AV21LiqDepPerAno = GXv_int14[0] ;
      invocar_guardaliquidacion2.this.AV22LiqDepPerMes = GXv_int15[0] ;
      invocar_guardaliquidacion2.this.AV23LiqPerMes = GXv_int16[0] ;
      invocar_guardaliquidacion2.this.AV24LiqPerAno = GXv_int17[0] ;
      invocar_guardaliquidacion2.this.AV25final = GXv_boolean18[0] ;
      invocar_guardaliquidacion2.this.AV26LiqFecImp = GXv_dtime19[0] ;
      invocar_guardaliquidacion2.this.AV27parmLiqPerPalabra = GXv_char20[0] ;
      invocar_guardaliquidacion2.this.AV28LiqNombre = GXv_char21[0] ;
      invocar_guardaliquidacion2.this.AV29LiqRelNro = GXv_int22[0] ;
      invocar_guardaliquidacion2.this.AV31ClientId = GXv_char26[0] ;
      invocar_guardaliquidacion2.this.AV32LiqSac = GXv_boolean27[0] ;
      invocar_guardaliquidacion2.this.AV33LiqSacLog = GXv_char28[0] ;
      invocar_guardaliquidacion2.this.AV38reLiquida = GXv_boolean29[0] ;
      invocar_guardaliquidacion2.this.AV39LiqModTra = GXv_char30[0] ;
      invocar_guardaliquidacion2.this.AV42LiqFrecPag = GXv_int31[0] ;
      invocar_guardaliquidacion2.this.AV40LiqPerDes = GXv_date32[0] ;
      invocar_guardaliquidacion2.this.AV41LiqPerHas = GXv_date33[0] ;
      invocar_guardaliquidacion2.this.AV43LiqTipoTarifa = GXv_char34[0] ;
      GXv_boolean29[0] = false ;
      new web.guardaliquidacion(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LiqFecha, AV12LiqFecPago, AV13LiqDescrip, AV14LiqClase, AV39LiqModTra, AV42LiqFrecPag, AV43LiqTipoTarifa, AV40LiqPerDes, AV41LiqPerHas, AV15LiqEstado, AV16TLiqCod, AV17AplicaA, AV18collecion_LegNumero, AV19LiqDepBanCod, AV20LiqDepPrvFec, AV21LiqDepPerAno, AV22LiqDepPerMes, AV23LiqPerMes, AV24LiqPerAno, AV25final, AV26LiqFecImp, AV27parmLiqPerPalabra, AV28LiqNombre, AV29LiqRelNro, "", "", DecimalUtil.doubleToDec(0), AV31ClientId, AV32LiqSac, AV33LiqSacLog, AV37daemonUUID, AV38reLiquida, GXv_boolean29) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new int[1] ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new int[1] ;
      AV11LiqFecha = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      AV12LiqFecPago = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV13LiqDescrip = "" ;
      GXv_char6 = new String[1] ;
      GXv_int7 = new byte[1] ;
      GXv_int8 = new byte[1] ;
      AV16TLiqCod = "" ;
      GXv_char9 = new String[1] ;
      AV17AplicaA = "" ;
      GXv_char10 = new String[1] ;
      AV18collecion_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_objcol_int11 = new GXSimpleCollection[1] ;
      AV19LiqDepBanCod = "" ;
      GXv_char12 = new String[1] ;
      AV20LiqDepPrvFec = GXutil.nullDate() ;
      GXv_date13 = new java.util.Date[1] ;
      GXv_int14 = new short[1] ;
      GXv_int15 = new byte[1] ;
      GXv_int16 = new byte[1] ;
      GXv_int17 = new short[1] ;
      GXv_boolean18 = new boolean[1] ;
      AV26LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime19 = new java.util.Date[1] ;
      AV27parmLiqPerPalabra = "" ;
      GXv_char20 = new String[1] ;
      AV28LiqNombre = "" ;
      GXv_char21 = new String[1] ;
      GXv_int22 = new int[1] ;
      GXv_char23 = new String[1] ;
      GXv_char24 = new String[1] ;
      GXv_decimal25 = new java.math.BigDecimal[1] ;
      AV31ClientId = "" ;
      GXv_char26 = new String[1] ;
      GXv_boolean27 = new boolean[1] ;
      AV33LiqSacLog = "" ;
      GXv_char28 = new String[1] ;
      AV39LiqModTra = "" ;
      GXv_char30 = new String[1] ;
      GXv_int31 = new byte[1] ;
      AV40LiqPerDes = GXutil.nullDate() ;
      GXv_date32 = new java.util.Date[1] ;
      AV41LiqPerHas = GXutil.nullDate() ;
      GXv_date33 = new java.util.Date[1] ;
      AV43LiqTipoTarifa = "" ;
      GXv_char34 = new String[1] ;
      GXv_boolean29 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqClase ;
   private byte GXv_int7[] ;
   private byte AV15LiqEstado ;
   private byte GXv_int8[] ;
   private byte AV22LiqDepPerMes ;
   private byte GXv_int15[] ;
   private byte AV23LiqPerMes ;
   private byte GXv_int16[] ;
   private byte AV42LiqFrecPag ;
   private byte GXv_int31[] ;
   private short AV9EmpCod ;
   private short GXv_int2[] ;
   private short AV21LiqDepPerAno ;
   private short GXv_int14[] ;
   private short AV24LiqPerAno ;
   private short GXv_int17[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GXv_int1[] ;
   private int AV10LiqNro ;
   private int GXv_int3[] ;
   private int AV29LiqRelNro ;
   private int GXv_int22[] ;
   private java.math.BigDecimal GXv_decimal25[] ;
   private String AV37daemonUUID ;
   private String GXv_char6[] ;
   private String AV16TLiqCod ;
   private String GXv_char9[] ;
   private String AV17AplicaA ;
   private String GXv_char10[] ;
   private String AV19LiqDepBanCod ;
   private String GXv_char12[] ;
   private String AV27parmLiqPerPalabra ;
   private String GXv_char20[] ;
   private String GXv_char21[] ;
   private String GXv_char23[] ;
   private String GXv_char24[] ;
   private String GXv_char26[] ;
   private String GXv_char28[] ;
   private String AV39LiqModTra ;
   private String GXv_char30[] ;
   private String AV43LiqTipoTarifa ;
   private String GXv_char34[] ;
   private java.util.Date AV26LiqFecImp ;
   private java.util.Date GXv_dtime19[] ;
   private java.util.Date AV11LiqFecha ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date AV12LiqFecPago ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV20LiqDepPrvFec ;
   private java.util.Date GXv_date13[] ;
   private java.util.Date AV40LiqPerDes ;
   private java.util.Date GXv_date32[] ;
   private java.util.Date AV41LiqPerHas ;
   private java.util.Date GXv_date33[] ;
   private boolean AV25final ;
   private boolean GXv_boolean18[] ;
   private boolean AV32LiqSac ;
   private boolean GXv_boolean27[] ;
   private boolean AV38reLiquida ;
   private boolean GXv_boolean29[] ;
   private String AV13LiqDescrip ;
   private String AV28LiqNombre ;
   private String AV31ClientId ;
   private String AV33LiqSacLog ;
   private GXSimpleCollection<Integer> AV18collecion_LegNumero ;
   private GXSimpleCollection<Integer> GXv_objcol_int11[] ;
   private web.Sdtsdt_datos_liq AV35sdt_datos_liq ;
}

