package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerimportededuccion extends GXProcedure
{
   public obtenerimportededuccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerimportededuccion.class ), "" );
   }

   public obtenerimportededuccion( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           String aP4 ,
                                           java.util.Date aP5 ,
                                           String aP6 ,
                                           boolean aP7 ,
                                           byte aP8 ,
                                           String aP9 ,
                                           boolean aP10 ,
                                           boolean[] aP11 )
   {
      obtenerimportededuccion.this.aP12 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        byte aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        boolean[] aP11 ,
                        java.math.BigDecimal[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             byte aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean[] aP11 ,
                             java.math.BigDecimal[] aP12 )
   {
      obtenerimportededuccion.this.AV13CliCod = aP0;
      obtenerimportededuccion.this.AV12EmpCod = aP1;
      obtenerimportededuccion.this.AV22LiqNro = aP2;
      obtenerimportededuccion.this.AV10LegNumero = aP3;
      obtenerimportededuccion.this.AV18operandos = aP4;
      obtenerimportededuccion.this.AV14LiqPeriodo = aP5;
      obtenerimportededuccion.this.AV8LegDedConCodigo = aP6;
      obtenerimportededuccion.this.AV25ddjjAnual = aP7;
      obtenerimportededuccion.this.AV26LegDedCodSiradig = aP8;
      obtenerimportededuccion.this.AV30LegDedCodMot = aP9;
      obtenerimportededuccion.this.AV33validar = aP10;
      obtenerimportededuccion.this.aP11 = aP11;
      obtenerimportededuccion.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV20liquidaconFinalEs ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.esliquidacionfinal(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV22LiqNro, AV14LiqPeriodo, GXv_boolean2) ;
      obtenerimportededuccion.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV20liquidaconFinalEs = GXt_boolean1 ;
      if ( ! (GXutil.strcmp("", AV8LegDedConCodigo)==0) )
      {
         GXv_char3[0] = "" ;
         GXv_char4[0] = AV21SubTipoConCod2 ;
         new web.conceptogetsubtipos(remoteHandle, context).execute( AV13CliCod, AV8LegDedConCodigo, GXv_char3, GXv_char4) ;
         obtenerimportededuccion.this.AV21SubTipoConCod2 = GXv_char4[0] ;
      }
      AV23LegDedAnio = (short)(GXutil.year( AV14LiqPeriodo)) ;
      GXt_char5 = AV24clasifAnual ;
      GXv_char4[0] = GXt_char5 ;
      new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).execute( GXv_char4) ;
      obtenerimportededuccion.this.GXt_char5 = GXv_char4[0] ;
      AV24clasifAnual = GXt_char5 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, GXutil.str( AV13CliCod, 6, 0)+httpContext.getMessage( " emp ", "")+GXutil.str( AV12EmpCod, 4, 0)+httpContext.getMessage( " leg ", "")+GXutil.str( AV10LegNumero, 8, 0)+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV14LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &&LegDedConCodigo ", "")+AV8LegDedConCodigo+httpContext.getMessage( " &SubTipoConCod2 ", "")+GXutil.trim( AV21SubTipoConCod2)+httpContext.getMessage( " &liquidaconFinalEs ", "")+GXutil.trim( GXutil.booltostr( AV20liquidaconFinalEs))+httpContext.getMessage( " &LegDedAnio ", "")+GXutil.trim( GXutil.str( AV23LegDedAnio, 4, 0))+httpContext.getMessage( " &clasifAnual ", "")+AV24clasifAnual+httpContext.getMessage( " &operandos ", "")+GXutil.trim( AV18operandos)) ;
      if ( ( AV20liquidaconFinalEs ) && ! (GXutil.strcmp("", AV21SubTipoConCod2)==0) )
      {
         if ( GXutil.strcmp(AV21SubTipoConCod2, AV24clasifAnual) == 0 )
         {
            AV29final = true ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&ddjjAnual ", "")+GXutil.trim( GXutil.booltostr( AV25ddjjAnual))+httpContext.getMessage( " &final ", "")+GXutil.trim( GXutil.booltostr( AV29final))) ;
      if ( ( AV25ddjjAnual ) || ( AV29final ) )
      {
         AV31enero = localUtil.ymdtod( AV23LegDedAnio, 1, 1) ;
         AV32ultimoDiaPeriodo = GXutil.eomdate( AV14LiqPeriodo) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, GXutil.str( AV13CliCod, 6, 0)+httpContext.getMessage( " es anual &LegDedAnio ", "")+GXutil.trim( GXutil.str( AV23LegDedAnio, 4, 0))+httpContext.getMessage( " &LegDedConCodigo ", "")+GXutil.trim( AV8LegDedConCodigo)+httpContext.getMessage( " &LegDedCodSiradig ", "")+GXutil.trim( GXutil.str( AV26LegDedCodSiradig, 2, 0))+httpContext.getMessage( " &LegDedCodMot ", "")+GXutil.trim( AV30LegDedCodMot)) ;
         AV43GXLvl28 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Byte.valueOf(AV26LegDedCodSiradig) ,
                                              AV30LegDedCodMot ,
                                              Byte.valueOf(A864LegDedCodSiradig) ,
                                              A870LegDedCodMot ,
                                              A557LegDedFchHas ,
                                              AV32ultimoDiaPeriodo ,
                                              Integer.valueOf(AV13CliCod) ,
                                              Short.valueOf(AV12EmpCod) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              Short.valueOf(AV23LegDedAnio) ,
                                              AV8LegDedConCodigo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              Short.valueOf(A768LegDedAnio) ,
                                              A84LegDedConCodigo } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                              }
         });
         /* Using cursor P00JI2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV23LegDedAnio), AV8LegDedConCodigo, AV32ultimoDiaPeriodo, Byte.valueOf(AV26LegDedCodSiradig), AV30LegDedCodMot});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A557LegDedFchHas = P00JI2_A557LegDedFchHas[0] ;
            A870LegDedCodMot = P00JI2_A870LegDedCodMot[0] ;
            A864LegDedCodSiradig = P00JI2_A864LegDedCodSiradig[0] ;
            A84LegDedConCodigo = P00JI2_A84LegDedConCodigo[0] ;
            A768LegDedAnio = P00JI2_A768LegDedAnio[0] ;
            A6LegNumero = P00JI2_A6LegNumero[0] ;
            A1EmpCod = P00JI2_A1EmpCod[0] ;
            A3CliCod = P00JI2_A3CliCod[0] ;
            A560LegDedImporte = P00JI2_A560LegDedImporte[0] ;
            A83LegDedSec = P00JI2_A83LegDedSec[0] ;
            AV43GXLvl28 = (byte)(1) ;
            GXt_decimal6 = AV36SiraPropor ;
            GXv_decimal7[0] = GXt_decimal6 ;
            new web.getsiradigpropor(remoteHandle, context).execute( A3CliCod, "DED", GXutil.trim( GXutil.str( A864LegDedCodSiradig, 2, 0)), A84LegDedConCodigo, GXv_decimal7) ;
            obtenerimportededuccion.this.GXt_decimal6 = GXv_decimal7[0] ;
            AV36SiraPropor = GXt_decimal6 ;
            AV9LegDedImporte = AV9LegDedImporte.add(((A560LegDedImporte.multiply(AV36SiraPropor)))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&SiraPropor ", "")+GXutil.trim( GXutil.str( AV36SiraPropor, 6, 4))+httpContext.getMessage( " LegDedImporte ", "")+GXutil.trim( GXutil.str( A560LegDedImporte, 14, 2))) ;
            AV39existe = true ;
            if ( AV33validar )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV43GXLvl28 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "none ", "")) ;
         }
      }
      else
      {
         GXt_char5 = AV27pagosACuentaConCodigo ;
         GXt_char8 = AV27pagosACuentaConCodigo ;
         GXv_char4[0] = GXt_char8 ;
         new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         obtenerimportededuccion.this.GXt_char8 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char5 ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char8, GXv_char3) ;
         obtenerimportededuccion.this.GXt_char5 = GXv_char3[0] ;
         AV27pagosACuentaConCodigo = GXt_char5 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( " &LegDedConCodigo ", "")+GXutil.trim( AV8LegDedConCodigo)+httpContext.getMessage( " &pagosACuentaConCodigo ", "")+GXutil.trim( AV27pagosACuentaConCodigo)) ;
         if ( ( GXutil.strcmp(AV8LegDedConCodigo, AV27pagosACuentaConCodigo) == 0 ) && ! AV33validar && ( new web.viejopagosacuenta(remoteHandle, context).executeUdp( ) ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            GXv_decimal7[0] = AV9LegDedImporte ;
            new web.obtenerimportecuenta(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, 0, (short)(GXutil.year( AV14LiqPeriodo)), AV10LegNumero, AV8LegDedConCodigo, GXv_decimal7) ;
            obtenerimportededuccion.this.AV9LegDedImporte = GXv_decimal7[0] ;
         }
         else
         {
            GXv_decimal7[0] = AV9LegDedImporte ;
            GXv_boolean2[0] = AV39existe ;
            new web.obtenerimportededucciondeperiodo(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV10LegNumero, AV14LiqPeriodo, AV8LegDedConCodigo, "siradig", AV18operandos, AV33validar, GXv_decimal7, GXv_boolean2) ;
            obtenerimportededuccion.this.AV9LegDedImporte = GXv_decimal7[0] ;
            obtenerimportededuccion.this.AV39existe = GXv_boolean2[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&LegDedImporte ", "")+GXutil.trim( GXutil.str( AV9LegDedImporte, 14, 2))) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = obtenerimportededuccion.this.AV39existe;
      this.aP12[0] = obtenerimportededuccion.this.AV9LegDedImporte;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LegDedImporte = DecimalUtil.ZERO ;
      AV21SubTipoConCod2 = "" ;
      AV24clasifAnual = "" ;
      AV42Pgmname = "" ;
      AV31enero = GXutil.nullDate() ;
      AV32ultimoDiaPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      A870LegDedCodMot = "" ;
      A557LegDedFchHas = GXutil.nullDate() ;
      A84LegDedConCodigo = "" ;
      P00JI2_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      P00JI2_A870LegDedCodMot = new String[] {""} ;
      P00JI2_A864LegDedCodSiradig = new byte[1] ;
      P00JI2_A84LegDedConCodigo = new String[] {""} ;
      P00JI2_A768LegDedAnio = new short[1] ;
      P00JI2_A6LegNumero = new int[1] ;
      P00JI2_A1EmpCod = new short[1] ;
      P00JI2_A3CliCod = new int[1] ;
      P00JI2_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00JI2_A83LegDedSec = new int[1] ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      AV36SiraPropor = DecimalUtil.ZERO ;
      GXt_decimal6 = DecimalUtil.ZERO ;
      AV27pagosACuentaConCodigo = "" ;
      GXt_char5 = "" ;
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_boolean2 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtenerimportededuccion__default(),
         new Object[] {
             new Object[] {
            P00JI2_A557LegDedFchHas, P00JI2_A870LegDedCodMot, P00JI2_A864LegDedCodSiradig, P00JI2_A84LegDedConCodigo, P00JI2_A768LegDedAnio, P00JI2_A6LegNumero, P00JI2_A1EmpCod, P00JI2_A3CliCod, P00JI2_A560LegDedImporte, P00JI2_A83LegDedSec
            }
         }
      );
      AV42Pgmname = "ObtenerImporteDeduccion" ;
      /* GeneXus formulas. */
      AV42Pgmname = "ObtenerImporteDeduccion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV26LegDedCodSiradig ;
   private byte AV43GXLvl28 ;
   private byte A864LegDedCodSiradig ;
   private short AV12EmpCod ;
   private short AV23LegDedAnio ;
   private short A1EmpCod ;
   private short A768LegDedAnio ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV22LiqNro ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private java.math.BigDecimal AV9LegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private java.math.BigDecimal AV36SiraPropor ;
   private java.math.BigDecimal GXt_decimal6 ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV18operandos ;
   private String AV8LegDedConCodigo ;
   private String AV30LegDedCodMot ;
   private String AV21SubTipoConCod2 ;
   private String AV24clasifAnual ;
   private String AV42Pgmname ;
   private String scmdbuf ;
   private String A870LegDedCodMot ;
   private String A84LegDedConCodigo ;
   private String AV27pagosACuentaConCodigo ;
   private String GXt_char5 ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV14LiqPeriodo ;
   private java.util.Date AV31enero ;
   private java.util.Date AV32ultimoDiaPeriodo ;
   private java.util.Date A557LegDedFchHas ;
   private boolean AV25ddjjAnual ;
   private boolean AV33validar ;
   private boolean AV39existe ;
   private boolean AV20liquidaconFinalEs ;
   private boolean GXt_boolean1 ;
   private boolean AV29final ;
   private boolean Cond_result ;
   private boolean GXv_boolean2[] ;
   private java.math.BigDecimal[] aP12 ;
   private boolean[] aP11 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00JI2_A557LegDedFchHas ;
   private String[] P00JI2_A870LegDedCodMot ;
   private byte[] P00JI2_A864LegDedCodSiradig ;
   private String[] P00JI2_A84LegDedConCodigo ;
   private short[] P00JI2_A768LegDedAnio ;
   private int[] P00JI2_A6LegNumero ;
   private short[] P00JI2_A1EmpCod ;
   private int[] P00JI2_A3CliCod ;
   private java.math.BigDecimal[] P00JI2_A560LegDedImporte ;
   private int[] P00JI2_A83LegDedSec ;
}

