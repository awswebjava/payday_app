package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class zonawwgetfilterdata extends GXProcedure
{
   public zonawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( zonawwgetfilterdata.class ), "" );
   }

   public zonawwgetfilterdata( int remoteHandle ,
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
      zonawwgetfilterdata.this.aP5 = new String[] {""};
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
      zonawwgetfilterdata.this.AV18DDOName = aP0;
      zonawwgetfilterdata.this.AV16SearchTxt = aP1;
      zonawwgetfilterdata.this.AV17SearchTxtTo = aP2;
      zonawwgetfilterdata.this.aP3 = aP3;
      zonawwgetfilterdata.this.aP4 = aP4;
      zonawwgetfilterdata.this.aP5 = aP5;
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
      zonawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV39CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      zonawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV39CliCod = GXt_int3 ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWZona", GXv_boolean6) ;
      zonawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_ZONCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADZONCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_ZONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADZONDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_ZONPROVINCIA") == 0 )
         {
            /* Execute user subroutine: 'LOADZONPROVINCIAOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV22OptionsJson = AV21Options.toJSonString(false) ;
      AV25OptionsDescJson = AV24OptionsDesc.toJSonString(false) ;
      AV27OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV29Session.getValue("ZonaWWGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ZonaWWGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("ZonaWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONCOD") == 0 )
         {
            AV10TFZonCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONCOD_SEL") == 0 )
         {
            AV35TFZonCod_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFZonCod_Sels.fromJSonString(AV35TFZonCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONDESCRIP") == 0 )
         {
            AV12TFZonDescrip = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONDESCRIP_SEL") == 0 )
         {
            AV37TFZonDescrip_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFZonDescrip_Sels.fromJSonString(AV37TFZonDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONPROVINCIA") == 0 )
         {
            AV43TFZonProvincia = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONPROVINCIA_SEL") == 0 )
         {
            AV42TFZonProvincia_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFZonProvincia_Sels.fromJSonString(AV42TFZonProvincia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFZONPORCAUMENDED") == 0 )
         {
            AV45TFZonPorcAumenDed = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV46TFZonPorcAumenDed_To = CommonUtil.decimalVal( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV47MenuOpcCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADZONCODOPTIONS' Routine */
      returnInSub = false ;
      AV10TFZonCod = AV16SearchTxt ;
      AV36TFZonCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Zonawwds_1_tfzoncod = AV10TFZonCod ;
      AV53Zonawwds_2_tfzoncod_sels = AV36TFZonCod_Sels ;
      AV54Zonawwds_3_tfzondescrip = AV12TFZonDescrip ;
      AV55Zonawwds_4_tfzondescrip_sels = AV38TFZonDescrip_Sels ;
      AV56Zonawwds_5_tfzonprovincia = AV43TFZonProvincia ;
      AV57Zonawwds_6_tfzonprovincia_sels = AV44TFZonProvincia_Sels ;
      AV58Zonawwds_7_tfzonporcaumended = AV45TFZonPorcAumenDed ;
      AV59Zonawwds_8_tfzonporcaumended_to = AV46TFZonPorcAumenDed_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A20ZonCod ,
                                           AV53Zonawwds_2_tfzoncod_sels ,
                                           A342ZonDescrip ,
                                           AV55Zonawwds_4_tfzondescrip_sels ,
                                           A589ZonProvincia ,
                                           AV57Zonawwds_6_tfzonprovincia_sels ,
                                           Integer.valueOf(AV53Zonawwds_2_tfzoncod_sels.size()) ,
                                           AV52Zonawwds_1_tfzoncod ,
                                           Integer.valueOf(AV55Zonawwds_4_tfzondescrip_sels.size()) ,
                                           AV54Zonawwds_3_tfzondescrip ,
                                           Integer.valueOf(AV57Zonawwds_6_tfzonprovincia_sels.size()) ,
                                           AV56Zonawwds_5_tfzonprovincia ,
                                           AV58Zonawwds_7_tfzonporcaumended ,
                                           AV59Zonawwds_8_tfzonporcaumended_to ,
                                           A880ZonPorcAumenDed } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL
                                           }
      });
      lV52Zonawwds_1_tfzoncod = GXutil.padr( GXutil.rtrim( AV52Zonawwds_1_tfzoncod), 20, "%") ;
      lV54Zonawwds_3_tfzondescrip = GXutil.concat( GXutil.rtrim( AV54Zonawwds_3_tfzondescrip), "%", "") ;
      lV56Zonawwds_5_tfzonprovincia = GXutil.concat( GXutil.rtrim( AV56Zonawwds_5_tfzonprovincia), "%", "") ;
      /* Using cursor P00962 */
      pr_default.execute(0, new Object[] {lV52Zonawwds_1_tfzoncod, lV54Zonawwds_3_tfzondescrip, lV56Zonawwds_5_tfzonprovincia, AV58Zonawwds_7_tfzonporcaumended, AV59Zonawwds_8_tfzonporcaumended_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A880ZonPorcAumenDed = P00962_A880ZonPorcAumenDed[0] ;
         A589ZonProvincia = P00962_A589ZonProvincia[0] ;
         A342ZonDescrip = P00962_A342ZonDescrip[0] ;
         A20ZonCod = P00962_A20ZonCod[0] ;
         if ( ! (GXutil.strcmp("", A20ZonCod)==0) )
         {
            AV20Option = A20ZonCod ;
            AV21Options.add(AV20Option, 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADZONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFZonDescrip = AV16SearchTxt ;
      AV38TFZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Zonawwds_1_tfzoncod = AV10TFZonCod ;
      AV53Zonawwds_2_tfzoncod_sels = AV36TFZonCod_Sels ;
      AV54Zonawwds_3_tfzondescrip = AV12TFZonDescrip ;
      AV55Zonawwds_4_tfzondescrip_sels = AV38TFZonDescrip_Sels ;
      AV56Zonawwds_5_tfzonprovincia = AV43TFZonProvincia ;
      AV57Zonawwds_6_tfzonprovincia_sels = AV44TFZonProvincia_Sels ;
      AV58Zonawwds_7_tfzonporcaumended = AV45TFZonPorcAumenDed ;
      AV59Zonawwds_8_tfzonporcaumended_to = AV46TFZonPorcAumenDed_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A20ZonCod ,
                                           AV53Zonawwds_2_tfzoncod_sels ,
                                           A342ZonDescrip ,
                                           AV55Zonawwds_4_tfzondescrip_sels ,
                                           A589ZonProvincia ,
                                           AV57Zonawwds_6_tfzonprovincia_sels ,
                                           Integer.valueOf(AV53Zonawwds_2_tfzoncod_sels.size()) ,
                                           AV52Zonawwds_1_tfzoncod ,
                                           Integer.valueOf(AV55Zonawwds_4_tfzondescrip_sels.size()) ,
                                           AV54Zonawwds_3_tfzondescrip ,
                                           Integer.valueOf(AV57Zonawwds_6_tfzonprovincia_sels.size()) ,
                                           AV56Zonawwds_5_tfzonprovincia ,
                                           AV58Zonawwds_7_tfzonporcaumended ,
                                           AV59Zonawwds_8_tfzonporcaumended_to ,
                                           A880ZonPorcAumenDed } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL
                                           }
      });
      lV52Zonawwds_1_tfzoncod = GXutil.padr( GXutil.rtrim( AV52Zonawwds_1_tfzoncod), 20, "%") ;
      lV54Zonawwds_3_tfzondescrip = GXutil.concat( GXutil.rtrim( AV54Zonawwds_3_tfzondescrip), "%", "") ;
      lV56Zonawwds_5_tfzonprovincia = GXutil.concat( GXutil.rtrim( AV56Zonawwds_5_tfzonprovincia), "%", "") ;
      /* Using cursor P00963 */
      pr_default.execute(1, new Object[] {lV52Zonawwds_1_tfzoncod, lV54Zonawwds_3_tfzondescrip, lV56Zonawwds_5_tfzonprovincia, AV58Zonawwds_7_tfzonporcaumended, AV59Zonawwds_8_tfzonporcaumended_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk963 = false ;
         A342ZonDescrip = P00963_A342ZonDescrip[0] ;
         A880ZonPorcAumenDed = P00963_A880ZonPorcAumenDed[0] ;
         A589ZonProvincia = P00963_A589ZonProvincia[0] ;
         A20ZonCod = P00963_A20ZonCod[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00963_A342ZonDescrip[0], A342ZonDescrip) == 0 ) )
         {
            brk963 = false ;
            A20ZonCod = P00963_A20ZonCod[0] ;
            AV28count = (long)(AV28count+1) ;
            brk963 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A342ZonDescrip)==0) )
         {
            AV20Option = A342ZonDescrip ;
            AV21Options.add(AV20Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk963 )
         {
            brk963 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADZONPROVINCIAOPTIONS' Routine */
      returnInSub = false ;
      AV43TFZonProvincia = AV16SearchTxt ;
      AV44TFZonProvincia_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Zonawwds_1_tfzoncod = AV10TFZonCod ;
      AV53Zonawwds_2_tfzoncod_sels = AV36TFZonCod_Sels ;
      AV54Zonawwds_3_tfzondescrip = AV12TFZonDescrip ;
      AV55Zonawwds_4_tfzondescrip_sels = AV38TFZonDescrip_Sels ;
      AV56Zonawwds_5_tfzonprovincia = AV43TFZonProvincia ;
      AV57Zonawwds_6_tfzonprovincia_sels = AV44TFZonProvincia_Sels ;
      AV58Zonawwds_7_tfzonporcaumended = AV45TFZonPorcAumenDed ;
      AV59Zonawwds_8_tfzonporcaumended_to = AV46TFZonPorcAumenDed_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A20ZonCod ,
                                           AV53Zonawwds_2_tfzoncod_sels ,
                                           A342ZonDescrip ,
                                           AV55Zonawwds_4_tfzondescrip_sels ,
                                           A589ZonProvincia ,
                                           AV57Zonawwds_6_tfzonprovincia_sels ,
                                           Integer.valueOf(AV53Zonawwds_2_tfzoncod_sels.size()) ,
                                           AV52Zonawwds_1_tfzoncod ,
                                           Integer.valueOf(AV55Zonawwds_4_tfzondescrip_sels.size()) ,
                                           AV54Zonawwds_3_tfzondescrip ,
                                           Integer.valueOf(AV57Zonawwds_6_tfzonprovincia_sels.size()) ,
                                           AV56Zonawwds_5_tfzonprovincia ,
                                           AV58Zonawwds_7_tfzonporcaumended ,
                                           AV59Zonawwds_8_tfzonporcaumended_to ,
                                           A880ZonPorcAumenDed } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL
                                           }
      });
      lV52Zonawwds_1_tfzoncod = GXutil.padr( GXutil.rtrim( AV52Zonawwds_1_tfzoncod), 20, "%") ;
      lV54Zonawwds_3_tfzondescrip = GXutil.concat( GXutil.rtrim( AV54Zonawwds_3_tfzondescrip), "%", "") ;
      lV56Zonawwds_5_tfzonprovincia = GXutil.concat( GXutil.rtrim( AV56Zonawwds_5_tfzonprovincia), "%", "") ;
      /* Using cursor P00964 */
      pr_default.execute(2, new Object[] {lV52Zonawwds_1_tfzoncod, lV54Zonawwds_3_tfzondescrip, lV56Zonawwds_5_tfzonprovincia, AV58Zonawwds_7_tfzonporcaumended, AV59Zonawwds_8_tfzonporcaumended_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk965 = false ;
         A589ZonProvincia = P00964_A589ZonProvincia[0] ;
         A880ZonPorcAumenDed = P00964_A880ZonPorcAumenDed[0] ;
         A342ZonDescrip = P00964_A342ZonDescrip[0] ;
         A20ZonCod = P00964_A20ZonCod[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00964_A589ZonProvincia[0], A589ZonProvincia) == 0 ) )
         {
            brk965 = false ;
            A20ZonCod = P00964_A20ZonCod[0] ;
            AV28count = (long)(AV28count+1) ;
            brk965 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A589ZonProvincia)==0) )
         {
            AV20Option = A589ZonProvincia ;
            AV21Options.add(AV20Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk965 )
         {
            brk965 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = zonawwgetfilterdata.this.AV22OptionsJson;
      this.aP4[0] = zonawwgetfilterdata.this.AV25OptionsDescJson;
      this.aP5[0] = zonawwgetfilterdata.this.AV27OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22OptionsJson = "" ;
      AV25OptionsDescJson = "" ;
      AV27OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV29Session = httpContext.getWebSession();
      AV31GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV32GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFZonCod = "" ;
      AV35TFZonCod_SelsJson = "" ;
      AV36TFZonCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFZonDescrip = "" ;
      AV37TFZonDescrip_SelsJson = "" ;
      AV38TFZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFZonProvincia = "" ;
      AV42TFZonProvincia_SelsJson = "" ;
      AV44TFZonProvincia_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFZonPorcAumenDed = DecimalUtil.ZERO ;
      AV46TFZonPorcAumenDed_To = DecimalUtil.ZERO ;
      AV47MenuOpcCod = "" ;
      A20ZonCod = "" ;
      AV52Zonawwds_1_tfzoncod = "" ;
      AV53Zonawwds_2_tfzoncod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Zonawwds_3_tfzondescrip = "" ;
      AV55Zonawwds_4_tfzondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Zonawwds_5_tfzonprovincia = "" ;
      AV57Zonawwds_6_tfzonprovincia_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58Zonawwds_7_tfzonporcaumended = DecimalUtil.ZERO ;
      AV59Zonawwds_8_tfzonporcaumended_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV52Zonawwds_1_tfzoncod = "" ;
      lV54Zonawwds_3_tfzondescrip = "" ;
      lV56Zonawwds_5_tfzonprovincia = "" ;
      A342ZonDescrip = "" ;
      A589ZonProvincia = "" ;
      A880ZonPorcAumenDed = DecimalUtil.ZERO ;
      P00962_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00962_A589ZonProvincia = new String[] {""} ;
      P00962_A342ZonDescrip = new String[] {""} ;
      P00962_A20ZonCod = new String[] {""} ;
      AV20Option = "" ;
      P00963_A342ZonDescrip = new String[] {""} ;
      P00963_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00963_A589ZonProvincia = new String[] {""} ;
      P00963_A20ZonCod = new String[] {""} ;
      P00964_A589ZonProvincia = new String[] {""} ;
      P00964_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00964_A342ZonDescrip = new String[] {""} ;
      P00964_A20ZonCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.zonawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00962_A880ZonPorcAumenDed, P00962_A589ZonProvincia, P00962_A342ZonDescrip, P00962_A20ZonCod
            }
            , new Object[] {
            P00963_A342ZonDescrip, P00963_A880ZonPorcAumenDed, P00963_A589ZonProvincia, P00963_A20ZonCod
            }
            , new Object[] {
            P00964_A589ZonProvincia, P00964_A880ZonPorcAumenDed, P00964_A342ZonDescrip, P00964_A20ZonCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV39CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV50GXV1 ;
   private int AV53Zonawwds_2_tfzoncod_sels_size ;
   private int AV55Zonawwds_4_tfzondescrip_sels_size ;
   private int AV57Zonawwds_6_tfzonprovincia_sels_size ;
   private long AV28count ;
   private java.math.BigDecimal AV45TFZonPorcAumenDed ;
   private java.math.BigDecimal AV46TFZonPorcAumenDed_To ;
   private java.math.BigDecimal AV58Zonawwds_7_tfzonporcaumended ;
   private java.math.BigDecimal AV59Zonawwds_8_tfzonporcaumended_to ;
   private java.math.BigDecimal A880ZonPorcAumenDed ;
   private String AV10TFZonCod ;
   private String A20ZonCod ;
   private String AV52Zonawwds_1_tfzoncod ;
   private String scmdbuf ;
   private String lV52Zonawwds_1_tfzoncod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk963 ;
   private boolean brk965 ;
   private String AV22OptionsJson ;
   private String AV25OptionsDescJson ;
   private String AV27OptionIndexesJson ;
   private String AV35TFZonCod_SelsJson ;
   private String AV37TFZonDescrip_SelsJson ;
   private String AV42TFZonProvincia_SelsJson ;
   private String AV18DDOName ;
   private String AV16SearchTxt ;
   private String AV17SearchTxtTo ;
   private String AV12TFZonDescrip ;
   private String AV43TFZonProvincia ;
   private String AV47MenuOpcCod ;
   private String AV54Zonawwds_3_tfzondescrip ;
   private String AV56Zonawwds_5_tfzonprovincia ;
   private String lV54Zonawwds_3_tfzondescrip ;
   private String lV56Zonawwds_5_tfzonprovincia ;
   private String A342ZonDescrip ;
   private String A589ZonProvincia ;
   private String AV20Option ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00962_A880ZonPorcAumenDed ;
   private String[] P00962_A589ZonProvincia ;
   private String[] P00962_A342ZonDescrip ;
   private String[] P00962_A20ZonCod ;
   private String[] P00963_A342ZonDescrip ;
   private java.math.BigDecimal[] P00963_A880ZonPorcAumenDed ;
   private String[] P00963_A589ZonProvincia ;
   private String[] P00963_A20ZonCod ;
   private String[] P00964_A589ZonProvincia ;
   private java.math.BigDecimal[] P00964_A880ZonPorcAumenDed ;
   private String[] P00964_A342ZonDescrip ;
   private String[] P00964_A20ZonCod ;
   private GXSimpleCollection<String> AV36TFZonCod_Sels ;
   private GXSimpleCollection<String> AV53Zonawwds_2_tfzoncod_sels ;
   private GXSimpleCollection<String> AV21Options ;
   private GXSimpleCollection<String> AV24OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV38TFZonDescrip_Sels ;
   private GXSimpleCollection<String> AV44TFZonProvincia_Sels ;
   private GXSimpleCollection<String> AV55Zonawwds_4_tfzondescrip_sels ;
   private GXSimpleCollection<String> AV57Zonawwds_6_tfzonprovincia_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class zonawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00962( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A20ZonCod ,
                                          GXSimpleCollection<String> AV53Zonawwds_2_tfzoncod_sels ,
                                          String A342ZonDescrip ,
                                          GXSimpleCollection<String> AV55Zonawwds_4_tfzondescrip_sels ,
                                          String A589ZonProvincia ,
                                          GXSimpleCollection<String> AV57Zonawwds_6_tfzonprovincia_sels ,
                                          int AV53Zonawwds_2_tfzoncod_sels_size ,
                                          String AV52Zonawwds_1_tfzoncod ,
                                          int AV55Zonawwds_4_tfzondescrip_sels_size ,
                                          String AV54Zonawwds_3_tfzondescrip ,
                                          int AV57Zonawwds_6_tfzonprovincia_sels_size ,
                                          String AV56Zonawwds_5_tfzonprovincia ,
                                          java.math.BigDecimal AV58Zonawwds_7_tfzonporcaumended ,
                                          java.math.BigDecimal AV59Zonawwds_8_tfzonporcaumended_to ,
                                          java.math.BigDecimal A880ZonPorcAumenDed )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS ZonPorcAumenDed, NULL AS ZonProvincia, NULL AS ZonDescrip, ZonCod FROM ( SELECT ZonPorcAumenDed, ZonProvincia, ZonDescrip, ZonCod FROM Zona" ;
      if ( ( AV53Zonawwds_2_tfzoncod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Zonawwds_1_tfzoncod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV53Zonawwds_2_tfzoncod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Zonawwds_2_tfzoncod_sels, "ZonCod IN (", ")")+")");
      }
      if ( ( AV55Zonawwds_4_tfzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Zonawwds_3_tfzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV55Zonawwds_4_tfzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Zonawwds_4_tfzondescrip_sels, "ZonDescrip IN (", ")")+")");
      }
      if ( ( AV57Zonawwds_6_tfzonprovincia_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Zonawwds_5_tfzonprovincia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonProvincia) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV57Zonawwds_6_tfzonprovincia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Zonawwds_6_tfzonprovincia_sels, "ZonProvincia IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Zonawwds_7_tfzonporcaumended)==0) )
      {
         addWhere(sWhereString, "(ZonPorcAumenDed >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Zonawwds_8_tfzonporcaumended_to)==0) )
      {
         addWhere(sWhereString, "(ZonPorcAumenDed <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ZonCod" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY ZonCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00963( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A20ZonCod ,
                                          GXSimpleCollection<String> AV53Zonawwds_2_tfzoncod_sels ,
                                          String A342ZonDescrip ,
                                          GXSimpleCollection<String> AV55Zonawwds_4_tfzondescrip_sels ,
                                          String A589ZonProvincia ,
                                          GXSimpleCollection<String> AV57Zonawwds_6_tfzonprovincia_sels ,
                                          int AV53Zonawwds_2_tfzoncod_sels_size ,
                                          String AV52Zonawwds_1_tfzoncod ,
                                          int AV55Zonawwds_4_tfzondescrip_sels_size ,
                                          String AV54Zonawwds_3_tfzondescrip ,
                                          int AV57Zonawwds_6_tfzonprovincia_sels_size ,
                                          String AV56Zonawwds_5_tfzonprovincia ,
                                          java.math.BigDecimal AV58Zonawwds_7_tfzonporcaumended ,
                                          java.math.BigDecimal AV59Zonawwds_8_tfzonporcaumended_to ,
                                          java.math.BigDecimal A880ZonPorcAumenDed )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT ZonDescrip, ZonPorcAumenDed, ZonProvincia, ZonCod FROM Zona" ;
      if ( ( AV53Zonawwds_2_tfzoncod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Zonawwds_1_tfzoncod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV53Zonawwds_2_tfzoncod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Zonawwds_2_tfzoncod_sels, "ZonCod IN (", ")")+")");
      }
      if ( ( AV55Zonawwds_4_tfzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Zonawwds_3_tfzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV55Zonawwds_4_tfzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Zonawwds_4_tfzondescrip_sels, "ZonDescrip IN (", ")")+")");
      }
      if ( ( AV57Zonawwds_6_tfzonprovincia_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Zonawwds_5_tfzonprovincia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonProvincia) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV57Zonawwds_6_tfzonprovincia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Zonawwds_6_tfzonprovincia_sels, "ZonProvincia IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Zonawwds_7_tfzonporcaumended)==0) )
      {
         addWhere(sWhereString, "(ZonPorcAumenDed >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Zonawwds_8_tfzonporcaumended_to)==0) )
      {
         addWhere(sWhereString, "(ZonPorcAumenDed <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ZonDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P00964( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A20ZonCod ,
                                          GXSimpleCollection<String> AV53Zonawwds_2_tfzoncod_sels ,
                                          String A342ZonDescrip ,
                                          GXSimpleCollection<String> AV55Zonawwds_4_tfzondescrip_sels ,
                                          String A589ZonProvincia ,
                                          GXSimpleCollection<String> AV57Zonawwds_6_tfzonprovincia_sels ,
                                          int AV53Zonawwds_2_tfzoncod_sels_size ,
                                          String AV52Zonawwds_1_tfzoncod ,
                                          int AV55Zonawwds_4_tfzondescrip_sels_size ,
                                          String AV54Zonawwds_3_tfzondescrip ,
                                          int AV57Zonawwds_6_tfzonprovincia_sels_size ,
                                          String AV56Zonawwds_5_tfzonprovincia ,
                                          java.math.BigDecimal AV58Zonawwds_7_tfzonporcaumended ,
                                          java.math.BigDecimal AV59Zonawwds_8_tfzonporcaumended_to ,
                                          java.math.BigDecimal A880ZonPorcAumenDed )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[5];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT ZonProvincia, ZonPorcAumenDed, ZonDescrip, ZonCod FROM Zona" ;
      if ( ( AV53Zonawwds_2_tfzoncod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Zonawwds_1_tfzoncod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV53Zonawwds_2_tfzoncod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Zonawwds_2_tfzoncod_sels, "ZonCod IN (", ")")+")");
      }
      if ( ( AV55Zonawwds_4_tfzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Zonawwds_3_tfzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV55Zonawwds_4_tfzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Zonawwds_4_tfzondescrip_sels, "ZonDescrip IN (", ")")+")");
      }
      if ( ( AV57Zonawwds_6_tfzonprovincia_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Zonawwds_5_tfzonprovincia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ZonProvincia) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV57Zonawwds_6_tfzonprovincia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Zonawwds_6_tfzonprovincia_sels, "ZonProvincia IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Zonawwds_7_tfzonporcaumended)==0) )
      {
         addWhere(sWhereString, "(ZonPorcAumenDed >= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Zonawwds_8_tfzonporcaumended_to)==0) )
      {
         addWhere(sWhereString, "(ZonPorcAumenDed <= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ZonProvincia" ;
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
                  return conditional_P00962(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] );
            case 1 :
                  return conditional_P00963(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] );
            case 2 :
                  return conditional_P00964(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00962", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00963", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00964", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               return;
      }
   }

}

