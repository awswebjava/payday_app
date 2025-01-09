package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variable_listarwwgetfilterdata extends GXProcedure
{
   public variable_listarwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_listarwwgetfilterdata.class ), "" );
   }

   public variable_listarwwgetfilterdata( int remoteHandle ,
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
      variable_listarwwgetfilterdata.this.aP5 = new String[] {""};
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
      variable_listarwwgetfilterdata.this.AV35DDOName = aP0;
      variable_listarwwgetfilterdata.this.AV36SearchTxt = aP1;
      variable_listarwwgetfilterdata.this.AV37SearchTxtTo = aP2;
      variable_listarwwgetfilterdata.this.aP3 = aP3;
      variable_listarwwgetfilterdata.this.aP4 = aP4;
      variable_listarwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV42EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      variable_listarwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV42EmpCod = GXt_int1 ;
      GXt_int3 = AV43CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      variable_listarwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV43CliCod = GXt_int3 ;
      AV25Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar", GXv_boolean6) ;
      variable_listarwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_OPECLIID") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECLIIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_OPECLICODFORMULA") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECLICODFORMULAOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_OPECLIDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECLIDESCRIPOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_VARRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADVARRELREFOPTIONS' */
            S151 ();
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
      if ( GXutil.strcmp(AV30Session.getValue("Variable_listarWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Variable_listarWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("Variable_listarWWGridState"), null, null);
      }
      AV59GXV1 = 1 ;
      while ( AV59GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV59GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID") == 0 )
         {
            AV12TFOpeCliId = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID_SEL") == 0 )
         {
            AV11TFOpeCliId_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFOpeCliId_Sels.fromJSonString(AV11TFOpeCliId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLICODFORMULA") == 0 )
         {
            AV15TFOpeCliCodFormula = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLICODFORMULA_SEL") == 0 )
         {
            AV14TFOpeCliCodFormula_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFOpeCliCodFormula_Sels.fromJSonString(AV14TFOpeCliCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIDESCRIP") == 0 )
         {
            AV18TFOpeCliDescrip = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIDESCRIP_SEL") == 0 )
         {
            AV17TFOpeCliDescrip_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFOpeCliDescrip_Sels.fromJSonString(AV17TFOpeCliDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIESCANT_SEL") == 0 )
         {
            AV21TFOpeCliEsCant_Sel = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIALIES_SEL") == 0 )
         {
            AV22TFOpeCliAliEs_Sel = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARRELREF") == 0 )
         {
            AV53TFVarRelRef = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARRELREF_SEL") == 0 )
         {
            AV52TFVarRelRef_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFVarRelRef_Sels.fromJSonString(AV52TFVarRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARFRECACT") == 0 )
         {
            AV55TFVarFrecAct = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFVarFrecAct_To = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV51MenuOpcCod = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV59GXV1 = (int)(AV59GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADOPECLIIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFOpeCliId = AV36SearchTxt ;
      AV13TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61Variable_listarwwds_1_tfopecliid = AV12TFOpeCliId ;
      AV62Variable_listarwwds_2_tfopecliid_sels = AV13TFOpeCliId_Sels ;
      AV63Variable_listarwwds_3_tfopeclicodformula = AV15TFOpeCliCodFormula ;
      AV64Variable_listarwwds_4_tfopeclicodformula_sels = AV16TFOpeCliCodFormula_Sels ;
      AV65Variable_listarwwds_5_tfopeclidescrip = AV18TFOpeCliDescrip ;
      AV66Variable_listarwwds_6_tfopeclidescrip_sels = AV19TFOpeCliDescrip_Sels ;
      AV67Variable_listarwwds_7_tfopecliescant_sel = AV21TFOpeCliEsCant_Sel ;
      AV68Variable_listarwwds_8_tfopeclialies_sel = AV22TFOpeCliAliEs_Sel ;
      AV69Variable_listarwwds_9_tfvarrelref = AV53TFVarRelRef ;
      AV70Variable_listarwwds_10_tfvarrelref_sels = AV54TFVarRelRef_Sels ;
      AV71Variable_listarwwds_11_tfvarfrecact = AV55TFVarFrecAct ;
      AV72Variable_listarwwds_12_tfvarfrecact_to = AV56TFVarFrecAct_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV62Variable_listarwwds_2_tfopecliid_sels ,
                                           A549OpeCliCodFormula ,
                                           AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                           A534OpeCliDescrip ,
                                           AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                           A2011VarRelRef ,
                                           AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                           Integer.valueOf(AV62Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                           AV61Variable_listarwwds_1_tfopecliid ,
                                           Integer.valueOf(AV64Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                           AV63Variable_listarwwds_3_tfopeclicodformula ,
                                           Integer.valueOf(AV66Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                           AV65Variable_listarwwds_5_tfopeclidescrip ,
                                           Byte.valueOf(AV67Variable_listarwwds_7_tfopecliescant_sel) ,
                                           Byte.valueOf(AV68Variable_listarwwds_8_tfopeclialies_sel) ,
                                           Integer.valueOf(AV70Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                           AV69Variable_listarwwds_9_tfvarrelref ,
                                           Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact) ,
                                           Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to) ,
                                           Boolean.valueOf(A931OpeCliEsCant) ,
                                           Boolean.valueOf(A934OpeCliAliEs) ,
                                           Byte.valueOf(A1913VarFrecAct) ,
                                           Integer.valueOf(AV43CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV61Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV61Variable_listarwwds_1_tfopecliid), 40, "%") ;
      lV63Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV63Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
      lV65Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV65Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
      lV69Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV69Variable_listarwwds_9_tfvarrelref), "%", "") ;
      /* Using cursor P01PX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV43CliCod), lV61Variable_listarwwds_1_tfopecliid, lV63Variable_listarwwds_3_tfopeclicodformula, lV65Variable_listarwwds_5_tfopeclidescrip, lV69Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1PX2 = false ;
         A3CliCod = P01PX2_A3CliCod[0] ;
         A82OpeCliId = P01PX2_A82OpeCliId[0] ;
         A1913VarFrecAct = P01PX2_A1913VarFrecAct[0] ;
         A2011VarRelRef = P01PX2_A2011VarRelRef[0] ;
         A934OpeCliAliEs = P01PX2_A934OpeCliAliEs[0] ;
         A931OpeCliEsCant = P01PX2_A931OpeCliEsCant[0] ;
         A534OpeCliDescrip = P01PX2_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P01PX2_A549OpeCliCodFormula[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01PX2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01PX2_A82OpeCliId[0], A82OpeCliId) == 0 ) )
         {
            brk1PX2 = false ;
            AV29count = (long)(AV29count+1) ;
            brk1PX2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A82OpeCliId)==0) )
         {
            AV24Option = A82OpeCliId ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PX2 )
         {
            brk1PX2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADOPECLICODFORMULAOPTIONS' Routine */
      returnInSub = false ;
      AV15TFOpeCliCodFormula = AV36SearchTxt ;
      AV16TFOpeCliCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61Variable_listarwwds_1_tfopecliid = AV12TFOpeCliId ;
      AV62Variable_listarwwds_2_tfopecliid_sels = AV13TFOpeCliId_Sels ;
      AV63Variable_listarwwds_3_tfopeclicodformula = AV15TFOpeCliCodFormula ;
      AV64Variable_listarwwds_4_tfopeclicodformula_sels = AV16TFOpeCliCodFormula_Sels ;
      AV65Variable_listarwwds_5_tfopeclidescrip = AV18TFOpeCliDescrip ;
      AV66Variable_listarwwds_6_tfopeclidescrip_sels = AV19TFOpeCliDescrip_Sels ;
      AV67Variable_listarwwds_7_tfopecliescant_sel = AV21TFOpeCliEsCant_Sel ;
      AV68Variable_listarwwds_8_tfopeclialies_sel = AV22TFOpeCliAliEs_Sel ;
      AV69Variable_listarwwds_9_tfvarrelref = AV53TFVarRelRef ;
      AV70Variable_listarwwds_10_tfvarrelref_sels = AV54TFVarRelRef_Sels ;
      AV71Variable_listarwwds_11_tfvarfrecact = AV55TFVarFrecAct ;
      AV72Variable_listarwwds_12_tfvarfrecact_to = AV56TFVarFrecAct_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV62Variable_listarwwds_2_tfopecliid_sels ,
                                           A549OpeCliCodFormula ,
                                           AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                           A534OpeCliDescrip ,
                                           AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                           A2011VarRelRef ,
                                           AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                           Integer.valueOf(AV62Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                           AV61Variable_listarwwds_1_tfopecliid ,
                                           Integer.valueOf(AV64Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                           AV63Variable_listarwwds_3_tfopeclicodformula ,
                                           Integer.valueOf(AV66Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                           AV65Variable_listarwwds_5_tfopeclidescrip ,
                                           Byte.valueOf(AV67Variable_listarwwds_7_tfopecliescant_sel) ,
                                           Byte.valueOf(AV68Variable_listarwwds_8_tfopeclialies_sel) ,
                                           Integer.valueOf(AV70Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                           AV69Variable_listarwwds_9_tfvarrelref ,
                                           Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact) ,
                                           Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to) ,
                                           Boolean.valueOf(A931OpeCliEsCant) ,
                                           Boolean.valueOf(A934OpeCliAliEs) ,
                                           Byte.valueOf(A1913VarFrecAct) ,
                                           Integer.valueOf(AV43CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV61Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV61Variable_listarwwds_1_tfopecliid), 40, "%") ;
      lV63Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV63Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
      lV65Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV65Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
      lV69Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV69Variable_listarwwds_9_tfvarrelref), "%", "") ;
      /* Using cursor P01PX3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV43CliCod), lV61Variable_listarwwds_1_tfopecliid, lV63Variable_listarwwds_3_tfopeclicodformula, lV65Variable_listarwwds_5_tfopeclidescrip, lV69Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1PX4 = false ;
         A3CliCod = P01PX3_A3CliCod[0] ;
         A549OpeCliCodFormula = P01PX3_A549OpeCliCodFormula[0] ;
         A1913VarFrecAct = P01PX3_A1913VarFrecAct[0] ;
         A2011VarRelRef = P01PX3_A2011VarRelRef[0] ;
         A934OpeCliAliEs = P01PX3_A934OpeCliAliEs[0] ;
         A931OpeCliEsCant = P01PX3_A931OpeCliEsCant[0] ;
         A534OpeCliDescrip = P01PX3_A534OpeCliDescrip[0] ;
         A82OpeCliId = P01PX3_A82OpeCliId[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01PX3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01PX3_A549OpeCliCodFormula[0], A549OpeCliCodFormula) == 0 ) )
         {
            brk1PX4 = false ;
            A82OpeCliId = P01PX3_A82OpeCliId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk1PX4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A549OpeCliCodFormula)==0) )
         {
            AV24Option = A549OpeCliCodFormula ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PX4 )
         {
            brk1PX4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADOPECLIDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV43CliCod, 6, 0))+httpContext.getMessage( " &TFOpeCliId ", "")+AV12TFOpeCliId) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&TFOpeCliId_Sels ", "")+GXutil.trim( GXutil.str( AV13TFOpeCliId_Sels.size(), 9, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&TFOpeCliCodFormula ", "")+AV15TFOpeCliCodFormula) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&TFVarRelRef ", "")+AV53TFVarRelRef) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&&TFOpeCliUltVal ", "")+AV45TFOpeCliUltVal) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&TFOpeCliCodFormula_Sels ", "")+GXutil.trim( GXutil.str( AV16TFOpeCliCodFormula_Sels.size(), 9, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&TFOpeCliDescrip_Sels ", "")+GXutil.trim( GXutil.str( AV19TFOpeCliDescrip_Sels.size(), 9, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&TFOpeCliEsCant_Sel ", "")+GXutil.trim( GXutil.str( AV21TFOpeCliEsCant_Sel, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&TFOpeCliAliEs_Sel ", "")+GXutil.trim( GXutil.str( AV22TFOpeCliAliEs_Sel, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&TFOpeCliUltVal_Sels ", "")+GXutil.trim( GXutil.str( AV46TFOpeCliUltVal_Sels.size(), 9, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV76Pgmname, httpContext.getMessage( "&&&TFVarRelRef_Sels ", "")+GXutil.trim( GXutil.str( AV54TFVarRelRef_Sels.size(), 9, 0))) ;
      AV18TFOpeCliDescrip = AV36SearchTxt ;
      AV19TFOpeCliDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61Variable_listarwwds_1_tfopecliid = AV12TFOpeCliId ;
      AV62Variable_listarwwds_2_tfopecliid_sels = AV13TFOpeCliId_Sels ;
      AV63Variable_listarwwds_3_tfopeclicodformula = AV15TFOpeCliCodFormula ;
      AV64Variable_listarwwds_4_tfopeclicodformula_sels = AV16TFOpeCliCodFormula_Sels ;
      AV65Variable_listarwwds_5_tfopeclidescrip = AV18TFOpeCliDescrip ;
      AV66Variable_listarwwds_6_tfopeclidescrip_sels = AV19TFOpeCliDescrip_Sels ;
      AV67Variable_listarwwds_7_tfopecliescant_sel = AV21TFOpeCliEsCant_Sel ;
      AV68Variable_listarwwds_8_tfopeclialies_sel = AV22TFOpeCliAliEs_Sel ;
      AV69Variable_listarwwds_9_tfvarrelref = AV53TFVarRelRef ;
      AV70Variable_listarwwds_10_tfvarrelref_sels = AV54TFVarRelRef_Sels ;
      AV71Variable_listarwwds_11_tfvarfrecact = AV55TFVarFrecAct ;
      AV72Variable_listarwwds_12_tfvarfrecact_to = AV56TFVarFrecAct_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV62Variable_listarwwds_2_tfopecliid_sels ,
                                           A549OpeCliCodFormula ,
                                           AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                           A534OpeCliDescrip ,
                                           AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                           A2011VarRelRef ,
                                           AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                           Integer.valueOf(AV62Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                           AV61Variable_listarwwds_1_tfopecliid ,
                                           Integer.valueOf(AV64Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                           AV63Variable_listarwwds_3_tfopeclicodformula ,
                                           Integer.valueOf(AV66Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                           AV65Variable_listarwwds_5_tfopeclidescrip ,
                                           Byte.valueOf(AV67Variable_listarwwds_7_tfopecliescant_sel) ,
                                           Byte.valueOf(AV68Variable_listarwwds_8_tfopeclialies_sel) ,
                                           Integer.valueOf(AV70Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                           AV69Variable_listarwwds_9_tfvarrelref ,
                                           Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact) ,
                                           Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to) ,
                                           Boolean.valueOf(A931OpeCliEsCant) ,
                                           Boolean.valueOf(A934OpeCliAliEs) ,
                                           Byte.valueOf(A1913VarFrecAct) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV43CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV61Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV61Variable_listarwwds_1_tfopecliid), 40, "%") ;
      lV63Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV63Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
      lV65Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV65Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
      lV69Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV69Variable_listarwwds_9_tfvarrelref), "%", "") ;
      /* Using cursor P01PX4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV43CliCod), lV61Variable_listarwwds_1_tfopecliid, lV63Variable_listarwwds_3_tfopeclicodformula, lV65Variable_listarwwds_5_tfopeclidescrip, lV69Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1PX6 = false ;
         A3CliCod = P01PX4_A3CliCod[0] ;
         A534OpeCliDescrip = P01PX4_A534OpeCliDescrip[0] ;
         A1913VarFrecAct = P01PX4_A1913VarFrecAct[0] ;
         A2011VarRelRef = P01PX4_A2011VarRelRef[0] ;
         A934OpeCliAliEs = P01PX4_A934OpeCliAliEs[0] ;
         A931OpeCliEsCant = P01PX4_A931OpeCliEsCant[0] ;
         A549OpeCliCodFormula = P01PX4_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P01PX4_A82OpeCliId[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01PX4_A534OpeCliDescrip[0], A534OpeCliDescrip) == 0 ) )
         {
            brk1PX6 = false ;
            A3CliCod = P01PX4_A3CliCod[0] ;
            A82OpeCliId = P01PX4_A82OpeCliId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk1PX6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A534OpeCliDescrip)==0) )
         {
            AV24Option = A534OpeCliDescrip ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PX6 )
         {
            brk1PX6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADVARRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV53TFVarRelRef = AV36SearchTxt ;
      AV54TFVarRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61Variable_listarwwds_1_tfopecliid = AV12TFOpeCliId ;
      AV62Variable_listarwwds_2_tfopecliid_sels = AV13TFOpeCliId_Sels ;
      AV63Variable_listarwwds_3_tfopeclicodformula = AV15TFOpeCliCodFormula ;
      AV64Variable_listarwwds_4_tfopeclicodformula_sels = AV16TFOpeCliCodFormula_Sels ;
      AV65Variable_listarwwds_5_tfopeclidescrip = AV18TFOpeCliDescrip ;
      AV66Variable_listarwwds_6_tfopeclidescrip_sels = AV19TFOpeCliDescrip_Sels ;
      AV67Variable_listarwwds_7_tfopecliescant_sel = AV21TFOpeCliEsCant_Sel ;
      AV68Variable_listarwwds_8_tfopeclialies_sel = AV22TFOpeCliAliEs_Sel ;
      AV69Variable_listarwwds_9_tfvarrelref = AV53TFVarRelRef ;
      AV70Variable_listarwwds_10_tfvarrelref_sels = AV54TFVarRelRef_Sels ;
      AV71Variable_listarwwds_11_tfvarfrecact = AV55TFVarFrecAct ;
      AV72Variable_listarwwds_12_tfvarfrecact_to = AV56TFVarFrecAct_To ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV62Variable_listarwwds_2_tfopecliid_sels ,
                                           A549OpeCliCodFormula ,
                                           AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                           A534OpeCliDescrip ,
                                           AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                           A2011VarRelRef ,
                                           AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                           Integer.valueOf(AV62Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                           AV61Variable_listarwwds_1_tfopecliid ,
                                           Integer.valueOf(AV64Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                           AV63Variable_listarwwds_3_tfopeclicodformula ,
                                           Integer.valueOf(AV66Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                           AV65Variable_listarwwds_5_tfopeclidescrip ,
                                           Byte.valueOf(AV67Variable_listarwwds_7_tfopecliescant_sel) ,
                                           Byte.valueOf(AV68Variable_listarwwds_8_tfopeclialies_sel) ,
                                           Integer.valueOf(AV70Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                           AV69Variable_listarwwds_9_tfvarrelref ,
                                           Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact) ,
                                           Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to) ,
                                           Boolean.valueOf(A931OpeCliEsCant) ,
                                           Boolean.valueOf(A934OpeCliAliEs) ,
                                           Byte.valueOf(A1913VarFrecAct) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV43CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV61Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV61Variable_listarwwds_1_tfopecliid), 40, "%") ;
      lV63Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV63Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
      lV65Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV65Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
      lV69Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV69Variable_listarwwds_9_tfvarrelref), "%", "") ;
      /* Using cursor P01PX5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV43CliCod), lV61Variable_listarwwds_1_tfopecliid, lV63Variable_listarwwds_3_tfopeclicodformula, lV65Variable_listarwwds_5_tfopeclidescrip, lV69Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV71Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV72Variable_listarwwds_12_tfvarfrecact_to)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk1PX8 = false ;
         A3CliCod = P01PX5_A3CliCod[0] ;
         A2011VarRelRef = P01PX5_A2011VarRelRef[0] ;
         A1913VarFrecAct = P01PX5_A1913VarFrecAct[0] ;
         A934OpeCliAliEs = P01PX5_A934OpeCliAliEs[0] ;
         A931OpeCliEsCant = P01PX5_A931OpeCliEsCant[0] ;
         A534OpeCliDescrip = P01PX5_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P01PX5_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P01PX5_A82OpeCliId[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P01PX5_A2011VarRelRef[0], A2011VarRelRef) == 0 ) )
         {
            brk1PX8 = false ;
            A3CliCod = P01PX5_A3CliCod[0] ;
            A82OpeCliId = P01PX5_A82OpeCliId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk1PX8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A2011VarRelRef)==0) )
         {
            AV24Option = A2011VarRelRef ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PX8 )
         {
            brk1PX8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = variable_listarwwgetfilterdata.this.AV38OptionsJson;
      this.aP4[0] = variable_listarwwgetfilterdata.this.AV39OptionsDescJson;
      this.aP5[0] = variable_listarwwgetfilterdata.this.AV40OptionIndexesJson;
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
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV25Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFOpeCliId = "" ;
      AV11TFOpeCliId_SelsJson = "" ;
      AV13TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFOpeCliCodFormula = "" ;
      AV14TFOpeCliCodFormula_SelsJson = "" ;
      AV16TFOpeCliCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFOpeCliDescrip = "" ;
      AV17TFOpeCliDescrip_SelsJson = "" ;
      AV19TFOpeCliDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFVarRelRef = "" ;
      AV52TFVarRelRef_SelsJson = "" ;
      AV54TFVarRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51MenuOpcCod = "" ;
      A82OpeCliId = "" ;
      AV61Variable_listarwwds_1_tfopecliid = "" ;
      AV62Variable_listarwwds_2_tfopecliid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Variable_listarwwds_3_tfopeclicodformula = "" ;
      AV64Variable_listarwwds_4_tfopeclicodformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Variable_listarwwds_5_tfopeclidescrip = "" ;
      AV66Variable_listarwwds_6_tfopeclidescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Variable_listarwwds_9_tfvarrelref = "" ;
      AV70Variable_listarwwds_10_tfvarrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV61Variable_listarwwds_1_tfopecliid = "" ;
      lV63Variable_listarwwds_3_tfopeclicodformula = "" ;
      lV65Variable_listarwwds_5_tfopeclidescrip = "" ;
      lV69Variable_listarwwds_9_tfvarrelref = "" ;
      A549OpeCliCodFormula = "" ;
      A534OpeCliDescrip = "" ;
      A2011VarRelRef = "" ;
      P01PX2_A3CliCod = new int[1] ;
      P01PX2_A82OpeCliId = new String[] {""} ;
      P01PX2_A1913VarFrecAct = new byte[1] ;
      P01PX2_A2011VarRelRef = new String[] {""} ;
      P01PX2_A934OpeCliAliEs = new boolean[] {false} ;
      P01PX2_A931OpeCliEsCant = new boolean[] {false} ;
      P01PX2_A534OpeCliDescrip = new String[] {""} ;
      P01PX2_A549OpeCliCodFormula = new String[] {""} ;
      AV24Option = "" ;
      P01PX3_A3CliCod = new int[1] ;
      P01PX3_A549OpeCliCodFormula = new String[] {""} ;
      P01PX3_A1913VarFrecAct = new byte[1] ;
      P01PX3_A2011VarRelRef = new String[] {""} ;
      P01PX3_A934OpeCliAliEs = new boolean[] {false} ;
      P01PX3_A931OpeCliEsCant = new boolean[] {false} ;
      P01PX3_A534OpeCliDescrip = new String[] {""} ;
      P01PX3_A82OpeCliId = new String[] {""} ;
      AV76Pgmname = "" ;
      AV45TFOpeCliUltVal = "" ;
      AV46TFOpeCliUltVal_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      P01PX4_A3CliCod = new int[1] ;
      P01PX4_A534OpeCliDescrip = new String[] {""} ;
      P01PX4_A1913VarFrecAct = new byte[1] ;
      P01PX4_A2011VarRelRef = new String[] {""} ;
      P01PX4_A934OpeCliAliEs = new boolean[] {false} ;
      P01PX4_A931OpeCliEsCant = new boolean[] {false} ;
      P01PX4_A549OpeCliCodFormula = new String[] {""} ;
      P01PX4_A82OpeCliId = new String[] {""} ;
      P01PX5_A3CliCod = new int[1] ;
      P01PX5_A2011VarRelRef = new String[] {""} ;
      P01PX5_A1913VarFrecAct = new byte[1] ;
      P01PX5_A934OpeCliAliEs = new boolean[] {false} ;
      P01PX5_A931OpeCliEsCant = new boolean[] {false} ;
      P01PX5_A534OpeCliDescrip = new String[] {""} ;
      P01PX5_A549OpeCliCodFormula = new String[] {""} ;
      P01PX5_A82OpeCliId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_listarwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01PX2_A3CliCod, P01PX2_A82OpeCliId, P01PX2_A1913VarFrecAct, P01PX2_A2011VarRelRef, P01PX2_A934OpeCliAliEs, P01PX2_A931OpeCliEsCant, P01PX2_A534OpeCliDescrip, P01PX2_A549OpeCliCodFormula
            }
            , new Object[] {
            P01PX3_A3CliCod, P01PX3_A549OpeCliCodFormula, P01PX3_A1913VarFrecAct, P01PX3_A2011VarRelRef, P01PX3_A934OpeCliAliEs, P01PX3_A931OpeCliEsCant, P01PX3_A534OpeCliDescrip, P01PX3_A82OpeCliId
            }
            , new Object[] {
            P01PX4_A3CliCod, P01PX4_A534OpeCliDescrip, P01PX4_A1913VarFrecAct, P01PX4_A2011VarRelRef, P01PX4_A934OpeCliAliEs, P01PX4_A931OpeCliEsCant, P01PX4_A549OpeCliCodFormula, P01PX4_A82OpeCliId
            }
            , new Object[] {
            P01PX5_A3CliCod, P01PX5_A2011VarRelRef, P01PX5_A1913VarFrecAct, P01PX5_A934OpeCliAliEs, P01PX5_A931OpeCliEsCant, P01PX5_A534OpeCliDescrip, P01PX5_A549OpeCliCodFormula, P01PX5_A82OpeCliId
            }
         }
      );
      AV76Pgmname = "Variable_listarWWGetFilterData" ;
      /* GeneXus formulas. */
      AV76Pgmname = "Variable_listarWWGetFilterData" ;
      Gx_err = (short)(0) ;
   }

   private byte AV21TFOpeCliEsCant_Sel ;
   private byte AV22TFOpeCliAliEs_Sel ;
   private byte AV55TFVarFrecAct ;
   private byte AV56TFVarFrecAct_To ;
   private byte AV67Variable_listarwwds_7_tfopecliescant_sel ;
   private byte AV68Variable_listarwwds_8_tfopeclialies_sel ;
   private byte AV71Variable_listarwwds_11_tfvarfrecact ;
   private byte AV72Variable_listarwwds_12_tfvarfrecact_to ;
   private byte A1913VarFrecAct ;
   private short AV42EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV43CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV59GXV1 ;
   private int AV62Variable_listarwwds_2_tfopecliid_sels_size ;
   private int AV64Variable_listarwwds_4_tfopeclicodformula_sels_size ;
   private int AV66Variable_listarwwds_6_tfopeclidescrip_sels_size ;
   private int AV70Variable_listarwwds_10_tfvarrelref_sels_size ;
   private int A3CliCod ;
   private long AV29count ;
   private String AV12TFOpeCliId ;
   private String AV15TFOpeCliCodFormula ;
   private String A82OpeCliId ;
   private String AV61Variable_listarwwds_1_tfopecliid ;
   private String AV63Variable_listarwwds_3_tfopeclicodformula ;
   private String scmdbuf ;
   private String lV61Variable_listarwwds_1_tfopecliid ;
   private String lV63Variable_listarwwds_3_tfopeclicodformula ;
   private String A549OpeCliCodFormula ;
   private String AV76Pgmname ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean brk1PX2 ;
   private boolean brk1PX4 ;
   private boolean brk1PX6 ;
   private boolean brk1PX8 ;
   private String AV38OptionsJson ;
   private String AV39OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV11TFOpeCliId_SelsJson ;
   private String AV14TFOpeCliCodFormula_SelsJson ;
   private String AV17TFOpeCliDescrip_SelsJson ;
   private String AV52TFVarRelRef_SelsJson ;
   private String AV35DDOName ;
   private String AV36SearchTxt ;
   private String AV37SearchTxtTo ;
   private String AV18TFOpeCliDescrip ;
   private String AV53TFVarRelRef ;
   private String AV51MenuOpcCod ;
   private String AV65Variable_listarwwds_5_tfopeclidescrip ;
   private String AV69Variable_listarwwds_9_tfvarrelref ;
   private String lV65Variable_listarwwds_5_tfopeclidescrip ;
   private String lV69Variable_listarwwds_9_tfvarrelref ;
   private String A534OpeCliDescrip ;
   private String A2011VarRelRef ;
   private String AV24Option ;
   private String AV45TFOpeCliUltVal ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private GXSimpleCollection<String> AV46TFOpeCliUltVal_Sels ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01PX2_A3CliCod ;
   private String[] P01PX2_A82OpeCliId ;
   private byte[] P01PX2_A1913VarFrecAct ;
   private String[] P01PX2_A2011VarRelRef ;
   private boolean[] P01PX2_A934OpeCliAliEs ;
   private boolean[] P01PX2_A931OpeCliEsCant ;
   private String[] P01PX2_A534OpeCliDescrip ;
   private String[] P01PX2_A549OpeCliCodFormula ;
   private int[] P01PX3_A3CliCod ;
   private String[] P01PX3_A549OpeCliCodFormula ;
   private byte[] P01PX3_A1913VarFrecAct ;
   private String[] P01PX3_A2011VarRelRef ;
   private boolean[] P01PX3_A934OpeCliAliEs ;
   private boolean[] P01PX3_A931OpeCliEsCant ;
   private String[] P01PX3_A534OpeCliDescrip ;
   private String[] P01PX3_A82OpeCliId ;
   private int[] P01PX4_A3CliCod ;
   private String[] P01PX4_A534OpeCliDescrip ;
   private byte[] P01PX4_A1913VarFrecAct ;
   private String[] P01PX4_A2011VarRelRef ;
   private boolean[] P01PX4_A934OpeCliAliEs ;
   private boolean[] P01PX4_A931OpeCliEsCant ;
   private String[] P01PX4_A549OpeCliCodFormula ;
   private String[] P01PX4_A82OpeCliId ;
   private int[] P01PX5_A3CliCod ;
   private String[] P01PX5_A2011VarRelRef ;
   private byte[] P01PX5_A1913VarFrecAct ;
   private boolean[] P01PX5_A934OpeCliAliEs ;
   private boolean[] P01PX5_A931OpeCliEsCant ;
   private String[] P01PX5_A534OpeCliDescrip ;
   private String[] P01PX5_A549OpeCliCodFormula ;
   private String[] P01PX5_A82OpeCliId ;
   private GXSimpleCollection<String> AV13TFOpeCliId_Sels ;
   private GXSimpleCollection<String> AV16TFOpeCliCodFormula_Sels ;
   private GXSimpleCollection<String> AV62Variable_listarwwds_2_tfopecliid_sels ;
   private GXSimpleCollection<String> AV64Variable_listarwwds_4_tfopeclicodformula_sels ;
   private GXSimpleCollection<String> AV25Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV19TFOpeCliDescrip_Sels ;
   private GXSimpleCollection<String> AV54TFVarRelRef_Sels ;
   private GXSimpleCollection<String> AV66Variable_listarwwds_6_tfopeclidescrip_sels ;
   private GXSimpleCollection<String> AV70Variable_listarwwds_10_tfvarrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class variable_listarwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01PX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV62Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV62Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV61Variable_listarwwds_1_tfopecliid ,
                                          int AV64Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV63Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV66Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV65Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV67Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV68Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV70Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV69Variable_listarwwds_9_tfvarrelref ,
                                          byte AV71Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV72Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          int AV43CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliId, VarFrecAct, VarRelRef, OpeCliAliEs, OpeCliEsCant, OpeCliDescrip, OpeCliCodFormula FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV62Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV62Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV70Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV70Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV71Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV72Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01PX3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV62Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV62Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV61Variable_listarwwds_1_tfopecliid ,
                                          int AV64Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV63Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV66Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV65Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV67Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV68Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV70Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV69Variable_listarwwds_9_tfvarrelref ,
                                          byte AV71Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV72Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          int AV43CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[7];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliCodFormula, VarFrecAct, VarRelRef, OpeCliAliEs, OpeCliEsCant, OpeCliDescrip, OpeCliId FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV62Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV62Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV70Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV70Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV71Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV72Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliCodFormula" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01PX4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV62Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV62Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV61Variable_listarwwds_1_tfopecliid ,
                                          int AV64Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV63Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV66Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV65Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV67Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV68Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV70Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV69Variable_listarwwds_9_tfvarrelref ,
                                          byte AV71Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV72Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          int A3CliCod ,
                                          int AV43CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[7];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliDescrip, VarFrecAct, VarRelRef, OpeCliAliEs, OpeCliEsCant, OpeCliCodFormula, OpeCliId FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV62Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV62Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV70Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV70Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV71Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (0==AV72Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OpeCliDescrip" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P01PX5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV62Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV64Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV66Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV70Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV62Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV61Variable_listarwwds_1_tfopecliid ,
                                          int AV64Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV63Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV66Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV65Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV67Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV68Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV70Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV69Variable_listarwwds_9_tfvarrelref ,
                                          byte AV71Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV72Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          int A3CliCod ,
                                          int AV43CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[7];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT CliCod, VarRelRef, VarFrecAct, OpeCliAliEs, OpeCliEsCant, OpeCliDescrip, OpeCliCodFormula, OpeCliId FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV62Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV62Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV64Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV66Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV67Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV68Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV70Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV70Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV71Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! (0==AV72Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY VarRelRef" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P01PX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 1 :
                  return conditional_P01PX3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 2 :
                  return conditional_P01PX4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 3 :
                  return conditional_P01PX5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PX3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PX4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PX5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               return;
      }
   }

}

