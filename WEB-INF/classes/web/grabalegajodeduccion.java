package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabalegajodeduccion extends GXProcedure
{
   public grabalegajodeduccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabalegajodeduccion.class ), "" );
   }

   public grabalegajodeduccion( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 ,
                              String aP6 ,
                              java.math.BigDecimal aP7 ,
                              byte aP8 ,
                              String aP9 )
   {
      grabalegajodeduccion.this.aP10 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        java.math.BigDecimal aP7 ,
                        byte aP8 ,
                        String aP9 ,
                        boolean[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             java.math.BigDecimal aP7 ,
                             byte aP8 ,
                             String aP9 ,
                             boolean[] aP10 )
   {
      grabalegajodeduccion.this.AV8CliCod = aP0;
      grabalegajodeduccion.this.AV9EmpCod = aP1;
      grabalegajodeduccion.this.AV15LegNumero = aP2;
      grabalegajodeduccion.this.AV10LegDedConCodigo = aP3;
      grabalegajodeduccion.this.AV12LegDedFchDes = aP4;
      grabalegajodeduccion.this.AV13LegDedFchHas = aP5;
      grabalegajodeduccion.this.AV11LegDedDescrip = aP6;
      grabalegajodeduccion.this.AV14LegDedImporte = aP7;
      grabalegajodeduccion.this.AV18LegDedCodSiradig = aP8;
      grabalegajodeduccion.this.AV19LegDedCodMot = aP9;
      grabalegajodeduccion.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE legajo_deducciones

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A6LegNumero = AV15LegNumero ;
      GXt_int1 = A83LegDedSec ;
      GXv_int2[0] = GXt_int1 ;
      new web.getnextdedsec(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV15LegNumero, GXv_int2) ;
      grabalegajodeduccion.this.GXt_int1 = GXv_int2[0] ;
      A83LegDedSec = GXt_int1 ;
      A556LegDedFchDes = AV12LegDedFchDes ;
      A557LegDedFchHas = AV13LegDedFchHas ;
      A84LegDedConCodigo = AV10LegDedConCodigo ;
      A560LegDedImporte = AV14LegDedImporte ;
      A568LegDedDescrip = AV11LegDedDescrip ;
      A767LegDedMes = (byte)(GXutil.month( AV12LegDedFchDes)) ;
      A768LegDedAnio = (short)(GXutil.year( AV12LegDedFchDes)) ;
      A864LegDedCodSiradig = AV18LegDedCodSiradig ;
      A870LegDedCodMot = AV19LegDedCodMot ;
      AV17dioAlta = true ;
      A1553LegDedTipo = "siradig" ;
      A1080LegDedUsado = (byte)(0) ;
      A1081LegDedNroLiq = 0 ;
      A1555LegDedFile = "" ;
      A1558LegDedFileNom = "" ;
      A1559LegDedFileExt = "" ;
      /* Using cursor P00KC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec), A556LegDedFchDes, A557LegDedFchHas, A84LegDedConCodigo, A560LegDedImporte, A568LegDedDescrip, Byte.valueOf(A767LegDedMes), Short.valueOf(A768LegDedAnio), Byte.valueOf(A864LegDedCodSiradig), A870LegDedCodMot, Byte.valueOf(A1080LegDedUsado), Integer.valueOf(A1081LegDedNroLiq), A1553LegDedTipo, A1555LegDedFile, A1558LegDedFileNom, A1559LegDedFileExt});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, httpContext.getMessage( "&LegDedConCodigo ", "")+AV10LegDedConCodigo) ;
      if ( ! (GXutil.strcmp("", AV10LegDedConCodigo)==0) )
      {
         AV10LegDedConCodigo = GXutil.trim( AV10LegDedConCodigo) ;
         AV125LiqPeriodo = localUtil.ymdtod( GXutil.year( AV12LegDedFchDes), GXutil.month( AV12LegDedFchDes), 1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, "1") ;
         AV131GXLvl32 = (byte)(0) ;
         /* Using cursor P00KC3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), AV10LegDedConCodigo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A954ConCondCodigo = P00KC3_A954ConCondCodigo[0] ;
            A953ConCondicion = P00KC3_A953ConCondicion[0] ;
            n953ConCondicion = P00KC3_n953ConCondicion[0] ;
            A3CliCod = P00KC3_A3CliCod[0] ;
            A26ConCodigo = P00KC3_A26ConCodigo[0] ;
            AV131GXLvl32 = (byte)(1) ;
            AV126ConCodigo = A26ConCodigo ;
            /* Execute user subroutine: 'TIPOS LIQ' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, httpContext.getMessage( "2 &ConCodigo ", "")+GXutil.trim( AV126ConCodigo)+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV15LegNumero, 8, 0))+httpContext.getMessage( " tliq ", "")+AV127TLiqCod.toJSonString(false)+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV125LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            /* Execute user subroutine: 'LIQUIDACIONES' */
            S121 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV131GXLvl32 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, httpContext.getMessage( "none2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'TIPOS LIQ' Routine */
      returnInSub = false ;
      AV127TLiqCod.clear();
      /* Using cursor P00KC4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod), AV126ConCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A26ConCodigo = P00KC4_A26ConCodigo[0] ;
         A3CliCod = P00KC4_A3CliCod[0] ;
         A32TLiqCod = P00KC4_A32TLiqCod[0] ;
         n32TLiqCod = P00KC4_n32TLiqCod[0] ;
         AV127TLiqCod.add(GXutil.trim( A32TLiqCod), 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void S121( )
   {
      /* 'LIQUIDACIONES' Routine */
      returnInSub = false ;
      AV133GXLvl85 = (byte)(0) ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A32TLiqCod ,
                                           AV127TLiqCod ,
                                           Byte.valueOf(A278LiqEstado) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV15LegNumero) ,
                                           AV125LiqPeriodo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A283LiqPeriodo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.DATE
                                           }
      });
      /* Using cursor P00KC5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV15LegNumero), AV125LiqPeriodo});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A283LiqPeriodo = P00KC5_A283LiqPeriodo[0] ;
         A278LiqEstado = P00KC5_A278LiqEstado[0] ;
         A32TLiqCod = P00KC5_A32TLiqCod[0] ;
         n32TLiqCod = P00KC5_n32TLiqCod[0] ;
         A6LegNumero = P00KC5_A6LegNumero[0] ;
         A1EmpCod = P00KC5_A1EmpCod[0] ;
         A3CliCod = P00KC5_A3CliCod[0] ;
         A31LiqNro = P00KC5_A31LiqNro[0] ;
         A278LiqEstado = P00KC5_A278LiqEstado[0] ;
         AV133GXLvl85 = (byte)(1) ;
         AV121LiqNro = A31LiqNro ;
         GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean4[0] = AV16existe ;
         GXv_int5[0] = (byte)(0) ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV121LiqNro, AV15LegNumero, AV126ConCodigo, "Recalculo", true, GXv_decimal3, GXv_boolean4, GXv_int5) ;
         grabalegajodeduccion.this.AV16existe = GXv_boolean4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, httpContext.getMessage( "existe ", "")+GXutil.trim( GXutil.booltostr( AV16existe))) ;
         if ( ! AV16existe )
         {
            GXt_int1 = AV122LiqDSecuencial ;
            GXv_int2[0] = GXt_int1 ;
            new web.ultimoliqdsecuencial(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A31LiqNro, AV15LegNumero, GXv_int2) ;
            grabalegajodeduccion.this.GXt_int1 = GXv_int2[0] ;
            AV122LiqDSecuencial = GXt_int1 ;
            AV122LiqDSecuencial = (int)(AV122LiqDSecuencial+1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, httpContext.getMessage( "&LiqDSecuencial ", "")+GXutil.trim( GXutil.str( AV122LiqDSecuencial, 5, 0))) ;
            GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean4[0] = false ;
            GXv_char6[0] = "" ;
            GXv_char7[0] = "" ;
            new web.newliquidaciondetalle3(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A31LiqNro, 0, AV15LegNumero, AV126ConCodigo, false, AV122LiqDSecuencial, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), AV123date, AV123date, DecimalUtil.doubleToDec(0), false, AV124mostrarconcepto, AV125LiqPeriodo, A32TLiqCod, false, (byte)(1), false, "", GXv_decimal3, GXv_boolean4, GXv_char6, GXv_char7) ;
         }
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( AV133GXLvl85 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV130Pgmname, httpContext.getMessage( "none1", "")) ;
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = grabalegajodeduccion.this.AV17dioAlta;
      Application.commitDataStores(context, remoteHandle, pr_default, "grabalegajodeduccion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      A84LegDedConCodigo = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      A568LegDedDescrip = "" ;
      A870LegDedCodMot = "" ;
      A1553LegDedTipo = "" ;
      A1555LegDedFile = "" ;
      A1558LegDedFileNom = "" ;
      A1559LegDedFileExt = "" ;
      Gx_emsg = "" ;
      AV130Pgmname = "" ;
      AV125LiqPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00KC3_A954ConCondCodigo = new String[] {""} ;
      P00KC3_A953ConCondicion = new String[] {""} ;
      P00KC3_n953ConCondicion = new boolean[] {false} ;
      P00KC3_A3CliCod = new int[1] ;
      P00KC3_A26ConCodigo = new String[] {""} ;
      A954ConCondCodigo = "" ;
      A953ConCondicion = "" ;
      A26ConCodigo = "" ;
      AV126ConCodigo = "" ;
      AV127TLiqCod = new GXSimpleCollection<String>(String.class, "internal", "");
      P00KC4_A26ConCodigo = new String[] {""} ;
      P00KC4_A3CliCod = new int[1] ;
      P00KC4_A32TLiqCod = new String[] {""} ;
      P00KC4_n32TLiqCod = new boolean[] {false} ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      P00KC5_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00KC5_A278LiqEstado = new byte[1] ;
      P00KC5_A32TLiqCod = new String[] {""} ;
      P00KC5_n32TLiqCod = new boolean[] {false} ;
      P00KC5_A6LegNumero = new int[1] ;
      P00KC5_A1EmpCod = new short[1] ;
      P00KC5_A3CliCod = new int[1] ;
      P00KC5_A31LiqNro = new int[1] ;
      GXv_int5 = new byte[1] ;
      GXv_int2 = new int[1] ;
      AV123date = GXutil.nullDate() ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabalegajodeduccion__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P00KC3_A954ConCondCodigo, P00KC3_A953ConCondicion, P00KC3_n953ConCondicion, P00KC3_A3CliCod, P00KC3_A26ConCodigo
            }
            , new Object[] {
            P00KC4_A26ConCodigo, P00KC4_A3CliCod, P00KC4_A32TLiqCod
            }
            , new Object[] {
            P00KC5_A283LiqPeriodo, P00KC5_A278LiqEstado, P00KC5_A32TLiqCod, P00KC5_n32TLiqCod, P00KC5_A6LegNumero, P00KC5_A1EmpCod, P00KC5_A3CliCod, P00KC5_A31LiqNro
            }
         }
      );
      AV130Pgmname = "GrabaLegajoDeduccion" ;
      /* GeneXus formulas. */
      AV130Pgmname = "GrabaLegajoDeduccion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18LegDedCodSiradig ;
   private byte A767LegDedMes ;
   private byte A864LegDedCodSiradig ;
   private byte A1080LegDedUsado ;
   private byte AV131GXLvl32 ;
   private byte AV133GXLvl85 ;
   private byte A278LiqEstado ;
   private byte GXv_int5[] ;
   private byte AV124mostrarconcepto ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A768LegDedAnio ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15LegNumero ;
   private int GX_INS72 ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int A1081LegDedNroLiq ;
   private int A31LiqNro ;
   private int AV121LiqNro ;
   private int AV122LiqDSecuencial ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private java.math.BigDecimal AV14LegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV10LegDedConCodigo ;
   private String AV19LegDedCodMot ;
   private String A84LegDedConCodigo ;
   private String A870LegDedCodMot ;
   private String A1553LegDedTipo ;
   private String Gx_emsg ;
   private String AV130Pgmname ;
   private String scmdbuf ;
   private String A954ConCondCodigo ;
   private String A953ConCondicion ;
   private String A26ConCodigo ;
   private String AV126ConCodigo ;
   private String A32TLiqCod ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private java.util.Date AV12LegDedFchDes ;
   private java.util.Date AV13LegDedFchHas ;
   private java.util.Date A556LegDedFchDes ;
   private java.util.Date A557LegDedFchHas ;
   private java.util.Date AV125LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV123date ;
   private boolean AV17dioAlta ;
   private boolean n953ConCondicion ;
   private boolean returnInSub ;
   private boolean n32TLiqCod ;
   private boolean AV16existe ;
   private boolean GXv_boolean4[] ;
   private String A1555LegDedFile ;
   private String AV11LegDedDescrip ;
   private String A568LegDedDescrip ;
   private String A1558LegDedFileNom ;
   private String A1559LegDedFileExt ;
   private GXSimpleCollection<String> AV127TLiqCod ;
   private boolean[] aP10 ;
   private IDataStoreProvider pr_default ;
   private String[] P00KC3_A954ConCondCodigo ;
   private String[] P00KC3_A953ConCondicion ;
   private boolean[] P00KC3_n953ConCondicion ;
   private int[] P00KC3_A3CliCod ;
   private String[] P00KC3_A26ConCodigo ;
   private String[] P00KC4_A26ConCodigo ;
   private int[] P00KC4_A3CliCod ;
   private String[] P00KC4_A32TLiqCod ;
   private boolean[] P00KC4_n32TLiqCod ;
   private java.util.Date[] P00KC5_A283LiqPeriodo ;
   private byte[] P00KC5_A278LiqEstado ;
   private String[] P00KC5_A32TLiqCod ;
   private boolean[] P00KC5_n32TLiqCod ;
   private int[] P00KC5_A6LegNumero ;
   private short[] P00KC5_A1EmpCod ;
   private int[] P00KC5_A3CliCod ;
   private int[] P00KC5_A31LiqNro ;
}

