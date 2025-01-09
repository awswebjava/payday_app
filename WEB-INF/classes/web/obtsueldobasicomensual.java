package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtsueldobasicomensual extends GXProcedure
{
   public obtsueldobasicomensual( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtsueldobasicomensual.class ), "" );
   }

   public obtsueldobasicomensual( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 )
   {
      obtsueldobasicomensual.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal aP5 ,
                        String aP6 ,
                        String[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      obtsueldobasicomensual.this.AV11CliCod = aP0;
      obtsueldobasicomensual.this.AV8EmpCod = aP1;
      obtsueldobasicomensual.this.AV9LegNumero = aP2;
      obtsueldobasicomensual.this.AV13LiqNro = aP3;
      obtsueldobasicomensual.this.AV12LiqPeriodo = aP4;
      obtsueldobasicomensual.this.AV39parmSueldoImportes = aP5;
      obtsueldobasicomensual.this.AV34que = aP6;
      obtsueldobasicomensual.this.aP7 = aP7;
      obtsueldobasicomensual.this.aP8 = aP8;
      obtsueldobasicomensual.this.aP9 = aP9;
      obtsueldobasicomensual.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10SueldoJornal = DecimalUtil.ZERO ;
      GXv_char1[0] = AV36LegCatCodigo ;
      GXv_char2[0] = AV37LegConveCodigo ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV13LiqNro, AV9LegNumero, GXv_char1, GXv_char2) ;
      obtsueldobasicomensual.this.AV36LegCatCodigo = GXv_char1[0] ;
      obtsueldobasicomensual.this.AV37LegConveCodigo = GXv_char2[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV9LegNumero, 8, 0))) ;
      /* Using cursor P00PJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00PJ2_A6LegNumero[0] ;
         A1EmpCod = P00PJ2_A1EmpCod[0] ;
         A3CliCod = P00PJ2_A3CliCod[0] ;
         A1576LegConveVersionCli = P00PJ2_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = P00PJ2_n1576LegConveVersionCli[0] ;
         A22LegPaiCod = P00PJ2_A22LegPaiCod[0] ;
         n22LegPaiCod = P00PJ2_n22LegPaiCod[0] ;
         A235LegClase = P00PJ2_A235LegClase[0] ;
         A2417LegTipoTarifa = P00PJ2_A2417LegTipoTarifa[0] ;
         if ( ! (GXutil.strcmp("", AV36LegCatCodigo)==0) && ! (GXutil.strcmp("", AV37LegConveCodigo)==0) )
         {
            if ( (0==A1576LegConveVersionCli) )
            {
               AV21error = httpContext.getMessage( "El legajo no tiene asignado versión de convenio", "") ;
               AV23LiqDLog = AV21error ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            GXv_int3[0] = AV29CliConveVer ;
            new web.getversiondelegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_int3) ;
            obtsueldobasicomensual.this.AV29CliConveVer = GXv_int3[0] ;
            GXv_int4[0] = AV40CliPaiConve ;
            new web.getpaisdeconvenio(remoteHandle, context).execute( AV37LegConveCodigo, A22LegPaiCod, GXv_int4) ;
            obtsueldobasicomensual.this.AV40CliPaiConve = GXv_int4[0] ;
            GXv_boolean5[0] = AV20devolvioValorHora ;
            GXv_char2[0] = AV21error ;
            GXv_decimal6[0] = AV10SueldoJornal ;
            new web.getescalasalarialvigente3(remoteHandle, context).execute( AV29CliConveVer, AV40CliPaiConve, AV37LegConveCodigo, AV36LegCatCodigo, AV12LiqPeriodo, A235LegClase, AV34que, GXv_boolean5, GXv_char2, GXv_decimal6) ;
            obtsueldobasicomensual.this.AV20devolvioValorHora = GXv_boolean5[0] ;
            obtsueldobasicomensual.this.AV21error = GXv_char2[0] ;
            obtsueldobasicomensual.this.AV10SueldoJornal = GXv_decimal6[0] ;
            GXv_char2[0] = AV27CatDescrip ;
            GXv_boolean5[0] = false ;
            new web.getcategoria(remoteHandle, context).execute( AV11CliCod, AV29CliConveVer, AV37LegConveCodigo, AV36LegCatCodigo, GXv_char2, GXv_boolean5) ;
            obtsueldobasicomensual.this.AV27CatDescrip = GXv_char2[0] ;
            AV23LiqDLog = httpContext.getMessage( "Se inicializa valor con ", "") + GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2)) + httpContext.getMessage( " según la escala salarial vigente al ", "") + GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para el convenio ", "") + GXutil.trim( AV37LegConveCodigo) + httpContext.getMessage( " de la categoría ", "") + GXutil.trim( AV27CatDescrip) ;
            if ( ! (GXutil.strcmp("", AV21error)==0) )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV9LegNumero, 8, 0))+httpContext.getMessage( " &SueldoJornal ", "")+GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2))) ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "2 &parmSueldoImportes ", "")+GXutil.trim( GXutil.str( AV39parmSueldoImportes, 14, 2))) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39parmSueldoImportes)==0) )
            {
               GXv_decimal6[0] = AV10SueldoJornal ;
               GXv_char2[0] = AV38LegSuelTipo ;
               GXv_int4[0] = (short)(0) ;
               GXv_boolean5[0] = AV32existe ;
               new web.getlegajosueldoultimo(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV13LiqNro, AV9LegNumero, AV12LiqPeriodo, GXv_decimal6, GXv_char2, GXv_int4, GXv_boolean5) ;
               obtsueldobasicomensual.this.AV10SueldoJornal = GXv_decimal6[0] ;
               obtsueldobasicomensual.this.AV38LegSuelTipo = GXv_char2[0] ;
               obtsueldobasicomensual.this.AV32existe = GXv_boolean5[0] ;
               if ( ! AV32existe )
               {
                  GXv_char2[0] = AV21error ;
                  new web.getcoderrprin(remoteHandle, context).execute( GXv_char2) ;
                  obtsueldobasicomensual.this.AV21error = GXv_char2[0] ;
                  GXv_char2[0] = AV33LegNomApe ;
                  new web.getlegnomape(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, GXv_char2) ;
                  obtsueldobasicomensual.this.AV33LegNomApe = GXv_char2[0] ;
                  AV21error += GXutil.trim( AV33LegNomApe) + httpContext.getMessage( " no tiene remuneración asignada para ", "") + localUtil.cmonth( AV12LiqPeriodo, httpContext.getLanguage( )) + " " + GXutil.trim( GXutil.str( GXutil.year( AV12LiqPeriodo), 10, 0)) ;
                  AV23LiqDLog = AV21error ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               AV10SueldoJornal = AV39parmSueldoImportes ;
            }
            AV23LiqDLog = httpContext.getMessage( "Valor mensual", "") ;
            AV23LiqDLog += httpContext.getMessage( " es ", "") + GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2)) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "3 &SueldoJornal ", "")+GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LiqDLog ¿", "")+GXutil.trim( AV23LiqDLog)) ;
            if ( GXutil.strcmp(A2417LegTipoTarifa, "H") == 0 )
            {
               AV20devolvioValorHora = true ;
            }
         }
         if ( AV20devolvioValorHora )
         {
            GXv_decimal6[0] = AV16horasMes ;
            GXv_char2[0] = AV30horasMesLiqDLog ;
            GXv_char1[0] = AV21error ;
            new web.horasmes(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, AV12LiqPeriodo, GXv_decimal6, GXv_char2, GXv_char1) ;
            obtsueldobasicomensual.this.AV16horasMes = GXv_decimal6[0] ;
            obtsueldobasicomensual.this.AV30horasMesLiqDLog = GXv_char2[0] ;
            obtsueldobasicomensual.this.AV21error = GXv_char1[0] ;
            if ( ! (GXutil.strcmp("", AV21error)==0) )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "&horasMes ", "")+GXutil.trim( GXutil.str( AV16horasMes, 5, 1))) ;
            AV10SueldoJornal = AV10SueldoJornal.multiply(AV16horasMes) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "&&SueldoJornal ", "")+GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2))) ;
            GXv_char2[0] = AV31horasMesTooltip ;
            new web.armatooltip(remoteHandle, context).execute( AV11CliCod, AV16horasMes, AV30horasMesLiqDLog, false, GXv_char2) ;
            obtsueldobasicomensual.this.AV31horasMesTooltip = GXv_char2[0] ;
            AV23LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( AV31horasMesTooltip) + httpContext.getMessage( " horas del mes", "") ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV19OriginalSueldoJornal = AV10SueldoJornal ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "4 &SueldoJornal ", "")+GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2))+httpContext.getMessage( " &OriginalSueldoJornal ", "")+GXutil.trim( GXutil.str( AV19OriginalSueldoJornal, 14, 2))) ;
      GXv_decimal6[0] = AV10SueldoJornal ;
      GXv_decimal7[0] = DecimalUtil.doubleToDec(AV26horasSemanaNormal) ;
      GXv_decimal8[0] = AV25LegHorasSem ;
      new web.reducirporparcial(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, AV12LiqPeriodo, AV19OriginalSueldoJornal, GXv_decimal6, GXv_decimal7, GXv_decimal8) ;
      obtsueldobasicomensual.this.AV10SueldoJornal = GXv_decimal6[0] ;
      obtsueldobasicomensual.this.AV26horasSemanaNormal = (short)(DecimalUtil.decToDouble(GXv_decimal7[0])) ;
      obtsueldobasicomensual.this.AV25LegHorasSem = GXv_decimal8[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "5 &SueldoJornal ", "")+GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2))+httpContext.getMessage( " &OriginalSueldoJornal ", "")+GXutil.trim( GXutil.str( AV19OriginalSueldoJornal, 14, 2))) ;
      if ( DecimalUtil.compareTo(GXutil.roundDecimal( AV10SueldoJornal, 2), GXutil.roundDecimal( AV19OriginalSueldoJornal, 2)) != 0 )
      {
         AV23LiqDLog += httpContext.getMessage( ". Se reduce a ", "") + GXutil.trim( GXutil.str( AV10SueldoJornal, 14, 2)) + httpContext.getMessage( " por ser jornada parcial de ", "") + GXutil.trim( GXutil.str( AV25LegHorasSem, 4, 1)) + httpContext.getMessage( " horas a la semana siendo la jornada normal de ", "") + GXutil.trim( GXutil.str( AV26horasSemanaNormal, 4, 0)) + httpContext.getMessage( " horas", "") ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV43Pgmname, httpContext.getMessage( "liqdlog ", "")+GXutil.trim( AV23LiqDLog)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = obtsueldobasicomensual.this.AV21error;
      this.aP8[0] = obtsueldobasicomensual.this.AV10SueldoJornal;
      this.aP9[0] = obtsueldobasicomensual.this.AV38LegSuelTipo;
      this.aP10[0] = obtsueldobasicomensual.this.AV23LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21error = "" ;
      AV10SueldoJornal = DecimalUtil.ZERO ;
      AV38LegSuelTipo = "" ;
      AV23LiqDLog = "" ;
      AV36LegCatCodigo = "" ;
      AV37LegConveCodigo = "" ;
      AV43Pgmname = "" ;
      scmdbuf = "" ;
      P00PJ2_A6LegNumero = new int[1] ;
      P00PJ2_A1EmpCod = new short[1] ;
      P00PJ2_A3CliCod = new int[1] ;
      P00PJ2_A1576LegConveVersionCli = new int[1] ;
      P00PJ2_n1576LegConveVersionCli = new boolean[] {false} ;
      P00PJ2_A22LegPaiCod = new short[1] ;
      P00PJ2_n22LegPaiCod = new boolean[] {false} ;
      P00PJ2_A235LegClase = new byte[1] ;
      P00PJ2_A2417LegTipoTarifa = new String[] {""} ;
      A2417LegTipoTarifa = "" ;
      GXv_int3 = new int[1] ;
      AV27CatDescrip = "" ;
      GXv_int4 = new short[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV33LegNomApe = "" ;
      AV16horasMes = DecimalUtil.ZERO ;
      AV30horasMesLiqDLog = "" ;
      GXv_char1 = new String[1] ;
      AV31horasMesTooltip = "" ;
      GXv_char2 = new String[1] ;
      AV19OriginalSueldoJornal = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV25LegHorasSem = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtsueldobasicomensual__default(),
         new Object[] {
             new Object[] {
            P00PJ2_A6LegNumero, P00PJ2_A1EmpCod, P00PJ2_A3CliCod, P00PJ2_A1576LegConveVersionCli, P00PJ2_n1576LegConveVersionCli, P00PJ2_A22LegPaiCod, P00PJ2_n22LegPaiCod, P00PJ2_A235LegClase, P00PJ2_A2417LegTipoTarifa
            }
         }
      );
      AV43Pgmname = "ObtSueldoBasicoMensual" ;
      /* GeneXus formulas. */
      AV43Pgmname = "ObtSueldoBasicoMensual" ;
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short AV40CliPaiConve ;
   private short GXv_int4[] ;
   private short AV26horasSemanaNormal ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int AV13LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1576LegConveVersionCli ;
   private int AV29CliConveVer ;
   private int GXv_int3[] ;
   private java.math.BigDecimal AV39parmSueldoImportes ;
   private java.math.BigDecimal AV10SueldoJornal ;
   private java.math.BigDecimal AV16horasMes ;
   private java.math.BigDecimal AV19OriginalSueldoJornal ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal AV25LegHorasSem ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV34que ;
   private String AV38LegSuelTipo ;
   private String AV36LegCatCodigo ;
   private String AV37LegConveCodigo ;
   private String AV43Pgmname ;
   private String scmdbuf ;
   private String A2417LegTipoTarifa ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean n1576LegConveVersionCli ;
   private boolean n22LegPaiCod ;
   private boolean returnInSub ;
   private boolean AV20devolvioValorHora ;
   private boolean AV32existe ;
   private boolean GXv_boolean5[] ;
   private String AV23LiqDLog ;
   private String AV30horasMesLiqDLog ;
   private String AV21error ;
   private String AV27CatDescrip ;
   private String AV33LegNomApe ;
   private String AV31horasMesTooltip ;
   private String[] aP10 ;
   private String[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private int[] P00PJ2_A6LegNumero ;
   private short[] P00PJ2_A1EmpCod ;
   private int[] P00PJ2_A3CliCod ;
   private int[] P00PJ2_A1576LegConveVersionCli ;
   private boolean[] P00PJ2_n1576LegConveVersionCli ;
   private short[] P00PJ2_A22LegPaiCod ;
   private boolean[] P00PJ2_n22LegPaiCod ;
   private byte[] P00PJ2_A235LegClase ;
   private String[] P00PJ2_A2417LegTipoTarifa ;
}

final  class obtsueldobasicomensual__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00PJ2", "SELECT LegNumero, EmpCod, CliCod, LegConveVersionCli, LegPaiCod, LegClase, LegTipoTarifa FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(6);
               ((String[]) buf[8])[0] = rslt.getString(7, 1);
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

