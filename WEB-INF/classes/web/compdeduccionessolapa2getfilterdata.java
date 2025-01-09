package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class compdeduccionessolapa2getfilterdata extends GXProcedure
{
   public compdeduccionessolapa2getfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( compdeduccionessolapa2getfilterdata.class ), "" );
   }

   public compdeduccionessolapa2getfilterdata( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      compdeduccionessolapa2getfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      compdeduccionessolapa2getfilterdata.this.AV35DDOName = aP0;
      compdeduccionessolapa2getfilterdata.this.AV36SearchTxt = aP1;
      compdeduccionessolapa2getfilterdata.this.AV37SearchTxtTo = aP2;
      compdeduccionessolapa2getfilterdata.this.aP3 = aP3;
      compdeduccionessolapa2getfilterdata.this.aP4 = aP4;
      compdeduccionessolapa2getfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV25Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa", GXv_boolean2) ;
      compdeduccionessolapa2getfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_LEGDEDCONCODYDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGDEDCONCODYDESCOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_LEGDEDDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGDEDDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV38OptionsJson = AV25Options.toJSonString(false) ;
      AV39OptionsDescJson = AV27OptionsDesc.toJSonString(false) ;
      AV40OptionIndexesJson = AV28OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("CompDeduccionesSolapa2GridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CompDeduccionesSolapa2GridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("CompDeduccionesSolapa2GridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDANIO") == 0 )
         {
            AV11TFLegDedAnio = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLegDedAnio_To = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDMES_SEL") == 0 )
         {
            AV13TFLegDedMes_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV14TFLegDedMes_Sels.fromJSonString(AV13TFLegDedMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC") == 0 )
         {
            AV16TFLegDedConCodYDesc = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC_SEL") == 0 )
         {
            AV15TFLegDedConCodYDesc_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFLegDedConCodYDesc_Sels.fromJSonString(AV15TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP") == 0 )
         {
            AV19TFLegDedDescrip = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP_SEL") == 0 )
         {
            AV18TFLegDedDescrip_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFLegDedDescrip_Sels.fromJSonString(AV18TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDIMPORTE") == 0 )
         {
            AV21TFLegDedImporte = CommonUtil.decimalVal( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV22TFLegDedImporte_To = CommonUtil.decimalVal( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV41CliCod = (int)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV42EmpCod = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV44LegNumero = (int)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGDEDCONCODYDESCOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLegDedConCodYDesc = AV36SearchTxt ;
      AV17TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV17TFLegDedConCodYDesc_Sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV14TFLegDedMes_Sels ,
                                           A568LegDedDescrip ,
                                           AV20TFLegDedDescrip_Sels ,
                                           Short.valueOf(AV11TFLegDedAnio) ,
                                           Short.valueOf(AV12TFLegDedAnio_To) ,
                                           Integer.valueOf(AV14TFLegDedMes_Sels.size()) ,
                                           Integer.valueOf(AV17TFLegDedConCodYDesc_Sels.size()) ,
                                           AV16TFLegDedConCodYDesc ,
                                           Integer.valueOf(AV20TFLegDedDescrip_Sels.size()) ,
                                           AV19TFLegDedDescrip ,
                                           AV21TFLegDedImporte ,
                                           AV22TFLegDedImporte_To ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(AV42EmpCod) ,
                                           Integer.valueOf(AV44LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLegDedConCodYDesc = GXutil.concat( GXutil.rtrim( AV16TFLegDedConCodYDesc), "%", "") ;
      lV19TFLegDedDescrip = GXutil.concat( GXutil.rtrim( AV19TFLegDedDescrip), "%", "") ;
      /* Using cursor P01QQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV42EmpCod), Integer.valueOf(AV44LegNumero), Integer.valueOf(AV17TFLegDedConCodYDesc_Sels.size()), Short.valueOf(AV11TFLegDedAnio), Short.valueOf(AV12TFLegDedAnio_To), lV16TFLegDedConCodYDesc, lV19TFLegDedDescrip, AV21TFLegDedImporte, AV22TFLegDedImporte_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1QQ2 = false ;
         A6LegNumero = P01QQ2_A6LegNumero[0] ;
         A1EmpCod = P01QQ2_A1EmpCod[0] ;
         A3CliCod = P01QQ2_A3CliCod[0] ;
         A560LegDedImporte = P01QQ2_A560LegDedImporte[0] ;
         A568LegDedDescrip = P01QQ2_A568LegDedDescrip[0] ;
         A570LegDedConCodYDesc = P01QQ2_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = P01QQ2_A767LegDedMes[0] ;
         A768LegDedAnio = P01QQ2_A768LegDedAnio[0] ;
         A84LegDedConCodigo = P01QQ2_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = P01QQ2_A559LegDedConDescrip[0] ;
         A83LegDedSec = P01QQ2_A83LegDedSec[0] ;
         A559LegDedConDescrip = P01QQ2_A559LegDedConDescrip[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01QQ2_A3CliCod[0] == A3CliCod ) && ( P01QQ2_A1EmpCod[0] == A1EmpCod ) && ( P01QQ2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QQ2_A84LegDedConCodigo[0], A84LegDedConCodigo) == 0 ) )
         {
            brk1QQ2 = false ;
            A83LegDedSec = P01QQ2_A83LegDedSec[0] ;
            AV29count = (long)(AV29count+1) ;
            brk1QQ2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A570LegDedConCodYDesc)==0) )
         {
            AV24Option = A570LegDedConCodYDesc ;
            AV23InsertIndex = 1 ;
            while ( ( AV23InsertIndex <= AV25Options.size() ) && ( GXutil.strcmp((String)AV25Options.elementAt(-1+AV23InsertIndex), AV24Option) < 0 ) )
            {
               AV23InsertIndex = (int)(AV23InsertIndex+1) ;
            }
            AV25Options.add(AV24Option, AV23InsertIndex);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), AV23InsertIndex);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QQ2 )
         {
            brk1QQ2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGDEDDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV19TFLegDedDescrip = AV36SearchTxt ;
      AV20TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV17TFLegDedConCodYDesc_Sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV14TFLegDedMes_Sels ,
                                           A568LegDedDescrip ,
                                           AV20TFLegDedDescrip_Sels ,
                                           Short.valueOf(AV11TFLegDedAnio) ,
                                           Short.valueOf(AV12TFLegDedAnio_To) ,
                                           Integer.valueOf(AV14TFLegDedMes_Sels.size()) ,
                                           Integer.valueOf(AV17TFLegDedConCodYDesc_Sels.size()) ,
                                           AV16TFLegDedConCodYDesc ,
                                           Integer.valueOf(AV20TFLegDedDescrip_Sels.size()) ,
                                           AV19TFLegDedDescrip ,
                                           AV21TFLegDedImporte ,
                                           AV22TFLegDedImporte_To ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(AV42EmpCod) ,
                                           Integer.valueOf(AV44LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLegDedConCodYDesc = GXutil.concat( GXutil.rtrim( AV16TFLegDedConCodYDesc), "%", "") ;
      lV19TFLegDedDescrip = GXutil.concat( GXutil.rtrim( AV19TFLegDedDescrip), "%", "") ;
      /* Using cursor P01QQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV42EmpCod), Integer.valueOf(AV44LegNumero), Integer.valueOf(AV17TFLegDedConCodYDesc_Sels.size()), Short.valueOf(AV11TFLegDedAnio), Short.valueOf(AV12TFLegDedAnio_To), lV16TFLegDedConCodYDesc, lV19TFLegDedDescrip, AV21TFLegDedImporte, AV22TFLegDedImporte_To});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1QQ4 = false ;
         A568LegDedDescrip = P01QQ3_A568LegDedDescrip[0] ;
         A6LegNumero = P01QQ3_A6LegNumero[0] ;
         A1EmpCod = P01QQ3_A1EmpCod[0] ;
         A3CliCod = P01QQ3_A3CliCod[0] ;
         A560LegDedImporte = P01QQ3_A560LegDedImporte[0] ;
         A570LegDedConCodYDesc = P01QQ3_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = P01QQ3_A767LegDedMes[0] ;
         A768LegDedAnio = P01QQ3_A768LegDedAnio[0] ;
         A84LegDedConCodigo = P01QQ3_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = P01QQ3_A559LegDedConDescrip[0] ;
         A83LegDedSec = P01QQ3_A83LegDedSec[0] ;
         A559LegDedConDescrip = P01QQ3_A559LegDedConDescrip[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01QQ3_A3CliCod[0] == A3CliCod ) && ( P01QQ3_A1EmpCod[0] == A1EmpCod ) && ( P01QQ3_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QQ3_A568LegDedDescrip[0], A568LegDedDescrip) == 0 ) )
         {
            brk1QQ4 = false ;
            A83LegDedSec = P01QQ3_A83LegDedSec[0] ;
            AV29count = (long)(AV29count+1) ;
            brk1QQ4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A568LegDedDescrip)==0) )
         {
            AV24Option = A568LegDedDescrip ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QQ4 )
         {
            brk1QQ4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = compdeduccionessolapa2getfilterdata.this.AV38OptionsJson;
      this.aP4[0] = compdeduccionessolapa2getfilterdata.this.AV39OptionsDescJson;
      this.aP5[0] = compdeduccionessolapa2getfilterdata.this.AV40OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV38OptionsJson = "" ;
      AV39OptionsDescJson = "" ;
      AV40OptionIndexesJson = "" ;
      AV25Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV13TFLegDedMes_SelsJson = "" ;
      AV14TFLegDedMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV16TFLegDedConCodYDesc = "" ;
      AV15TFLegDedConCodYDesc_SelsJson = "" ;
      AV17TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFLegDedDescrip = "" ;
      AV18TFLegDedDescrip_SelsJson = "" ;
      AV20TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFLegDedImporte = DecimalUtil.ZERO ;
      AV22TFLegDedImporte_To = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV16TFLegDedConCodYDesc = "" ;
      lV19TFLegDedDescrip = "" ;
      A570LegDedConCodYDesc = "" ;
      A568LegDedDescrip = "" ;
      A84LegDedConCodigo = "" ;
      A559LegDedConDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      P01QQ2_A6LegNumero = new int[1] ;
      P01QQ2_A1EmpCod = new short[1] ;
      P01QQ2_A3CliCod = new int[1] ;
      P01QQ2_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QQ2_A568LegDedDescrip = new String[] {""} ;
      P01QQ2_A570LegDedConCodYDesc = new String[] {""} ;
      P01QQ2_A767LegDedMes = new byte[1] ;
      P01QQ2_A768LegDedAnio = new short[1] ;
      P01QQ2_A84LegDedConCodigo = new String[] {""} ;
      P01QQ2_A559LegDedConDescrip = new String[] {""} ;
      P01QQ2_A83LegDedSec = new int[1] ;
      AV24Option = "" ;
      P01QQ3_A568LegDedDescrip = new String[] {""} ;
      P01QQ3_A6LegNumero = new int[1] ;
      P01QQ3_A1EmpCod = new short[1] ;
      P01QQ3_A3CliCod = new int[1] ;
      P01QQ3_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QQ3_A570LegDedConCodYDesc = new String[] {""} ;
      P01QQ3_A767LegDedMes = new byte[1] ;
      P01QQ3_A768LegDedAnio = new short[1] ;
      P01QQ3_A84LegDedConCodigo = new String[] {""} ;
      P01QQ3_A559LegDedConDescrip = new String[] {""} ;
      P01QQ3_A83LegDedSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.compdeduccionessolapa2getfilterdata__default(),
         new Object[] {
             new Object[] {
            P01QQ2_A6LegNumero, P01QQ2_A1EmpCod, P01QQ2_A3CliCod, P01QQ2_A560LegDedImporte, P01QQ2_A568LegDedDescrip, P01QQ2_A570LegDedConCodYDesc, P01QQ2_A767LegDedMes, P01QQ2_A768LegDedAnio, P01QQ2_A84LegDedConCodigo, P01QQ2_A559LegDedConDescrip,
            P01QQ2_A83LegDedSec
            }
            , new Object[] {
            P01QQ3_A568LegDedDescrip, P01QQ3_A6LegNumero, P01QQ3_A1EmpCod, P01QQ3_A3CliCod, P01QQ3_A560LegDedImporte, P01QQ3_A570LegDedConCodYDesc, P01QQ3_A767LegDedMes, P01QQ3_A768LegDedAnio, P01QQ3_A84LegDedConCodigo, P01QQ3_A559LegDedConDescrip,
            P01QQ3_A83LegDedSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A767LegDedMes ;
   private short AV11TFLegDedAnio ;
   private short AV12TFLegDedAnio_To ;
   private short AV42EmpCod ;
   private short A768LegDedAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV47GXV1 ;
   private int AV41CliCod ;
   private int AV44LegNumero ;
   private int AV14TFLegDedMes_Sels_size ;
   private int AV17TFLegDedConCodYDesc_Sels_size ;
   private int AV20TFLegDedDescrip_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int AV23InsertIndex ;
   private long AV29count ;
   private java.math.BigDecimal AV21TFLegDedImporte ;
   private java.math.BigDecimal AV22TFLegDedImporte_To ;
   private java.math.BigDecimal A560LegDedImporte ;
   private String scmdbuf ;
   private String A84LegDedConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1QQ2 ;
   private boolean brk1QQ4 ;
   private String AV38OptionsJson ;
   private String AV39OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV13TFLegDedMes_SelsJson ;
   private String AV15TFLegDedConCodYDesc_SelsJson ;
   private String AV18TFLegDedDescrip_SelsJson ;
   private String AV35DDOName ;
   private String AV36SearchTxt ;
   private String AV37SearchTxtTo ;
   private String AV16TFLegDedConCodYDesc ;
   private String AV19TFLegDedDescrip ;
   private String lV16TFLegDedConCodYDesc ;
   private String lV19TFLegDedDescrip ;
   private String A570LegDedConCodYDesc ;
   private String A568LegDedDescrip ;
   private String A559LegDedConDescrip ;
   private String AV24Option ;
   private GXSimpleCollection<Byte> AV14TFLegDedMes_Sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01QQ2_A6LegNumero ;
   private short[] P01QQ2_A1EmpCod ;
   private int[] P01QQ2_A3CliCod ;
   private java.math.BigDecimal[] P01QQ2_A560LegDedImporte ;
   private String[] P01QQ2_A568LegDedDescrip ;
   private String[] P01QQ2_A570LegDedConCodYDesc ;
   private byte[] P01QQ2_A767LegDedMes ;
   private short[] P01QQ2_A768LegDedAnio ;
   private String[] P01QQ2_A84LegDedConCodigo ;
   private String[] P01QQ2_A559LegDedConDescrip ;
   private int[] P01QQ2_A83LegDedSec ;
   private String[] P01QQ3_A568LegDedDescrip ;
   private int[] P01QQ3_A6LegNumero ;
   private short[] P01QQ3_A1EmpCod ;
   private int[] P01QQ3_A3CliCod ;
   private java.math.BigDecimal[] P01QQ3_A560LegDedImporte ;
   private String[] P01QQ3_A570LegDedConCodYDesc ;
   private byte[] P01QQ3_A767LegDedMes ;
   private short[] P01QQ3_A768LegDedAnio ;
   private String[] P01QQ3_A84LegDedConCodigo ;
   private String[] P01QQ3_A559LegDedConDescrip ;
   private int[] P01QQ3_A83LegDedSec ;
   private GXSimpleCollection<String> AV25Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV17TFLegDedConCodYDesc_Sels ;
   private GXSimpleCollection<String> AV20TFLegDedDescrip_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class compdeduccionessolapa2getfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01QQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV17TFLegDedConCodYDesc_Sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV14TFLegDedMes_Sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV20TFLegDedDescrip_Sels ,
                                          short AV11TFLegDedAnio ,
                                          short AV12TFLegDedAnio_To ,
                                          int AV14TFLegDedMes_Sels_size ,
                                          int AV17TFLegDedConCodYDesc_Sels_size ,
                                          String AV16TFLegDedConCodYDesc ,
                                          int AV20TFLegDedDescrip_Sels_size ,
                                          String AV19TFLegDedDescrip ,
                                          java.math.BigDecimal AV21TFLegDedImporte ,
                                          java.math.BigDecimal AV22TFLegDedImporte_To ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          int AV41CliCod ,
                                          short AV42EmpCod ,
                                          int AV44LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[10];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) AS LegDedConCodYDesc," ;
      scmdbuf += " T1.LegDedMes, T1.LegDedAnio, T1.LegDedConCodigo AS LegDedConCodigo, T2.ConDescrip AS LegDedConDescrip, T1.LegDedSec FROM (legajo_deducciones T1 INNER JOIN Concepto" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV17TFLegDedConCodYDesc_Sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) IN (", ")")+"))");
      if ( ! (0==AV11TFLegDedAnio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV12TFLegDedAnio_To) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( AV14TFLegDedMes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV14TFLegDedMes_Sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV17TFLegDedConCodYDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV16TFLegDedConCodYDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ( AV20TFLegDedDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFLegDedDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV20TFLegDedDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFLegDedDescrip_Sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV21TFLegDedImporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22TFLegDedImporte_To)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedConCodigo" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01QQ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV17TFLegDedConCodYDesc_Sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV14TFLegDedMes_Sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV20TFLegDedDescrip_Sels ,
                                          short AV11TFLegDedAnio ,
                                          short AV12TFLegDedAnio_To ,
                                          int AV14TFLegDedMes_Sels_size ,
                                          int AV17TFLegDedConCodYDesc_Sels_size ,
                                          String AV16TFLegDedConCodYDesc ,
                                          int AV20TFLegDedDescrip_Sels_size ,
                                          String AV19TFLegDedDescrip ,
                                          java.math.BigDecimal AV21TFLegDedImporte ,
                                          java.math.BigDecimal AV22TFLegDedImporte_To ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          int AV41CliCod ,
                                          short AV42EmpCod ,
                                          int AV44LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[10];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.LegDedDescrip, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedImporte, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) AS LegDedConCodYDesc," ;
      scmdbuf += " T1.LegDedMes, T1.LegDedAnio, T1.LegDedConCodigo AS LegDedConCodigo, T2.ConDescrip AS LegDedConDescrip, T1.LegDedSec FROM (legajo_deducciones T1 INNER JOIN Concepto" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV17TFLegDedConCodYDesc_Sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) IN (", ")")+"))");
      if ( ! (0==AV11TFLegDedAnio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int7[4] = (byte)(1) ;
      }
      if ( ! (0==AV12TFLegDedAnio_To) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( AV14TFLegDedMes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV14TFLegDedMes_Sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV17TFLegDedConCodYDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV16TFLegDedConCodYDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( ( AV20TFLegDedDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFLegDedDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( AV20TFLegDedDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFLegDedDescrip_Sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV21TFLegDedImporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22TFLegDedImporte_To)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedDescrip" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P01QQ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() );
            case 1 :
                  return conditional_P01QQ3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01QQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01QQ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

