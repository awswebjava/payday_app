package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajoloaddvcombo extends GXProcedure
{
   public legajoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajoloaddvcombo.class ), "" );
   }

   public legajoloaddvcombo( int remoteHandle ,
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
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      legajoloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        int aP5 ,
                        int aP6 ,
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
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      legajoloaddvcombo.this.AV13ComboName = aP0;
      legajoloaddvcombo.this.AV15TrnMode = aP1;
      legajoloaddvcombo.this.AV24IsDynamicCall = aP2;
      legajoloaddvcombo.this.AV17CliCod = aP3;
      legajoloaddvcombo.this.AV18EmpCod = aP4;
      legajoloaddvcombo.this.AV19LegNumero = aP5;
      legajoloaddvcombo.this.AV45Cond_CliCod = aP6;
      legajoloaddvcombo.this.AV21SearchTxt = aP7;
      legajoloaddvcombo.this.aP8 = aP8;
      legajoloaddvcombo.this.aP9 = aP9;
      legajoloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV13ComboName, "CatCodigo") == 0 )
      {
         new web.msgdebug(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "dinamic ", "")+GXutil.trim( GXutil.booltostr( AV24IsDynamicCall))+httpContext.getMessage( " mode ", "")+AV15TrnMode+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV17CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV18EmpCod, 4, 0))+httpContext.getMessage( " legnro ", "")+GXutil.trim( GXutil.str( AV19LegNumero, 8, 0))) ;
      }
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo", GXv_boolean2) ;
      legajoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV20MaxItems = 100 ;
         if ( GXutil.strcmp(AV13ComboName, "MprCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MPRCOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV13ComboName, "ZonCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ZONCOD' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV13ComboName, "LegPropCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGPROPCOD' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV13ComboName, "LegSuelConcepto") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGSUELCONCEPTO' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV13ComboName, "LegTipoTra") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGTIPOTRA' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV13ComboName, "LegSexo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGSEXO' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV13ComboName, "LegEstadoCivil") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGESTADOCIVIL' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( GXutil.strcmp(AV15TrnMode, "INS") == 0 )
      {
         GXv_char4[0] = AV12SelectedValue ;
         GXv_char5[0] = AV23SelectedText ;
         new web.dvcombodefaults(remoteHandle, context).execute( AV13ComboName, GXv_char4, GXv_char5) ;
         legajoloaddvcombo.this.AV12SelectedValue = GXv_char4[0] ;
         legajoloaddvcombo.this.AV23SelectedText = GXv_char5[0] ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_MPRCOD' Routine */
      returnInSub = false ;
      if ( AV24IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV21SearchTxt ,
                                              A303MprDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV21SearchTxt = GXutil.concat( GXutil.rtrim( AV21SearchTxt), "%", "") ;
         /* Using cursor P001F2 */
         pr_default.execute(0, new Object[] {lV21SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A303MprDescrip = P001F2_A303MprDescrip[0] ;
            A18MprCod = P001F2_A18MprCod[0] ;
            n18MprCod = P001F2_n18MprCod[0] ;
            AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A18MprCod );
            AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A303MprDescrip );
            AV10Combo_Data.add(AV11Combo_DataItem, 0);
            if ( AV10Combo_Data.size() > AV20MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV15TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV15TrnMode, "GET") != 0 )
            {
               /* Using cursor P001F3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV19LegNumero)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A6LegNumero = P001F3_A6LegNumero[0] ;
                  A1EmpCod = P001F3_A1EmpCod[0] ;
                  A3CliCod = P001F3_A3CliCod[0] ;
                  A18MprCod = P001F3_A18MprCod[0] ;
                  n18MprCod = P001F3_n18MprCod[0] ;
                  A303MprDescrip = P001F3_A303MprDescrip[0] ;
                  A303MprDescrip = P001F3_A303MprDescrip[0] ;
                  AV12SelectedValue = A18MprCod ;
                  AV23SelectedText = A303MprDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV39MprCod = AV21SearchTxt ;
               /* Using cursor P001F4 */
               pr_default.execute(2, new Object[] {AV39MprCod});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A18MprCod = P001F4_A18MprCod[0] ;
                  n18MprCod = P001F4_n18MprCod[0] ;
                  A303MprDescrip = P001F4_A303MprDescrip[0] ;
                  AV23SelectedText = A303MprDescrip ;
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
      /* 'LOADCOMBOITEMS_ZONCOD' Routine */
      returnInSub = false ;
      /* Using cursor P001F5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         A20ZonCod = P001F5_A20ZonCod[0] ;
         n20ZonCod = P001F5_n20ZonCod[0] ;
         A342ZonDescrip = P001F5_A342ZonDescrip[0] ;
         AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A20ZonCod );
         AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A342ZonDescrip );
         AV10Combo_Data.add(AV11Combo_DataItem, 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
      AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
      if ( GXutil.strcmp(AV15TrnMode, "INS") != 0 )
      {
         /* Using cursor P001F6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV19LegNumero)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A6LegNumero = P001F6_A6LegNumero[0] ;
            A1EmpCod = P001F6_A1EmpCod[0] ;
            A3CliCod = P001F6_A3CliCod[0] ;
            A20ZonCod = P001F6_A20ZonCod[0] ;
            n20ZonCod = P001F6_n20ZonCod[0] ;
            AV12SelectedValue = A20ZonCod ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_LEGPROPCOD' Routine */
      returnInSub = false ;
      if ( AV24IsDynamicCall )
      {
         if ( GXutil.strcmp(AV15TrnMode, "GET_DSC") == 0 )
         {
            AV52ValuesCollection.fromJSonString(AV21SearchTxt, null);
            AV51DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV67GXV1 = 1 ;
            while ( AV67GXV1 <= AV52ValuesCollection.size() )
            {
               AV53ValueItem = (String)AV52ValuesCollection.elementAt(-1+AV67GXV1) ;
               AV57propCod_Filter = AV53ValueItem ;
               AV68GXLvl122 = (byte)(0) ;
               /* Using cursor P001F7 */
               pr_default.execute(5, new Object[] {AV57propCod_Filter});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A2227propCod = P001F7_A2227propCod[0] ;
                  A2228propDesc = P001F7_A2228propDesc[0] ;
                  AV68GXLvl122 = (byte)(1) ;
                  AV51DscsCollection.add(A2228propDesc, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(5);
               if ( AV68GXLvl122 == 0 )
               {
                  AV51DscsCollection.add("", 0);
               }
               AV67GXV1 = (int)(AV67GXV1+1) ;
            }
            AV22Combo_DataJson = AV51DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(6, new Object[]{ new Object[]{
                                                 AV21SearchTxt ,
                                                 A2228propDesc } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV21SearchTxt = GXutil.concat( GXutil.rtrim( AV21SearchTxt), "%", "") ;
            /* Using cursor P001F8 */
            pr_default.execute(6, new Object[] {lV21SearchTxt});
            while ( (pr_default.getStatus(6) != 101) )
            {
               A2228propDesc = P001F8_A2228propDesc[0] ;
               A2227propCod = P001F8_A2227propCod[0] ;
               AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A2227propCod );
               AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A2228propDesc );
               AV10Combo_Data.add(AV11Combo_DataItem, 0);
               if ( AV10Combo_Data.size() > AV20MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(6);
            }
            pr_default.close(6);
            AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S141( )
   {
      /* 'LOADCOMBOITEMS_LEGSUELCONCEPTO' Routine */
      returnInSub = false ;
      if ( AV24IsDynamicCall )
      {
         if ( GXutil.strcmp(AV15TrnMode, "GET_DSC") == 0 )
         {
            AV52ValuesCollection.fromJSonString(AV21SearchTxt, null);
            AV51DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV70GXV2 = 1 ;
            while ( AV70GXV2 <= AV52ValuesCollection.size() )
            {
               AV53ValueItem = (String)AV52ValuesCollection.elementAt(-1+AV70GXV2) ;
               AV58ConCodigo_Filter = AV53ValueItem ;
               AV71GXLvl161 = (byte)(0) ;
               /* Using cursor P001F9 */
               pr_default.execute(7, new Object[] {Integer.valueOf(AV45Cond_CliCod), AV58ConCodigo_Filter});
               while ( (pr_default.getStatus(7) != 101) )
               {
                  A3CliCod = P001F9_A3CliCod[0] ;
                  A26ConCodigo = P001F9_A26ConCodigo[0] ;
                  A42ConCodYDesc = P001F9_A42ConCodYDesc[0] ;
                  n42ConCodYDesc = P001F9_n42ConCodYDesc[0] ;
                  AV71GXLvl161 = (byte)(1) ;
                  AV51DscsCollection.add(A42ConCodYDesc, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(7);
               if ( AV71GXLvl161 == 0 )
               {
                  AV51DscsCollection.add("", 0);
               }
               AV70GXV2 = (int)(AV70GXV2+1) ;
            }
            AV22Combo_DataJson = AV51DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(8, new Object[]{ new Object[]{
                                                 AV21SearchTxt ,
                                                 A42ConCodYDesc ,
                                                 Integer.valueOf(AV45Cond_CliCod) ,
                                                 Integer.valueOf(A3CliCod) } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                                 }
            });
            lV21SearchTxt = GXutil.concat( GXutil.rtrim( AV21SearchTxt), "%", "") ;
            /* Using cursor P001F10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(AV45Cond_CliCod), lV21SearchTxt});
            while ( (pr_default.getStatus(8) != 101) )
            {
               A42ConCodYDesc = P001F10_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P001F10_n42ConCodYDesc[0] ;
               A3CliCod = P001F10_A3CliCod[0] ;
               A26ConCodigo = P001F10_A26ConCodigo[0] ;
               AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
               AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
               AV10Combo_Data.add(AV11Combo_DataItem, 0);
               if ( AV10Combo_Data.size() > AV20MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(8);
            }
            pr_default.close(8);
            AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S151( )
   {
      /* 'LOADCOMBOITEMS_LEGTIPOTRA' Routine */
      returnInSub = false ;
      if ( AV24IsDynamicCall )
      {
         if ( GXutil.strcmp(AV15TrnMode, "GET_DSC") == 0 )
         {
            AV52ValuesCollection.fromJSonString(AV21SearchTxt, null);
            AV51DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV73GXV3 = 1 ;
            while ( AV73GXV3 <= AV52ValuesCollection.size() )
            {
               AV53ValueItem = (String)AV52ValuesCollection.elementAt(-1+AV73GXV3) ;
               AV54TipoTraId_Filter = AV53ValueItem ;
               AV74GXLvl202 = (byte)(0) ;
               /* Using cursor P001F11 */
               pr_default.execute(9, new Object[] {AV54TipoTraId_Filter});
               while ( (pr_default.getStatus(9) != 101) )
               {
                  A1292TipoTraId = P001F11_A1292TipoTraId[0] ;
                  A1293TipoTraNom = P001F11_A1293TipoTraNom[0] ;
                  AV74GXLvl202 = (byte)(1) ;
                  AV51DscsCollection.add(A1293TipoTraNom, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(9);
               if ( AV74GXLvl202 == 0 )
               {
                  AV51DscsCollection.add("", 0);
               }
               AV73GXV3 = (int)(AV73GXV3+1) ;
            }
            AV22Combo_DataJson = AV51DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(10, new Object[]{ new Object[]{
                                                 AV21SearchTxt ,
                                                 A1293TipoTraNom } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV21SearchTxt = GXutil.concat( GXutil.rtrim( AV21SearchTxt), "%", "") ;
            /* Using cursor P001F12 */
            pr_default.execute(10, new Object[] {lV21SearchTxt});
            while ( (pr_default.getStatus(10) != 101) )
            {
               A1293TipoTraNom = P001F12_A1293TipoTraNom[0] ;
               A1292TipoTraId = P001F12_A1292TipoTraId[0] ;
               AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1292TipoTraId );
               AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1293TipoTraNom );
               AV10Combo_Data.add(AV11Combo_DataItem, 0);
               if ( AV10Combo_Data.size() > AV20MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(10);
            }
            pr_default.close(10);
            AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
         }
      }
   }

   public void S161( )
   {
      /* 'LOADCOMBOITEMS_LEGSEXO' Routine */
      returnInSub = false ;
      if ( AV24IsDynamicCall )
      {
         pr_default.dynParam(11, new Object[]{ new Object[]{
                                              AV21SearchTxt ,
                                              A1744SexoNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV21SearchTxt = GXutil.concat( GXutil.rtrim( AV21SearchTxt), "%", "") ;
         /* Using cursor P001F13 */
         pr_default.execute(11, new Object[] {lV21SearchTxt});
         while ( (pr_default.getStatus(11) != 101) )
         {
            A1744SexoNombre = P001F13_A1744SexoNombre[0] ;
            A1743SexoId = P001F13_A1743SexoId[0] ;
            AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1743SexoId, 2, 0)) );
            AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1744SexoNombre );
            AV10Combo_Data.add(AV11Combo_DataItem, 0);
            if ( AV10Combo_Data.size() > AV20MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(11);
         }
         pr_default.close(11);
         AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV15TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV15TrnMode, "GET") != 0 )
            {
               /* Using cursor P001F14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV19LegNumero)});
               while ( (pr_default.getStatus(12) != 101) )
               {
                  A6LegNumero = P001F14_A6LegNumero[0] ;
                  A1EmpCod = P001F14_A1EmpCod[0] ;
                  A3CliCod = P001F14_A3CliCod[0] ;
                  A263LegSexo = P001F14_A263LegSexo[0] ;
                  n263LegSexo = P001F14_n263LegSexo[0] ;
                  AV12SelectedValue = ((0==A263LegSexo) ? "" : GXutil.trim( GXutil.str( A263LegSexo, 2, 0))) ;
                  AV55SexoId = A263LegSexo ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(12);
            }
            else
            {
               AV55SexoId = (byte)(GXutil.lval( AV21SearchTxt)) ;
            }
            /* Using cursor P001F15 */
            pr_default.execute(13, new Object[] {Byte.valueOf(AV55SexoId)});
            while ( (pr_default.getStatus(13) != 101) )
            {
               A1743SexoId = P001F15_A1743SexoId[0] ;
               A1744SexoNombre = P001F15_A1744SexoNombre[0] ;
               AV23SelectedText = A1744SexoNombre ;
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
      /* 'LOADCOMBOITEMS_LEGESTADOCIVIL' Routine */
      returnInSub = false ;
      if ( AV24IsDynamicCall )
      {
         pr_default.dynParam(14, new Object[]{ new Object[]{
                                              AV21SearchTxt ,
                                              A1749EstaCivilDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV21SearchTxt = GXutil.concat( GXutil.rtrim( AV21SearchTxt), "%", "") ;
         /* Using cursor P001F16 */
         pr_default.execute(14, new Object[] {lV21SearchTxt});
         while ( (pr_default.getStatus(14) != 101) )
         {
            A1749EstaCivilDescrip = P001F16_A1749EstaCivilDescrip[0] ;
            A1748EstaCivilCod = P001F16_A1748EstaCivilCod[0] ;
            AV11Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1748EstaCivilCod, 4, 0)) );
            AV11Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1749EstaCivilDescrip );
            AV10Combo_Data.add(AV11Combo_DataItem, 0);
            if ( AV10Combo_Data.size() > AV20MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(14);
         }
         pr_default.close(14);
         AV22Combo_DataJson = AV10Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV15TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV15TrnMode, "GET") != 0 )
            {
               /* Using cursor P001F17 */
               pr_default.execute(15, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV19LegNumero)});
               while ( (pr_default.getStatus(15) != 101) )
               {
                  A6LegNumero = P001F17_A6LegNumero[0] ;
                  A1EmpCod = P001F17_A1EmpCod[0] ;
                  A3CliCod = P001F17_A3CliCod[0] ;
                  A243LegEstadoCivil = P001F17_A243LegEstadoCivil[0] ;
                  n243LegEstadoCivil = P001F17_n243LegEstadoCivil[0] ;
                  AV12SelectedValue = ((0==A243LegEstadoCivil) ? "" : GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0))) ;
                  AV56EstaCivilCod = A243LegEstadoCivil ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(15);
            }
            else
            {
               AV56EstaCivilCod = (short)(GXutil.lval( AV21SearchTxt)) ;
            }
            /* Using cursor P001F18 */
            pr_default.execute(16, new Object[] {Short.valueOf(AV56EstaCivilCod)});
            while ( (pr_default.getStatus(16) != 101) )
            {
               A1748EstaCivilCod = P001F18_A1748EstaCivilCod[0] ;
               A1749EstaCivilDescrip = P001F18_A1749EstaCivilDescrip[0] ;
               AV23SelectedText = A1749EstaCivilDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(16);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = legajoloaddvcombo.this.AV12SelectedValue;
      this.aP9[0] = legajoloaddvcombo.this.AV23SelectedText;
      this.aP10[0] = legajoloaddvcombo.this.AV22Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12SelectedValue = "" ;
      AV23SelectedText = "" ;
      AV22Combo_DataJson = "" ;
      AV61Pgmname = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      scmdbuf = "" ;
      lV21SearchTxt = "" ;
      A303MprDescrip = "" ;
      P001F2_A303MprDescrip = new String[] {""} ;
      P001F2_A18MprCod = new String[] {""} ;
      P001F2_n18MprCod = new boolean[] {false} ;
      A18MprCod = "" ;
      AV11Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV10Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P001F3_A6LegNumero = new int[1] ;
      P001F3_A1EmpCod = new short[1] ;
      P001F3_A3CliCod = new int[1] ;
      P001F3_A18MprCod = new String[] {""} ;
      P001F3_n18MprCod = new boolean[] {false} ;
      P001F3_A303MprDescrip = new String[] {""} ;
      AV39MprCod = "" ;
      P001F4_A18MprCod = new String[] {""} ;
      P001F4_n18MprCod = new boolean[] {false} ;
      P001F4_A303MprDescrip = new String[] {""} ;
      P001F5_A20ZonCod = new String[] {""} ;
      P001F5_n20ZonCod = new boolean[] {false} ;
      P001F5_A342ZonDescrip = new String[] {""} ;
      A20ZonCod = "" ;
      A342ZonDescrip = "" ;
      P001F6_A6LegNumero = new int[1] ;
      P001F6_A1EmpCod = new short[1] ;
      P001F6_A3CliCod = new int[1] ;
      P001F6_A20ZonCod = new String[] {""} ;
      P001F6_n20ZonCod = new boolean[] {false} ;
      A2228propDesc = "" ;
      AV52ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53ValueItem = "" ;
      AV57propCod_Filter = "" ;
      P001F7_A2227propCod = new String[] {""} ;
      P001F7_A2228propDesc = new String[] {""} ;
      A2227propCod = "" ;
      P001F8_A2228propDesc = new String[] {""} ;
      P001F8_A2227propCod = new String[] {""} ;
      A42ConCodYDesc = "" ;
      AV58ConCodigo_Filter = "" ;
      P001F9_A3CliCod = new int[1] ;
      P001F9_A26ConCodigo = new String[] {""} ;
      P001F9_A42ConCodYDesc = new String[] {""} ;
      P001F9_n42ConCodYDesc = new boolean[] {false} ;
      A26ConCodigo = "" ;
      P001F10_A42ConCodYDesc = new String[] {""} ;
      P001F10_n42ConCodYDesc = new boolean[] {false} ;
      P001F10_A3CliCod = new int[1] ;
      P001F10_A26ConCodigo = new String[] {""} ;
      A1293TipoTraNom = "" ;
      AV54TipoTraId_Filter = "" ;
      P001F11_A1292TipoTraId = new String[] {""} ;
      P001F11_A1293TipoTraNom = new String[] {""} ;
      A1292TipoTraId = "" ;
      P001F12_A1293TipoTraNom = new String[] {""} ;
      P001F12_A1292TipoTraId = new String[] {""} ;
      A1744SexoNombre = "" ;
      P001F13_A1744SexoNombre = new String[] {""} ;
      P001F13_A1743SexoId = new byte[1] ;
      P001F14_A6LegNumero = new int[1] ;
      P001F14_A1EmpCod = new short[1] ;
      P001F14_A3CliCod = new int[1] ;
      P001F14_A263LegSexo = new byte[1] ;
      P001F14_n263LegSexo = new boolean[] {false} ;
      P001F15_A1743SexoId = new byte[1] ;
      P001F15_A1744SexoNombre = new String[] {""} ;
      A1749EstaCivilDescrip = "" ;
      P001F16_A1749EstaCivilDescrip = new String[] {""} ;
      P001F16_A1748EstaCivilCod = new short[1] ;
      P001F17_A6LegNumero = new int[1] ;
      P001F17_A1EmpCod = new short[1] ;
      P001F17_A3CliCod = new int[1] ;
      P001F17_A243LegEstadoCivil = new short[1] ;
      P001F17_n243LegEstadoCivil = new boolean[] {false} ;
      P001F18_A1748EstaCivilCod = new short[1] ;
      P001F18_A1749EstaCivilDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P001F2_A303MprDescrip, P001F2_A18MprCod
            }
            , new Object[] {
            P001F3_A6LegNumero, P001F3_A1EmpCod, P001F3_A3CliCod, P001F3_A18MprCod, P001F3_n18MprCod, P001F3_A303MprDescrip
            }
            , new Object[] {
            P001F4_A18MprCod, P001F4_A303MprDescrip
            }
            , new Object[] {
            P001F5_A20ZonCod, P001F5_A342ZonDescrip
            }
            , new Object[] {
            P001F6_A6LegNumero, P001F6_A1EmpCod, P001F6_A3CliCod, P001F6_A20ZonCod, P001F6_n20ZonCod
            }
            , new Object[] {
            P001F7_A2227propCod, P001F7_A2228propDesc
            }
            , new Object[] {
            P001F8_A2228propDesc, P001F8_A2227propCod
            }
            , new Object[] {
            P001F9_A3CliCod, P001F9_A26ConCodigo, P001F9_A42ConCodYDesc, P001F9_n42ConCodYDesc
            }
            , new Object[] {
            P001F10_A42ConCodYDesc, P001F10_n42ConCodYDesc, P001F10_A3CliCod, P001F10_A26ConCodigo
            }
            , new Object[] {
            P001F11_A1292TipoTraId, P001F11_A1293TipoTraNom
            }
            , new Object[] {
            P001F12_A1293TipoTraNom, P001F12_A1292TipoTraId
            }
            , new Object[] {
            P001F13_A1744SexoNombre, P001F13_A1743SexoId
            }
            , new Object[] {
            P001F14_A6LegNumero, P001F14_A1EmpCod, P001F14_A3CliCod, P001F14_A263LegSexo, P001F14_n263LegSexo
            }
            , new Object[] {
            P001F15_A1743SexoId, P001F15_A1744SexoNombre
            }
            , new Object[] {
            P001F16_A1749EstaCivilDescrip, P001F16_A1748EstaCivilCod
            }
            , new Object[] {
            P001F17_A6LegNumero, P001F17_A1EmpCod, P001F17_A3CliCod, P001F17_A243LegEstadoCivil, P001F17_n243LegEstadoCivil
            }
            , new Object[] {
            P001F18_A1748EstaCivilCod, P001F18_A1749EstaCivilDescrip
            }
         }
      );
      AV61Pgmname = "LegajoLoadDVCombo" ;
      /* GeneXus formulas. */
      AV61Pgmname = "LegajoLoadDVCombo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV68GXLvl122 ;
   private byte AV71GXLvl161 ;
   private byte AV74GXLvl202 ;
   private byte A1743SexoId ;
   private byte A263LegSexo ;
   private byte AV55SexoId ;
   private short AV18EmpCod ;
   private short A1EmpCod ;
   private short A1748EstaCivilCod ;
   private short A243LegEstadoCivil ;
   private short AV56EstaCivilCod ;
   private short Gx_err ;
   private int AV17CliCod ;
   private int AV19LegNumero ;
   private int AV45Cond_CliCod ;
   private int AV20MaxItems ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV67GXV1 ;
   private int AV70GXV2 ;
   private int AV73GXV3 ;
   private String AV15TrnMode ;
   private String AV61Pgmname ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String scmdbuf ;
   private String A18MprCod ;
   private String AV39MprCod ;
   private String A20ZonCod ;
   private String AV57propCod_Filter ;
   private String A2227propCod ;
   private String AV58ConCodigo_Filter ;
   private String A26ConCodigo ;
   private String AV54TipoTraId_Filter ;
   private String A1292TipoTraId ;
   private boolean AV24IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n18MprCod ;
   private boolean n20ZonCod ;
   private boolean n42ConCodYDesc ;
   private boolean n263LegSexo ;
   private boolean n243LegEstadoCivil ;
   private String AV22Combo_DataJson ;
   private String AV13ComboName ;
   private String AV21SearchTxt ;
   private String AV12SelectedValue ;
   private String AV23SelectedText ;
   private String lV21SearchTxt ;
   private String A303MprDescrip ;
   private String A342ZonDescrip ;
   private String A2228propDesc ;
   private String AV53ValueItem ;
   private String A42ConCodYDesc ;
   private String A1293TipoTraNom ;
   private String A1744SexoNombre ;
   private String A1749EstaCivilDescrip ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P001F2_A303MprDescrip ;
   private String[] P001F2_A18MprCod ;
   private boolean[] P001F2_n18MprCod ;
   private int[] P001F3_A6LegNumero ;
   private short[] P001F3_A1EmpCod ;
   private int[] P001F3_A3CliCod ;
   private String[] P001F3_A18MprCod ;
   private boolean[] P001F3_n18MprCod ;
   private String[] P001F3_A303MprDescrip ;
   private String[] P001F4_A18MprCod ;
   private boolean[] P001F4_n18MprCod ;
   private String[] P001F4_A303MprDescrip ;
   private String[] P001F5_A20ZonCod ;
   private boolean[] P001F5_n20ZonCod ;
   private String[] P001F5_A342ZonDescrip ;
   private int[] P001F6_A6LegNumero ;
   private short[] P001F6_A1EmpCod ;
   private int[] P001F6_A3CliCod ;
   private String[] P001F6_A20ZonCod ;
   private boolean[] P001F6_n20ZonCod ;
   private String[] P001F7_A2227propCod ;
   private String[] P001F7_A2228propDesc ;
   private String[] P001F8_A2228propDesc ;
   private String[] P001F8_A2227propCod ;
   private int[] P001F9_A3CliCod ;
   private String[] P001F9_A26ConCodigo ;
   private String[] P001F9_A42ConCodYDesc ;
   private boolean[] P001F9_n42ConCodYDesc ;
   private String[] P001F10_A42ConCodYDesc ;
   private boolean[] P001F10_n42ConCodYDesc ;
   private int[] P001F10_A3CliCod ;
   private String[] P001F10_A26ConCodigo ;
   private String[] P001F11_A1292TipoTraId ;
   private String[] P001F11_A1293TipoTraNom ;
   private String[] P001F12_A1293TipoTraNom ;
   private String[] P001F12_A1292TipoTraId ;
   private String[] P001F13_A1744SexoNombre ;
   private byte[] P001F13_A1743SexoId ;
   private int[] P001F14_A6LegNumero ;
   private short[] P001F14_A1EmpCod ;
   private int[] P001F14_A3CliCod ;
   private byte[] P001F14_A263LegSexo ;
   private boolean[] P001F14_n263LegSexo ;
   private byte[] P001F15_A1743SexoId ;
   private String[] P001F15_A1744SexoNombre ;
   private String[] P001F16_A1749EstaCivilDescrip ;
   private short[] P001F16_A1748EstaCivilCod ;
   private int[] P001F17_A6LegNumero ;
   private short[] P001F17_A1EmpCod ;
   private int[] P001F17_A3CliCod ;
   private short[] P001F17_A243LegEstadoCivil ;
   private boolean[] P001F17_n243LegEstadoCivil ;
   private short[] P001F18_A1748EstaCivilCod ;
   private String[] P001F18_A1749EstaCivilDescrip ;
   private GXSimpleCollection<String> AV52ValuesCollection ;
   private GXSimpleCollection<String> AV51DscsCollection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV10Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV11Combo_DataItem ;
}

final  class legajoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001F2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV21SearchTxt ,
                                          String A303MprDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT MprDescrip, MprCod FROM ModalidadAFIP" ;
      if ( ! (GXutil.strcmp("", AV21SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(MprDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MprDescrip" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P001F8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV21SearchTxt ,
                                          String A2228propDesc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT propDesc, propCod FROM propiedades_adicionales" ;
      if ( ! (GXutil.strcmp("", AV21SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(propDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY propDesc" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P001F10( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV21SearchTxt ,
                                           String A42ConCodYDesc ,
                                           int AV45Cond_CliCod ,
                                           int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[2];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT ConCodYDesc, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV21SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConCodYDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodYDesc" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P001F12( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV21SearchTxt ,
                                           String A1293TipoTraNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[1];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( ! (GXutil.strcmp("", AV21SearchTxt)==0) )
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

   protected Object[] conditional_P001F13( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV21SearchTxt ,
                                           String A1744SexoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[1];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT SexoNombre, SexoId FROM Sexos" ;
      if ( ! (GXutil.strcmp("", AV21SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SexoNombre) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SexoNombre" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P001F16( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV21SearchTxt ,
                                           String A1749EstaCivilDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[1];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT EstaCivilDescrip, EstaCivilCod FROM Estados_civiles" ;
      if ( ! (GXutil.strcmp("", AV21SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int16[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EstaCivilDescrip" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
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
                  return conditional_P001F2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 6 :
                  return conditional_P001F8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 8 :
                  return conditional_P001F10(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
            case 10 :
                  return conditional_P001F12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 11 :
                  return conditional_P001F13(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 14 :
                  return conditional_P001F16(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001F2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F3", "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.MprCod, T2.MprDescrip FROM (Legajo T1 LEFT JOIN ModalidadAFIP T2 ON T2.MprCod = T1.MprCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F4", "SELECT MprCod, MprDescrip FROM ModalidadAFIP WHERE MprCod = ( ?) ORDER BY MprCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F5", "SELECT ZonCod, ZonDescrip FROM Zona ORDER BY ZonCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F6", "SELECT LegNumero, EmpCod, CliCod, ZonCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F7", "SELECT propCod, propDesc FROM propiedades_adicionales WHERE propCod = ( ?) ORDER BY propCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F9", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F10", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F11", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F13", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F14", "SELECT LegNumero, EmpCod, CliCod, LegSexo FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F15", "SELECT SexoId, SexoNombre FROM Sexos WHERE SexoId = ? ORDER BY SexoId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F16", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001F17", "SELECT LegNumero, EmpCod, CliCod, LegEstadoCivil FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001F18", "SELECT EstaCivilCod, EstaCivilDescrip FROM Estados_civiles WHERE EstaCivilCod = ? ORDER BY EstaCivilCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 13 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 13 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

