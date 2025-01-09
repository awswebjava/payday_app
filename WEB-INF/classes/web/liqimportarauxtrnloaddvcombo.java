package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqimportarauxtrnloaddvcombo extends GXProcedure
{
   public liqimportarauxtrnloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqimportarauxtrnloaddvcombo.class ), "" );
   }

   public liqimportarauxtrnloaddvcombo( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             short aP5 ,
                             short aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      liqimportarauxtrnloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        short aP5 ,
                        short aP6 ,
                        String aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             short aP5 ,
                             short aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      liqimportarauxtrnloaddvcombo.this.AV17ComboName = aP0;
      liqimportarauxtrnloaddvcombo.this.AV19TrnMode = aP1;
      liqimportarauxtrnloaddvcombo.this.AV22IsDynamicCall = aP2;
      liqimportarauxtrnloaddvcombo.this.AV30CliCod = aP3;
      liqimportarauxtrnloaddvcombo.this.AV31EmpCod = aP4;
      liqimportarauxtrnloaddvcombo.this.AV32Cond_PaiCod = aP5;
      liqimportarauxtrnloaddvcombo.this.AV33Cond_ProvCod = aP6;
      liqimportarauxtrnloaddvcombo.this.AV12SearchTxt = aP7;
      liqimportarauxtrnloaddvcombo.this.aP8 = aP8;
      liqimportarauxtrnloaddvcombo.this.aP9 = aP9;
      liqimportarauxtrnloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn", GXv_boolean2) ;
      liqimportarauxtrnloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "PaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAICOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "ProvCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PROVCOD' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "LocCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LOCCOD' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "ActCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ACTCODIGO' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "TipEmpleCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_TIPEMPLECOD' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "EmpZonCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPZONCOD' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_PAICOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A312PaiNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P00342 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A312PaiNom = P00342_A312PaiNom[0] ;
            A46PaiCod = P00342_A46PaiCod[0] ;
            n46PaiCod = P00342_n46PaiCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A46PaiCod, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A312PaiNom );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P00343 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV31EmpCod)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1EmpCod = P00343_A1EmpCod[0] ;
                  A3CliCod = P00343_A3CliCod[0] ;
                  A46PaiCod = P00343_A46PaiCod[0] ;
                  n46PaiCod = P00343_n46PaiCod[0] ;
                  A312PaiNom = P00343_A312PaiNom[0] ;
                  A312PaiNom = P00343_A312PaiNom[0] ;
                  AV16SelectedValue = ((0==A46PaiCod) ? "" : GXutil.trim( GXutil.str( A46PaiCod, 4, 0))) ;
                  AV21SelectedText = A312PaiNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24PaiCod = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P00344 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV24PaiCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A46PaiCod = P00344_A46PaiCod[0] ;
                  n46PaiCod = P00344_n46PaiCod[0] ;
                  A312PaiNom = P00344_A312PaiNom[0] ;
                  AV21SelectedText = A312PaiNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_PROVCOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A322ProvNom ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV32Cond_PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P00345 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV32Cond_PaiCod), lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A46PaiCod = P00345_A46PaiCod[0] ;
            n46PaiCod = P00345_n46PaiCod[0] ;
            A322ProvNom = P00345_A322ProvNom[0] ;
            A47ProvCod = P00345_A47ProvCod[0] ;
            n47ProvCod = P00345_n47ProvCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A47ProvCod, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A322ProvNom );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P00346 */
               pr_default.execute(4, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV31EmpCod)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A46PaiCod = P00346_A46PaiCod[0] ;
                  n46PaiCod = P00346_n46PaiCod[0] ;
                  A4CliPaiCod = P00346_A4CliPaiCod[0] ;
                  n4CliPaiCod = P00346_n4CliPaiCod[0] ;
                  A1EmpCod = P00346_A1EmpCod[0] ;
                  A3CliCod = P00346_A3CliCod[0] ;
                  A47ProvCod = P00346_A47ProvCod[0] ;
                  n47ProvCod = P00346_n47ProvCod[0] ;
                  A322ProvNom = P00346_A322ProvNom[0] ;
                  A4CliPaiCod = P00346_A4CliPaiCod[0] ;
                  n4CliPaiCod = P00346_n4CliPaiCod[0] ;
                  A322ProvNom = P00346_A322ProvNom[0] ;
                  /* Using cursor P00347 */
                  pr_default.execute(5, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
                  A322ProvNom = P00347_A322ProvNom[0] ;
                  pr_default.close(5);
                  AV16SelectedValue = ((0==A47ProvCod) ? "" : GXutil.trim( GXutil.str( A47ProvCod, 4, 0))) ;
                  AV21SelectedText = A322ProvNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV25ProvCod = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P00348 */
               pr_default.execute(6, new Object[] {Short.valueOf(AV32Cond_PaiCod), Short.valueOf(AV25ProvCod)});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A46PaiCod = P00348_A46PaiCod[0] ;
                  n46PaiCod = P00348_n46PaiCod[0] ;
                  A47ProvCod = P00348_A47ProvCod[0] ;
                  n47ProvCod = P00348_n47ProvCod[0] ;
                  A322ProvNom = P00348_A322ProvNom[0] ;
                  AV21SelectedText = A322ProvNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(6);
            }
         }
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_LOCCOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(7, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A286LocNom ,
                                              Short.valueOf(AV32Cond_PaiCod) ,
                                              Short.valueOf(AV33Cond_ProvCod) ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(A47ProvCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P00349 */
         pr_default.execute(7, new Object[] {Short.valueOf(AV32Cond_PaiCod), Short.valueOf(AV33Cond_ProvCod), lV12SearchTxt});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A286LocNom = P00349_A286LocNom[0] ;
            A47ProvCod = P00349_A47ProvCod[0] ;
            n47ProvCod = P00349_n47ProvCod[0] ;
            A46PaiCod = P00349_A46PaiCod[0] ;
            n46PaiCod = P00349_n46PaiCod[0] ;
            A48LocCod = P00349_A48LocCod[0] ;
            n48LocCod = P00349_n48LocCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A48LocCod, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A286LocNom );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(7);
         }
         pr_default.close(7);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003410 */
               pr_default.execute(8, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV31EmpCod)});
               while ( (pr_default.getStatus(8) != 101) )
               {
                  A46PaiCod = P003410_A46PaiCod[0] ;
                  n46PaiCod = P003410_n46PaiCod[0] ;
                  A47ProvCod = P003410_A47ProvCod[0] ;
                  n47ProvCod = P003410_n47ProvCod[0] ;
                  A4CliPaiCod = P003410_A4CliPaiCod[0] ;
                  n4CliPaiCod = P003410_n4CliPaiCod[0] ;
                  A1EmpCod = P003410_A1EmpCod[0] ;
                  A3CliCod = P003410_A3CliCod[0] ;
                  A48LocCod = P003410_A48LocCod[0] ;
                  n48LocCod = P003410_n48LocCod[0] ;
                  A286LocNom = P003410_A286LocNom[0] ;
                  A4CliPaiCod = P003410_A4CliPaiCod[0] ;
                  n4CliPaiCod = P003410_n4CliPaiCod[0] ;
                  A286LocNom = P003410_A286LocNom[0] ;
                  /* Using cursor P003411 */
                  pr_default.execute(9, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
                  A286LocNom = P003411_A286LocNom[0] ;
                  pr_default.close(9);
                  AV16SelectedValue = ((0==A48LocCod) ? "" : GXutil.trim( GXutil.str( A48LocCod, 4, 0))) ;
                  AV21SelectedText = A286LocNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(8);
            }
            else
            {
               AV26LocCod = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P003412 */
               pr_default.execute(10, new Object[] {Short.valueOf(AV32Cond_PaiCod), Short.valueOf(AV33Cond_ProvCod), Short.valueOf(AV26LocCod)});
               while ( (pr_default.getStatus(10) != 101) )
               {
                  A47ProvCod = P003412_A47ProvCod[0] ;
                  n47ProvCod = P003412_n47ProvCod[0] ;
                  A46PaiCod = P003412_A46PaiCod[0] ;
                  n46PaiCod = P003412_n46PaiCod[0] ;
                  A48LocCod = P003412_A48LocCod[0] ;
                  n48LocCod = P003412_n48LocCod[0] ;
                  A286LocNom = P003412_A286LocNom[0] ;
                  AV21SelectedText = A286LocNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(10);
            }
         }
      }
   }

   public void S141( )
   {
      /* 'LOADCOMBOITEMS_ACTCODIGO' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(11, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A108ActDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003413 */
         pr_default.execute(11, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(11) != 101) )
         {
            A108ActDescrip = P003413_A108ActDescrip[0] ;
            A43ActCodigo = P003413_A43ActCodigo[0] ;
            n43ActCodigo = P003413_n43ActCodigo[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A43ActCodigo );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A108ActDescrip );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(11);
         }
         pr_default.close(11);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003414 */
               pr_default.execute(12, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV31EmpCod)});
               while ( (pr_default.getStatus(12) != 101) )
               {
                  A1EmpCod = P003414_A1EmpCod[0] ;
                  A3CliCod = P003414_A3CliCod[0] ;
                  A43ActCodigo = P003414_A43ActCodigo[0] ;
                  n43ActCodigo = P003414_n43ActCodigo[0] ;
                  A108ActDescrip = P003414_A108ActDescrip[0] ;
                  A108ActDescrip = P003414_A108ActDescrip[0] ;
                  AV16SelectedValue = A43ActCodigo ;
                  AV21SelectedText = A108ActDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(12);
            }
            else
            {
               AV27ActCodigo = AV12SearchTxt ;
               /* Using cursor P003415 */
               pr_default.execute(13, new Object[] {AV27ActCodigo});
               while ( (pr_default.getStatus(13) != 101) )
               {
                  A43ActCodigo = P003415_A43ActCodigo[0] ;
                  n43ActCodigo = P003415_n43ActCodigo[0] ;
                  A108ActDescrip = P003415_A108ActDescrip[0] ;
                  AV21SelectedText = A108ActDescrip ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(13);
            }
         }
      }
   }

   public void S151( )
   {
      /* 'LOADCOMBOITEMS_TIPEMPLECOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(14, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A339TipEmpleDescri } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003416 */
         pr_default.execute(14, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(14) != 101) )
         {
            A339TipEmpleDescri = P003416_A339TipEmpleDescri[0] ;
            A45TipEmpleCod = P003416_A45TipEmpleCod[0] ;
            n45TipEmpleCod = P003416_n45TipEmpleCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A45TipEmpleCod );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A339TipEmpleDescri );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(14);
         }
         pr_default.close(14);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003417 */
               pr_default.execute(15, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV31EmpCod)});
               while ( (pr_default.getStatus(15) != 101) )
               {
                  A1EmpCod = P003417_A1EmpCod[0] ;
                  A3CliCod = P003417_A3CliCod[0] ;
                  A45TipEmpleCod = P003417_A45TipEmpleCod[0] ;
                  n45TipEmpleCod = P003417_n45TipEmpleCod[0] ;
                  A339TipEmpleDescri = P003417_A339TipEmpleDescri[0] ;
                  A339TipEmpleDescri = P003417_A339TipEmpleDescri[0] ;
                  AV16SelectedValue = A45TipEmpleCod ;
                  AV21SelectedText = A339TipEmpleDescri ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(15);
            }
            else
            {
               AV28TipEmpleCod = AV12SearchTxt ;
               /* Using cursor P003418 */
               pr_default.execute(16, new Object[] {AV28TipEmpleCod});
               while ( (pr_default.getStatus(16) != 101) )
               {
                  A45TipEmpleCod = P003418_A45TipEmpleCod[0] ;
                  n45TipEmpleCod = P003418_n45TipEmpleCod[0] ;
                  A339TipEmpleDescri = P003418_A339TipEmpleDescri[0] ;
                  AV21SelectedText = A339TipEmpleDescri ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(16);
            }
         }
      }
   }

   public void S161( )
   {
      /* 'LOADCOMBOITEMS_EMPZONCOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(17, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A342ZonDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003419 */
         pr_default.execute(17, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(17) != 101) )
         {
            A342ZonDescrip = P003419_A342ZonDescrip[0] ;
            A20ZonCod = P003419_A20ZonCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A20ZonCod );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A342ZonDescrip );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(17);
         }
         pr_default.close(17);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003420 */
               pr_default.execute(18, new Object[] {Integer.valueOf(AV30CliCod), Short.valueOf(AV31EmpCod)});
               while ( (pr_default.getStatus(18) != 101) )
               {
                  A1EmpCod = P003420_A1EmpCod[0] ;
                  A3CliCod = P003420_A3CliCod[0] ;
                  A44EmpZonCod = P003420_A44EmpZonCod[0] ;
                  n44EmpZonCod = P003420_n44EmpZonCod[0] ;
                  AV16SelectedValue = A44EmpZonCod ;
                  AV29ZonCod = A44EmpZonCod ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(18);
            }
            else
            {
               AV29ZonCod = AV12SearchTxt ;
            }
            /* Using cursor P003421 */
            pr_default.execute(19, new Object[] {AV29ZonCod});
            while ( (pr_default.getStatus(19) != 101) )
            {
               A20ZonCod = P003421_A20ZonCod[0] ;
               A342ZonDescrip = P003421_A342ZonDescrip[0] ;
               AV21SelectedText = A342ZonDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(19);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = liqimportarauxtrnloaddvcombo.this.AV16SelectedValue;
      this.aP9[0] = liqimportarauxtrnloaddvcombo.this.AV21SelectedText;
      this.aP10[0] = liqimportarauxtrnloaddvcombo.this.AV13Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(9);
      pr_default.close(5);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV13Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A312PaiNom = "" ;
      P00342_A312PaiNom = new String[] {""} ;
      P00342_A46PaiCod = new short[1] ;
      P00342_n46PaiCod = new boolean[] {false} ;
      AV15Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P00343_A1EmpCod = new short[1] ;
      P00343_A3CliCod = new int[1] ;
      P00343_A46PaiCod = new short[1] ;
      P00343_n46PaiCod = new boolean[] {false} ;
      P00343_A312PaiNom = new String[] {""} ;
      P00344_A46PaiCod = new short[1] ;
      P00344_n46PaiCod = new boolean[] {false} ;
      P00344_A312PaiNom = new String[] {""} ;
      A322ProvNom = "" ;
      P00345_A46PaiCod = new short[1] ;
      P00345_n46PaiCod = new boolean[] {false} ;
      P00345_A322ProvNom = new String[] {""} ;
      P00345_A47ProvCod = new short[1] ;
      P00345_n47ProvCod = new boolean[] {false} ;
      P00346_A46PaiCod = new short[1] ;
      P00346_n46PaiCod = new boolean[] {false} ;
      P00346_A4CliPaiCod = new short[1] ;
      P00346_n4CliPaiCod = new boolean[] {false} ;
      P00346_A1EmpCod = new short[1] ;
      P00346_A3CliCod = new int[1] ;
      P00346_A47ProvCod = new short[1] ;
      P00346_n47ProvCod = new boolean[] {false} ;
      P00346_A322ProvNom = new String[] {""} ;
      P00347_A322ProvNom = new String[] {""} ;
      P00348_A46PaiCod = new short[1] ;
      P00348_n46PaiCod = new boolean[] {false} ;
      P00348_A47ProvCod = new short[1] ;
      P00348_n47ProvCod = new boolean[] {false} ;
      P00348_A322ProvNom = new String[] {""} ;
      A286LocNom = "" ;
      P00349_A286LocNom = new String[] {""} ;
      P00349_A47ProvCod = new short[1] ;
      P00349_n47ProvCod = new boolean[] {false} ;
      P00349_A46PaiCod = new short[1] ;
      P00349_n46PaiCod = new boolean[] {false} ;
      P00349_A48LocCod = new short[1] ;
      P00349_n48LocCod = new boolean[] {false} ;
      P003410_A46PaiCod = new short[1] ;
      P003410_n46PaiCod = new boolean[] {false} ;
      P003410_A47ProvCod = new short[1] ;
      P003410_n47ProvCod = new boolean[] {false} ;
      P003410_A4CliPaiCod = new short[1] ;
      P003410_n4CliPaiCod = new boolean[] {false} ;
      P003410_A1EmpCod = new short[1] ;
      P003410_A3CliCod = new int[1] ;
      P003410_A48LocCod = new short[1] ;
      P003410_n48LocCod = new boolean[] {false} ;
      P003410_A286LocNom = new String[] {""} ;
      P003411_A286LocNom = new String[] {""} ;
      P003412_A47ProvCod = new short[1] ;
      P003412_n47ProvCod = new boolean[] {false} ;
      P003412_A46PaiCod = new short[1] ;
      P003412_n46PaiCod = new boolean[] {false} ;
      P003412_A48LocCod = new short[1] ;
      P003412_n48LocCod = new boolean[] {false} ;
      P003412_A286LocNom = new String[] {""} ;
      A108ActDescrip = "" ;
      P003413_A108ActDescrip = new String[] {""} ;
      P003413_A43ActCodigo = new String[] {""} ;
      P003413_n43ActCodigo = new boolean[] {false} ;
      A43ActCodigo = "" ;
      P003414_A1EmpCod = new short[1] ;
      P003414_A3CliCod = new int[1] ;
      P003414_A43ActCodigo = new String[] {""} ;
      P003414_n43ActCodigo = new boolean[] {false} ;
      P003414_A108ActDescrip = new String[] {""} ;
      AV27ActCodigo = "" ;
      P003415_A43ActCodigo = new String[] {""} ;
      P003415_n43ActCodigo = new boolean[] {false} ;
      P003415_A108ActDescrip = new String[] {""} ;
      A339TipEmpleDescri = "" ;
      P003416_A339TipEmpleDescri = new String[] {""} ;
      P003416_A45TipEmpleCod = new String[] {""} ;
      P003416_n45TipEmpleCod = new boolean[] {false} ;
      A45TipEmpleCod = "" ;
      P003417_A1EmpCod = new short[1] ;
      P003417_A3CliCod = new int[1] ;
      P003417_A45TipEmpleCod = new String[] {""} ;
      P003417_n45TipEmpleCod = new boolean[] {false} ;
      P003417_A339TipEmpleDescri = new String[] {""} ;
      AV28TipEmpleCod = "" ;
      P003418_A45TipEmpleCod = new String[] {""} ;
      P003418_n45TipEmpleCod = new boolean[] {false} ;
      P003418_A339TipEmpleDescri = new String[] {""} ;
      A342ZonDescrip = "" ;
      P003419_A342ZonDescrip = new String[] {""} ;
      P003419_A20ZonCod = new String[] {""} ;
      A20ZonCod = "" ;
      P003420_A1EmpCod = new short[1] ;
      P003420_A3CliCod = new int[1] ;
      P003420_A44EmpZonCod = new String[] {""} ;
      P003420_n44EmpZonCod = new boolean[] {false} ;
      A44EmpZonCod = "" ;
      AV29ZonCod = "" ;
      P003421_A20ZonCod = new String[] {""} ;
      P003421_A342ZonDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqimportarauxtrnloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P00342_A312PaiNom, P00342_A46PaiCod
            }
            , new Object[] {
            P00343_A1EmpCod, P00343_A3CliCod, P00343_A46PaiCod, P00343_n46PaiCod, P00343_A312PaiNom
            }
            , new Object[] {
            P00344_A46PaiCod, P00344_A312PaiNom
            }
            , new Object[] {
            P00345_A46PaiCod, P00345_A322ProvNom, P00345_A47ProvCod
            }
            , new Object[] {
            P00346_A46PaiCod, P00346_n46PaiCod, P00346_A4CliPaiCod, P00346_n4CliPaiCod, P00346_A1EmpCod, P00346_A3CliCod, P00346_A47ProvCod, P00346_n47ProvCod, P00346_A322ProvNom
            }
            , new Object[] {
            P00347_A322ProvNom
            }
            , new Object[] {
            P00348_A46PaiCod, P00348_A47ProvCod, P00348_A322ProvNom
            }
            , new Object[] {
            P00349_A286LocNom, P00349_A47ProvCod, P00349_A46PaiCod, P00349_A48LocCod
            }
            , new Object[] {
            P003410_A46PaiCod, P003410_n46PaiCod, P003410_A47ProvCod, P003410_n47ProvCod, P003410_A4CliPaiCod, P003410_n4CliPaiCod, P003410_A1EmpCod, P003410_A3CliCod, P003410_A48LocCod, P003410_n48LocCod,
            P003410_A286LocNom
            }
            , new Object[] {
            P003411_A286LocNom
            }
            , new Object[] {
            P003412_A47ProvCod, P003412_A46PaiCod, P003412_A48LocCod, P003412_A286LocNom
            }
            , new Object[] {
            P003413_A108ActDescrip, P003413_A43ActCodigo
            }
            , new Object[] {
            P003414_A1EmpCod, P003414_A3CliCod, P003414_A43ActCodigo, P003414_n43ActCodigo, P003414_A108ActDescrip
            }
            , new Object[] {
            P003415_A43ActCodigo, P003415_A108ActDescrip
            }
            , new Object[] {
            P003416_A339TipEmpleDescri, P003416_A45TipEmpleCod
            }
            , new Object[] {
            P003417_A1EmpCod, P003417_A3CliCod, P003417_A45TipEmpleCod, P003417_n45TipEmpleCod, P003417_A339TipEmpleDescri
            }
            , new Object[] {
            P003418_A45TipEmpleCod, P003418_A339TipEmpleDescri
            }
            , new Object[] {
            P003419_A342ZonDescrip, P003419_A20ZonCod
            }
            , new Object[] {
            P003420_A1EmpCod, P003420_A3CliCod, P003420_A44EmpZonCod, P003420_n44EmpZonCod
            }
            , new Object[] {
            P003421_A20ZonCod, P003421_A342ZonDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV31EmpCod ;
   private short AV32Cond_PaiCod ;
   private short AV33Cond_ProvCod ;
   private short A46PaiCod ;
   private short A1EmpCod ;
   private short AV24PaiCod ;
   private short A47ProvCod ;
   private short A4CliPaiCod ;
   private short AV25ProvCod ;
   private short A48LocCod ;
   private short AV26LocCod ;
   private short Gx_err ;
   private int AV30CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV19TrnMode ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private String AV27ActCodigo ;
   private String A45TipEmpleCod ;
   private String AV28TipEmpleCod ;
   private String A20ZonCod ;
   private String A44EmpZonCod ;
   private String AV29ZonCod ;
   private boolean AV22IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n4CliPaiCod ;
   private boolean n48LocCod ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV21SelectedText ;
   private String lV12SearchTxt ;
   private String A312PaiNom ;
   private String A322ProvNom ;
   private String A286LocNom ;
   private String A108ActDescrip ;
   private String A339TipEmpleDescri ;
   private String A342ZonDescrip ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P00342_A312PaiNom ;
   private short[] P00342_A46PaiCod ;
   private boolean[] P00342_n46PaiCod ;
   private short[] P00343_A1EmpCod ;
   private int[] P00343_A3CliCod ;
   private short[] P00343_A46PaiCod ;
   private boolean[] P00343_n46PaiCod ;
   private String[] P00343_A312PaiNom ;
   private short[] P00344_A46PaiCod ;
   private boolean[] P00344_n46PaiCod ;
   private String[] P00344_A312PaiNom ;
   private short[] P00345_A46PaiCod ;
   private boolean[] P00345_n46PaiCod ;
   private String[] P00345_A322ProvNom ;
   private short[] P00345_A47ProvCod ;
   private boolean[] P00345_n47ProvCod ;
   private short[] P00346_A46PaiCod ;
   private boolean[] P00346_n46PaiCod ;
   private short[] P00346_A4CliPaiCod ;
   private boolean[] P00346_n4CliPaiCod ;
   private short[] P00346_A1EmpCod ;
   private int[] P00346_A3CliCod ;
   private short[] P00346_A47ProvCod ;
   private boolean[] P00346_n47ProvCod ;
   private String[] P00346_A322ProvNom ;
   private String[] P00347_A322ProvNom ;
   private short[] P00348_A46PaiCod ;
   private boolean[] P00348_n46PaiCod ;
   private short[] P00348_A47ProvCod ;
   private boolean[] P00348_n47ProvCod ;
   private String[] P00348_A322ProvNom ;
   private String[] P00349_A286LocNom ;
   private short[] P00349_A47ProvCod ;
   private boolean[] P00349_n47ProvCod ;
   private short[] P00349_A46PaiCod ;
   private boolean[] P00349_n46PaiCod ;
   private short[] P00349_A48LocCod ;
   private boolean[] P00349_n48LocCod ;
   private short[] P003410_A46PaiCod ;
   private boolean[] P003410_n46PaiCod ;
   private short[] P003410_A47ProvCod ;
   private boolean[] P003410_n47ProvCod ;
   private short[] P003410_A4CliPaiCod ;
   private boolean[] P003410_n4CliPaiCod ;
   private short[] P003410_A1EmpCod ;
   private int[] P003410_A3CliCod ;
   private short[] P003410_A48LocCod ;
   private boolean[] P003410_n48LocCod ;
   private String[] P003410_A286LocNom ;
   private String[] P003411_A286LocNom ;
   private short[] P003412_A47ProvCod ;
   private boolean[] P003412_n47ProvCod ;
   private short[] P003412_A46PaiCod ;
   private boolean[] P003412_n46PaiCod ;
   private short[] P003412_A48LocCod ;
   private boolean[] P003412_n48LocCod ;
   private String[] P003412_A286LocNom ;
   private String[] P003413_A108ActDescrip ;
   private String[] P003413_A43ActCodigo ;
   private boolean[] P003413_n43ActCodigo ;
   private short[] P003414_A1EmpCod ;
   private int[] P003414_A3CliCod ;
   private String[] P003414_A43ActCodigo ;
   private boolean[] P003414_n43ActCodigo ;
   private String[] P003414_A108ActDescrip ;
   private String[] P003415_A43ActCodigo ;
   private boolean[] P003415_n43ActCodigo ;
   private String[] P003415_A108ActDescrip ;
   private String[] P003416_A339TipEmpleDescri ;
   private String[] P003416_A45TipEmpleCod ;
   private boolean[] P003416_n45TipEmpleCod ;
   private short[] P003417_A1EmpCod ;
   private int[] P003417_A3CliCod ;
   private String[] P003417_A45TipEmpleCod ;
   private boolean[] P003417_n45TipEmpleCod ;
   private String[] P003417_A339TipEmpleDescri ;
   private String[] P003418_A45TipEmpleCod ;
   private boolean[] P003418_n45TipEmpleCod ;
   private String[] P003418_A339TipEmpleDescri ;
   private String[] P003419_A342ZonDescrip ;
   private String[] P003419_A20ZonCod ;
   private short[] P003420_A1EmpCod ;
   private int[] P003420_A3CliCod ;
   private String[] P003420_A44EmpZonCod ;
   private boolean[] P003420_n44EmpZonCod ;
   private String[] P003421_A20ZonCod ;
   private String[] P003421_A342ZonDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class liqimportarauxtrnloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00342( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A312PaiNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT PaiNom, PaiCod FROM Pais" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiNom" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00345( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A322ProvNom ,
                                          short A46PaiCod ,
                                          short AV32Cond_PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT PaiCod, ProvNom, ProvCod FROM Provincia" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ProvNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ProvNom" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P00349( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A286LocNom ,
                                          short AV32Cond_PaiCod ,
                                          short AV33Cond_ProvCod ,
                                          short A46PaiCod ,
                                          short A47ProvCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT LocNom, ProvCod, PaiCod, LocCod FROM Localidad" ;
      addWhere(sWhereString, "(PaiCod = ? and ProvCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(LocNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, ProvCod, LocNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P003413( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A108ActDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[1];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT ActDescrip, ActCodigo FROM Actividad" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ActDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActDescrip" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P003416( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A339TipEmpleDescri )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[1];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT TipEmpleDescri, TipEmpleCod FROM TipoEmpleador" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleDescri) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipEmpleDescri" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P003419( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A342ZonDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[1];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT ZonDescrip, ZonCod FROM Zona" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ZonDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ZonDescrip" ;
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
                  return conditional_P00342(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P00345(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
            case 7 :
                  return conditional_P00349(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
            case 11 :
                  return conditional_P003413(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 14 :
                  return conditional_P003416(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 17 :
                  return conditional_P003419(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00342", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00343", "SELECT T1.EmpCod, T1.CliCod, T1.PaiCod, T2.PaiNom FROM (Empresa T1 LEFT JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00344", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00345", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00346", "SELECT T1.PaiCod, T2.CliPaiCod, T1.EmpCod, T1.CliCod, T1.ProvCod, T3.ProvNom FROM ((Empresa T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) LEFT JOIN Provincia T3 ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00347", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00348", "SELECT PaiCod, ProvCod, ProvNom FROM Provincia WHERE PaiCod = ? and ProvCod = ? ORDER BY PaiCod, ProvCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00349", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003410", "SELECT T1.PaiCod, T1.ProvCod, T2.CliPaiCod, T1.EmpCod, T1.CliCod, T1.LocCod, T3.LocNom FROM ((Empresa T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) LEFT JOIN Localidad T3 ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod AND T3.LocCod = T1.LocCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003411", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003412", "SELECT ProvCod, PaiCod, LocCod, LocNom FROM Localidad WHERE PaiCod = ? and ProvCod = ? and LocCod = ? ORDER BY PaiCod, ProvCod, LocCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003413", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003414", "SELECT T1.EmpCod, T1.CliCod, T1.ActCodigo, T2.ActDescrip FROM (Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003415", "SELECT ActCodigo, ActDescrip FROM Actividad WHERE ActCodigo = ( ?) ORDER BY ActCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003416", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003417", "SELECT T1.EmpCod, T1.CliCod, T1.TipEmpleCod, T2.TipEmpleDescri FROM (Empresa T1 LEFT JOIN TipoEmpleador T2 ON T2.TipEmpleCod = T1.TipEmpleCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003418", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador WHERE TipEmpleCod = ( ?) ORDER BY TipEmpleCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003419", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003420", "SELECT EmpCod, CliCod, EmpZonCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003421", "SELECT ZonCod, ZonDescrip FROM Zona WHERE ZonCod = ( ?) ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 8);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 11 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 8);
               return;
            case 14 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 17 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

