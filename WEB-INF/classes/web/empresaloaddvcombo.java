package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresaloaddvcombo extends GXProcedure
{
   public empresaloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresaloaddvcombo.class ), "" );
   }

   public empresaloaddvcombo( int remoteHandle ,
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
                             int aP5 ,
                             short aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      empresaloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        int aP5 ,
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
                             int aP5 ,
                             short aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      empresaloaddvcombo.this.AV17ComboName = aP0;
      empresaloaddvcombo.this.AV19TrnMode = aP1;
      empresaloaddvcombo.this.AV22IsDynamicCall = aP2;
      empresaloaddvcombo.this.AV28CliCod = aP3;
      empresaloaddvcombo.this.AV29EmpCod = aP4;
      empresaloaddvcombo.this.AV30Cond_CliCod = aP5;
      empresaloaddvcombo.this.AV40Cond_EmpCod = aP6;
      empresaloaddvcombo.this.AV12SearchTxt = aP7;
      empresaloaddvcombo.this.aP8 = aP8;
      empresaloaddvcombo.this.aP9 = aP9;
      empresaloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa", GXv_boolean2) ;
      empresaloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "EmpHsPDiaTipTra") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPHSPDIATIPTRA' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "PaiTipoTraId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAITIPOTRAID' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "EmpOrigen") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPORIGEN' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "EmpReligion") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPRELIGION' */
            S141 ();
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
         else if ( GXutil.strcmp(AV17ComboName, "ActComCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ACTCOMCODIGO' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( GXutil.strcmp(AV19TrnMode, "INS") == 0 )
      {
         GXv_char4[0] = AV16SelectedValue ;
         GXv_char5[0] = AV21SelectedText ;
         new web.dvcombodefaults(remoteHandle, context).execute( AV17ComboName, GXv_char4, GXv_char5) ;
         empresaloaddvcombo.this.AV16SelectedValue = GXv_char4[0] ;
         empresaloaddvcombo.this.AV21SelectedText = GXv_char5[0] ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_EMPHSPDIATIPTRA' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         if ( GXutil.strcmp(AV19TrnMode, "GET_DSC") == 0 )
         {
            AV37ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV36DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV48GXV1 = 1 ;
            while ( AV48GXV1 <= AV37ValuesCollection.size() )
            {
               AV38ValueItem = (String)AV37ValuesCollection.elementAt(-1+AV48GXV1) ;
               AV41PaiTipoTraId_Filter = AV38ValueItem ;
               AV49GXLvl48 = (byte)(0) ;
               /* Using cursor P00132 */
               pr_default.execute(0, new Object[] {Integer.valueOf(AV30Cond_CliCod), Short.valueOf(AV40Cond_EmpCod), AV41PaiTipoTraId_Filter});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A1EmpCod = P00132_A1EmpCod[0] ;
                  A3CliCod = P00132_A3CliCod[0] ;
                  A1294PaiTipoTraId = P00132_A1294PaiTipoTraId[0] ;
                  A1344EmpHsDia = P00132_A1344EmpHsDia[0] ;
                  AV49GXLvl48 = (byte)(1) ;
                  AV36DscsCollection.add(GXutil.trim( localUtil.format( A1344EmpHsDia, "9.9")), 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
               if ( AV49GXLvl48 == 0 )
               {
                  AV36DscsCollection.add("", 0);
               }
               AV48GXV1 = (int)(AV48GXV1+1) ;
            }
            AV13Combo_DataJson = AV36DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1344EmpHsDia ,
                                                 Integer.valueOf(AV30Cond_CliCod) ,
                                                 Short.valueOf(AV40Cond_EmpCod) } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P00133 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV30Cond_CliCod), Short.valueOf(AV40Cond_EmpCod), lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A3CliCod = P00133_A3CliCod[0] ;
               A1EmpCod = P00133_A1EmpCod[0] ;
               A1344EmpHsDia = P00133_A1344EmpHsDia[0] ;
               A1294PaiTipoTraId = P00133_A1294PaiTipoTraId[0] ;
               AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1294PaiTipoTraId );
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( A1344EmpHsDia, "9.9")) );
               AV14Combo_Data.add(AV15Combo_DataItem, 0);
               if ( AV14Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_PAITIPOTRAID' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         if ( GXutil.strcmp(AV19TrnMode, "GET_DSC") == 0 )
         {
            AV37ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV36DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV51GXV2 = 1 ;
            while ( AV51GXV2 <= AV37ValuesCollection.size() )
            {
               AV38ValueItem = (String)AV37ValuesCollection.elementAt(-1+AV51GXV2) ;
               AV42TipoTraId_Filter = AV38ValueItem ;
               AV52GXLvl89 = (byte)(0) ;
               /* Using cursor P00134 */
               pr_default.execute(2, new Object[] {AV42TipoTraId_Filter});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1292TipoTraId = P00134_A1292TipoTraId[0] ;
                  A1293TipoTraNom = P00134_A1293TipoTraNom[0] ;
                  AV52GXLvl89 = (byte)(1) ;
                  AV36DscsCollection.add(A1293TipoTraNom, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
               if ( AV52GXLvl89 == 0 )
               {
                  AV36DscsCollection.add("", 0);
               }
               AV51GXV2 = (int)(AV51GXV2+1) ;
            }
            AV13Combo_DataJson = AV36DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(3, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1293TipoTraNom } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P00135 */
            pr_default.execute(3, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(3) != 101) )
            {
               A1293TipoTraNom = P00135_A1293TipoTraNom[0] ;
               A1292TipoTraId = P00135_A1292TipoTraId[0] ;
               AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1292TipoTraId );
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1293TipoTraNom );
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
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_EMPORIGEN' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         if ( GXutil.strcmp(AV19TrnMode, "GET_DSC") == 0 )
         {
            AV37ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV36DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV54GXV3 = 1 ;
            while ( AV54GXV3 <= AV37ValuesCollection.size() )
            {
               AV38ValueItem = (String)AV37ValuesCollection.elementAt(-1+AV54GXV3) ;
               AV39OrigId_Filter = AV38ValueItem ;
               AV55GXLvl128 = (byte)(0) ;
               /* Using cursor P00136 */
               pr_default.execute(4, new Object[] {AV39OrigId_Filter});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A1231OrigId = P00136_A1231OrigId[0] ;
                  A1284OrigNombre = P00136_A1284OrigNombre[0] ;
                  AV55GXLvl128 = (byte)(1) ;
                  AV36DscsCollection.add(A1284OrigNombre, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
               if ( AV55GXLvl128 == 0 )
               {
                  AV36DscsCollection.add("", 0);
               }
               AV54GXV3 = (int)(AV54GXV3+1) ;
            }
            AV13Combo_DataJson = AV36DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(5, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1284OrigNombre } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P00137 */
            pr_default.execute(5, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A1284OrigNombre = P00137_A1284OrigNombre[0] ;
               A1231OrigId = P00137_A1231OrigId[0] ;
               AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1231OrigId );
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1284OrigNombre );
               AV14Combo_Data.add(AV15Combo_DataItem, 0);
               if ( AV14Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(5);
            }
            pr_default.close(5);
            AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S141( )
   {
      /* 'LOADCOMBOITEMS_EMPRELIGION' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         if ( GXutil.strcmp(AV19TrnMode, "GET_DSC") == 0 )
         {
            AV37ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV36DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV57GXV4 = 1 ;
            while ( AV57GXV4 <= AV37ValuesCollection.size() )
            {
               AV38ValueItem = (String)AV37ValuesCollection.elementAt(-1+AV57GXV4) ;
               AV44ReligId_Filter = AV38ValueItem ;
               AV58GXLvl167 = (byte)(0) ;
               /* Using cursor P00138 */
               pr_default.execute(6, new Object[] {AV44ReligId_Filter});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A1229ReligId = P00138_A1229ReligId[0] ;
                  A1283ReligNombre = P00138_A1283ReligNombre[0] ;
                  AV58GXLvl167 = (byte)(1) ;
                  AV36DscsCollection.add(A1283ReligNombre, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(6);
               if ( AV58GXLvl167 == 0 )
               {
                  AV36DscsCollection.add("", 0);
               }
               AV57GXV4 = (int)(AV57GXV4+1) ;
            }
            AV13Combo_DataJson = AV36DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(7, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1283ReligNombre } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P00139 */
            pr_default.execute(7, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(7) != 101) )
            {
               A1283ReligNombre = P00139_A1283ReligNombre[0] ;
               A1229ReligId = P00139_A1229ReligId[0] ;
               AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1229ReligId );
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1283ReligNombre );
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
      }
   }

   public void S151( )
   {
      /* 'LOADCOMBOITEMS_ACTCODIGO' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(8, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A108ActDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P001310 */
         pr_default.execute(8, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(8) != 101) )
         {
            A108ActDescrip = P001310_A108ActDescrip[0] ;
            A43ActCodigo = P001310_A43ActCodigo[0] ;
            n43ActCodigo = P001310_n43ActCodigo[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A43ActCodigo );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A108ActDescrip );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(8);
         }
         pr_default.close(8);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P001311 */
               pr_default.execute(9, new Object[] {Integer.valueOf(AV28CliCod), Short.valueOf(AV29EmpCod)});
               while ( (pr_default.getStatus(9) != 101) )
               {
                  A1EmpCod = P001311_A1EmpCod[0] ;
                  A3CliCod = P001311_A3CliCod[0] ;
                  A43ActCodigo = P001311_A43ActCodigo[0] ;
                  n43ActCodigo = P001311_n43ActCodigo[0] ;
                  A108ActDescrip = P001311_A108ActDescrip[0] ;
                  A108ActDescrip = P001311_A108ActDescrip[0] ;
                  AV16SelectedValue = A43ActCodigo ;
                  AV21SelectedText = A108ActDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(9);
            }
            else
            {
               AV24ActCodigo = AV12SearchTxt ;
               /* Using cursor P001312 */
               pr_default.execute(10, new Object[] {AV24ActCodigo});
               while ( (pr_default.getStatus(10) != 101) )
               {
                  A43ActCodigo = P001312_A43ActCodigo[0] ;
                  n43ActCodigo = P001312_n43ActCodigo[0] ;
                  A108ActDescrip = P001312_A108ActDescrip[0] ;
                  AV21SelectedText = A108ActDescrip ;
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

   public void S161( )
   {
      /* 'LOADCOMBOITEMS_EMPZONCOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(11, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A342ZonDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P001313 */
         pr_default.execute(11, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(11) != 101) )
         {
            A342ZonDescrip = P001313_A342ZonDescrip[0] ;
            A20ZonCod = P001313_A20ZonCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A20ZonCod );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A342ZonDescrip );
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
               /* Using cursor P001314 */
               pr_default.execute(12, new Object[] {Integer.valueOf(AV28CliCod), Short.valueOf(AV29EmpCod)});
               while ( (pr_default.getStatus(12) != 101) )
               {
                  A1EmpCod = P001314_A1EmpCod[0] ;
                  A3CliCod = P001314_A3CliCod[0] ;
                  A44EmpZonCod = P001314_A44EmpZonCod[0] ;
                  n44EmpZonCod = P001314_n44EmpZonCod[0] ;
                  AV16SelectedValue = A44EmpZonCod ;
                  AV33ZonCod = A44EmpZonCod ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(12);
            }
            else
            {
               AV33ZonCod = AV12SearchTxt ;
            }
            /* Using cursor P001315 */
            pr_default.execute(13, new Object[] {AV33ZonCod});
            while ( (pr_default.getStatus(13) != 101) )
            {
               A20ZonCod = P001315_A20ZonCod[0] ;
               A342ZonDescrip = P001315_A342ZonDescrip[0] ;
               AV21SelectedText = A342ZonDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(13);
         }
      }
   }

   public void S171( )
   {
      /* 'LOADCOMBOITEMS_ACTCOMCODIGO' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(14, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A904ActComDescripcion } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P001316 */
         pr_default.execute(14, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(14) != 101) )
         {
            A904ActComDescripcion = P001316_A904ActComDescripcion[0] ;
            A903ActComCodigo = P001316_A903ActComCodigo[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A903ActComCodigo );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A904ActComDescripcion );
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
               /* Using cursor P001317 */
               pr_default.execute(15, new Object[] {Integer.valueOf(AV28CliCod), Short.valueOf(AV29EmpCod)});
               while ( (pr_default.getStatus(15) != 101) )
               {
                  A1EmpCod = P001317_A1EmpCod[0] ;
                  A3CliCod = P001317_A3CliCod[0] ;
                  A903ActComCodigo = P001317_A903ActComCodigo[0] ;
                  A904ActComDescripcion = P001317_A904ActComDescripcion[0] ;
                  A904ActComDescripcion = P001317_A904ActComDescripcion[0] ;
                  AV16SelectedValue = A903ActComCodigo ;
                  AV21SelectedText = A904ActComDescripcion ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(15);
            }
            else
            {
               AV45ActComCodigo = AV12SearchTxt ;
               /* Using cursor P001318 */
               pr_default.execute(16, new Object[] {AV45ActComCodigo});
               while ( (pr_default.getStatus(16) != 101) )
               {
                  A903ActComCodigo = P001318_A903ActComCodigo[0] ;
                  A904ActComDescripcion = P001318_A904ActComDescripcion[0] ;
                  AV21SelectedText = A904ActComDescripcion ;
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

   protected void cleanup( )
   {
      this.aP8[0] = empresaloaddvcombo.this.AV16SelectedValue;
      this.aP9[0] = empresaloaddvcombo.this.AV21SelectedText;
      this.aP10[0] = empresaloaddvcombo.this.AV13Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
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
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      AV37ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38ValueItem = "" ;
      AV41PaiTipoTraId_Filter = "" ;
      scmdbuf = "" ;
      P00132_A1EmpCod = new short[1] ;
      P00132_A3CliCod = new int[1] ;
      P00132_A1294PaiTipoTraId = new String[] {""} ;
      P00132_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1294PaiTipoTraId = "" ;
      lV12SearchTxt = "" ;
      P00133_A3CliCod = new int[1] ;
      P00133_A1EmpCod = new short[1] ;
      P00133_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00133_A1294PaiTipoTraId = new String[] {""} ;
      AV15Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1293TipoTraNom = "" ;
      AV42TipoTraId_Filter = "" ;
      P00134_A1292TipoTraId = new String[] {""} ;
      P00134_A1293TipoTraNom = new String[] {""} ;
      A1292TipoTraId = "" ;
      P00135_A1293TipoTraNom = new String[] {""} ;
      P00135_A1292TipoTraId = new String[] {""} ;
      A1284OrigNombre = "" ;
      AV39OrigId_Filter = "" ;
      P00136_A1231OrigId = new String[] {""} ;
      P00136_A1284OrigNombre = new String[] {""} ;
      A1231OrigId = "" ;
      P00137_A1284OrigNombre = new String[] {""} ;
      P00137_A1231OrigId = new String[] {""} ;
      A1283ReligNombre = "" ;
      AV44ReligId_Filter = "" ;
      P00138_A1229ReligId = new String[] {""} ;
      P00138_A1283ReligNombre = new String[] {""} ;
      A1229ReligId = "" ;
      P00139_A1283ReligNombre = new String[] {""} ;
      P00139_A1229ReligId = new String[] {""} ;
      A108ActDescrip = "" ;
      P001310_A108ActDescrip = new String[] {""} ;
      P001310_A43ActCodigo = new String[] {""} ;
      P001310_n43ActCodigo = new boolean[] {false} ;
      A43ActCodigo = "" ;
      P001311_A1EmpCod = new short[1] ;
      P001311_A3CliCod = new int[1] ;
      P001311_A43ActCodigo = new String[] {""} ;
      P001311_n43ActCodigo = new boolean[] {false} ;
      P001311_A108ActDescrip = new String[] {""} ;
      AV24ActCodigo = "" ;
      P001312_A43ActCodigo = new String[] {""} ;
      P001312_n43ActCodigo = new boolean[] {false} ;
      P001312_A108ActDescrip = new String[] {""} ;
      A342ZonDescrip = "" ;
      P001313_A342ZonDescrip = new String[] {""} ;
      P001313_A20ZonCod = new String[] {""} ;
      A20ZonCod = "" ;
      P001314_A1EmpCod = new short[1] ;
      P001314_A3CliCod = new int[1] ;
      P001314_A44EmpZonCod = new String[] {""} ;
      P001314_n44EmpZonCod = new boolean[] {false} ;
      A44EmpZonCod = "" ;
      AV33ZonCod = "" ;
      P001315_A20ZonCod = new String[] {""} ;
      P001315_A342ZonDescrip = new String[] {""} ;
      A904ActComDescripcion = "" ;
      P001316_A904ActComDescripcion = new String[] {""} ;
      P001316_A903ActComCodigo = new String[] {""} ;
      A903ActComCodigo = "" ;
      P001317_A1EmpCod = new short[1] ;
      P001317_A3CliCod = new int[1] ;
      P001317_A903ActComCodigo = new String[] {""} ;
      P001317_A904ActComDescripcion = new String[] {""} ;
      AV45ActComCodigo = "" ;
      P001318_A903ActComCodigo = new String[] {""} ;
      P001318_A904ActComDescripcion = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresaloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P00132_A1EmpCod, P00132_A3CliCod, P00132_A1294PaiTipoTraId, P00132_A1344EmpHsDia
            }
            , new Object[] {
            P00133_A3CliCod, P00133_A1EmpCod, P00133_A1344EmpHsDia, P00133_A1294PaiTipoTraId
            }
            , new Object[] {
            P00134_A1292TipoTraId, P00134_A1293TipoTraNom
            }
            , new Object[] {
            P00135_A1293TipoTraNom, P00135_A1292TipoTraId
            }
            , new Object[] {
            P00136_A1231OrigId, P00136_A1284OrigNombre
            }
            , new Object[] {
            P00137_A1284OrigNombre, P00137_A1231OrigId
            }
            , new Object[] {
            P00138_A1229ReligId, P00138_A1283ReligNombre
            }
            , new Object[] {
            P00139_A1283ReligNombre, P00139_A1229ReligId
            }
            , new Object[] {
            P001310_A108ActDescrip, P001310_A43ActCodigo
            }
            , new Object[] {
            P001311_A1EmpCod, P001311_A3CliCod, P001311_A43ActCodigo, P001311_n43ActCodigo, P001311_A108ActDescrip
            }
            , new Object[] {
            P001312_A43ActCodigo, P001312_A108ActDescrip
            }
            , new Object[] {
            P001313_A342ZonDescrip, P001313_A20ZonCod
            }
            , new Object[] {
            P001314_A1EmpCod, P001314_A3CliCod, P001314_A44EmpZonCod, P001314_n44EmpZonCod
            }
            , new Object[] {
            P001315_A20ZonCod, P001315_A342ZonDescrip
            }
            , new Object[] {
            P001316_A904ActComDescripcion, P001316_A903ActComCodigo
            }
            , new Object[] {
            P001317_A1EmpCod, P001317_A3CliCod, P001317_A903ActComCodigo, P001317_A904ActComDescripcion
            }
            , new Object[] {
            P001318_A903ActComCodigo, P001318_A904ActComDescripcion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV49GXLvl48 ;
   private byte AV52GXLvl89 ;
   private byte AV55GXLvl128 ;
   private byte AV58GXLvl167 ;
   private short AV29EmpCod ;
   private short AV40Cond_EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV28CliCod ;
   private int AV30Cond_CliCod ;
   private int AV11MaxItems ;
   private int AV48GXV1 ;
   private int A3CliCod ;
   private int AV51GXV2 ;
   private int AV54GXV3 ;
   private int AV57GXV4 ;
   private java.math.BigDecimal A1344EmpHsDia ;
   private String AV19TrnMode ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String AV41PaiTipoTraId_Filter ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String AV42TipoTraId_Filter ;
   private String A1292TipoTraId ;
   private String AV39OrigId_Filter ;
   private String A1231OrigId ;
   private String AV44ReligId_Filter ;
   private String A1229ReligId ;
   private String A43ActCodigo ;
   private String AV24ActCodigo ;
   private String A20ZonCod ;
   private String A44EmpZonCod ;
   private String AV33ZonCod ;
   private String A903ActComCodigo ;
   private String AV45ActComCodigo ;
   private boolean AV22IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n43ActCodigo ;
   private boolean n44EmpZonCod ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV21SelectedText ;
   private String AV38ValueItem ;
   private String lV12SearchTxt ;
   private String A1293TipoTraNom ;
   private String A1284OrigNombre ;
   private String A1283ReligNombre ;
   private String A108ActDescrip ;
   private String A342ZonDescrip ;
   private String A904ActComDescripcion ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private short[] P00132_A1EmpCod ;
   private int[] P00132_A3CliCod ;
   private String[] P00132_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] P00132_A1344EmpHsDia ;
   private int[] P00133_A3CliCod ;
   private short[] P00133_A1EmpCod ;
   private java.math.BigDecimal[] P00133_A1344EmpHsDia ;
   private String[] P00133_A1294PaiTipoTraId ;
   private String[] P00134_A1292TipoTraId ;
   private String[] P00134_A1293TipoTraNom ;
   private String[] P00135_A1293TipoTraNom ;
   private String[] P00135_A1292TipoTraId ;
   private String[] P00136_A1231OrigId ;
   private String[] P00136_A1284OrigNombre ;
   private String[] P00137_A1284OrigNombre ;
   private String[] P00137_A1231OrigId ;
   private String[] P00138_A1229ReligId ;
   private String[] P00138_A1283ReligNombre ;
   private String[] P00139_A1283ReligNombre ;
   private String[] P00139_A1229ReligId ;
   private String[] P001310_A108ActDescrip ;
   private String[] P001310_A43ActCodigo ;
   private boolean[] P001310_n43ActCodigo ;
   private short[] P001311_A1EmpCod ;
   private int[] P001311_A3CliCod ;
   private String[] P001311_A43ActCodigo ;
   private boolean[] P001311_n43ActCodigo ;
   private String[] P001311_A108ActDescrip ;
   private String[] P001312_A43ActCodigo ;
   private boolean[] P001312_n43ActCodigo ;
   private String[] P001312_A108ActDescrip ;
   private String[] P001313_A342ZonDescrip ;
   private String[] P001313_A20ZonCod ;
   private short[] P001314_A1EmpCod ;
   private int[] P001314_A3CliCod ;
   private String[] P001314_A44EmpZonCod ;
   private boolean[] P001314_n44EmpZonCod ;
   private String[] P001315_A20ZonCod ;
   private String[] P001315_A342ZonDescrip ;
   private String[] P001316_A904ActComDescripcion ;
   private String[] P001316_A903ActComCodigo ;
   private short[] P001317_A1EmpCod ;
   private int[] P001317_A3CliCod ;
   private String[] P001317_A903ActComCodigo ;
   private String[] P001317_A904ActComDescripcion ;
   private String[] P001318_A903ActComCodigo ;
   private String[] P001318_A904ActComDescripcion ;
   private GXSimpleCollection<String> AV37ValuesCollection ;
   private GXSimpleCollection<String> AV36DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class empresaloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00133( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          java.math.BigDecimal A1344EmpHsDia ,
                                          int AV30Cond_CliCod ,
                                          short AV40Cond_EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[3];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, EmpHsDia, PaiTipoTraId FROM Empresatipo_trabajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(SUBSTR(TO_CHAR(EmpHsDia,'0.9'), 2) like '%' || ?)");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EmpHsDia" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P00135( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1293TipoTraNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoTraNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00137( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1284OrigNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[1];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT OrigNombre, OrigId FROM Origen" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(OrigNombre) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OrigNombre" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P00139( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1283ReligNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[1];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT ReligNombre, ReligId FROM Religion" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ReligNombre) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ReligNombre" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P001310( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A108ActDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[1];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT ActDescrip, ActCodigo FROM Actividad" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ActDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActDescrip" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P001313( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A342ZonDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[1];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT ZonDescrip, ZonCod FROM Zona" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ZonDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int16[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ZonDescrip" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P001316( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A904ActComDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[1];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT ActComDescripcion, ActComCodigo FROM actividadcomercial" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ActComDescripcion) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int18[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActComDescripcion" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_P00133(context, remoteHandle, httpContext, (String)dynConstraints[0] , (java.math.BigDecimal)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() );
            case 3 :
                  return conditional_P00135(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 5 :
                  return conditional_P00137(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 7 :
                  return conditional_P00139(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 8 :
                  return conditional_P001310(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 11 :
                  return conditional_P001313(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 14 :
                  return conditional_P001316(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00132", "SELECT EmpCod, CliCod, PaiTipoTraId, EmpHsDia FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? and PaiTipoTraId = ( ?) ORDER BY CliCod, EmpCod, PaiTipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00133", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00134", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00135", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00136", "SELECT OrigId, OrigNombre FROM Origen WHERE OrigId = ( ?) ORDER BY OrigId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00137", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00138", "SELECT ReligId, ReligNombre FROM Religion WHERE ReligId = ( ?) ORDER BY ReligId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00139", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001310", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001311", "SELECT T1.EmpCod, T1.CliCod, T1.ActCodigo, T2.ActDescrip FROM (Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001312", "SELECT ActCodigo, ActDescrip FROM Actividad WHERE ActCodigo = ( ?) ORDER BY ActCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001313", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001314", "SELECT EmpCod, CliCod, EmpZonCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001315", "SELECT ZonCod, ZonDescrip FROM Zona WHERE ZonCod = ( ?) ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001316", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001317", "SELECT T1.EmpCod, T1.CliCod, T1.ActComCodigo, T2.ActComDescripcion FROM (Empresa T1 INNER JOIN actividadcomercial T2 ON T2.ActComCodigo = T1.ActComCodigo) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001318", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial WHERE ActComCodigo = ( ?) ORDER BY ActComCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 8);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 16 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
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
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 8);
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
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

