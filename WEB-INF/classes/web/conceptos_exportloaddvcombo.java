package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptos_exportloaddvcombo extends GXProcedure
{
   public conceptos_exportloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptos_exportloaddvcombo.class ), "" );
   }

   public conceptos_exportloaddvcombo( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      conceptos_exportloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
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
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      conceptos_exportloaddvcombo.this.AV15ComboName = aP0;
      conceptos_exportloaddvcombo.this.AV16TrnMode = aP1;
      conceptos_exportloaddvcombo.this.AV17IsDynamicCall = aP2;
      conceptos_exportloaddvcombo.this.AV18CliCod = aP3;
      conceptos_exportloaddvcombo.this.AV19ConCodigo = aP4;
      conceptos_exportloaddvcombo.this.AV29Cond_TipoConCod = aP5;
      conceptos_exportloaddvcombo.this.AV30Cond_SubTipoConCod1 = aP6;
      conceptos_exportloaddvcombo.this.AV12SearchTxt = aP7;
      conceptos_exportloaddvcombo.this.aP8 = aP8;
      conceptos_exportloaddvcombo.this.aP9 = aP9;
      conceptos_exportloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export", GXv_boolean2) ;
      conceptos_exportloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         else if ( GXutil.strcmp(AV15ComboName, "SubTipoConCod1") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SUBTIPOCONCOD1' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "SubTipoConCod2") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SUBTIPOCONCOD2' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "ConCondicion") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONCONDICION' */
            S141 ();
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
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A370TipoConDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KL2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A370TipoConDescrip = P01KL2_A370TipoConDescrip[0] ;
            A37TipoConCod = P01KL2_A37TipoConCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A37TipoConCod );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A370TipoConDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01KL3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A26ConCodigo = P01KL3_A26ConCodigo[0] ;
                  A3CliCod = P01KL3_A3CliCod[0] ;
                  A37TipoConCod = P01KL3_A37TipoConCod[0] ;
                  A370TipoConDescrip = P01KL3_A370TipoConDescrip[0] ;
                  A370TipoConDescrip = P01KL3_A370TipoConDescrip[0] ;
                  AV20SelectedValue = A37TipoConCod ;
                  AV21SelectedText = A370TipoConDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV26TipoConCod = AV12SearchTxt ;
               /* Using cursor P01KL4 */
               pr_default.execute(2, new Object[] {AV26TipoConCod});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A37TipoConCod = P01KL4_A37TipoConCod[0] ;
                  A370TipoConDescrip = P01KL4_A370TipoConDescrip[0] ;
                  AV21SelectedText = A370TipoConDescrip ;
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
      /* 'LOADCOMBOITEMS_SUBTIPOCONCOD1' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A371SubTipoConDes1 ,
                                              A37TipoConCod ,
                                              AV29Cond_TipoConCod } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KL5 */
         pr_default.execute(3, new Object[] {AV29Cond_TipoConCod, lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A37TipoConCod = P01KL5_A37TipoConCod[0] ;
            A371SubTipoConDes1 = P01KL5_A371SubTipoConDes1[0] ;
            A38SubTipoConCod1 = P01KL5_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P01KL5_n38SubTipoConCod1[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A38SubTipoConCod1 );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A371SubTipoConDes1 );
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
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01KL6 */
               pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A37TipoConCod = P01KL6_A37TipoConCod[0] ;
                  A26ConCodigo = P01KL6_A26ConCodigo[0] ;
                  A3CliCod = P01KL6_A3CliCod[0] ;
                  A38SubTipoConCod1 = P01KL6_A38SubTipoConCod1[0] ;
                  n38SubTipoConCod1 = P01KL6_n38SubTipoConCod1[0] ;
                  A371SubTipoConDes1 = P01KL6_A371SubTipoConDes1[0] ;
                  A371SubTipoConDes1 = P01KL6_A371SubTipoConDes1[0] ;
                  AV20SelectedValue = A38SubTipoConCod1 ;
                  AV21SelectedText = A371SubTipoConDes1 ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV27SubTipoConCod1 = AV12SearchTxt ;
               /* Using cursor P01KL7 */
               pr_default.execute(5, new Object[] {AV29Cond_TipoConCod, AV27SubTipoConCod1});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A37TipoConCod = P01KL7_A37TipoConCod[0] ;
                  A38SubTipoConCod1 = P01KL7_A38SubTipoConCod1[0] ;
                  n38SubTipoConCod1 = P01KL7_n38SubTipoConCod1[0] ;
                  A371SubTipoConDes1 = P01KL7_A371SubTipoConDes1[0] ;
                  AV21SelectedText = A371SubTipoConDes1 ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(5);
            }
         }
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_SUBTIPOCONCOD2' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A372SubTipoConDes2 ,
                                              A37TipoConCod ,
                                              AV29Cond_TipoConCod ,
                                              A38SubTipoConCod1 ,
                                              AV30Cond_SubTipoConCod1 } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KL8 */
         pr_default.execute(6, new Object[] {AV29Cond_TipoConCod, AV30Cond_SubTipoConCod1, lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A37TipoConCod = P01KL8_A37TipoConCod[0] ;
            A38SubTipoConCod1 = P01KL8_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P01KL8_n38SubTipoConCod1[0] ;
            A372SubTipoConDes2 = P01KL8_A372SubTipoConDes2[0] ;
            A39SubTipoConCod2 = P01KL8_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = P01KL8_n39SubTipoConCod2[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A39SubTipoConCod2 );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A372SubTipoConDes2 );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(6);
         }
         pr_default.close(6);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01KL9 */
               pr_default.execute(7, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo});
               while ( (pr_default.getStatus(7) != 101) )
               {
                  A37TipoConCod = P01KL9_A37TipoConCod[0] ;
                  A38SubTipoConCod1 = P01KL9_A38SubTipoConCod1[0] ;
                  n38SubTipoConCod1 = P01KL9_n38SubTipoConCod1[0] ;
                  A26ConCodigo = P01KL9_A26ConCodigo[0] ;
                  A3CliCod = P01KL9_A3CliCod[0] ;
                  A39SubTipoConCod2 = P01KL9_A39SubTipoConCod2[0] ;
                  n39SubTipoConCod2 = P01KL9_n39SubTipoConCod2[0] ;
                  A372SubTipoConDes2 = P01KL9_A372SubTipoConDes2[0] ;
                  A372SubTipoConDes2 = P01KL9_A372SubTipoConDes2[0] ;
                  AV20SelectedValue = A39SubTipoConCod2 ;
                  AV21SelectedText = A372SubTipoConDes2 ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(7);
            }
            else
            {
               AV28SubTipoConCod2 = AV12SearchTxt ;
               /* Using cursor P01KL10 */
               pr_default.execute(8, new Object[] {AV29Cond_TipoConCod, AV30Cond_SubTipoConCod1, AV28SubTipoConCod2});
               while ( (pr_default.getStatus(8) != 101) )
               {
                  A38SubTipoConCod1 = P01KL10_A38SubTipoConCod1[0] ;
                  n38SubTipoConCod1 = P01KL10_n38SubTipoConCod1[0] ;
                  A37TipoConCod = P01KL10_A37TipoConCod[0] ;
                  A39SubTipoConCod2 = P01KL10_A39SubTipoConCod2[0] ;
                  n39SubTipoConCod2 = P01KL10_n39SubTipoConCod2[0] ;
                  A372SubTipoConDes2 = P01KL10_A372SubTipoConDes2[0] ;
                  AV21SelectedText = A372SubTipoConDes2 ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(8);
            }
         }
      }
   }

   public void S141( )
   {
      /* 'LOADCOMBOITEMS_CONCONDICION' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(9, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1758CondicionDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KL11 */
         pr_default.execute(9, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(9) != 101) )
         {
            A1758CondicionDescrip = P01KL11_A1758CondicionDescrip[0] ;
            A953ConCondicion = P01KL11_A953ConCondicion[0] ;
            n953ConCondicion = P01KL11_n953ConCondicion[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A953ConCondicion );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1758CondicionDescrip );
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
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01KL12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo});
               while ( (pr_default.getStatus(10) != 101) )
               {
                  A26ConCodigo = P01KL12_A26ConCodigo[0] ;
                  A3CliCod = P01KL12_A3CliCod[0] ;
                  A953ConCondicion = P01KL12_A953ConCondicion[0] ;
                  n953ConCondicion = P01KL12_n953ConCondicion[0] ;
                  A1758CondicionDescrip = P01KL12_A1758CondicionDescrip[0] ;
                  A1758CondicionDescrip = P01KL12_A1758CondicionDescrip[0] ;
                  AV20SelectedValue = A953ConCondicion ;
                  AV21SelectedText = A1758CondicionDescrip ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(10);
            }
            else
            {
               AV32ConCondicion = AV12SearchTxt ;
               /* Using cursor P01KL13 */
               pr_default.execute(11, new Object[] {AV32ConCondicion});
               while ( (pr_default.getStatus(11) != 101) )
               {
                  A953ConCondicion = P01KL13_A953ConCondicion[0] ;
                  n953ConCondicion = P01KL13_n953ConCondicion[0] ;
                  A1758CondicionDescrip = P01KL13_A1758CondicionDescrip[0] ;
                  AV21SelectedText = A1758CondicionDescrip ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(11);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = conceptos_exportloaddvcombo.this.AV20SelectedValue;
      this.aP9[0] = conceptos_exportloaddvcombo.this.AV21SelectedText;
      this.aP10[0] = conceptos_exportloaddvcombo.this.AV22Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
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
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A370TipoConDescrip = "" ;
      P01KL2_A370TipoConDescrip = new String[] {""} ;
      P01KL2_A37TipoConCod = new String[] {""} ;
      A37TipoConCod = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01KL3_A26ConCodigo = new String[] {""} ;
      P01KL3_A3CliCod = new int[1] ;
      P01KL3_A37TipoConCod = new String[] {""} ;
      P01KL3_A370TipoConDescrip = new String[] {""} ;
      A26ConCodigo = "" ;
      AV26TipoConCod = "" ;
      P01KL4_A37TipoConCod = new String[] {""} ;
      P01KL4_A370TipoConDescrip = new String[] {""} ;
      A371SubTipoConDes1 = "" ;
      P01KL5_A37TipoConCod = new String[] {""} ;
      P01KL5_A371SubTipoConDes1 = new String[] {""} ;
      P01KL5_A38SubTipoConCod1 = new String[] {""} ;
      P01KL5_n38SubTipoConCod1 = new boolean[] {false} ;
      A38SubTipoConCod1 = "" ;
      P01KL6_A37TipoConCod = new String[] {""} ;
      P01KL6_A26ConCodigo = new String[] {""} ;
      P01KL6_A3CliCod = new int[1] ;
      P01KL6_A38SubTipoConCod1 = new String[] {""} ;
      P01KL6_n38SubTipoConCod1 = new boolean[] {false} ;
      P01KL6_A371SubTipoConDes1 = new String[] {""} ;
      AV27SubTipoConCod1 = "" ;
      P01KL7_A37TipoConCod = new String[] {""} ;
      P01KL7_A38SubTipoConCod1 = new String[] {""} ;
      P01KL7_n38SubTipoConCod1 = new boolean[] {false} ;
      P01KL7_A371SubTipoConDes1 = new String[] {""} ;
      A372SubTipoConDes2 = "" ;
      P01KL8_A37TipoConCod = new String[] {""} ;
      P01KL8_A38SubTipoConCod1 = new String[] {""} ;
      P01KL8_n38SubTipoConCod1 = new boolean[] {false} ;
      P01KL8_A372SubTipoConDes2 = new String[] {""} ;
      P01KL8_A39SubTipoConCod2 = new String[] {""} ;
      P01KL8_n39SubTipoConCod2 = new boolean[] {false} ;
      A39SubTipoConCod2 = "" ;
      P01KL9_A37TipoConCod = new String[] {""} ;
      P01KL9_A38SubTipoConCod1 = new String[] {""} ;
      P01KL9_n38SubTipoConCod1 = new boolean[] {false} ;
      P01KL9_A26ConCodigo = new String[] {""} ;
      P01KL9_A3CliCod = new int[1] ;
      P01KL9_A39SubTipoConCod2 = new String[] {""} ;
      P01KL9_n39SubTipoConCod2 = new boolean[] {false} ;
      P01KL9_A372SubTipoConDes2 = new String[] {""} ;
      AV28SubTipoConCod2 = "" ;
      P01KL10_A38SubTipoConCod1 = new String[] {""} ;
      P01KL10_n38SubTipoConCod1 = new boolean[] {false} ;
      P01KL10_A37TipoConCod = new String[] {""} ;
      P01KL10_A39SubTipoConCod2 = new String[] {""} ;
      P01KL10_n39SubTipoConCod2 = new boolean[] {false} ;
      P01KL10_A372SubTipoConDes2 = new String[] {""} ;
      A1758CondicionDescrip = "" ;
      P01KL11_A1758CondicionDescrip = new String[] {""} ;
      P01KL11_A953ConCondicion = new String[] {""} ;
      P01KL11_n953ConCondicion = new boolean[] {false} ;
      A953ConCondicion = "" ;
      P01KL12_A26ConCodigo = new String[] {""} ;
      P01KL12_A3CliCod = new int[1] ;
      P01KL12_A953ConCondicion = new String[] {""} ;
      P01KL12_n953ConCondicion = new boolean[] {false} ;
      P01KL12_A1758CondicionDescrip = new String[] {""} ;
      AV32ConCondicion = "" ;
      P01KL13_A953ConCondicion = new String[] {""} ;
      P01KL13_n953ConCondicion = new boolean[] {false} ;
      P01KL13_A1758CondicionDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptos_exportloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01KL2_A370TipoConDescrip, P01KL2_A37TipoConCod
            }
            , new Object[] {
            P01KL3_A26ConCodigo, P01KL3_A3CliCod, P01KL3_A37TipoConCod, P01KL3_A370TipoConDescrip
            }
            , new Object[] {
            P01KL4_A37TipoConCod, P01KL4_A370TipoConDescrip
            }
            , new Object[] {
            P01KL5_A37TipoConCod, P01KL5_A371SubTipoConDes1, P01KL5_A38SubTipoConCod1
            }
            , new Object[] {
            P01KL6_A37TipoConCod, P01KL6_A26ConCodigo, P01KL6_A3CliCod, P01KL6_A38SubTipoConCod1, P01KL6_n38SubTipoConCod1, P01KL6_A371SubTipoConDes1
            }
            , new Object[] {
            P01KL7_A37TipoConCod, P01KL7_A38SubTipoConCod1, P01KL7_A371SubTipoConDes1
            }
            , new Object[] {
            P01KL8_A37TipoConCod, P01KL8_A38SubTipoConCod1, P01KL8_A372SubTipoConDes2, P01KL8_A39SubTipoConCod2
            }
            , new Object[] {
            P01KL9_A37TipoConCod, P01KL9_A38SubTipoConCod1, P01KL9_n38SubTipoConCod1, P01KL9_A26ConCodigo, P01KL9_A3CliCod, P01KL9_A39SubTipoConCod2, P01KL9_n39SubTipoConCod2, P01KL9_A372SubTipoConDes2
            }
            , new Object[] {
            P01KL10_A38SubTipoConCod1, P01KL10_A37TipoConCod, P01KL10_A39SubTipoConCod2, P01KL10_A372SubTipoConDes2
            }
            , new Object[] {
            P01KL11_A1758CondicionDescrip, P01KL11_A953ConCondicion
            }
            , new Object[] {
            P01KL12_A26ConCodigo, P01KL12_A3CliCod, P01KL12_A953ConCondicion, P01KL12_n953ConCondicion, P01KL12_A1758CondicionDescrip
            }
            , new Object[] {
            P01KL13_A953ConCondicion, P01KL13_A1758CondicionDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV19ConCodigo ;
   private String AV29Cond_TipoConCod ;
   private String AV30Cond_SubTipoConCod1 ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String AV26TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String AV27SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String AV28SubTipoConCod2 ;
   private String A953ConCondicion ;
   private String AV32ConCondicion ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n953ConCondicion ;
   private String AV22Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV20SelectedValue ;
   private String AV21SelectedText ;
   private String lV12SearchTxt ;
   private String A370TipoConDescrip ;
   private String A371SubTipoConDes1 ;
   private String A372SubTipoConDes2 ;
   private String A1758CondicionDescrip ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01KL2_A370TipoConDescrip ;
   private String[] P01KL2_A37TipoConCod ;
   private String[] P01KL3_A26ConCodigo ;
   private int[] P01KL3_A3CliCod ;
   private String[] P01KL3_A37TipoConCod ;
   private String[] P01KL3_A370TipoConDescrip ;
   private String[] P01KL4_A37TipoConCod ;
   private String[] P01KL4_A370TipoConDescrip ;
   private String[] P01KL5_A37TipoConCod ;
   private String[] P01KL5_A371SubTipoConDes1 ;
   private String[] P01KL5_A38SubTipoConCod1 ;
   private boolean[] P01KL5_n38SubTipoConCod1 ;
   private String[] P01KL6_A37TipoConCod ;
   private String[] P01KL6_A26ConCodigo ;
   private int[] P01KL6_A3CliCod ;
   private String[] P01KL6_A38SubTipoConCod1 ;
   private boolean[] P01KL6_n38SubTipoConCod1 ;
   private String[] P01KL6_A371SubTipoConDes1 ;
   private String[] P01KL7_A37TipoConCod ;
   private String[] P01KL7_A38SubTipoConCod1 ;
   private boolean[] P01KL7_n38SubTipoConCod1 ;
   private String[] P01KL7_A371SubTipoConDes1 ;
   private String[] P01KL8_A37TipoConCod ;
   private String[] P01KL8_A38SubTipoConCod1 ;
   private boolean[] P01KL8_n38SubTipoConCod1 ;
   private String[] P01KL8_A372SubTipoConDes2 ;
   private String[] P01KL8_A39SubTipoConCod2 ;
   private boolean[] P01KL8_n39SubTipoConCod2 ;
   private String[] P01KL9_A37TipoConCod ;
   private String[] P01KL9_A38SubTipoConCod1 ;
   private boolean[] P01KL9_n38SubTipoConCod1 ;
   private String[] P01KL9_A26ConCodigo ;
   private int[] P01KL9_A3CliCod ;
   private String[] P01KL9_A39SubTipoConCod2 ;
   private boolean[] P01KL9_n39SubTipoConCod2 ;
   private String[] P01KL9_A372SubTipoConDes2 ;
   private String[] P01KL10_A38SubTipoConCod1 ;
   private boolean[] P01KL10_n38SubTipoConCod1 ;
   private String[] P01KL10_A37TipoConCod ;
   private String[] P01KL10_A39SubTipoConCod2 ;
   private boolean[] P01KL10_n39SubTipoConCod2 ;
   private String[] P01KL10_A372SubTipoConDes2 ;
   private String[] P01KL11_A1758CondicionDescrip ;
   private String[] P01KL11_A953ConCondicion ;
   private boolean[] P01KL11_n953ConCondicion ;
   private String[] P01KL12_A26ConCodigo ;
   private int[] P01KL12_A3CliCod ;
   private String[] P01KL12_A953ConCondicion ;
   private boolean[] P01KL12_n953ConCondicion ;
   private String[] P01KL12_A1758CondicionDescrip ;
   private String[] P01KL13_A953ConCondicion ;
   private boolean[] P01KL13_n953ConCondicion ;
   private String[] P01KL13_A1758CondicionDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class conceptos_exportloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KL2( ModelContext context ,
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

   protected Object[] conditional_P01KL5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A371SubTipoConDes1 ,
                                          String A37TipoConCod ,
                                          String AV29Cond_TipoConCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT TipoConCod, SubTipoConDes1, SubTipoConCod1 FROM TipoDeConceptoSubtipo1" ;
      addWhere(sWhereString, "(TipoConCod = ( ?))");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConDes1) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SubTipoConDes1" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01KL8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A372SubTipoConDes2 ,
                                          String A37TipoConCod ,
                                          String AV29Cond_TipoConCod ,
                                          String A38SubTipoConCod1 ,
                                          String AV30Cond_SubTipoConCod1 )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes2, SubTipoConCod2 FROM tipo_concepto_subtipo2" ;
      addWhere(sWhereString, "(TipoConCod = ( ?))");
      addWhere(sWhereString, "(SubTipoConCod1 = ( ?))");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConDes2) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SubTipoConDes2" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01KL11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String AV12SearchTxt ,
                                           String A1758CondicionDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[1];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CondicionDescrip, ConCondicion FROM Condiciones_concepto" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(CondicionDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CondicionDescrip" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P01KL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01KL5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] );
            case 6 :
                  return conditional_P01KL8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] );
            case 9 :
                  return conditional_P01KL11(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KL3", "SELECT T1.ConCodigo, T1.CliCod, T1.TipoConCod, T2.TipoConDescrip FROM (Concepto T1 INNER JOIN TipoDeConcepto T2 ON T2.TipoConCod = T1.TipoConCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL4", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto WHERE TipoConCod = ( ?) ORDER BY TipoConCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KL6", "SELECT T1.TipoConCod, T1.ConCodigo, T1.CliCod, T1.SubTipoConCod1, T2.SubTipoConDes1 FROM (Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL7", "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes1 FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KL9", "SELECT T1.TipoConCod, T1.SubTipoConCod1, T1.ConCodigo, T1.CliCod, T1.SubTipoConCod2, T2.SubTipoConDes2 FROM (Concepto T1 LEFT JOIN tipo_concepto_subtipo2 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1 AND T2.SubTipoConCod2 = T1.SubTipoConCod2) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL10", "SELECT SubTipoConCod1, TipoConCod, SubTipoConCod2, SubTipoConDes2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) and SubTipoConCod2 = ( ?) ORDER BY TipoConCod, SubTipoConCod1, SubTipoConCod2  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KL12", "SELECT T1.ConCodigo, T1.CliCod, T1.ConCondicion, T2.CondicionDescrip FROM (Concepto T1 LEFT JOIN Condiciones_concepto T2 ON T2.ConCondicion = T1.ConCondicion) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KL13", "SELECT ConCondicion, CondicionDescrip FROM Condiciones_concepto WHERE ConCondicion = ( ?) ORDER BY ConCondicion  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 11 :
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

