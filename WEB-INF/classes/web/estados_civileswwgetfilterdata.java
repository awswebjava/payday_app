package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estados_civileswwgetfilterdata extends GXProcedure
{
   public estados_civileswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estados_civileswwgetfilterdata.class ), "" );
   }

   public estados_civileswwgetfilterdata( int remoteHandle ,
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
      estados_civileswwgetfilterdata.this.aP5 = new String[] {""};
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
      estados_civileswwgetfilterdata.this.AV28DDOName = aP0;
      estados_civileswwgetfilterdata.this.AV29SearchTxt = aP1;
      estados_civileswwgetfilterdata.this.AV30SearchTxtTo = aP2;
      estados_civileswwgetfilterdata.this.aP3 = aP3;
      estados_civileswwgetfilterdata.this.aP4 = aP4;
      estados_civileswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      estados_civileswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      estados_civileswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEstados_civiles", GXv_boolean6) ;
      estados_civileswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_ESTACIVILDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADESTACIVILDESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_ESTACIVILDESCRIPFEM") == 0 )
         {
            /* Execute user subroutine: 'LOADESTACIVILDESCRIPFEMOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_ESTACIVILCODFOR") == 0 )
         {
            /* Execute user subroutine: 'LOADESTACIVILCODFOROPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("Estados_civilesWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Estados_civilesWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("Estados_civilesWWGridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCOD") == 0 )
         {
            AV11TFEstaCivilCod = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFEstaCivilCod_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIP") == 0 )
         {
            AV14TFEstaCivilDescrip = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIP_SEL") == 0 )
         {
            AV13TFEstaCivilDescrip_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFEstaCivilDescrip_Sels.fromJSonString(AV13TFEstaCivilDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIPFEM") == 0 )
         {
            AV38TFEstaCivilDescripFem = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIPFEM_SEL") == 0 )
         {
            AV37TFEstaCivilDescripFem_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFEstaCivilDescripFem_Sels.fromJSonString(AV37TFEstaCivilDescripFem_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCODFOR") == 0 )
         {
            AV42TFEstaCivilCodFor = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCODFOR_SEL") == 0 )
         {
            AV41TFEstaCivilCodFor_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFEstaCivilCodFor_Sels.fromJSonString(AV41TFEstaCivilCodFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCASADOES_SEL") == 0 )
         {
            AV44TFEstaCivilCasadoEs_Sel = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV40MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADESTACIVILDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFEstaCivilDescrip = AV29SearchTxt ;
      AV15TFEstaCivilDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Estados_civileswwds_1_tfestacivilcod = AV11TFEstaCivilCod ;
      AV50Estados_civileswwds_2_tfestacivilcod_to = AV12TFEstaCivilCod_To ;
      AV51Estados_civileswwds_3_tfestacivildescrip = AV14TFEstaCivilDescrip ;
      AV52Estados_civileswwds_4_tfestacivildescrip_sels = AV15TFEstaCivilDescrip_Sels ;
      AV53Estados_civileswwds_5_tfestacivildescripfem = AV38TFEstaCivilDescripFem ;
      AV54Estados_civileswwds_6_tfestacivildescripfem_sels = AV39TFEstaCivilDescripFem_Sels ;
      AV55Estados_civileswwds_7_tfestacivilcodfor = AV42TFEstaCivilCodFor ;
      AV56Estados_civileswwds_8_tfestacivilcodfor_sels = AV43TFEstaCivilCodFor_Sels ;
      AV57Estados_civileswwds_9_tfestacivilcasadoes_sel = AV44TFEstaCivilCasadoEs_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1749EstaCivilDescrip ,
                                           AV52Estados_civileswwds_4_tfestacivildescrip_sels ,
                                           A1751EstaCivilDescripFem ,
                                           AV54Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                           A2093EstaCivilCodFor ,
                                           AV56Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                           Short.valueOf(AV49Estados_civileswwds_1_tfestacivilcod) ,
                                           Short.valueOf(AV50Estados_civileswwds_2_tfestacivilcod_to) ,
                                           Integer.valueOf(AV52Estados_civileswwds_4_tfestacivildescrip_sels.size()) ,
                                           AV51Estados_civileswwds_3_tfestacivildescrip ,
                                           Integer.valueOf(AV54Estados_civileswwds_6_tfestacivildescripfem_sels.size()) ,
                                           AV53Estados_civileswwds_5_tfestacivildescripfem ,
                                           Integer.valueOf(AV56Estados_civileswwds_8_tfestacivilcodfor_sels.size()) ,
                                           AV55Estados_civileswwds_7_tfestacivilcodfor ,
                                           Byte.valueOf(AV57Estados_civileswwds_9_tfestacivilcasadoes_sel) ,
                                           Short.valueOf(A1748EstaCivilCod) ,
                                           Boolean.valueOf(A2272EstaCivilCasadoEs) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV51Estados_civileswwds_3_tfestacivildescrip = GXutil.concat( GXutil.rtrim( AV51Estados_civileswwds_3_tfestacivildescrip), "%", "") ;
      lV53Estados_civileswwds_5_tfestacivildescripfem = GXutil.concat( GXutil.rtrim( AV53Estados_civileswwds_5_tfestacivildescripfem), "%", "") ;
      lV55Estados_civileswwds_7_tfestacivilcodfor = GXutil.padr( GXutil.rtrim( AV55Estados_civileswwds_7_tfestacivilcodfor), 20, "%") ;
      /* Using cursor P01K72 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV49Estados_civileswwds_1_tfestacivilcod), Short.valueOf(AV50Estados_civileswwds_2_tfestacivilcod_to), lV51Estados_civileswwds_3_tfestacivildescrip, lV53Estados_civileswwds_5_tfestacivildescripfem, lV55Estados_civileswwds_7_tfestacivilcodfor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1K72 = false ;
         A1749EstaCivilDescrip = P01K72_A1749EstaCivilDescrip[0] ;
         A2272EstaCivilCasadoEs = P01K72_A2272EstaCivilCasadoEs[0] ;
         A2093EstaCivilCodFor = P01K72_A2093EstaCivilCodFor[0] ;
         A1751EstaCivilDescripFem = P01K72_A1751EstaCivilDescripFem[0] ;
         A1748EstaCivilCod = P01K72_A1748EstaCivilCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01K72_A1749EstaCivilDescrip[0], A1749EstaCivilDescrip) == 0 ) )
         {
            brk1K72 = false ;
            A1748EstaCivilCod = P01K72_A1748EstaCivilCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1K72 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1749EstaCivilDescrip)==0) )
         {
            AV17Option = A1749EstaCivilDescrip ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1K72 )
         {
            brk1K72 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADESTACIVILDESCRIPFEMOPTIONS' Routine */
      returnInSub = false ;
      AV38TFEstaCivilDescripFem = AV29SearchTxt ;
      AV39TFEstaCivilDescripFem_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Estados_civileswwds_1_tfestacivilcod = AV11TFEstaCivilCod ;
      AV50Estados_civileswwds_2_tfestacivilcod_to = AV12TFEstaCivilCod_To ;
      AV51Estados_civileswwds_3_tfestacivildescrip = AV14TFEstaCivilDescrip ;
      AV52Estados_civileswwds_4_tfestacivildescrip_sels = AV15TFEstaCivilDescrip_Sels ;
      AV53Estados_civileswwds_5_tfestacivildescripfem = AV38TFEstaCivilDescripFem ;
      AV54Estados_civileswwds_6_tfestacivildescripfem_sels = AV39TFEstaCivilDescripFem_Sels ;
      AV55Estados_civileswwds_7_tfestacivilcodfor = AV42TFEstaCivilCodFor ;
      AV56Estados_civileswwds_8_tfestacivilcodfor_sels = AV43TFEstaCivilCodFor_Sels ;
      AV57Estados_civileswwds_9_tfestacivilcasadoes_sel = AV44TFEstaCivilCasadoEs_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1749EstaCivilDescrip ,
                                           AV52Estados_civileswwds_4_tfestacivildescrip_sels ,
                                           A1751EstaCivilDescripFem ,
                                           AV54Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                           A2093EstaCivilCodFor ,
                                           AV56Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                           Short.valueOf(AV49Estados_civileswwds_1_tfestacivilcod) ,
                                           Short.valueOf(AV50Estados_civileswwds_2_tfestacivilcod_to) ,
                                           Integer.valueOf(AV52Estados_civileswwds_4_tfestacivildescrip_sels.size()) ,
                                           AV51Estados_civileswwds_3_tfestacivildescrip ,
                                           Integer.valueOf(AV54Estados_civileswwds_6_tfestacivildescripfem_sels.size()) ,
                                           AV53Estados_civileswwds_5_tfestacivildescripfem ,
                                           Integer.valueOf(AV56Estados_civileswwds_8_tfestacivilcodfor_sels.size()) ,
                                           AV55Estados_civileswwds_7_tfestacivilcodfor ,
                                           Byte.valueOf(AV57Estados_civileswwds_9_tfestacivilcasadoes_sel) ,
                                           Short.valueOf(A1748EstaCivilCod) ,
                                           Boolean.valueOf(A2272EstaCivilCasadoEs) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV51Estados_civileswwds_3_tfestacivildescrip = GXutil.concat( GXutil.rtrim( AV51Estados_civileswwds_3_tfestacivildescrip), "%", "") ;
      lV53Estados_civileswwds_5_tfestacivildescripfem = GXutil.concat( GXutil.rtrim( AV53Estados_civileswwds_5_tfestacivildescripfem), "%", "") ;
      lV55Estados_civileswwds_7_tfestacivilcodfor = GXutil.padr( GXutil.rtrim( AV55Estados_civileswwds_7_tfestacivilcodfor), 20, "%") ;
      /* Using cursor P01K73 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV49Estados_civileswwds_1_tfestacivilcod), Short.valueOf(AV50Estados_civileswwds_2_tfestacivilcod_to), lV51Estados_civileswwds_3_tfestacivildescrip, lV53Estados_civileswwds_5_tfestacivildescripfem, lV55Estados_civileswwds_7_tfestacivilcodfor});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1K74 = false ;
         A1751EstaCivilDescripFem = P01K73_A1751EstaCivilDescripFem[0] ;
         A2272EstaCivilCasadoEs = P01K73_A2272EstaCivilCasadoEs[0] ;
         A2093EstaCivilCodFor = P01K73_A2093EstaCivilCodFor[0] ;
         A1749EstaCivilDescrip = P01K73_A1749EstaCivilDescrip[0] ;
         A1748EstaCivilCod = P01K73_A1748EstaCivilCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01K73_A1751EstaCivilDescripFem[0], A1751EstaCivilDescripFem) == 0 ) )
         {
            brk1K74 = false ;
            A1748EstaCivilCod = P01K73_A1748EstaCivilCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1K74 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1751EstaCivilDescripFem)==0) )
         {
            AV17Option = A1751EstaCivilDescripFem ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1K74 )
         {
            brk1K74 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADESTACIVILCODFOROPTIONS' Routine */
      returnInSub = false ;
      AV42TFEstaCivilCodFor = AV29SearchTxt ;
      AV43TFEstaCivilCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Estados_civileswwds_1_tfestacivilcod = AV11TFEstaCivilCod ;
      AV50Estados_civileswwds_2_tfestacivilcod_to = AV12TFEstaCivilCod_To ;
      AV51Estados_civileswwds_3_tfestacivildescrip = AV14TFEstaCivilDescrip ;
      AV52Estados_civileswwds_4_tfestacivildescrip_sels = AV15TFEstaCivilDescrip_Sels ;
      AV53Estados_civileswwds_5_tfestacivildescripfem = AV38TFEstaCivilDescripFem ;
      AV54Estados_civileswwds_6_tfestacivildescripfem_sels = AV39TFEstaCivilDescripFem_Sels ;
      AV55Estados_civileswwds_7_tfestacivilcodfor = AV42TFEstaCivilCodFor ;
      AV56Estados_civileswwds_8_tfestacivilcodfor_sels = AV43TFEstaCivilCodFor_Sels ;
      AV57Estados_civileswwds_9_tfestacivilcasadoes_sel = AV44TFEstaCivilCasadoEs_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1749EstaCivilDescrip ,
                                           AV52Estados_civileswwds_4_tfestacivildescrip_sels ,
                                           A1751EstaCivilDescripFem ,
                                           AV54Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                           A2093EstaCivilCodFor ,
                                           AV56Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                           Short.valueOf(AV49Estados_civileswwds_1_tfestacivilcod) ,
                                           Short.valueOf(AV50Estados_civileswwds_2_tfestacivilcod_to) ,
                                           Integer.valueOf(AV52Estados_civileswwds_4_tfestacivildescrip_sels.size()) ,
                                           AV51Estados_civileswwds_3_tfestacivildescrip ,
                                           Integer.valueOf(AV54Estados_civileswwds_6_tfestacivildescripfem_sels.size()) ,
                                           AV53Estados_civileswwds_5_tfestacivildescripfem ,
                                           Integer.valueOf(AV56Estados_civileswwds_8_tfestacivilcodfor_sels.size()) ,
                                           AV55Estados_civileswwds_7_tfestacivilcodfor ,
                                           Byte.valueOf(AV57Estados_civileswwds_9_tfestacivilcasadoes_sel) ,
                                           Short.valueOf(A1748EstaCivilCod) ,
                                           Boolean.valueOf(A2272EstaCivilCasadoEs) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV51Estados_civileswwds_3_tfestacivildescrip = GXutil.concat( GXutil.rtrim( AV51Estados_civileswwds_3_tfestacivildescrip), "%", "") ;
      lV53Estados_civileswwds_5_tfestacivildescripfem = GXutil.concat( GXutil.rtrim( AV53Estados_civileswwds_5_tfestacivildescripfem), "%", "") ;
      lV55Estados_civileswwds_7_tfestacivilcodfor = GXutil.padr( GXutil.rtrim( AV55Estados_civileswwds_7_tfestacivilcodfor), 20, "%") ;
      /* Using cursor P01K74 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV49Estados_civileswwds_1_tfestacivilcod), Short.valueOf(AV50Estados_civileswwds_2_tfestacivilcod_to), lV51Estados_civileswwds_3_tfestacivildescrip, lV53Estados_civileswwds_5_tfestacivildescripfem, lV55Estados_civileswwds_7_tfestacivilcodfor});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1K76 = false ;
         A2093EstaCivilCodFor = P01K74_A2093EstaCivilCodFor[0] ;
         A2272EstaCivilCasadoEs = P01K74_A2272EstaCivilCasadoEs[0] ;
         A1751EstaCivilDescripFem = P01K74_A1751EstaCivilDescripFem[0] ;
         A1749EstaCivilDescrip = P01K74_A1749EstaCivilDescrip[0] ;
         A1748EstaCivilCod = P01K74_A1748EstaCivilCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01K74_A2093EstaCivilCodFor[0], A2093EstaCivilCodFor) == 0 ) )
         {
            brk1K76 = false ;
            A1748EstaCivilCod = P01K74_A1748EstaCivilCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1K76 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2093EstaCivilCodFor)==0) )
         {
            AV17Option = A2093EstaCivilCodFor ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1K76 )
         {
            brk1K76 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = estados_civileswwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = estados_civileswwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = estados_civileswwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFEstaCivilDescrip = "" ;
      AV13TFEstaCivilDescrip_SelsJson = "" ;
      AV15TFEstaCivilDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFEstaCivilDescripFem = "" ;
      AV37TFEstaCivilDescripFem_SelsJson = "" ;
      AV39TFEstaCivilDescripFem_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFEstaCivilCodFor = "" ;
      AV41TFEstaCivilCodFor_SelsJson = "" ;
      AV43TFEstaCivilCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40MenuOpcCod = "" ;
      A1749EstaCivilDescrip = "" ;
      AV51Estados_civileswwds_3_tfestacivildescrip = "" ;
      AV52Estados_civileswwds_4_tfestacivildescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Estados_civileswwds_5_tfestacivildescripfem = "" ;
      AV54Estados_civileswwds_6_tfestacivildescripfem_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Estados_civileswwds_7_tfestacivilcodfor = "" ;
      AV56Estados_civileswwds_8_tfestacivilcodfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Estados_civileswwds_3_tfestacivildescrip = "" ;
      lV53Estados_civileswwds_5_tfestacivildescripfem = "" ;
      lV55Estados_civileswwds_7_tfestacivilcodfor = "" ;
      A1751EstaCivilDescripFem = "" ;
      A2093EstaCivilCodFor = "" ;
      P01K72_A1749EstaCivilDescrip = new String[] {""} ;
      P01K72_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      P01K72_A2093EstaCivilCodFor = new String[] {""} ;
      P01K72_A1751EstaCivilDescripFem = new String[] {""} ;
      P01K72_A1748EstaCivilCod = new short[1] ;
      AV17Option = "" ;
      P01K73_A1751EstaCivilDescripFem = new String[] {""} ;
      P01K73_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      P01K73_A2093EstaCivilCodFor = new String[] {""} ;
      P01K73_A1749EstaCivilDescrip = new String[] {""} ;
      P01K73_A1748EstaCivilCod = new short[1] ;
      P01K74_A2093EstaCivilCodFor = new String[] {""} ;
      P01K74_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      P01K74_A1751EstaCivilDescripFem = new String[] {""} ;
      P01K74_A1749EstaCivilDescrip = new String[] {""} ;
      P01K74_A1748EstaCivilCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estados_civileswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01K72_A1749EstaCivilDescrip, P01K72_A2272EstaCivilCasadoEs, P01K72_A2093EstaCivilCodFor, P01K72_A1751EstaCivilDescripFem, P01K72_A1748EstaCivilCod
            }
            , new Object[] {
            P01K73_A1751EstaCivilDescripFem, P01K73_A2272EstaCivilCasadoEs, P01K73_A2093EstaCivilCodFor, P01K73_A1749EstaCivilDescrip, P01K73_A1748EstaCivilCod
            }
            , new Object[] {
            P01K74_A2093EstaCivilCodFor, P01K74_A2272EstaCivilCasadoEs, P01K74_A1751EstaCivilDescripFem, P01K74_A1749EstaCivilDescrip, P01K74_A1748EstaCivilCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV44TFEstaCivilCasadoEs_Sel ;
   private byte AV57Estados_civileswwds_9_tfestacivilcasadoes_sel ;
   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFEstaCivilCod ;
   private short AV12TFEstaCivilCod_To ;
   private short AV49Estados_civileswwds_1_tfestacivilcod ;
   private short AV50Estados_civileswwds_2_tfestacivilcod_to ;
   private short A1748EstaCivilCod ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV47GXV1 ;
   private int AV52Estados_civileswwds_4_tfestacivildescrip_sels_size ;
   private int AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size ;
   private int AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size ;
   private long AV22count ;
   private String AV42TFEstaCivilCodFor ;
   private String AV55Estados_civileswwds_7_tfestacivilcodfor ;
   private String scmdbuf ;
   private String lV55Estados_civileswwds_7_tfestacivilcodfor ;
   private String A2093EstaCivilCodFor ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A2272EstaCivilCasadoEs ;
   private boolean brk1K72 ;
   private boolean brk1K74 ;
   private boolean brk1K76 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFEstaCivilDescrip_SelsJson ;
   private String AV37TFEstaCivilDescripFem_SelsJson ;
   private String AV41TFEstaCivilCodFor_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFEstaCivilDescrip ;
   private String AV38TFEstaCivilDescripFem ;
   private String AV40MenuOpcCod ;
   private String A1749EstaCivilDescrip ;
   private String AV51Estados_civileswwds_3_tfestacivildescrip ;
   private String AV53Estados_civileswwds_5_tfestacivildescripfem ;
   private String lV51Estados_civileswwds_3_tfestacivildescrip ;
   private String lV53Estados_civileswwds_5_tfestacivildescripfem ;
   private String A1751EstaCivilDescripFem ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01K72_A1749EstaCivilDescrip ;
   private boolean[] P01K72_A2272EstaCivilCasadoEs ;
   private String[] P01K72_A2093EstaCivilCodFor ;
   private String[] P01K72_A1751EstaCivilDescripFem ;
   private short[] P01K72_A1748EstaCivilCod ;
   private String[] P01K73_A1751EstaCivilDescripFem ;
   private boolean[] P01K73_A2272EstaCivilCasadoEs ;
   private String[] P01K73_A2093EstaCivilCodFor ;
   private String[] P01K73_A1749EstaCivilDescrip ;
   private short[] P01K73_A1748EstaCivilCod ;
   private String[] P01K74_A2093EstaCivilCodFor ;
   private boolean[] P01K74_A2272EstaCivilCasadoEs ;
   private String[] P01K74_A1751EstaCivilDescripFem ;
   private String[] P01K74_A1749EstaCivilDescrip ;
   private short[] P01K74_A1748EstaCivilCod ;
   private GXSimpleCollection<String> AV43TFEstaCivilCodFor_Sels ;
   private GXSimpleCollection<String> AV56Estados_civileswwds_8_tfestacivilcodfor_sels ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFEstaCivilDescrip_Sels ;
   private GXSimpleCollection<String> AV39TFEstaCivilDescripFem_Sels ;
   private GXSimpleCollection<String> AV52Estados_civileswwds_4_tfestacivildescrip_sels ;
   private GXSimpleCollection<String> AV54Estados_civileswwds_6_tfestacivildescripfem_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class estados_civileswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1749EstaCivilDescrip ,
                                          GXSimpleCollection<String> AV52Estados_civileswwds_4_tfestacivildescrip_sels ,
                                          String A1751EstaCivilDescripFem ,
                                          GXSimpleCollection<String> AV54Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                          String A2093EstaCivilCodFor ,
                                          GXSimpleCollection<String> AV56Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                          short AV49Estados_civileswwds_1_tfestacivilcod ,
                                          short AV50Estados_civileswwds_2_tfestacivilcod_to ,
                                          int AV52Estados_civileswwds_4_tfestacivildescrip_sels_size ,
                                          String AV51Estados_civileswwds_3_tfestacivildescrip ,
                                          int AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size ,
                                          String AV53Estados_civileswwds_5_tfestacivildescripfem ,
                                          int AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size ,
                                          String AV55Estados_civileswwds_7_tfestacivilcodfor ,
                                          byte AV57Estados_civileswwds_9_tfestacivilcasadoes_sel ,
                                          short A1748EstaCivilCod ,
                                          boolean A2272EstaCivilCasadoEs )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT EstaCivilDescrip, EstaCivilCasadoEs, EstaCivilCodFor, EstaCivilDescripFem, EstaCivilCod FROM Estados_civiles" ;
      if ( ! (0==AV49Estados_civileswwds_1_tfestacivilcod) )
      {
         addWhere(sWhereString, "(EstaCivilCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV50Estados_civileswwds_2_tfestacivilcod_to) )
      {
         addWhere(sWhereString, "(EstaCivilCod <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV52Estados_civileswwds_4_tfestacivildescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Estados_civileswwds_3_tfestacivildescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV52Estados_civileswwds_4_tfestacivildescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Estados_civileswwds_4_tfestacivildescrip_sels, "EstaCivilDescrip IN (", ")")+")");
      }
      if ( ( AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Estados_civileswwds_5_tfestacivildescripfem)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescripFem) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Estados_civileswwds_6_tfestacivildescripfem_sels, "EstaCivilDescripFem IN (", ")")+")");
      }
      if ( ( AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Estados_civileswwds_7_tfestacivilcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Estados_civileswwds_8_tfestacivilcodfor_sels, "EstaCivilCodFor IN (", ")")+")");
      }
      if ( AV57Estados_civileswwds_9_tfestacivilcasadoes_sel == 1 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = TRUE)");
      }
      if ( AV57Estados_civileswwds_9_tfestacivilcasadoes_sel == 2 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EstaCivilDescrip" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01K73( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1749EstaCivilDescrip ,
                                          GXSimpleCollection<String> AV52Estados_civileswwds_4_tfestacivildescrip_sels ,
                                          String A1751EstaCivilDescripFem ,
                                          GXSimpleCollection<String> AV54Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                          String A2093EstaCivilCodFor ,
                                          GXSimpleCollection<String> AV56Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                          short AV49Estados_civileswwds_1_tfestacivilcod ,
                                          short AV50Estados_civileswwds_2_tfestacivilcod_to ,
                                          int AV52Estados_civileswwds_4_tfestacivildescrip_sels_size ,
                                          String AV51Estados_civileswwds_3_tfestacivildescrip ,
                                          int AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size ,
                                          String AV53Estados_civileswwds_5_tfestacivildescripfem ,
                                          int AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size ,
                                          String AV55Estados_civileswwds_7_tfestacivilcodfor ,
                                          byte AV57Estados_civileswwds_9_tfestacivilcasadoes_sel ,
                                          short A1748EstaCivilCod ,
                                          boolean A2272EstaCivilCasadoEs )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT EstaCivilDescripFem, EstaCivilCasadoEs, EstaCivilCodFor, EstaCivilDescrip, EstaCivilCod FROM Estados_civiles" ;
      if ( ! (0==AV49Estados_civileswwds_1_tfestacivilcod) )
      {
         addWhere(sWhereString, "(EstaCivilCod >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV50Estados_civileswwds_2_tfestacivilcod_to) )
      {
         addWhere(sWhereString, "(EstaCivilCod <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV52Estados_civileswwds_4_tfestacivildescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Estados_civileswwds_3_tfestacivildescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV52Estados_civileswwds_4_tfestacivildescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Estados_civileswwds_4_tfestacivildescrip_sels, "EstaCivilDescrip IN (", ")")+")");
      }
      if ( ( AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Estados_civileswwds_5_tfestacivildescripfem)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescripFem) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Estados_civileswwds_6_tfestacivildescripfem_sels, "EstaCivilDescripFem IN (", ")")+")");
      }
      if ( ( AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Estados_civileswwds_7_tfestacivilcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Estados_civileswwds_8_tfestacivilcodfor_sels, "EstaCivilCodFor IN (", ")")+")");
      }
      if ( AV57Estados_civileswwds_9_tfestacivilcasadoes_sel == 1 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = TRUE)");
      }
      if ( AV57Estados_civileswwds_9_tfestacivilcasadoes_sel == 2 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EstaCivilDescripFem" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01K74( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1749EstaCivilDescrip ,
                                          GXSimpleCollection<String> AV52Estados_civileswwds_4_tfestacivildescrip_sels ,
                                          String A1751EstaCivilDescripFem ,
                                          GXSimpleCollection<String> AV54Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                          String A2093EstaCivilCodFor ,
                                          GXSimpleCollection<String> AV56Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                          short AV49Estados_civileswwds_1_tfestacivilcod ,
                                          short AV50Estados_civileswwds_2_tfestacivilcod_to ,
                                          int AV52Estados_civileswwds_4_tfestacivildescrip_sels_size ,
                                          String AV51Estados_civileswwds_3_tfestacivildescrip ,
                                          int AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size ,
                                          String AV53Estados_civileswwds_5_tfestacivildescripfem ,
                                          int AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size ,
                                          String AV55Estados_civileswwds_7_tfestacivilcodfor ,
                                          byte AV57Estados_civileswwds_9_tfestacivilcasadoes_sel ,
                                          short A1748EstaCivilCod ,
                                          boolean A2272EstaCivilCasadoEs )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[5];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT EstaCivilCodFor, EstaCivilCasadoEs, EstaCivilDescripFem, EstaCivilDescrip, EstaCivilCod FROM Estados_civiles" ;
      if ( ! (0==AV49Estados_civileswwds_1_tfestacivilcod) )
      {
         addWhere(sWhereString, "(EstaCivilCod >= ?)");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( ! (0==AV50Estados_civileswwds_2_tfestacivilcod_to) )
      {
         addWhere(sWhereString, "(EstaCivilCod <= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ( AV52Estados_civileswwds_4_tfestacivildescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Estados_civileswwds_3_tfestacivildescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV52Estados_civileswwds_4_tfestacivildescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Estados_civileswwds_4_tfestacivildescrip_sels, "EstaCivilDescrip IN (", ")")+")");
      }
      if ( ( AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Estados_civileswwds_5_tfestacivildescripfem)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescripFem) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV54Estados_civileswwds_6_tfestacivildescripfem_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Estados_civileswwds_6_tfestacivildescripfem_sels, "EstaCivilDescripFem IN (", ")")+")");
      }
      if ( ( AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Estados_civileswwds_7_tfestacivilcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV56Estados_civileswwds_8_tfestacivilcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Estados_civileswwds_8_tfestacivilcodfor_sels, "EstaCivilCodFor IN (", ")")+")");
      }
      if ( AV57Estados_civileswwds_9_tfestacivilcasadoes_sel == 1 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = TRUE)");
      }
      if ( AV57Estados_civileswwds_9_tfestacivilcasadoes_sel == 2 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EstaCivilCodFor" ;
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
                  return conditional_P01K72(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
            case 1 :
                  return conditional_P01K73(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
            case 2 :
                  return conditional_P01K74(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01K73", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01K74", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 30);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 30);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 30);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
      }
   }

}

