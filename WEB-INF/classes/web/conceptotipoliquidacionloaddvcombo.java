package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptotipoliquidacionloaddvcombo extends GXProcedure
{
   public conceptotipoliquidacionloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotipoliquidacionloaddvcombo.class ), "" );
   }

   public conceptotipoliquidacionloaddvcombo( int remoteHandle ,
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
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      conceptotipoliquidacionloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
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
                             String aP4 ,
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      conceptotipoliquidacionloaddvcombo.this.AV15ComboName = aP0;
      conceptotipoliquidacionloaddvcombo.this.AV16TrnMode = aP1;
      conceptotipoliquidacionloaddvcombo.this.AV17IsDynamicCall = aP2;
      conceptotipoliquidacionloaddvcombo.this.AV18CliCod = aP3;
      conceptotipoliquidacionloaddvcombo.this.AV19ConCodigo = aP4;
      conceptotipoliquidacionloaddvcombo.this.AV20TLiqCod = aP5;
      conceptotipoliquidacionloaddvcombo.this.AV27Cond_CliCod = aP6;
      conceptotipoliquidacionloaddvcombo.this.AV12SearchTxt = aP7;
      conceptotipoliquidacionloaddvcombo.this.aP8 = aP8;
      conceptotipoliquidacionloaddvcombo.this.aP9 = aP9;
      conceptotipoliquidacionloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoTipoLiquidacion", GXv_boolean2) ;
      conceptotipoliquidacionloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "CliCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLICOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "ConCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONCODIGO' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "TLiqCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_TLIQCOD' */
            S131 ();
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
      /* 'LOADCOMBOITEMS_CLICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A344CliNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KR2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A344CliNom = P01KR2_A344CliNom[0] ;
            A3CliCod = P01KR2_A3CliCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A3CliCod, 6, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A344CliNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01KR3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo, AV20TLiqCod});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A32TLiqCod = P01KR3_A32TLiqCod[0] ;
               A26ConCodigo = P01KR3_A26ConCodigo[0] ;
               A3CliCod = P01KR3_A3CliCod[0] ;
               A344CliNom = P01KR3_A344CliNom[0] ;
               A344CliNom = P01KR3_A344CliNom[0] ;
               AV21SelectedValue = ((0==A3CliCod) ? "" : GXutil.trim( GXutil.str( A3CliCod, 6, 0))) ;
               AV22SelectedText = A344CliNom ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV18CliCod) )
            {
               AV21SelectedValue = GXutil.trim( GXutil.str( AV18CliCod, 6, 0)) ;
               /* Using cursor P01KR4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV18CliCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A3CliCod = P01KR4_A3CliCod[0] ;
                  A344CliNom = P01KR4_A344CliNom[0] ;
                  AV22SelectedText = A344CliNom ;
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
      /* 'LOADCOMBOITEMS_CONCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A42ConCodYDesc ,
                                              Integer.valueOf(AV27Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KR5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV27Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A42ConCodYDesc = P01KR5_A42ConCodYDesc[0] ;
            n42ConCodYDesc = P01KR5_n42ConCodYDesc[0] ;
            A3CliCod = P01KR5_A3CliCod[0] ;
            A26ConCodigo = P01KR5_A26ConCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01KR6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo, AV20TLiqCod});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A32TLiqCod = P01KR6_A32TLiqCod[0] ;
               A26ConCodigo = P01KR6_A26ConCodigo[0] ;
               A3CliCod = P01KR6_A3CliCod[0] ;
               A42ConCodYDesc = P01KR6_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P01KR6_n42ConCodYDesc[0] ;
               A42ConCodYDesc = P01KR6_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P01KR6_n42ConCodYDesc[0] ;
               AV21SelectedValue = A26ConCodigo ;
               AV22SelectedText = A42ConCodYDesc ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV19ConCodigo)==0) )
            {
               AV21SelectedValue = AV19ConCodigo ;
               /* Using cursor P01KR7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(AV27Cond_CliCod), AV19ConCodigo});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A3CliCod = P01KR7_A3CliCod[0] ;
                  A26ConCodigo = P01KR7_A26ConCodigo[0] ;
                  A42ConCodYDesc = P01KR7_A42ConCodYDesc[0] ;
                  n42ConCodYDesc = P01KR7_n42ConCodYDesc[0] ;
                  AV22SelectedText = A42ConCodYDesc ;
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
      /* 'LOADCOMBOITEMS_TLIQCOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A340TliqDesc ,
                                              Integer.valueOf(AV27Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KR8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(AV27Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A340TliqDesc = P01KR8_A340TliqDesc[0] ;
            A3CliCod = P01KR8_A3CliCod[0] ;
            A32TLiqCod = P01KR8_A32TLiqCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A32TLiqCod );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A340TliqDesc );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(6);
         }
         pr_default.close(6);
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01KR9 */
            pr_default.execute(7, new Object[] {Integer.valueOf(AV18CliCod), AV19ConCodigo, AV20TLiqCod});
            while ( (pr_default.getStatus(7) != 101) )
            {
               A32TLiqCod = P01KR9_A32TLiqCod[0] ;
               A26ConCodigo = P01KR9_A26ConCodigo[0] ;
               A3CliCod = P01KR9_A3CliCod[0] ;
               A340TliqDesc = P01KR9_A340TliqDesc[0] ;
               A340TliqDesc = P01KR9_A340TliqDesc[0] ;
               AV21SelectedValue = A32TLiqCod ;
               AV22SelectedText = A340TliqDesc ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(7);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV20TLiqCod)==0) )
            {
               AV21SelectedValue = AV20TLiqCod ;
               /* Using cursor P01KR10 */
               pr_default.execute(8, new Object[] {Integer.valueOf(AV27Cond_CliCod), AV20TLiqCod});
               while ( (pr_default.getStatus(8) != 101) )
               {
                  A3CliCod = P01KR10_A3CliCod[0] ;
                  A32TLiqCod = P01KR10_A32TLiqCod[0] ;
                  A340TliqDesc = P01KR10_A340TliqDesc[0] ;
                  AV22SelectedText = A340TliqDesc ;
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

   protected void cleanup( )
   {
      this.aP8[0] = conceptotipoliquidacionloaddvcombo.this.AV21SelectedValue;
      this.aP9[0] = conceptotipoliquidacionloaddvcombo.this.AV22SelectedText;
      this.aP10[0] = conceptotipoliquidacionloaddvcombo.this.AV23Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV23Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A344CliNom = "" ;
      P01KR2_A344CliNom = new String[] {""} ;
      P01KR2_A3CliCod = new int[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01KR3_A32TLiqCod = new String[] {""} ;
      P01KR3_A26ConCodigo = new String[] {""} ;
      P01KR3_A3CliCod = new int[1] ;
      P01KR3_A344CliNom = new String[] {""} ;
      A32TLiqCod = "" ;
      A26ConCodigo = "" ;
      P01KR4_A3CliCod = new int[1] ;
      P01KR4_A344CliNom = new String[] {""} ;
      A42ConCodYDesc = "" ;
      P01KR5_A42ConCodYDesc = new String[] {""} ;
      P01KR5_n42ConCodYDesc = new boolean[] {false} ;
      P01KR5_A3CliCod = new int[1] ;
      P01KR5_A26ConCodigo = new String[] {""} ;
      P01KR6_A32TLiqCod = new String[] {""} ;
      P01KR6_A26ConCodigo = new String[] {""} ;
      P01KR6_A3CliCod = new int[1] ;
      P01KR6_A42ConCodYDesc = new String[] {""} ;
      P01KR6_n42ConCodYDesc = new boolean[] {false} ;
      P01KR7_A3CliCod = new int[1] ;
      P01KR7_A26ConCodigo = new String[] {""} ;
      P01KR7_A42ConCodYDesc = new String[] {""} ;
      P01KR7_n42ConCodYDesc = new boolean[] {false} ;
      A340TliqDesc = "" ;
      P01KR8_A340TliqDesc = new String[] {""} ;
      P01KR8_A3CliCod = new int[1] ;
      P01KR8_A32TLiqCod = new String[] {""} ;
      P01KR9_A32TLiqCod = new String[] {""} ;
      P01KR9_A26ConCodigo = new String[] {""} ;
      P01KR9_A3CliCod = new int[1] ;
      P01KR9_A340TliqDesc = new String[] {""} ;
      P01KR10_A3CliCod = new int[1] ;
      P01KR10_A32TLiqCod = new String[] {""} ;
      P01KR10_A340TliqDesc = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotipoliquidacionloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01KR2_A344CliNom, P01KR2_A3CliCod
            }
            , new Object[] {
            P01KR3_A32TLiqCod, P01KR3_A26ConCodigo, P01KR3_A3CliCod, P01KR3_A344CliNom
            }
            , new Object[] {
            P01KR4_A3CliCod, P01KR4_A344CliNom
            }
            , new Object[] {
            P01KR5_A42ConCodYDesc, P01KR5_n42ConCodYDesc, P01KR5_A3CliCod, P01KR5_A26ConCodigo
            }
            , new Object[] {
            P01KR6_A32TLiqCod, P01KR6_A26ConCodigo, P01KR6_A3CliCod, P01KR6_A42ConCodYDesc, P01KR6_n42ConCodYDesc
            }
            , new Object[] {
            P01KR7_A3CliCod, P01KR7_A26ConCodigo, P01KR7_A42ConCodYDesc, P01KR7_n42ConCodYDesc
            }
            , new Object[] {
            P01KR8_A340TliqDesc, P01KR8_A3CliCod, P01KR8_A32TLiqCod
            }
            , new Object[] {
            P01KR9_A32TLiqCod, P01KR9_A26ConCodigo, P01KR9_A3CliCod, P01KR9_A340TliqDesc
            }
            , new Object[] {
            P01KR10_A3CliCod, P01KR10_A32TLiqCod, P01KR10_A340TliqDesc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV27Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV19ConCodigo ;
   private String AV20TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String A26ConCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n42ConCodYDesc ;
   private String AV23Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A344CliNom ;
   private String A42ConCodYDesc ;
   private String A340TliqDesc ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01KR2_A344CliNom ;
   private int[] P01KR2_A3CliCod ;
   private String[] P01KR3_A32TLiqCod ;
   private String[] P01KR3_A26ConCodigo ;
   private int[] P01KR3_A3CliCod ;
   private String[] P01KR3_A344CliNom ;
   private int[] P01KR4_A3CliCod ;
   private String[] P01KR4_A344CliNom ;
   private String[] P01KR5_A42ConCodYDesc ;
   private boolean[] P01KR5_n42ConCodYDesc ;
   private int[] P01KR5_A3CliCod ;
   private String[] P01KR5_A26ConCodigo ;
   private String[] P01KR6_A32TLiqCod ;
   private String[] P01KR6_A26ConCodigo ;
   private int[] P01KR6_A3CliCod ;
   private String[] P01KR6_A42ConCodYDesc ;
   private boolean[] P01KR6_n42ConCodYDesc ;
   private int[] P01KR7_A3CliCod ;
   private String[] P01KR7_A26ConCodigo ;
   private String[] P01KR7_A42ConCodYDesc ;
   private boolean[] P01KR7_n42ConCodYDesc ;
   private String[] P01KR8_A340TliqDesc ;
   private int[] P01KR8_A3CliCod ;
   private String[] P01KR8_A32TLiqCod ;
   private String[] P01KR9_A32TLiqCod ;
   private String[] P01KR9_A26ConCodigo ;
   private int[] P01KR9_A3CliCod ;
   private String[] P01KR9_A340TliqDesc ;
   private int[] P01KR10_A3CliCod ;
   private String[] P01KR10_A32TLiqCod ;
   private String[] P01KR10_A340TliqDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class conceptotipoliquidacionloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A344CliNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliNom, CliCod FROM Cliente" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(CliNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliNom" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01KR5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A42ConCodYDesc ,
                                          int AV27Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT ConCodYDesc, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConCodYDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodYDesc" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01KR8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A340TliqDesc ,
                                          int AV27Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT TliqDesc, CliCod, TLiqCod FROM TipoLiquidacion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TliqDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, TliqDesc" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01KR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01KR5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
            case 6 :
                  return conditional_P01KR8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KR3", "SELECT T1.TLiqCod, T1.ConCodigo, T1.CliCod, T2.CliNom FROM (ConceptoTipoLiquidacion T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.TLiqCod = ( ?) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KR4", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KR5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KR6", "SELECT T1.TLiqCod, T1.ConCodigo, T1.CliCod, T2.ConCodYDesc FROM (ConceptoTipoLiquidacion T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.TLiqCod = ( ?) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KR7", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KR8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KR9", "SELECT T1.TLiqCod, T1.ConCodigo, T1.CliCod, T2.TliqDesc FROM (ConceptoTipoLiquidacion T1 INNER JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.TLiqCod = ( ?) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KR10", "SELECT CliCod, TLiqCod, TliqDesc FROM TipoLiquidacion WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
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
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 6 :
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
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