final  class grabalegajodeduccion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00KC5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV127TLiqCod ,
                                          byte A278LiqEstado ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV15LegNumero ,
                                          java.util.Date AV125LiqPeriodo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A283LiqPeriodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LiqPeriodo, T2.LiqEstado, T1.TLiqCod, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqNro FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod =" ;
      scmdbuf += " T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LiqPeriodo = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV127TLiqCod, "T1.TLiqCod IN (", ")")+")");
      addWhere(sWhereString, "(T2.LiqEstado <> 1)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqPeriodo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 3 :
                  return conditional_P00KC5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , (java.util.Date)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , (java.util.Date)dynConstraints[10] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00KC2", "SAVEPOINT gxupdate;INSERT INTO legajo_deducciones(CliCod, EmpCod, LegNumero, LegDedSec, LegDedFchDes, LegDedFchHas, LegDedConCodigo, LegDedImporte, LegDedDescrip, LegDedMes, LegDedAnio, LegDedCodSiradig, LegDedCodMot, LegDedUsado, LegDedNroLiq, LegDedTipo, LegDedFile, LegDedFileNom, LegDedFileExt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00KC3", "SELECT ConCondCodigo, ConCondicion, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and ConCondicion = ( 'B2')) AND (ConCondCodigo = ( ?)) ORDER BY CliCod, ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00KC4", "SELECT ConCodigo, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00KC5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 10);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setString(13, (String)parms[12], 2);
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setString(16, (String)parms[15], 20);
               stmt.setBLOBFile(17, (String)parms[16]);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setVarchar(19, (String)parms[18], 40, false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
      }
   }

}

