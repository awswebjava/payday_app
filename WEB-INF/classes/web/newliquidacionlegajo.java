package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newliquidacionlegajo extends GXProcedure
{
   public newliquidacionlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newliquidacionlegajo.class ), "" );
   }

   public newliquidacionlegajo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        java.math.BigDecimal aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal aP10 )
   {
      newliquidacionlegajo.this.AV8CliCod = aP0;
      newliquidacionlegajo.this.AV9EmpCod = aP1;
      newliquidacionlegajo.this.AV10LiqNro = aP2;
      newliquidacionlegajo.this.AV11LegNumero = aP3;
      newliquidacionlegajo.this.AV13LiqPeriodo = aP4;
      newliquidacionlegajo.this.AV14TliqCod = aP5;
      newliquidacionlegajo.this.AV15LiqLegAuxEstado = aP6;
      newliquidacionlegajo.this.AV18LiqLegErrorAux = aP7;
      newliquidacionlegajo.this.AV21LiqLegConvenio = aP8;
      newliquidacionlegajo.this.AV20LiqLegCatCodigo = aP9;
      newliquidacionlegajo.this.AV19LiqLegSueldo = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV23LiqLegDaemonUUID ;
      new web.getpdfdaemon(remoteHandle, context).execute( AV8CliCod, GXv_char1) ;
      newliquidacionlegajo.this.AV23LiqLegDaemonUUID = GXv_char1[0] ;
      /*
         INSERT RECORD ON TABLE LiquidacionLegajo

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A31LiqNro = AV10LiqNro ;
      A6LegNumero = AV11LegNumero ;
      A281LiqLegImpTotal = DecimalUtil.doubleToDec(0) ;
      A34LiqSecCodigo = "" ;
      n34LiqSecCodigo = false ;
      n34LiqSecCodigo = true ;
      A282LiqLegReciboNro = 0 ;
      A283LiqPeriodo = AV13LiqPeriodo ;
      A32TLiqCod = AV14TliqCod ;
      n32TLiqCod = false ;
      A1780LiqLegAuxEstado = AV15LiqLegAuxEstado ;
      A1781LiqLegErrorAux = AV18LiqLegErrorAux ;
      GXv_date2[0] = AV16LegFecIngreso ;
      GXv_date3[0] = AV17LegFecEgreso ;
      new web.getfecingresoyegreso(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LegNumero, GXv_date2, GXv_date3) ;
      newliquidacionlegajo.this.AV16LegFecIngreso = GXv_date2[0] ;
      newliquidacionlegajo.this.AV17LegFecEgreso = GXv_date3[0] ;
      A1815LiqLegFecEgr = AV17LegFecEgreso ;
      A1816LiqLegFecIng = AV16LegFecIngreso ;
      A2115LiqLegConvenio = AV21LiqLegConvenio ;
      A2113LiqLegCatCodigo = AV20LiqLegCatCodigo ;
      A2114LiqLegSueldo = AV19LiqLegSueldo ;
      A482LegLiqDatosHis = "" ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      A590LiqRutaPDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A883LIqLegIteraciones = (short)(0) ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      A961LiqNombrePDF = "" ;
      A962LiqNombrePDFVertical = "" ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      A1495LiqLegSegIns = DecimalUtil.ZERO ;
      A1496LieqLegSegUpd = DecimalUtil.ZERO ;
      A1546LiqLegHorasSem = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A499LiqLegCntConc = (short)(0) ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A2268LiqLegProcesado = (byte)(0) ;
      if ( ! (GXutil.strcmp("", AV23LiqLegDaemonUUID)==0) )
      {
         A2401LiqLegDaemonUUID = AV23LiqLegDaemonUUID ;
         n2401LiqLegDaemonUUID = false ;
      }
      else
      {
         A2401LiqLegDaemonUUID = "" ;
         n2401LiqLegDaemonUUID = false ;
         n2401LiqLegDaemonUUID = true ;
      }
      GXt_dtime4 = A2402LiqLegFecHor ;
      GXv_dtime5[0] = GXt_dtime4 ;
      new web.getahora(remoteHandle, context).execute( AV8CliCod, GXv_dtime5) ;
      newliquidacionlegajo.this.GXt_dtime4 = GXv_dtime5[0] ;
      A2402LiqLegFecHor = GXutil.resetMillis(GXt_dtime4) ;
      /* Using cursor P01Z72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), A281LiqLegImpTotal, Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo, Integer.valueOf(A282LiqLegReciboNro), A482LegLiqDatosHis, A498LiqLegImpTotBruto, Short.valueOf(A499LiqLegCntConc), A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A757LiqLegImpTotRetGan, A758LiqLegImpTotBruProm, A759LiqLegImpTotBruSinSAC, A760LiqLegImpBasico, A761LiqLegGNSI, A590LiqRutaPDF, A774LiqRutaPDFVertical, A775LiqLegImpPagosACuen, Short.valueOf(A883LIqLegIteraciones), A884LiqLegSegundos, A891LiqLegError, A961LiqNombrePDF, A962LiqNombrePDFVertical, A1131LiqLegImpOtrDescu, A1143LiqLegImpDescuNeg, A1157LiqLegImpContr, A1158LiqLegImpCosto, A1495LiqLegSegIns, A1496LieqLegSegUpd, A1546LiqLegHorasSem, Byte.valueOf(A1780LiqLegAuxEstado), A1781LiqLegErrorAux, A1815LiqLegFecEgr, A1816LiqLegFecIng, A2113LiqLegCatCodigo, A2115LiqLegConvenio, A2114LiqLegSueldo, Byte.valueOf(A2268LiqLegProcesado), Boolean.valueOf(n2401LiqLegDaemonUUID), A2401LiqLegDaemonUUID, A283LiqPeriodo, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2402LiqLegFecHor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
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
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV26Pgmname, httpContext.getMessage( "llama a update count de ", "")+AV23LiqLegDaemonUUID+httpContext.getMessage( ", legajo ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
      new web.upddaemoncount(remoteHandle, context).execute( AV8CliCod, AV23LiqLegDaemonUUID) ;
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
      AV23LiqLegDaemonUUID = "" ;
      GXv_char1 = new String[1] ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A34LiqSecCodigo = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      A1781LiqLegErrorAux = "" ;
      AV16LegFecIngreso = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      AV17LegFecEgreso = GXutil.nullDate() ;
      GXv_date3 = new java.util.Date[1] ;
      A1815LiqLegFecEgr = GXutil.nullDate() ;
      A1816LiqLegFecIng = GXutil.nullDate() ;
      A2115LiqLegConvenio = "" ;
      A2113LiqLegCatCodigo = "" ;
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      A482LegLiqDatosHis = "" ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      A590LiqRutaPDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      A961LiqNombrePDF = "" ;
      A962LiqNombrePDFVertical = "" ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      A1495LiqLegSegIns = DecimalUtil.ZERO ;
      A1496LieqLegSegUpd = DecimalUtil.ZERO ;
      A1546LiqLegHorasSem = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A2401LiqLegDaemonUUID = "" ;
      A2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime4 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime5 = new java.util.Date[1] ;
      Gx_emsg = "" ;
      AV26Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newliquidacionlegajo__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV26Pgmname = "newLiquidacionLegajo" ;
      /* GeneXus formulas. */
      AV26Pgmname = "newLiquidacionLegajo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqLegAuxEstado ;
   private byte A1780LiqLegAuxEstado ;
   private byte A2268LiqLegProcesado ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A883LIqLegIteraciones ;
   private short A499LiqLegCntConc ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV11LegNumero ;
   private int GX_INS28 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A282LiqLegReciboNro ;
   private java.math.BigDecimal AV19LiqLegSueldo ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal A2114LiqLegSueldo ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A761LiqLegGNSI ;
   private java.math.BigDecimal A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private java.math.BigDecimal A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal A1158LiqLegImpCosto ;
   private java.math.BigDecimal A1495LiqLegSegIns ;
   private java.math.BigDecimal A1496LieqLegSegUpd ;
   private java.math.BigDecimal A1546LiqLegHorasSem ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private String AV14TliqCod ;
   private String AV21LiqLegConvenio ;
   private String AV20LiqLegCatCodigo ;
   private String AV23LiqLegDaemonUUID ;
   private String GXv_char1[] ;
   private String A34LiqSecCodigo ;
   private String A32TLiqCod ;
   private String A2115LiqLegConvenio ;
   private String A2113LiqLegCatCodigo ;
   private String A961LiqNombrePDF ;
   private String A962LiqNombrePDFVertical ;
   private String A2401LiqLegDaemonUUID ;
   private String Gx_emsg ;
   private String AV26Pgmname ;
   private java.util.Date A2402LiqLegFecHor ;
   private java.util.Date GXt_dtime4 ;
   private java.util.Date GXv_dtime5[] ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV16LegFecIngreso ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date AV17LegFecEgreso ;
   private java.util.Date GXv_date3[] ;
   private java.util.Date A1815LiqLegFecEgr ;
   private java.util.Date A1816LiqLegFecIng ;
   private boolean n34LiqSecCodigo ;
   private boolean n32TLiqCod ;
   private boolean n2401LiqLegDaemonUUID ;
   private String AV18LiqLegErrorAux ;
   private String A1781LiqLegErrorAux ;
   private String A482LegLiqDatosHis ;
   private String A590LiqRutaPDF ;
   private String A774LiqRutaPDFVertical ;
   private String A891LiqLegError ;
   private IDataStoreProvider pr_default ;
}

