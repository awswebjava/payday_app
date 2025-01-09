package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresa_abm_1loaddvcombo extends GXProcedure
{
   public empresa_abm_1loaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_abm_1loaddvcombo.class ), "" );
   }

   public empresa_abm_1loaddvcombo( int remoteHandle ,
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
      empresa_abm_1loaddvcombo.this.aP10 = new String[] {""};
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
      empresa_abm_1loaddvcombo.this.AV15ComboName = aP0;
      empresa_abm_1loaddvcombo.this.AV16TrnMode = aP1;
      empresa_abm_1loaddvcombo.this.AV17IsDynamicCall = aP2;
      empresa_abm_1loaddvcombo.this.AV18CliCod = aP3;
      empresa_abm_1loaddvcombo.this.AV19EmpCod = aP4;
      empresa_abm_1loaddvcombo.this.AV41Cond_PaiCod = aP5;
      empresa_abm_1loaddvcombo.this.AV42Cond_ProvCod = aP6;
      empresa_abm_1loaddvcombo.this.AV12SearchTxt = aP7;
      empresa_abm_1loaddvcombo.this.aP8 = aP8;
      empresa_abm_1loaddvcombo.this.aP9 = aP9;
      empresa_abm_1loaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_abm_1", GXv_boolean2) ;
      empresa_abm_1loaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "TipoConCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_TIPOCONCOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EmpReligion") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPRELIGION' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EmpOrigen") == 0 )
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
         else if ( GXutil.strcmp(AV15ComboName, "PaiTipoTraId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAITIPOTRAID' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EmpHsPDiaTipTra") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPHSPDIATIPTRA' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "PaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAICOD' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "ProvCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PROVCOD' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "LocCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LOCCOD' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "ActCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ACTCODIGO' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "TipEmpleCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_TIPEMPLECOD' */
            S201 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EmpZonCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPZONCOD' */
            S211 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EmpActComercial") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMPACTCOMERCIAL' */
            S221 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "ARTSec") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ARTSEC' */
            S231 ();
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
      /* 'LOADCOMBOITEMS_TIPOCONCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV35ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV34DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV48GXV1 = 1 ;
            while ( AV48GXV1 <= AV35ValuesCollection.size() )
            {
               AV36ValueItem = (String)AV35ValuesCollection.elementAt(-1+AV48GXV1) ;
               AV45TipoConCod_Filter = AV36ValueItem ;
               AV49GXLvl56 = (byte)(0) ;
               /* Using cursor P01DN2 */
               pr_default.execute(0, new Object[] {AV45TipoConCod_Filter});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A37TipoConCod = P01DN2_A37TipoConCod[0] ;
                  A370TipoConDescrip = P01DN2_A370TipoConDescrip[0] ;
                  AV49GXLvl56 = (byte)(1) ;
                  AV34DscsCollection.add(A370TipoConDescrip, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
               if ( AV49GXLvl56 == 0 )
               {
                  AV34DscsCollection.add("", 0);
               }
               AV48GXV1 = (int)(AV48GXV1+1) ;
            }
            AV22Combo_DataJson = AV34DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A370TipoConDescrip } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P01DN3 */
            pr_default.execute(1, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A370TipoConDescrip = P01DN3_A370TipoConDescrip[0] ;
               A37TipoConCod = P01DN3_A37TipoConCod[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A37TipoConCod );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A370TipoConDescrip );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_EMPRELIGION' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV35ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV34DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV51GXV2 = 1 ;
            while ( AV51GXV2 <= AV35ValuesCollection.size() )
            {
               AV36ValueItem = (String)AV35ValuesCollection.elementAt(-1+AV51GXV2) ;
               AV43ReligId_Filter = AV36ValueItem ;
               AV52GXLvl95 = (byte)(0) ;
               /* Using cursor P01DN4 */
               pr_default.execute(2, new Object[] {AV43ReligId_Filter});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1229ReligId = P01DN4_A1229ReligId[0] ;
                  A1283ReligNombre = P01DN4_A1283ReligNombre[0] ;
                  AV52GXLvl95 = (byte)(1) ;
                  AV34DscsCollection.add(A1283ReligNombre, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
               if ( AV52GXLvl95 == 0 )
               {
                  AV34DscsCollection.add("", 0);
               }
               AV51GXV2 = (int)(AV51GXV2+1) ;
            }
            AV22Combo_DataJson = AV34DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(3, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1283ReligNombre } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P01DN5 */
            pr_default.execute(3, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(3) != 101) )
            {
               A1283ReligNombre = P01DN5_A1283ReligNombre[0] ;
               A1229ReligId = P01DN5_A1229ReligId[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1229ReligId );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1283ReligNombre );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(3);
            }
            pr_default.close(3);
            AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_EMPORIGEN' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV35ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV34DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV54GXV3 = 1 ;
            while ( AV54GXV3 <= AV35ValuesCollection.size() )
            {
               AV36ValueItem = (String)AV35ValuesCollection.elementAt(-1+AV54GXV3) ;
               AV37OrigId_Filter = AV36ValueItem ;
               AV55GXLvl134 = (byte)(0) ;
               /* Using cursor P01DN6 */
               pr_default.execute(4, new Object[] {AV37OrigId_Filter});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A1231OrigId = P01DN6_A1231OrigId[0] ;
                  A1284OrigNombre = P01DN6_A1284OrigNombre[0] ;
                  AV55GXLvl134 = (byte)(1) ;
                  AV34DscsCollection.add(A1284OrigNombre, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
               if ( AV55GXLvl134 == 0 )
               {
                  AV34DscsCollection.add("", 0);
               }
               AV54GXV3 = (int)(AV54GXV3+1) ;
            }
            AV22Combo_DataJson = AV34DscsCollection.toJSonString(false) ;
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
            /* Using cursor P01DN7 */
            pr_default.execute(5, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A1284OrigNombre = P01DN7_A1284OrigNombre[0] ;
               A1231OrigId = P01DN7_A1231OrigId[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1231OrigId );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1284OrigNombre );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(5);
            }
            pr_default.close(5);
            AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S141( )
   {
      /* 'LOADCOMBOITEMS_PAITIPOTRAID' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV35ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV34DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV57GXV4 = 1 ;
            while ( AV57GXV4 <= AV35ValuesCollection.size() )
            {
               AV36ValueItem = (String)AV35ValuesCollection.elementAt(-1+AV57GXV4) ;
               AV38TipoTraId_Filter = AV36ValueItem ;
               AV58GXLvl173 = (byte)(0) ;
               /* Using cursor P01DN8 */
               pr_default.execute(6, new Object[] {AV38TipoTraId_Filter});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A1292TipoTraId = P01DN8_A1292TipoTraId[0] ;
                  A1293TipoTraNom = P01DN8_A1293TipoTraNom[0] ;
                  AV58GXLvl173 = (byte)(1) ;
                  AV34DscsCollection.add(A1293TipoTraNom, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(6);
               if ( AV58GXLvl173 == 0 )
               {
                  AV34DscsCollection.add("", 0);
               }
               AV57GXV4 = (int)(AV57GXV4+1) ;
            }
            AV22Combo_DataJson = AV34DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(7, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1293TipoTraNom } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P01DN9 */
            pr_default.execute(7, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(7) != 101) )
            {
               A1293TipoTraNom = P01DN9_A1293TipoTraNom[0] ;
               A1292TipoTraId = P01DN9_A1292TipoTraId[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1292TipoTraId );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1293TipoTraNom );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(7);
            }
            pr_default.close(7);
            AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S151( )
   {
      /* 'LOADCOMBOITEMS_EMPHSPDIATIPTRA' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         if ( GXutil.strcmp(AV16TrnMode, "GET_DSC") == 0 )
         {
            AV35ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV34DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV60GXV5 = 1 ;
            while ( AV60GXV5 <= AV35ValuesCollection.size() )
            {
               AV36ValueItem = (String)AV35ValuesCollection.elementAt(-1+AV60GXV5) ;
               AV38TipoTraId_Filter = AV36ValueItem ;
               AV61GXLvl212 = (byte)(0) ;
               /* Using cursor P01DN10 */
               pr_default.execute(8, new Object[] {AV38TipoTraId_Filter});
               while ( (pr_default.getStatus(8) != 101) )
               {
                  A1292TipoTraId = P01DN10_A1292TipoTraId[0] ;
                  A1293TipoTraNom = P01DN10_A1293TipoTraNom[0] ;
                  AV61GXLvl212 = (byte)(1) ;
                  AV34DscsCollection.add(A1293TipoTraNom, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(8);
               if ( AV61GXLvl212 == 0 )
               {
                  AV34DscsCollection.add("", 0);
               }
               AV60GXV5 = (int)(AV60GXV5+1) ;
            }
            AV22Combo_DataJson = AV34DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(9, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A1293TipoTraNom } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P01DN11 */
            pr_default.execute(9, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(9) != 101) )
            {
               A1293TipoTraNom = P01DN11_A1293TipoTraNom[0] ;
               A1292TipoTraId = P01DN11_A1292TipoTraId[0] ;
               AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1292TipoTraId );
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1293TipoTraNom );
               AV13Combo_Data.add(AV14Combo_DataItem, 0);
               if ( AV13Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(9);
            }
            pr_default.close(9);
            AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S161( )
   {
      /* 'LOADCOMBOITEMS_PAICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(10, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A312PaiNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN12 */
         pr_default.execute(10, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(10) != 101) )
         {
            A312PaiNom = P01DN12_A312PaiNom[0] ;
            A46PaiCod = P01DN12_A46PaiCod[0] ;
            n46PaiCod = P01DN12_n46PaiCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A46PaiCod, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A312PaiNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(10);
         }
         pr_default.close(10);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN13 */
               pr_default.execute(11, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(11) != 101) )
               {
                  A1EmpCod = P01DN13_A1EmpCod[0] ;
                  A3CliCod = P01DN13_A3CliCod[0] ;
                  A46PaiCod = P01DN13_A46PaiCod[0] ;
                  n46PaiCod = P01DN13_n46PaiCod[0] ;
                  A312PaiNom = P01DN13_A312PaiNom[0] ;
                  A312PaiNom = P01DN13_A312PaiNom[0] ;
                  AV20SelectedValue = ((0==A46PaiCod) ? "" : GXutil.trim( GXutil.str( A46PaiCod, 4, 0))) ;
                  AV21SelectedText = A312PaiNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(11);
            }
            else
            {
               AV26PaiCod = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P01DN14 */
               pr_default.execute(12, new Object[] {Short.valueOf(AV26PaiCod)});
               while ( (pr_default.getStatus(12) != 101) )
               {
                  A46PaiCod = P01DN14_A46PaiCod[0] ;
                  n46PaiCod = P01DN14_n46PaiCod[0] ;
                  A312PaiNom = P01DN14_A312PaiNom[0] ;
                  AV21SelectedText = A312PaiNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(12);
            }
         }
      }
   }

   public void S171( )
   {
      /* 'LOADCOMBOITEMS_PROVCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(13, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A322ProvNom ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV41Cond_PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN15 */
         pr_default.execute(13, new Object[] {Short.valueOf(AV41Cond_PaiCod), lV12SearchTxt});
         while ( (pr_default.getStatus(13) != 101) )
         {
            A46PaiCod = P01DN15_A46PaiCod[0] ;
            n46PaiCod = P01DN15_n46PaiCod[0] ;
            A322ProvNom = P01DN15_A322ProvNom[0] ;
            A47ProvCod = P01DN15_A47ProvCod[0] ;
            n47ProvCod = P01DN15_n47ProvCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A47ProvCod, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A322ProvNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(13);
         }
         pr_default.close(13);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(14) != 101) )
               {
                  A46PaiCod = P01DN16_A46PaiCod[0] ;
                  n46PaiCod = P01DN16_n46PaiCod[0] ;
                  A4CliPaiCod = P01DN16_A4CliPaiCod[0] ;
                  n4CliPaiCod = P01DN16_n4CliPaiCod[0] ;
                  A1EmpCod = P01DN16_A1EmpCod[0] ;
                  A3CliCod = P01DN16_A3CliCod[0] ;
                  A47ProvCod = P01DN16_A47ProvCod[0] ;
                  n47ProvCod = P01DN16_n47ProvCod[0] ;
                  A322ProvNom = P01DN16_A322ProvNom[0] ;
                  A4CliPaiCod = P01DN16_A4CliPaiCod[0] ;
                  n4CliPaiCod = P01DN16_n4CliPaiCod[0] ;
                  A322ProvNom = P01DN16_A322ProvNom[0] ;
                  /* Using cursor P01DN17 */
                  pr_default.execute(15, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
                  A322ProvNom = P01DN17_A322ProvNom[0] ;
                  pr_default.close(15);
                  AV20SelectedValue = ((0==A47ProvCod) ? "" : GXutil.trim( GXutil.str( A47ProvCod, 4, 0))) ;
                  AV21SelectedText = A322ProvNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(14);
            }
            else
            {
               AV27ProvCod = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P01DN18 */
               pr_default.execute(16, new Object[] {Short.valueOf(AV41Cond_PaiCod), Short.valueOf(AV27ProvCod)});
               while ( (pr_default.getStatus(16) != 101) )
               {
                  A46PaiCod = P01DN18_A46PaiCod[0] ;
                  n46PaiCod = P01DN18_n46PaiCod[0] ;
                  A47ProvCod = P01DN18_A47ProvCod[0] ;
                  n47ProvCod = P01DN18_n47ProvCod[0] ;
                  A322ProvNom = P01DN18_A322ProvNom[0] ;
                  AV21SelectedText = A322ProvNom ;
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

   public void S181( )
   {
      /* 'LOADCOMBOITEMS_LOCCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(17, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A286LocNom ,
                                              Short.valueOf(AV41Cond_PaiCod) ,
                                              Short.valueOf(AV42Cond_ProvCod) ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(A47ProvCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN19 */
         pr_default.execute(17, new Object[] {Short.valueOf(AV41Cond_PaiCod), Short.valueOf(AV42Cond_ProvCod), lV12SearchTxt});
         while ( (pr_default.getStatus(17) != 101) )
         {
            A286LocNom = P01DN19_A286LocNom[0] ;
            A47ProvCod = P01DN19_A47ProvCod[0] ;
            n47ProvCod = P01DN19_n47ProvCod[0] ;
            A46PaiCod = P01DN19_A46PaiCod[0] ;
            n46PaiCod = P01DN19_n46PaiCod[0] ;
            A48LocCod = P01DN19_A48LocCod[0] ;
            n48LocCod = P01DN19_n48LocCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A48LocCod, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A286LocNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(17);
         }
         pr_default.close(17);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN20 */
               pr_default.execute(18, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(18) != 101) )
               {
                  A46PaiCod = P01DN20_A46PaiCod[0] ;
                  n46PaiCod = P01DN20_n46PaiCod[0] ;
                  A47ProvCod = P01DN20_A47ProvCod[0] ;
                  n47ProvCod = P01DN20_n47ProvCod[0] ;
                  A4CliPaiCod = P01DN20_A4CliPaiCod[0] ;
                  n4CliPaiCod = P01DN20_n4CliPaiCod[0] ;
                  A1EmpCod = P01DN20_A1EmpCod[0] ;
                  A3CliCod = P01DN20_A3CliCod[0] ;
                  A48LocCod = P01DN20_A48LocCod[0] ;
                  n48LocCod = P01DN20_n48LocCod[0] ;
                  A286LocNom = P01DN20_A286LocNom[0] ;
                  A4CliPaiCod = P01DN20_A4CliPaiCod[0] ;
                  n4CliPaiCod = P01DN20_n4CliPaiCod[0] ;
                  A286LocNom = P01DN20_A286LocNom[0] ;
                  /* Using cursor P01DN21 */
                  pr_default.execute(19, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
                  A286LocNom = P01DN21_A286LocNom[0] ;
                  pr_default.close(19);
                  AV20SelectedValue = ((0==A48LocCod) ? "" : GXutil.trim( GXutil.str( A48LocCod, 4, 0))) ;
                  AV21SelectedText = A286LocNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(18);
            }
            else
            {
               AV28LocCod = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P01DN22 */
               pr_default.execute(20, new Object[] {Short.valueOf(AV41Cond_PaiCod), Short.valueOf(AV42Cond_ProvCod), Short.valueOf(AV28LocCod)});
               while ( (pr_default.getStatus(20) != 101) )
               {
                  A47ProvCod = P01DN22_A47ProvCod[0] ;
                  n47ProvCod = P01DN22_n47ProvCod[0] ;
                  A46PaiCod = P01DN22_A46PaiCod[0] ;
                  n46PaiCod = P01DN22_n46PaiCod[0] ;
                  A48LocCod = P01DN22_A48LocCod[0] ;
                  n48LocCod = P01DN22_n48LocCod[0] ;
                  A286LocNom = P01DN22_A286LocNom[0] ;
                  AV21SelectedText = A286LocNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(20);
            }
         }
      }
   }

   public void S191( )
   {
      /* 'LOADCOMBOITEMS_ACTCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(21, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A108ActDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN23 */
         pr_default.execute(21, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(21) != 101) )
         {
            A108ActDescrip = P01DN23_A108ActDescrip[0] ;
            A43ActCodigo = P01DN23_A43ActCodigo[0] ;
            n43ActCodigo = P01DN23_n43ActCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A43ActCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A108ActDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(21);
         }
         pr_default.close(21);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN24 */
               pr_default.execute(22, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(22) != 101) )
               {
                  A1EmpCod = P01DN24_A1EmpCod[0] ;
                  A3CliCod = P01DN24_A3CliCod[0] ;
                  A43ActCodigo = P01DN24_A43ActCodigo[0] ;
                  n43ActCodigo = P01DN24_n43ActCodigo[0] ;
                  A108ActDescrip = P01DN24_A108ActDescrip[0] ;
                  A108ActDescrip = P01DN24_A108ActDescrip[0] ;
                  AV20SelectedValue = A43ActCodigo ;
                  AV21SelectedText = A108ActDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(22);
            }
            else
            {
               AV29ActCodigo = AV12SearchTxt ;
               /* Using cursor P01DN25 */
               pr_default.execute(23, new Object[] {AV29ActCodigo});
               while ( (pr_default.getStatus(23) != 101) )
               {
                  A43ActCodigo = P01DN25_A43ActCodigo[0] ;
                  n43ActCodigo = P01DN25_n43ActCodigo[0] ;
                  A108ActDescrip = P01DN25_A108ActDescrip[0] ;
                  AV21SelectedText = A108ActDescrip ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(23);
            }
         }
      }
   }

   public void S201( )
   {
      /* 'LOADCOMBOITEMS_TIPEMPLECOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(24, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A339TipEmpleDescri } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN26 */
         pr_default.execute(24, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(24) != 101) )
         {
            A339TipEmpleDescri = P01DN26_A339TipEmpleDescri[0] ;
            A45TipEmpleCod = P01DN26_A45TipEmpleCod[0] ;
            n45TipEmpleCod = P01DN26_n45TipEmpleCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A45TipEmpleCod );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A339TipEmpleDescri );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(24);
         }
         pr_default.close(24);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN27 */
               pr_default.execute(25, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(25) != 101) )
               {
                  A1EmpCod = P01DN27_A1EmpCod[0] ;
                  A3CliCod = P01DN27_A3CliCod[0] ;
                  A45TipEmpleCod = P01DN27_A45TipEmpleCod[0] ;
                  n45TipEmpleCod = P01DN27_n45TipEmpleCod[0] ;
                  A339TipEmpleDescri = P01DN27_A339TipEmpleDescri[0] ;
                  A339TipEmpleDescri = P01DN27_A339TipEmpleDescri[0] ;
                  AV20SelectedValue = A45TipEmpleCod ;
                  AV21SelectedText = A339TipEmpleDescri ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(25);
            }
            else
            {
               AV30TipEmpleCod = AV12SearchTxt ;
               /* Using cursor P01DN28 */
               pr_default.execute(26, new Object[] {AV30TipEmpleCod});
               while ( (pr_default.getStatus(26) != 101) )
               {
                  A45TipEmpleCod = P01DN28_A45TipEmpleCod[0] ;
                  n45TipEmpleCod = P01DN28_n45TipEmpleCod[0] ;
                  A339TipEmpleDescri = P01DN28_A339TipEmpleDescri[0] ;
                  AV21SelectedText = A339TipEmpleDescri ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(26);
            }
         }
      }
   }

   public void S211( )
   {
      /* 'LOADCOMBOITEMS_EMPZONCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(27, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A342ZonDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN29 */
         pr_default.execute(27, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(27) != 101) )
         {
            A342ZonDescrip = P01DN29_A342ZonDescrip[0] ;
            A20ZonCod = P01DN29_A20ZonCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A20ZonCod );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A342ZonDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(27);
         }
         pr_default.close(27);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN30 */
               pr_default.execute(28, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(28) != 101) )
               {
                  A1EmpCod = P01DN30_A1EmpCod[0] ;
                  A3CliCod = P01DN30_A3CliCod[0] ;
                  A44EmpZonCod = P01DN30_A44EmpZonCod[0] ;
                  n44EmpZonCod = P01DN30_n44EmpZonCod[0] ;
                  AV20SelectedValue = A44EmpZonCod ;
                  AV31ZonCod = A44EmpZonCod ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(28);
            }
            else
            {
               AV31ZonCod = AV12SearchTxt ;
            }
            /* Using cursor P01DN31 */
            pr_default.execute(29, new Object[] {AV31ZonCod});
            while ( (pr_default.getStatus(29) != 101) )
            {
               A20ZonCod = P01DN31_A20ZonCod[0] ;
               A342ZonDescrip = P01DN31_A342ZonDescrip[0] ;
               AV21SelectedText = A342ZonDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(29);
         }
      }
   }

   public void S221( )
   {
      /* 'LOADCOMBOITEMS_EMPACTCOMERCIAL' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(30, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A904ActComDescripcion } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN32 */
         pr_default.execute(30, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(30) != 101) )
         {
            A904ActComDescripcion = P01DN32_A904ActComDescripcion[0] ;
            A903ActComCodigo = P01DN32_A903ActComCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A903ActComCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A904ActComDescripcion );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(30);
         }
         pr_default.close(30);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN33 */
               pr_default.execute(31, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(31) != 101) )
               {
                  A1EmpCod = P01DN33_A1EmpCod[0] ;
                  A3CliCod = P01DN33_A3CliCod[0] ;
                  A1533EmpActComercial = P01DN33_A1533EmpActComercial[0] ;
                  AV20SelectedValue = A1533EmpActComercial ;
                  AV32ActComCodigo = A1533EmpActComercial ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(31);
            }
            else
            {
               AV32ActComCodigo = AV12SearchTxt ;
            }
            /* Using cursor P01DN34 */
            pr_default.execute(32, new Object[] {AV32ActComCodigo});
            while ( (pr_default.getStatus(32) != 101) )
            {
               A903ActComCodigo = P01DN34_A903ActComCodigo[0] ;
               A904ActComDescripcion = P01DN34_A904ActComDescripcion[0] ;
               AV21SelectedText = A904ActComDescripcion ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(32);
         }
      }
   }

   public void S231( )
   {
      /* 'LOADCOMBOITEMS_ARTSEC' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(33, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1150ARTPaiNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01DN35 */
         pr_default.execute(33, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(33) != 101) )
         {
            A1149ARTPaiCod = P01DN35_A1149ARTPaiCod[0] ;
            A1150ARTPaiNom = P01DN35_A1150ARTPaiNom[0] ;
            A1151ARTSec = P01DN35_A1151ARTSec[0] ;
            A1150ARTPaiNom = P01DN35_A1150ARTPaiNom[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1151ARTSec, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1150ARTPaiNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(33);
         }
         pr_default.close(33);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01DN36 */
               pr_default.execute(34, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
               while ( (pr_default.getStatus(34) != 101) )
               {
                  A1149ARTPaiCod = P01DN36_A1149ARTPaiCod[0] ;
                  A1EmpCod = P01DN36_A1EmpCod[0] ;
                  A3CliCod = P01DN36_A3CliCod[0] ;
                  A1151ARTSec = P01DN36_A1151ARTSec[0] ;
                  A1150ARTPaiNom = P01DN36_A1150ARTPaiNom[0] ;
                  A1149ARTPaiCod = P01DN36_A1149ARTPaiCod[0] ;
                  A1150ARTPaiNom = P01DN36_A1150ARTPaiNom[0] ;
                  AV20SelectedValue = ((0==A1151ARTSec) ? "" : GXutil.trim( GXutil.str( A1151ARTSec, 4, 0))) ;
                  AV21SelectedText = A1150ARTPaiNom ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(34);
            }
            else
            {
               AV33ARTSec = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P01DN37 */
               pr_default.execute(35, new Object[] {Short.valueOf(AV33ARTSec)});
               while ( (pr_default.getStatus(35) != 101) )
               {
                  A1149ARTPaiCod = P01DN37_A1149ARTPaiCod[0] ;
                  A1151ARTSec = P01DN37_A1151ARTSec[0] ;
                  A1150ARTPaiNom = P01DN37_A1150ARTPaiNom[0] ;
                  A1150ARTPaiNom = P01DN37_A1150ARTPaiNom[0] ;
                  AV21SelectedText = A1150ARTPaiNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(35);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = empresa_abm_1loaddvcombo.this.AV20SelectedValue;
      this.aP9[0] = empresa_abm_1loaddvcombo.this.AV21SelectedText;
      this.aP10[0] = empresa_abm_1loaddvcombo.this.AV22Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(19);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV22Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      A370TipoConDescrip = "" ;
      AV35ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36ValueItem = "" ;
      AV45TipoConCod_Filter = "" ;
      scmdbuf = "" ;
      P01DN2_A37TipoConCod = new String[] {""} ;
      P01DN2_A370TipoConDescrip = new String[] {""} ;
      A37TipoConCod = "" ;
      lV12SearchTxt = "" ;
      P01DN3_A370TipoConDescrip = new String[] {""} ;
      P01DN3_A37TipoConCod = new String[] {""} ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1283ReligNombre = "" ;
      AV43ReligId_Filter = "" ;
      P01DN4_A1229ReligId = new String[] {""} ;
      P01DN4_A1283ReligNombre = new String[] {""} ;
      A1229ReligId = "" ;
      P01DN5_A1283ReligNombre = new String[] {""} ;
      P01DN5_A1229ReligId = new String[] {""} ;
      A1284OrigNombre = "" ;
      AV37OrigId_Filter = "" ;
      P01DN6_A1231OrigId = new String[] {""} ;
      P01DN6_A1284OrigNombre = new String[] {""} ;
      A1231OrigId = "" ;
      P01DN7_A1284OrigNombre = new String[] {""} ;
      P01DN7_A1231OrigId = new String[] {""} ;
      A1293TipoTraNom = "" ;
      AV38TipoTraId_Filter = "" ;
      P01DN8_A1292TipoTraId = new String[] {""} ;
      P01DN8_A1293TipoTraNom = new String[] {""} ;
      A1292TipoTraId = "" ;
      P01DN9_A1293TipoTraNom = new String[] {""} ;
      P01DN9_A1292TipoTraId = new String[] {""} ;
      P01DN10_A1292TipoTraId = new String[] {""} ;
      P01DN10_A1293TipoTraNom = new String[] {""} ;
      P01DN11_A1293TipoTraNom = new String[] {""} ;
      P01DN11_A1292TipoTraId = new String[] {""} ;
      A312PaiNom = "" ;
      P01DN12_A312PaiNom = new String[] {""} ;
      P01DN12_A46PaiCod = new short[1] ;
      P01DN12_n46PaiCod = new boolean[] {false} ;
      P01DN13_A1EmpCod = new short[1] ;
      P01DN13_A3CliCod = new int[1] ;
      P01DN13_A46PaiCod = new short[1] ;
      P01DN13_n46PaiCod = new boolean[] {false} ;
      P01DN13_A312PaiNom = new String[] {""} ;
      P01DN14_A46PaiCod = new short[1] ;
      P01DN14_n46PaiCod = new boolean[] {false} ;
      P01DN14_A312PaiNom = new String[] {""} ;
      A322ProvNom = "" ;
      P01DN15_A46PaiCod = new short[1] ;
      P01DN15_n46PaiCod = new boolean[] {false} ;
      P01DN15_A322ProvNom = new String[] {""} ;
      P01DN15_A47ProvCod = new short[1] ;
      P01DN15_n47ProvCod = new boolean[] {false} ;
      P01DN16_A46PaiCod = new short[1] ;
      P01DN16_n46PaiCod = new boolean[] {false} ;
      P01DN16_A4CliPaiCod = new short[1] ;
      P01DN16_n4CliPaiCod = new boolean[] {false} ;
      P01DN16_A1EmpCod = new short[1] ;
      P01DN16_A3CliCod = new int[1] ;
      P01DN16_A47ProvCod = new short[1] ;
      P01DN16_n47ProvCod = new boolean[] {false} ;
      P01DN16_A322ProvNom = new String[] {""} ;
      P01DN17_A322ProvNom = new String[] {""} ;
      P01DN18_A46PaiCod = new short[1] ;
      P01DN18_n46PaiCod = new boolean[] {false} ;
      P01DN18_A47ProvCod = new short[1] ;
      P01DN18_n47ProvCod = new boolean[] {false} ;
      P01DN18_A322ProvNom = new String[] {""} ;
      A286LocNom = "" ;
      P01DN19_A286LocNom = new String[] {""} ;
      P01DN19_A47ProvCod = new short[1] ;
      P01DN19_n47ProvCod = new boolean[] {false} ;
      P01DN19_A46PaiCod = new short[1] ;
      P01DN19_n46PaiCod = new boolean[] {false} ;
      P01DN19_A48LocCod = new short[1] ;
      P01DN19_n48LocCod = new boolean[] {false} ;
      P01DN20_A46PaiCod = new short[1] ;
      P01DN20_n46PaiCod = new boolean[] {false} ;
      P01DN20_A47ProvCod = new short[1] ;
      P01DN20_n47ProvCod = new boolean[] {false} ;
      P01DN20_A4CliPaiCod = new short[1] ;
      P01DN20_n4CliPaiCod = new boolean[] {false} ;
      P01DN20_A1EmpCod = new short[1] ;
      P01DN20_A3CliCod = new int[1] ;
      P01DN20_A48LocCod = new short[1] ;
      P01DN20_n48LocCod = new boolean[] {false} ;
      P01DN20_A286LocNom = new String[] {""} ;
      P01DN21_A286LocNom = new String[] {""} ;
      P01DN22_A47ProvCod = new short[1] ;
      P01DN22_n47ProvCod = new boolean[] {false} ;
      P01DN22_A46PaiCod = new short[1] ;
      P01DN22_n46PaiCod = new boolean[] {false} ;
      P01DN22_A48LocCod = new short[1] ;
      P01DN22_n48LocCod = new boolean[] {false} ;
      P01DN22_A286LocNom = new String[] {""} ;
      A108ActDescrip = "" ;
      P01DN23_A108ActDescrip = new String[] {""} ;
      P01DN23_A43ActCodigo = new String[] {""} ;
      P01DN23_n43ActCodigo = new boolean[] {false} ;
      A43ActCodigo = "" ;
      P01DN24_A1EmpCod = new short[1] ;
      P01DN24_A3CliCod = new int[1] ;
      P01DN24_A43ActCodigo = new String[] {""} ;
      P01DN24_n43ActCodigo = new boolean[] {false} ;
      P01DN24_A108ActDescrip = new String[] {""} ;
      AV29ActCodigo = "" ;
      P01DN25_A43ActCodigo = new String[] {""} ;
      P01DN25_n43ActCodigo = new boolean[] {false} ;
      P01DN25_A108ActDescrip = new String[] {""} ;
      A339TipEmpleDescri = "" ;
      P01DN26_A339TipEmpleDescri = new String[] {""} ;
      P01DN26_A45TipEmpleCod = new String[] {""} ;
      P01DN26_n45TipEmpleCod = new boolean[] {false} ;
      A45TipEmpleCod = "" ;
      P01DN27_A1EmpCod = new short[1] ;
      P01DN27_A3CliCod = new int[1] ;
      P01DN27_A45TipEmpleCod = new String[] {""} ;
      P01DN27_n45TipEmpleCod = new boolean[] {false} ;
      P01DN27_A339TipEmpleDescri = new String[] {""} ;
      AV30TipEmpleCod = "" ;
      P01DN28_A45TipEmpleCod = new String[] {""} ;
      P01DN28_n45TipEmpleCod = new boolean[] {false} ;
      P01DN28_A339TipEmpleDescri = new String[] {""} ;
      A342ZonDescrip = "" ;
      P01DN29_A342ZonDescrip = new String[] {""} ;
      P01DN29_A20ZonCod = new String[] {""} ;
      A20ZonCod = "" ;
      P01DN30_A1EmpCod = new short[1] ;
      P01DN30_A3CliCod = new int[1] ;
      P01DN30_A44EmpZonCod = new String[] {""} ;
      P01DN30_n44EmpZonCod = new boolean[] {false} ;
      A44EmpZonCod = "" ;
      AV31ZonCod = "" ;
      P01DN31_A20ZonCod = new String[] {""} ;
      P01DN31_A342ZonDescrip = new String[] {""} ;
      A904ActComDescripcion = "" ;
      P01DN32_A904ActComDescripcion = new String[] {""} ;
      P01DN32_A903ActComCodigo = new String[] {""} ;
      A903ActComCodigo = "" ;
      P01DN33_A1EmpCod = new short[1] ;
      P01DN33_A3CliCod = new int[1] ;
      P01DN33_A1533EmpActComercial = new String[] {""} ;
      A1533EmpActComercial = "" ;
      AV32ActComCodigo = "" ;
      P01DN34_A903ActComCodigo = new String[] {""} ;
      P01DN34_A904ActComDescripcion = new String[] {""} ;
      A1150ARTPaiNom = "" ;
      P01DN35_A1149ARTPaiCod = new short[1] ;
      P01DN35_A1150ARTPaiNom = new String[] {""} ;
      P01DN35_A1151ARTSec = new short[1] ;
      P01DN36_A1149ARTPaiCod = new short[1] ;
      P01DN36_A1EmpCod = new short[1] ;
      P01DN36_A3CliCod = new int[1] ;
      P01DN36_A1151ARTSec = new short[1] ;
      P01DN36_A1150ARTPaiNom = new String[] {""} ;
      P01DN37_A1149ARTPaiCod = new short[1] ;
      P01DN37_A1151ARTSec = new short[1] ;
      P01DN37_A1150ARTPaiNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_abm_1loaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01DN2_A37TipoConCod, P01DN2_A370TipoConDescrip
            }
            , new Object[] {
            P01DN3_A370TipoConDescrip, P01DN3_A37TipoConCod
            }
            , new Object[] {
            P01DN4_A1229ReligId, P01DN4_A1283ReligNombre
            }
            , new Object[] {
            P01DN5_A1283ReligNombre, P01DN5_A1229ReligId
            }
            , new Object[] {
            P01DN6_A1231OrigId, P01DN6_A1284OrigNombre
            }
            , new Object[] {
            P01DN7_A1284OrigNombre, P01DN7_A1231OrigId
            }
            , new Object[] {
            P01DN8_A1292TipoTraId, P01DN8_A1293TipoTraNom
            }
            , new Object[] {
            P01DN9_A1293TipoTraNom, P01DN9_A1292TipoTraId
            }
            , new Object[] {
            P01DN10_A1292TipoTraId, P01DN10_A1293TipoTraNom
            }
            , new Object[] {
            P01DN11_A1293TipoTraNom, P01DN11_A1292TipoTraId
            }
            , new Object[] {
            P01DN12_A312PaiNom, P01DN12_A46PaiCod
            }
            , new Object[] {
            P01DN13_A1EmpCod, P01DN13_A3CliCod, P01DN13_A46PaiCod, P01DN13_n46PaiCod, P01DN13_A312PaiNom
            }
            , new Object[] {
            P01DN14_A46PaiCod, P01DN14_A312PaiNom
            }
            , new Object[] {
            P01DN15_A46PaiCod, P01DN15_A322ProvNom, P01DN15_A47ProvCod
            }
            , new Object[] {
            P01DN16_A46PaiCod, P01DN16_n46PaiCod, P01DN16_A4CliPaiCod, P01DN16_n4CliPaiCod, P01DN16_A1EmpCod, P01DN16_A3CliCod, P01DN16_A47ProvCod, P01DN16_n47ProvCod, P01DN16_A322ProvNom
            }
            , new Object[] {
            P01DN17_A322ProvNom
            }
            , new Object[] {
            P01DN18_A46PaiCod, P01DN18_A47ProvCod, P01DN18_A322ProvNom
            }
            , new Object[] {
            P01DN19_A286LocNom, P01DN19_A47ProvCod, P01DN19_A46PaiCod, P01DN19_A48LocCod
            }
            , new Object[] {
            P01DN20_A46PaiCod, P01DN20_n46PaiCod, P01DN20_A47ProvCod, P01DN20_n47ProvCod, P01DN20_A4CliPaiCod, P01DN20_n4CliPaiCod, P01DN20_A1EmpCod, P01DN20_A3CliCod, P01DN20_A48LocCod, P01DN20_n48LocCod,
            P01DN20_A286LocNom
            }
            , new Object[] {
            P01DN21_A286LocNom
            }
            , new Object[] {
            P01DN22_A47ProvCod, P01DN22_A46PaiCod, P01DN22_A48LocCod, P01DN22_A286LocNom
            }
            , new Object[] {
            P01DN23_A108ActDescrip, P01DN23_A43ActCodigo
            }
            , new Object[] {
            P01DN24_A1EmpCod, P01DN24_A3CliCod, P01DN24_A43ActCodigo, P01DN24_n43ActCodigo, P01DN24_A108ActDescrip
            }
            , new Object[] {
            P01DN25_A43ActCodigo, P01DN25_A108ActDescrip
            }
            , new Object[] {
            P01DN26_A339TipEmpleDescri, P01DN26_A45TipEmpleCod
            }
            , new Object[] {
            P01DN27_A1EmpCod, P01DN27_A3CliCod, P01DN27_A45TipEmpleCod, P01DN27_n45TipEmpleCod, P01DN27_A339TipEmpleDescri
            }
            , new Object[] {
            P01DN28_A45TipEmpleCod, P01DN28_A339TipEmpleDescri
            }
            , new Object[] {
            P01DN29_A342ZonDescrip, P01DN29_A20ZonCod
            }
            , new Object[] {
            P01DN30_A1EmpCod, P01DN30_A3CliCod, P01DN30_A44EmpZonCod, P01DN30_n44EmpZonCod
            }
            , new Object[] {
            P01DN31_A20ZonCod, P01DN31_A342ZonDescrip
            }
            , new Object[] {
            P01DN32_A904ActComDescripcion, P01DN32_A903ActComCodigo
            }
            , new Object[] {
            P01DN33_A1EmpCod, P01DN33_A3CliCod, P01DN33_A1533EmpActComercial
            }
            , new Object[] {
            P01DN34_A903ActComCodigo, P01DN34_A904ActComDescripcion
            }
            , new Object[] {
            P01DN35_A1149ARTPaiCod, P01DN35_A1150ARTPaiNom, P01DN35_A1151ARTSec
            }
            , new Object[] {
            P01DN36_A1149ARTPaiCod, P01DN36_A1EmpCod, P01DN36_A3CliCod, P01DN36_A1151ARTSec, P01DN36_A1150ARTPaiNom
            }
            , new Object[] {
            P01DN37_A1149ARTPaiCod, P01DN37_A1151ARTSec, P01DN37_A1150ARTPaiNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV49GXLvl56 ;
   private byte AV52GXLvl95 ;
   private byte AV55GXLvl134 ;
   private byte AV58GXLvl173 ;
   private byte AV61GXLvl212 ;
   private short AV19EmpCod ;
   private short AV41Cond_PaiCod ;
   private short AV42Cond_ProvCod ;
   private short A46PaiCod ;
   private short A1EmpCod ;
   private short AV26PaiCod ;
   private short A47ProvCod ;
   private short A4CliPaiCod ;
   private short AV27ProvCod ;
   private short A48LocCod ;
   private short AV28LocCod ;
   private short A1149ARTPaiCod ;
   private short A1151ARTSec ;
   private short AV33ARTSec ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int AV48GXV1 ;
   private int AV51GXV2 ;
   private int AV54GXV3 ;
   private int AV57GXV4 ;
   private int AV60GXV5 ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV45TipoConCod_Filter ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String AV43ReligId_Filter ;
   private String A1229ReligId ;
   private String AV37OrigId_Filter ;
   private String A1231OrigId ;
   private String AV38TipoTraId_Filter ;
   private String A1292TipoTraId ;
   private String A43ActCodigo ;
   private String AV29ActCodigo ;
   private String A45TipEmpleCod ;
   private String AV30TipEmpleCod ;
   private String A20ZonCod ;
   private String A44EmpZonCod ;
   private String AV31ZonCod ;
   private String A903ActComCodigo ;
   private String A1533EmpActComercial ;
   private String AV32ActComCodigo ;
   private boolean AV17IsDynamicCall ;
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
   private String AV22Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV20SelectedValue ;
   private String AV21SelectedText ;
   private String A370TipoConDescrip ;
   private String AV36ValueItem ;
   private String lV12SearchTxt ;
   private String A1283ReligNombre ;
   private String A1284OrigNombre ;
   private String A1293TipoTraNom ;
   private String A312PaiNom ;
   private String A322ProvNom ;
   private String A286LocNom ;
   private String A108ActDescrip ;
   private String A339TipEmpleDescri ;
   private String A342ZonDescrip ;
   private String A904ActComDescripcion ;
   private String A1150ARTPaiNom ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01DN2_A37TipoConCod ;
   private String[] P01DN2_A370TipoConDescrip ;
   private String[] P01DN3_A370TipoConDescrip ;
   private String[] P01DN3_A37TipoConCod ;
   private String[] P01DN4_A1229ReligId ;
   private String[] P01DN4_A1283ReligNombre ;
   private String[] P01DN5_A1283ReligNombre ;
   private String[] P01DN5_A1229ReligId ;
   private String[] P01DN6_A1231OrigId ;
   private String[] P01DN6_A1284OrigNombre ;
   private String[] P01DN7_A1284OrigNombre ;
   private String[] P01DN7_A1231OrigId ;
   private String[] P01DN8_A1292TipoTraId ;
   private String[] P01DN8_A1293TipoTraNom ;
   private String[] P01DN9_A1293TipoTraNom ;
   private String[] P01DN9_A1292TipoTraId ;
   private String[] P01DN10_A1292TipoTraId ;
   private String[] P01DN10_A1293TipoTraNom ;
   private String[] P01DN11_A1293TipoTraNom ;
   private String[] P01DN11_A1292TipoTraId ;
   private String[] P01DN12_A312PaiNom ;
   private short[] P01DN12_A46PaiCod ;
   private boolean[] P01DN12_n46PaiCod ;
   private short[] P01DN13_A1EmpCod ;
   private int[] P01DN13_A3CliCod ;
   private short[] P01DN13_A46PaiCod ;
   private boolean[] P01DN13_n46PaiCod ;
   private String[] P01DN13_A312PaiNom ;
   private short[] P01DN14_A46PaiCod ;
   private boolean[] P01DN14_n46PaiCod ;
   private String[] P01DN14_A312PaiNom ;
   private short[] P01DN15_A46PaiCod ;
   private boolean[] P01DN15_n46PaiCod ;
   private String[] P01DN15_A322ProvNom ;
   private short[] P01DN15_A47ProvCod ;
   private boolean[] P01DN15_n47ProvCod ;
   private short[] P01DN16_A46PaiCod ;
   private boolean[] P01DN16_n46PaiCod ;
   private short[] P01DN16_A4CliPaiCod ;
   private boolean[] P01DN16_n4CliPaiCod ;
   private short[] P01DN16_A1EmpCod ;
   private int[] P01DN16_A3CliCod ;
   private short[] P01DN16_A47ProvCod ;
   private boolean[] P01DN16_n47ProvCod ;
   private String[] P01DN16_A322ProvNom ;
   private String[] P01DN17_A322ProvNom ;
   private short[] P01DN18_A46PaiCod ;
   private boolean[] P01DN18_n46PaiCod ;
   private short[] P01DN18_A47ProvCod ;
   private boolean[] P01DN18_n47ProvCod ;
   private String[] P01DN18_A322ProvNom ;
   private String[] P01DN19_A286LocNom ;
   private short[] P01DN19_A47ProvCod ;
   private boolean[] P01DN19_n47ProvCod ;
   private short[] P01DN19_A46PaiCod ;
   private boolean[] P01DN19_n46PaiCod ;
   private short[] P01DN19_A48LocCod ;
   private boolean[] P01DN19_n48LocCod ;
   private short[] P01DN20_A46PaiCod ;
   private boolean[] P01DN20_n46PaiCod ;
   private short[] P01DN20_A47ProvCod ;
   private boolean[] P01DN20_n47ProvCod ;
   private short[] P01DN20_A4CliPaiCod ;
   private boolean[] P01DN20_n4CliPaiCod ;
   private short[] P01DN20_A1EmpCod ;
   private int[] P01DN20_A3CliCod ;
   private short[] P01DN20_A48LocCod ;
   private boolean[] P01DN20_n48LocCod ;
   private String[] P01DN20_A286LocNom ;
   private String[] P01DN21_A286LocNom ;
   private short[] P01DN22_A47ProvCod ;
   private boolean[] P01DN22_n47ProvCod ;
   private short[] P01DN22_A46PaiCod ;
   private boolean[] P01DN22_n46PaiCod ;
   private short[] P01DN22_A48LocCod ;
   private boolean[] P01DN22_n48LocCod ;
   private String[] P01DN22_A286LocNom ;
   private String[] P01DN23_A108ActDescrip ;
   private String[] P01DN23_A43ActCodigo ;
   private boolean[] P01DN23_n43ActCodigo ;
   private short[] P01DN24_A1EmpCod ;
   private int[] P01DN24_A3CliCod ;
   private String[] P01DN24_A43ActCodigo ;
   private boolean[] P01DN24_n43ActCodigo ;
   private String[] P01DN24_A108ActDescrip ;
   private String[] P01DN25_A43ActCodigo ;
   private boolean[] P01DN25_n43ActCodigo ;
   private String[] P01DN25_A108ActDescrip ;
   private String[] P01DN26_A339TipEmpleDescri ;
   private String[] P01DN26_A45TipEmpleCod ;
   private boolean[] P01DN26_n45TipEmpleCod ;
   private short[] P01DN27_A1EmpCod ;
   private int[] P01DN27_A3CliCod ;
   private String[] P01DN27_A45TipEmpleCod ;
   private boolean[] P01DN27_n45TipEmpleCod ;
   private String[] P01DN27_A339TipEmpleDescri ;
   private String[] P01DN28_A45TipEmpleCod ;
   private boolean[] P01DN28_n45TipEmpleCod ;
   private String[] P01DN28_A339TipEmpleDescri ;
   private String[] P01DN29_A342ZonDescrip ;
   private String[] P01DN29_A20ZonCod ;
   private short[] P01DN30_A1EmpCod ;
   private int[] P01DN30_A3CliCod ;
   private String[] P01DN30_A44EmpZonCod ;
   private boolean[] P01DN30_n44EmpZonCod ;
   private String[] P01DN31_A20ZonCod ;
   private String[] P01DN31_A342ZonDescrip ;
   private String[] P01DN32_A904ActComDescripcion ;
   private String[] P01DN32_A903ActComCodigo ;
   private short[] P01DN33_A1EmpCod ;
   private int[] P01DN33_A3CliCod ;
   private String[] P01DN33_A1533EmpActComercial ;
   private String[] P01DN34_A903ActComCodigo ;
   private String[] P01DN34_A904ActComDescripcion ;
   private short[] P01DN35_A1149ARTPaiCod ;
   private String[] P01DN35_A1150ARTPaiNom ;
   private short[] P01DN35_A1151ARTSec ;
   private short[] P01DN36_A1149ARTPaiCod ;
   private short[] P01DN36_A1EmpCod ;
   private int[] P01DN36_A3CliCod ;
   private short[] P01DN36_A1151ARTSec ;
   private String[] P01DN36_A1150ARTPaiNom ;
   private short[] P01DN37_A1149ARTPaiCod ;
   private short[] P01DN37_A1151ARTSec ;
   private String[] P01DN37_A1150ARTPaiNom ;
   private GXSimpleCollection<String> AV35ValuesCollection ;
   private GXSimpleCollection<String> AV34DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class empresa_abm_1loaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01DN3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A370TipoConDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT TipoConDescrip, TipoConCod FROM TipoDeConcepto" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipoConDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoConDescrip" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01DN5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1283ReligNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT ReligNombre, ReligId FROM Religion" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ReligNombre) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ReligNombre" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01DN7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1284OrigNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT OrigNombre, OrigId FROM Origen" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(OrigNombre) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OrigNombre" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01DN9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1293TipoTraNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[1];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoTraNom" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P01DN11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A1293TipoTraNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[1];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoTraNom" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P01DN12( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A312PaiNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[1];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT PaiNom, PaiCod FROM Pais" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiNom" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P01DN15( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A322ProvNom ,
                                           short A46PaiCod ,
                                           short AV41Cond_PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[2];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT PaiCod, ProvNom, ProvCod FROM Provincia" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ProvNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int16[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ProvNom" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P01DN19( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A286LocNom ,
                                           short AV41Cond_PaiCod ,
                                           short AV42Cond_ProvCod ,
                                           short A46PaiCod ,
                                           short A47ProvCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[3];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT LocNom, ProvCod, PaiCod, LocCod FROM Localidad" ;
      addWhere(sWhereString, "(PaiCod = ? and ProvCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(LocNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int18[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, ProvCod, LocNom" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   protected Object[] conditional_P01DN23( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A108ActDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[1];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT ActDescrip, ActCodigo FROM Actividad" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ActDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int20[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActDescrip" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   protected Object[] conditional_P01DN26( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A339TipEmpleDescri )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[1];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT TipEmpleDescri, TipEmpleCod FROM TipoEmpleador" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleDescri) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipEmpleDescri" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P01DN29( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A342ZonDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[1];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT ZonDescrip, ZonCod FROM Zona" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ZonDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int24[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ZonDescrip" ;
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
   }

   protected Object[] conditional_P01DN32( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A904ActComDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[1];
      Object[] GXv_Object27 = new Object[2];
      scmdbuf = "SELECT ActComDescripcion, ActComCodigo FROM actividadcomercial" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ActComDescripcion) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int26[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActComDescripcion" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
   }

   protected Object[] conditional_P01DN35( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A1150ARTPaiNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int28 = new byte[1];
      Object[] GXv_Object29 = new Object[2];
      scmdbuf = "SELECT T1.ARTPaiCod AS ARTPaiCod, T2.PaiNom AS ARTPaiNom, T1.ARTSec FROM (ART T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.ARTPaiCod)" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int28[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.PaiNom" ;
      GXv_Object29[0] = scmdbuf ;
      GXv_Object29[1] = GXv_int28 ;
      return GXv_Object29 ;
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
                  return conditional_P01DN3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01DN5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 5 :
                  return conditional_P01DN7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 7 :
                  return conditional_P01DN9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 9 :
                  return conditional_P01DN11(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 10 :
                  return conditional_P01DN12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 13 :
                  return conditional_P01DN15(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
            case 17 :
                  return conditional_P01DN19(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
            case 21 :
                  return conditional_P01DN23(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 24 :
                  return conditional_P01DN26(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 27 :
                  return conditional_P01DN29(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 30 :
                  return conditional_P01DN32(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 33 :
                  return conditional_P01DN35(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01DN2", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto WHERE TipoConCod = ( ?) ORDER BY TipoConCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN4", "SELECT ReligId, ReligNombre FROM Religion WHERE ReligId = ( ?) ORDER BY ReligId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN6", "SELECT OrigId, OrigNombre FROM Origen WHERE OrigId = ( ?) ORDER BY OrigId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN8", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN10", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN13", "SELECT T1.EmpCod, T1.CliCod, T1.PaiCod, T2.PaiNom FROM (Empresa T1 LEFT JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN14", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN15", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN16", "SELECT T1.PaiCod, T2.CliPaiCod, T1.EmpCod, T1.CliCod, T1.ProvCod, T3.ProvNom FROM ((Empresa T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) LEFT JOIN Provincia T3 ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN17", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN18", "SELECT PaiCod, ProvCod, ProvNom FROM Provincia WHERE PaiCod = ? and ProvCod = ? ORDER BY PaiCod, ProvCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN19", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN20", "SELECT T1.PaiCod, T1.ProvCod, T2.CliPaiCod, T1.EmpCod, T1.CliCod, T1.LocCod, T3.LocNom FROM ((Empresa T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) LEFT JOIN Localidad T3 ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod AND T3.LocCod = T1.LocCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN21", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN22", "SELECT ProvCod, PaiCod, LocCod, LocNom FROM Localidad WHERE PaiCod = ? and ProvCod = ? and LocCod = ? ORDER BY PaiCod, ProvCod, LocCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN23", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN24", "SELECT T1.EmpCod, T1.CliCod, T1.ActCodigo, T2.ActDescrip FROM (Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN25", "SELECT ActCodigo, ActDescrip FROM Actividad WHERE ActCodigo = ( ?) ORDER BY ActCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN26", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN27", "SELECT T1.EmpCod, T1.CliCod, T1.TipEmpleCod, T2.TipEmpleDescri FROM (Empresa T1 LEFT JOIN TipoEmpleador T2 ON T2.TipEmpleCod = T1.TipEmpleCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN28", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador WHERE TipEmpleCod = ( ?) ORDER BY TipEmpleCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN29", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN30", "SELECT EmpCod, CliCod, EmpZonCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN31", "SELECT ZonCod, ZonDescrip FROM Zona WHERE ZonCod = ( ?) ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN33", "SELECT EmpCod, CliCod, EmpActComercial FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN34", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial WHERE ActComCodigo = ( ?) ORDER BY ActComCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN35", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01DN36", "SELECT T2.ARTPaiCod AS ARTPaiCod, T1.EmpCod, T1.CliCod, T1.ARTSec, T3.PaiNom AS ARTPaiNom FROM ((Empresa T1 INNER JOIN ART T2 ON T2.ARTSec = T1.ARTSec) INNER JOIN Pais T3 ON T3.PaiCod = T2.ARTPaiCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01DN37", "SELECT T1.ARTPaiCod AS ARTPaiCod, T1.ARTSec, T2.PaiNom AS ARTPaiNom FROM (ART T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.ARTPaiCod) WHERE T1.ARTSec = ? ORDER BY T1.ARTSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 14 :
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
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 18 :
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
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 8);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 31 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 34 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 35 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 9 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 10 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
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
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
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
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 17 :
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
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
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
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 21 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 23 :
               stmt.setString(1, (String)parms[0], 8);
               return;
            case 24 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 26 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 27 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 29 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 30 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 33 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 35 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

