package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class bancowwgetfilterdata extends GXProcedure
{
   public bancowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( bancowwgetfilterdata.class ), "" );
   }

   public bancowwgetfilterdata( int remoteHandle ,
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
      bancowwgetfilterdata.this.aP5 = new String[] {""};
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
      bancowwgetfilterdata.this.AV23DDOName = aP0;
      bancowwgetfilterdata.this.AV21SearchTxt = aP1;
      bancowwgetfilterdata.this.AV22SearchTxtTo = aP2;
      bancowwgetfilterdata.this.aP3 = aP3;
      bancowwgetfilterdata.this.aP4 = aP4;
      bancowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      bancowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      bancowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWBanco", GXv_boolean6) ;
      bancowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_BANCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADBANCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_BANDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADBANDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_BANCORELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADBANCORELREFOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV27OptionsJson = AV26Options.toJSonString(false) ;
      AV30OptionsDescJson = AV29OptionsDesc.toJSonString(false) ;
      AV32OptionIndexesJson = AV31OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV34Session.getValue("BancoWWGridState"), "") == 0 )
      {
         AV36GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "BancoWWGridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV34Session.getValue("BancoWWGridState"), null, null);
      }
      AV63GXV1 = 1 ;
      while ( AV63GXV1 <= AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV37GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV1));
         if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANCOD") == 0 )
         {
            AV12TFBanCod = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANCOD_SEL") == 0 )
         {
            AV11TFBanCod_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFBanCod_Sels.fromJSonString(AV11TFBanCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANDESCRIP") == 0 )
         {
            AV15TFBanDescrip = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANDESCRIP_SEL") == 0 )
         {
            AV14TFBanDescrip_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFBanDescrip_Sels.fromJSonString(AV14TFBanDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANHABILITADO_SEL") == 0 )
         {
            AV17TFBanHabilitado_Sel = (byte)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANCORELREF") == 0 )
         {
            AV44TFBancoRelRef = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANCORELREF_SEL") == 0 )
         {
            AV43TFBancoRelRef_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFBancoRelRef_Sels.fromJSonString(AV43TFBancoRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV42MenuOpcCod = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV63GXV1 = (int)(AV63GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADBANCODOPTIONS' Routine */
      returnInSub = false ;
      AV12TFBanCod = AV21SearchTxt ;
      AV13TFBanCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65Bancowwds_1_tfbancod = AV12TFBanCod ;
      AV66Bancowwds_2_tfbancod_sels = AV13TFBanCod_Sels ;
      AV67Bancowwds_3_tfbandescrip = AV15TFBanDescrip ;
      AV68Bancowwds_4_tfbandescrip_sels = AV16TFBanDescrip_Sels ;
      AV69Bancowwds_5_tfbanhabilitado_sel = AV17TFBanHabilitado_Sel ;
      AV70Bancowwds_6_tfbancorelref = AV44TFBancoRelRef ;
      AV71Bancowwds_7_tfbancorelref_sels = AV45TFBancoRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A7BanCod ,
                                           AV66Bancowwds_2_tfbancod_sels ,
                                           A117BanDescrip ,
                                           AV68Bancowwds_4_tfbandescrip_sels ,
                                           A2012BancoRelRef ,
                                           AV71Bancowwds_7_tfbancorelref_sels ,
                                           Integer.valueOf(AV66Bancowwds_2_tfbancod_sels.size()) ,
                                           AV65Bancowwds_1_tfbancod ,
                                           Integer.valueOf(AV68Bancowwds_4_tfbandescrip_sels.size()) ,
                                           AV67Bancowwds_3_tfbandescrip ,
                                           Byte.valueOf(AV69Bancowwds_5_tfbanhabilitado_sel) ,
                                           Integer.valueOf(AV71Bancowwds_7_tfbancorelref_sels.size()) ,
                                           AV70Bancowwds_6_tfbancorelref ,
                                           Boolean.valueOf(A118BanHabilitado) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV65Bancowwds_1_tfbancod = GXutil.padr( GXutil.rtrim( AV65Bancowwds_1_tfbancod), 6, "%") ;
      lV67Bancowwds_3_tfbandescrip = GXutil.concat( GXutil.rtrim( AV67Bancowwds_3_tfbandescrip), "%", "") ;
      lV70Bancowwds_6_tfbancorelref = GXutil.concat( GXutil.rtrim( AV70Bancowwds_6_tfbancorelref), "%", "") ;
      /* Using cursor P006F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), lV65Bancowwds_1_tfbancod, lV67Bancowwds_3_tfbandescrip, lV70Bancowwds_6_tfbancorelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6F2 = false ;
         A3CliCod = P006F2_A3CliCod[0] ;
         A7BanCod = P006F2_A7BanCod[0] ;
         A2012BancoRelRef = P006F2_A2012BancoRelRef[0] ;
         A118BanHabilitado = P006F2_A118BanHabilitado[0] ;
         A117BanDescrip = P006F2_A117BanDescrip[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P006F2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006F2_A7BanCod[0], A7BanCod) == 0 ) )
         {
            brk6F2 = false ;
            AV33count = (long)(AV33count+1) ;
            brk6F2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A7BanCod)==0) )
         {
            AV25Option = A7BanCod ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6F2 )
         {
            brk6F2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADBANDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFBanDescrip = AV21SearchTxt ;
      AV16TFBanDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65Bancowwds_1_tfbancod = AV12TFBanCod ;
      AV66Bancowwds_2_tfbancod_sels = AV13TFBanCod_Sels ;
      AV67Bancowwds_3_tfbandescrip = AV15TFBanDescrip ;
      AV68Bancowwds_4_tfbandescrip_sels = AV16TFBanDescrip_Sels ;
      AV69Bancowwds_5_tfbanhabilitado_sel = AV17TFBanHabilitado_Sel ;
      AV70Bancowwds_6_tfbancorelref = AV44TFBancoRelRef ;
      AV71Bancowwds_7_tfbancorelref_sels = AV45TFBancoRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A7BanCod ,
                                           AV66Bancowwds_2_tfbancod_sels ,
                                           A117BanDescrip ,
                                           AV68Bancowwds_4_tfbandescrip_sels ,
                                           A2012BancoRelRef ,
                                           AV71Bancowwds_7_tfbancorelref_sels ,
                                           Integer.valueOf(AV66Bancowwds_2_tfbancod_sels.size()) ,
                                           AV65Bancowwds_1_tfbancod ,
                                           Integer.valueOf(AV68Bancowwds_4_tfbandescrip_sels.size()) ,
                                           AV67Bancowwds_3_tfbandescrip ,
                                           Byte.valueOf(AV69Bancowwds_5_tfbanhabilitado_sel) ,
                                           Integer.valueOf(AV71Bancowwds_7_tfbancorelref_sels.size()) ,
                                           AV70Bancowwds_6_tfbancorelref ,
                                           Boolean.valueOf(A118BanHabilitado) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV65Bancowwds_1_tfbancod = GXutil.padr( GXutil.rtrim( AV65Bancowwds_1_tfbancod), 6, "%") ;
      lV67Bancowwds_3_tfbandescrip = GXutil.concat( GXutil.rtrim( AV67Bancowwds_3_tfbandescrip), "%", "") ;
      lV70Bancowwds_6_tfbancorelref = GXutil.concat( GXutil.rtrim( AV70Bancowwds_6_tfbancorelref), "%", "") ;
      /* Using cursor P006F3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), lV65Bancowwds_1_tfbancod, lV67Bancowwds_3_tfbandescrip, lV70Bancowwds_6_tfbancorelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6F4 = false ;
         A3CliCod = P006F3_A3CliCod[0] ;
         A117BanDescrip = P006F3_A117BanDescrip[0] ;
         A2012BancoRelRef = P006F3_A2012BancoRelRef[0] ;
         A118BanHabilitado = P006F3_A118BanHabilitado[0] ;
         A7BanCod = P006F3_A7BanCod[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P006F3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006F3_A117BanDescrip[0], A117BanDescrip) == 0 ) )
         {
            brk6F4 = false ;
            A7BanCod = P006F3_A7BanCod[0] ;
            AV33count = (long)(AV33count+1) ;
            brk6F4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A117BanDescrip)==0) )
         {
            AV25Option = A117BanDescrip ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6F4 )
         {
            brk6F4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADBANCORELREFOPTIONS' Routine */
      returnInSub = false ;
      AV44TFBancoRelRef = AV21SearchTxt ;
      AV45TFBancoRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65Bancowwds_1_tfbancod = AV12TFBanCod ;
      AV66Bancowwds_2_tfbancod_sels = AV13TFBanCod_Sels ;
      AV67Bancowwds_3_tfbandescrip = AV15TFBanDescrip ;
      AV68Bancowwds_4_tfbandescrip_sels = AV16TFBanDescrip_Sels ;
      AV69Bancowwds_5_tfbanhabilitado_sel = AV17TFBanHabilitado_Sel ;
      AV70Bancowwds_6_tfbancorelref = AV44TFBancoRelRef ;
      AV71Bancowwds_7_tfbancorelref_sels = AV45TFBancoRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A7BanCod ,
                                           AV66Bancowwds_2_tfbancod_sels ,
                                           A117BanDescrip ,
                                           AV68Bancowwds_4_tfbandescrip_sels ,
                                           A2012BancoRelRef ,
                                           AV71Bancowwds_7_tfbancorelref_sels ,
                                           Integer.valueOf(AV66Bancowwds_2_tfbancod_sels.size()) ,
                                           AV65Bancowwds_1_tfbancod ,
                                           Integer.valueOf(AV68Bancowwds_4_tfbandescrip_sels.size()) ,
                                           AV67Bancowwds_3_tfbandescrip ,
                                           Byte.valueOf(AV69Bancowwds_5_tfbanhabilitado_sel) ,
                                           Integer.valueOf(AV71Bancowwds_7_tfbancorelref_sels.size()) ,
                                           AV70Bancowwds_6_tfbancorelref ,
                                           Boolean.valueOf(A118BanHabilitado) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV65Bancowwds_1_tfbancod = GXutil.padr( GXutil.rtrim( AV65Bancowwds_1_tfbancod), 6, "%") ;
      lV67Bancowwds_3_tfbandescrip = GXutil.concat( GXutil.rtrim( AV67Bancowwds_3_tfbandescrip), "%", "") ;
      lV70Bancowwds_6_tfbancorelref = GXutil.concat( GXutil.rtrim( AV70Bancowwds_6_tfbancorelref), "%", "") ;
      /* Using cursor P006F4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV41CliCod), lV65Bancowwds_1_tfbancod, lV67Bancowwds_3_tfbandescrip, lV70Bancowwds_6_tfbancorelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6F6 = false ;
         A3CliCod = P006F4_A3CliCod[0] ;
         A2012BancoRelRef = P006F4_A2012BancoRelRef[0] ;
         A118BanHabilitado = P006F4_A118BanHabilitado[0] ;
         A117BanDescrip = P006F4_A117BanDescrip[0] ;
         A7BanCod = P006F4_A7BanCod[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P006F4_A2012BancoRelRef[0], A2012BancoRelRef) == 0 ) )
         {
            brk6F6 = false ;
            A3CliCod = P006F4_A3CliCod[0] ;
            A7BanCod = P006F4_A7BanCod[0] ;
            AV33count = (long)(AV33count+1) ;
            brk6F6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2012BancoRelRef)==0) )
         {
            AV25Option = A2012BancoRelRef ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6F6 )
         {
            brk6F6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = bancowwgetfilterdata.this.AV27OptionsJson;
      this.aP4[0] = bancowwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = bancowwgetfilterdata.this.AV32OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV32OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV34Session = httpContext.getWebSession();
      AV36GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV37GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFBanCod = "" ;
      AV11TFBanCod_SelsJson = "" ;
      AV13TFBanCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFBanDescrip = "" ;
      AV14TFBanDescrip_SelsJson = "" ;
      AV16TFBanDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFBancoRelRef = "" ;
      AV43TFBancoRelRef_SelsJson = "" ;
      AV45TFBancoRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42MenuOpcCod = "" ;
      A7BanCod = "" ;
      AV65Bancowwds_1_tfbancod = "" ;
      AV66Bancowwds_2_tfbancod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67Bancowwds_3_tfbandescrip = "" ;
      AV68Bancowwds_4_tfbandescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Bancowwds_6_tfbancorelref = "" ;
      AV71Bancowwds_7_tfbancorelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV65Bancowwds_1_tfbancod = "" ;
      lV67Bancowwds_3_tfbandescrip = "" ;
      lV70Bancowwds_6_tfbancorelref = "" ;
      A117BanDescrip = "" ;
      A2012BancoRelRef = "" ;
      P006F2_A3CliCod = new int[1] ;
      P006F2_A7BanCod = new String[] {""} ;
      P006F2_A2012BancoRelRef = new String[] {""} ;
      P006F2_A118BanHabilitado = new boolean[] {false} ;
      P006F2_A117BanDescrip = new String[] {""} ;
      AV25Option = "" ;
      P006F3_A3CliCod = new int[1] ;
      P006F3_A117BanDescrip = new String[] {""} ;
      P006F3_A2012BancoRelRef = new String[] {""} ;
      P006F3_A118BanHabilitado = new boolean[] {false} ;
      P006F3_A7BanCod = new String[] {""} ;
      P006F4_A3CliCod = new int[1] ;
      P006F4_A2012BancoRelRef = new String[] {""} ;
      P006F4_A118BanHabilitado = new boolean[] {false} ;
      P006F4_A117BanDescrip = new String[] {""} ;
      P006F4_A7BanCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.bancowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006F2_A3CliCod, P006F2_A7BanCod, P006F2_A2012BancoRelRef, P006F2_A118BanHabilitado, P006F2_A117BanDescrip
            }
            , new Object[] {
            P006F3_A3CliCod, P006F3_A117BanDescrip, P006F3_A2012BancoRelRef, P006F3_A118BanHabilitado, P006F3_A7BanCod
            }
            , new Object[] {
            P006F4_A3CliCod, P006F4_A2012BancoRelRef, P006F4_A118BanHabilitado, P006F4_A117BanDescrip, P006F4_A7BanCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17TFBanHabilitado_Sel ;
   private byte AV69Bancowwds_5_tfbanhabilitado_sel ;
   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV63GXV1 ;
   private int AV66Bancowwds_2_tfbancod_sels_size ;
   private int AV68Bancowwds_4_tfbandescrip_sels_size ;
   private int AV71Bancowwds_7_tfbancorelref_sels_size ;
   private int A3CliCod ;
   private long AV33count ;
   private String AV12TFBanCod ;
   private String A7BanCod ;
   private String AV65Bancowwds_1_tfbancod ;
   private String scmdbuf ;
   private String lV65Bancowwds_1_tfbancod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A118BanHabilitado ;
   private boolean brk6F2 ;
   private boolean brk6F4 ;
   private boolean brk6F6 ;
   private String AV27OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV32OptionIndexesJson ;
   private String AV11TFBanCod_SelsJson ;
   private String AV14TFBanDescrip_SelsJson ;
   private String AV43TFBancoRelRef_SelsJson ;
   private String AV23DDOName ;
   private String AV21SearchTxt ;
   private String AV22SearchTxtTo ;
   private String AV15TFBanDescrip ;
   private String AV44TFBancoRelRef ;
   private String AV42MenuOpcCod ;
   private String AV67Bancowwds_3_tfbandescrip ;
   private String AV70Bancowwds_6_tfbancorelref ;
   private String lV67Bancowwds_3_tfbandescrip ;
   private String lV70Bancowwds_6_tfbancorelref ;
   private String A117BanDescrip ;
   private String A2012BancoRelRef ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV34Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006F2_A3CliCod ;
   private String[] P006F2_A7BanCod ;
   private String[] P006F2_A2012BancoRelRef ;
   private boolean[] P006F2_A118BanHabilitado ;
   private String[] P006F2_A117BanDescrip ;
   private int[] P006F3_A3CliCod ;
   private String[] P006F3_A117BanDescrip ;
   private String[] P006F3_A2012BancoRelRef ;
   private boolean[] P006F3_A118BanHabilitado ;
   private String[] P006F3_A7BanCod ;
   private int[] P006F4_A3CliCod ;
   private String[] P006F4_A2012BancoRelRef ;
   private boolean[] P006F4_A118BanHabilitado ;
   private String[] P006F4_A117BanDescrip ;
   private String[] P006F4_A7BanCod ;
   private GXSimpleCollection<String> AV13TFBanCod_Sels ;
   private GXSimpleCollection<String> AV66Bancowwds_2_tfbancod_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV29OptionsDesc ;
   private GXSimpleCollection<String> AV31OptionIndexes ;
   private GXSimpleCollection<String> AV16TFBanDescrip_Sels ;
   private GXSimpleCollection<String> AV45TFBancoRelRef_Sels ;
   private GXSimpleCollection<String> AV68Bancowwds_4_tfbandescrip_sels ;
   private GXSimpleCollection<String> AV71Bancowwds_7_tfbancorelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV36GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV37GridStateFilterValue ;
}

final  class bancowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006F2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A7BanCod ,
                                          GXSimpleCollection<String> AV66Bancowwds_2_tfbancod_sels ,
                                          String A117BanDescrip ,
                                          GXSimpleCollection<String> AV68Bancowwds_4_tfbandescrip_sels ,
                                          String A2012BancoRelRef ,
                                          GXSimpleCollection<String> AV71Bancowwds_7_tfbancorelref_sels ,
                                          int AV66Bancowwds_2_tfbancod_sels_size ,
                                          String AV65Bancowwds_1_tfbancod ,
                                          int AV68Bancowwds_4_tfbandescrip_sels_size ,
                                          String AV67Bancowwds_3_tfbandescrip ,
                                          byte AV69Bancowwds_5_tfbanhabilitado_sel ,
                                          int AV71Bancowwds_7_tfbancorelref_sels_size ,
                                          String AV70Bancowwds_6_tfbancorelref ,
                                          boolean A118BanHabilitado ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, BanCod, BancoRelRef, BanHabilitado, BanDescrip FROM Banco" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV66Bancowwds_2_tfbancod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Bancowwds_1_tfbancod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV66Bancowwds_2_tfbancod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Bancowwds_2_tfbancod_sels, "BanCod IN (", ")")+")");
      }
      if ( ( AV68Bancowwds_4_tfbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Bancowwds_3_tfbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV68Bancowwds_4_tfbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Bancowwds_4_tfbandescrip_sels, "BanDescrip IN (", ")")+")");
      }
      if ( AV69Bancowwds_5_tfbanhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(BanHabilitado = TRUE)");
      }
      if ( AV69Bancowwds_5_tfbanhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(BanHabilitado = FALSE)");
      }
      if ( ( AV71Bancowwds_7_tfbancorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Bancowwds_6_tfbancorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BancoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV71Bancowwds_7_tfbancorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Bancowwds_7_tfbancorelref_sels, "BancoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, BanCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006F3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A7BanCod ,
                                          GXSimpleCollection<String> AV66Bancowwds_2_tfbancod_sels ,
                                          String A117BanDescrip ,
                                          GXSimpleCollection<String> AV68Bancowwds_4_tfbandescrip_sels ,
                                          String A2012BancoRelRef ,
                                          GXSimpleCollection<String> AV71Bancowwds_7_tfbancorelref_sels ,
                                          int AV66Bancowwds_2_tfbancod_sels_size ,
                                          String AV65Bancowwds_1_tfbancod ,
                                          int AV68Bancowwds_4_tfbandescrip_sels_size ,
                                          String AV67Bancowwds_3_tfbandescrip ,
                                          byte AV69Bancowwds_5_tfbanhabilitado_sel ,
                                          int AV71Bancowwds_7_tfbancorelref_sels_size ,
                                          String AV70Bancowwds_6_tfbancorelref ,
                                          boolean A118BanHabilitado ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, BanDescrip, BancoRelRef, BanHabilitado, BanCod FROM Banco" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV66Bancowwds_2_tfbancod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Bancowwds_1_tfbancod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV66Bancowwds_2_tfbancod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Bancowwds_2_tfbancod_sels, "BanCod IN (", ")")+")");
      }
      if ( ( AV68Bancowwds_4_tfbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Bancowwds_3_tfbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV68Bancowwds_4_tfbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Bancowwds_4_tfbandescrip_sels, "BanDescrip IN (", ")")+")");
      }
      if ( AV69Bancowwds_5_tfbanhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(BanHabilitado = TRUE)");
      }
      if ( AV69Bancowwds_5_tfbanhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(BanHabilitado = FALSE)");
      }
      if ( ( AV71Bancowwds_7_tfbancorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Bancowwds_6_tfbancorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BancoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV71Bancowwds_7_tfbancorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Bancowwds_7_tfbancorelref_sels, "BancoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, BanDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006F4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A7BanCod ,
                                          GXSimpleCollection<String> AV66Bancowwds_2_tfbancod_sels ,
                                          String A117BanDescrip ,
                                          GXSimpleCollection<String> AV68Bancowwds_4_tfbandescrip_sels ,
                                          String A2012BancoRelRef ,
                                          GXSimpleCollection<String> AV71Bancowwds_7_tfbancorelref_sels ,
                                          int AV66Bancowwds_2_tfbancod_sels_size ,
                                          String AV65Bancowwds_1_tfbancod ,
                                          int AV68Bancowwds_4_tfbandescrip_sels_size ,
                                          String AV67Bancowwds_3_tfbandescrip ,
                                          byte AV69Bancowwds_5_tfbanhabilitado_sel ,
                                          int AV71Bancowwds_7_tfbancorelref_sels_size ,
                                          String AV70Bancowwds_6_tfbancorelref ,
                                          boolean A118BanHabilitado ,
                                          int A3CliCod ,
                                          int AV41CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, BancoRelRef, BanHabilitado, BanDescrip, BanCod FROM Banco" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV66Bancowwds_2_tfbancod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Bancowwds_1_tfbancod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV66Bancowwds_2_tfbancod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Bancowwds_2_tfbancod_sels, "BanCod IN (", ")")+")");
      }
      if ( ( AV68Bancowwds_4_tfbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Bancowwds_3_tfbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV68Bancowwds_4_tfbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Bancowwds_4_tfbandescrip_sels, "BanDescrip IN (", ")")+")");
      }
      if ( AV69Bancowwds_5_tfbanhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(BanHabilitado = TRUE)");
      }
      if ( AV69Bancowwds_5_tfbanhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(BanHabilitado = FALSE)");
      }
      if ( ( AV71Bancowwds_7_tfbancorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Bancowwds_6_tfbancorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BancoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV71Bancowwds_7_tfbancorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Bancowwds_7_tfbancorelref_sels, "BancoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY BancoRelRef" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P006F2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 1 :
                  return conditional_P006F3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 2 :
                  return conditional_P006F4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006F2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006F3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006F4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 6);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 6);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 6);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
      }
   }

}