final  class newliquidacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01Z72", "SAVEPOINT gxupdate;INSERT INTO LiquidacionLegajo(CliCod, EmpCod, LiqNro, LegNumero, LiqLegImpTotal, LiqSecCodigo, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpTotRetGan, LiqLegImpTotBruProm, LiqLegImpTotBruSinSAC, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LiqLegImpPagosACuen, LIqLegIteraciones, LiqLegSegundos, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpContr, LiqLegImpCosto, LiqLegSegIns, LieqLegSegUpd, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegProcesado, LiqLegDaemonUUID, LiqPeriodo, TLiqCod, LiqLegFecHor, LiqLegPDFEstado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setVarchar(8, (String)parms[8], 4000, false);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setShort(10, ((Number) parms[10]).shortValue());
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[18], 2);
               stmt.setVarchar(19, (String)parms[19], 400, false);
               stmt.setVarchar(20, (String)parms[20], 400, false);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[21], 2);
               stmt.setShort(22, ((Number) parms[22]).shortValue());
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[23], 6);
               stmt.setVarchar(24, (String)parms[24], 400, false);
               stmt.setString(25, (String)parms[25], 200);
               stmt.setString(26, (String)parms[26], 200);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[27], 2);
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[28], 2);
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[29], 2);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[30], 2);
               stmt.setBigDecimal(31, (java.math.BigDecimal)parms[31], 6);
               stmt.setBigDecimal(32, (java.math.BigDecimal)parms[32], 6);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[33], 1);
               stmt.setByte(34, ((Number) parms[34]).byteValue());
               stmt.setVarchar(35, (String)parms[35], 400, false);
               stmt.setDate(36, (java.util.Date)parms[36]);
               stmt.setDate(37, (java.util.Date)parms[37]);
               stmt.setString(38, (String)parms[38], 40);
               stmt.setString(39, (String)parms[39], 20);
               stmt.setBigDecimal(40, (java.math.BigDecimal)parms[40], 2);
               stmt.setByte(41, ((Number) parms[41]).byteValue());
               if ( ((Boolean) parms[42]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[43], 36);
               }
               stmt.setDate(43, (java.util.Date)parms[44]);
               if ( ((Boolean) parms[45]).booleanValue() )
               {
                  stmt.setNull( 44 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(44, (String)parms[46], 20);
               }
               stmt.setDateTime(45, (java.util.Date)parms[47], false);
               return;
      }
   }

}