final  class obtenerimportededuccion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00JI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV26LegDedCodSiradig ,
                                          String AV30LegDedCodMot ,
                                          byte A864LegDedCodSiradig ,
                                          String A870LegDedCodMot ,
                                          java.util.Date A557LegDedFchHas ,
                                          java.util.Date AV32ultimoDiaPeriodo ,
                                          int AV13CliCod ,
                                          short AV12EmpCod ,
                                          int AV10LegNumero ,
                                          short AV23LegDedAnio ,
                                          String AV8LegDedConCodigo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[8];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT LegDedFchHas, LegDedCodMot, LegDedCodSiradig, LegDedConCodigo, LegDedAnio, LegNumero, EmpCod, CliCod, LegDedImporte, LegDedSec FROM legajo_deducciones" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and LegDedAnio = ? and LegDedConCodigo = ( ?))");
      addWhere(sWhereString, "(LegDedFchHas <= ?)");
      if ( ! (0==AV26LegDedCodSiradig) )
      {
         addWhere(sWhereString, "(LegDedCodSiradig = ?)");
      }
      else
      {
         GXv_int9[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV30LegDedCodMot)==0) )
      {
         addWhere(sWhereString, "(LegDedCodMot = ( ?))");
      }
      else
      {
         GXv_int9[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegDedAnio, LegDedConCodigo" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00JI2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 2);
               }
               return;
      }
   }

}

