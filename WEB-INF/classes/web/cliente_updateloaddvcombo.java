package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cliente_updateloaddvcombo extends GXProcedure
{
   public cliente_updateloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_updateloaddvcombo.class ), "" );
   }

   public cliente_updateloaddvcombo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             int aP4 ,
                             int aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      cliente_updateloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        int aP4 ,
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
                             int aP4 ,
                             int aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      cliente_updateloaddvcombo.this.AV15ComboName = aP0;
      cliente_updateloaddvcombo.this.AV16TrnMode = aP1;
      cliente_updateloaddvcombo.this.AV17IsDynamicCall = aP2;
      cliente_updateloaddvcombo.this.AV18CliCod = aP3;
      cliente_updateloaddvcombo.this.AV27CliUpdCliCod = aP4;
      cliente_updateloaddvcombo.this.AV28CliUpdRelSec = aP5;
      cliente_updateloaddvcombo.this.AV31Cond_CliUpdCliCod = aP6;
      cliente_updateloaddvcombo.this.AV12SearchTxt = aP7;
      cliente_updateloaddvcombo.this.aP8 = aP8;
      cliente_updateloaddvcombo.this.aP9 = aP9;
      cliente_updateloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Update", GXv_boolean2) ;
      cliente_updateloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         else if ( GXutil.strcmp(AV15ComboName, "CliUpdCliCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLIUPDCLICOD' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "CliUpdRelSec") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLIUPDRELSEC' */
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
         /* Using cursor P01RB2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A344CliNom = P01RB2_A344CliNom[0] ;
            A3CliCod = P01RB2_A3CliCod[0] ;
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
         AV21Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01RB3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Integer.valueOf(AV27CliUpdCliCod), Integer.valueOf(AV28CliUpdRelSec)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1887CliUpdRelSec = P01RB3_A1887CliUpdRelSec[0] ;
               A1881CliUpdCliCod = P01RB3_A1881CliUpdCliCod[0] ;
               A3CliCod = P01RB3_A3CliCod[0] ;
               A344CliNom = P01RB3_A344CliNom[0] ;
               A344CliNom = P01RB3_A344CliNom[0] ;
               AV19SelectedValue = ((0==A3CliCod) ? "" : GXutil.trim( GXutil.str( A3CliCod, 6, 0))) ;
               AV20SelectedText = A344CliNom ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV18CliCod) )
            {
               AV19SelectedValue = GXutil.trim( GXutil.str( AV18CliCod, 6, 0)) ;
               /* Using cursor P01RB4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV18CliCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A3CliCod = P01RB4_A3CliCod[0] ;
                  A344CliNom = P01RB4_A344CliNom[0] ;
                  AV20SelectedText = A344CliNom ;
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
      /* 'LOADCOMBOITEMS_CLIUPDCLICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A344CliNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01RB5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A344CliNom = P01RB5_A344CliNom[0] ;
            A3CliCod = P01RB5_A3CliCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A3CliCod, 6, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A344CliNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV21Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01RB6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), Integer.valueOf(AV27CliUpdCliCod), Integer.valueOf(AV28CliUpdRelSec)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A1887CliUpdRelSec = P01RB6_A1887CliUpdRelSec[0] ;
               A1881CliUpdCliCod = P01RB6_A1881CliUpdCliCod[0] ;
               A3CliCod = P01RB6_A3CliCod[0] ;
               AV19SelectedValue = ((0==A1881CliUpdCliCod) ? "" : GXutil.trim( GXutil.str( A1881CliUpdCliCod, 6, 0))) ;
               AV25CliCodAux = A1881CliUpdCliCod ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
            /* Using cursor P01RB7 */
            pr_default.execute(5, new Object[] {Integer.valueOf(AV25CliCodAux)});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A3CliCod = P01RB7_A3CliCod[0] ;
               A344CliNom = P01RB7_A344CliNom[0] ;
               AV20SelectedText = A344CliNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(5);
         }
         else
         {
            if ( ! (0==AV27CliUpdCliCod) )
            {
               AV19SelectedValue = GXutil.trim( GXutil.str( AV27CliUpdCliCod, 6, 0)) ;
               /* Using cursor P01RB8 */
               pr_default.execute(6, new Object[] {Integer.valueOf(AV27CliUpdCliCod)});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A3CliCod = P01RB8_A3CliCod[0] ;
                  A344CliNom = P01RB8_A344CliNom[0] ;
                  AV20SelectedText = A344CliNom ;
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
      /* 'LOADCOMBOITEMS_CLIUPDRELSEC' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(7, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1879CliReleaseDes ,
                                              Integer.valueOf(A3CliCod) ,
                                              Integer.valueOf(AV31Cond_CliUpdCliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01RB9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(AV31Cond_CliUpdCliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A3CliCod = P01RB9_A3CliCod[0] ;
            A1879CliReleaseDes = P01RB9_A1879CliReleaseDes[0] ;
            A1885CliRelSec = P01RB9_A1885CliRelSec[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1885CliRelSec, 6, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1879CliReleaseDes );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(7);
         }
         pr_default.close(7);
         AV21Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01RB10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(AV18CliCod), Integer.valueOf(AV27CliUpdCliCod), Integer.valueOf(AV28CliUpdRelSec)});
            while ( (pr_default.getStatus(8) != 101) )
            {
               A1887CliUpdRelSec = P01RB10_A1887CliUpdRelSec[0] ;
               A1881CliUpdCliCod = P01RB10_A1881CliUpdCliCod[0] ;
               A3CliCod = P01RB10_A3CliCod[0] ;
               AV19SelectedValue = ((0==A1887CliUpdRelSec) ? "" : GXutil.trim( GXutil.str( A1887CliUpdRelSec, 6, 0))) ;
               AV30Cond_Aux_CliUpdCliCod = A1881CliUpdCliCod ;
               AV29CliRelSec = A1887CliUpdRelSec ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(8);
            /* Using cursor P01RB11 */
            pr_default.execute(9, new Object[] {Integer.valueOf(AV30Cond_Aux_CliUpdCliCod), Integer.valueOf(AV29CliRelSec)});
            while ( (pr_default.getStatus(9) != 101) )
            {
               A3CliCod = P01RB11_A3CliCod[0] ;
               A1885CliRelSec = P01RB11_A1885CliRelSec[0] ;
               A1879CliReleaseDes = P01RB11_A1879CliReleaseDes[0] ;
               AV20SelectedText = A1879CliReleaseDes ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(9);
         }
         else
         {
            if ( ! (0==AV28CliUpdRelSec) )
            {
               AV19SelectedValue = GXutil.trim( GXutil.str( AV28CliUpdRelSec, 6, 0)) ;
               /* Using cursor P01RB12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(AV30Cond_Aux_CliUpdCliCod), Integer.valueOf(AV28CliUpdRelSec)});
               while ( (pr_default.getStatus(10) != 101) )
               {
                  A3CliCod = P01RB12_A3CliCod[0] ;
                  A1885CliRelSec = P01RB12_A1885CliRelSec[0] ;
                  A1879CliReleaseDes = P01RB12_A1879CliReleaseDes[0] ;
                  AV20SelectedText = A1879CliReleaseDes ;
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

   protected void cleanup( )
   {
      this.aP8[0] = cliente_updateloaddvcombo.this.AV19SelectedValue;
      this.aP9[0] = cliente_updateloaddvcombo.this.AV20SelectedText;
      this.aP10[0] = cliente_updateloaddvcombo.this.AV21Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19SelectedValue = "" ;
      AV20SelectedText = "" ;
      AV21Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A344CliNom = "" ;
      P01RB2_A344CliNom = new String[] {""} ;
      P01RB2_A3CliCod = new int[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01RB3_A1887CliUpdRelSec = new int[1] ;
      P01RB3_A1881CliUpdCliCod = new int[1] ;
      P01RB3_A3CliCod = new int[1] ;
      P01RB3_A344CliNom = new String[] {""} ;
      P01RB4_A3CliCod = new int[1] ;
      P01RB4_A344CliNom = new String[] {""} ;
      P01RB5_A344CliNom = new String[] {""} ;
      P01RB5_A3CliCod = new int[1] ;
      P01RB6_A1887CliUpdRelSec = new int[1] ;
      P01RB6_A1881CliUpdCliCod = new int[1] ;
      P01RB6_A3CliCod = new int[1] ;
      P01RB7_A3CliCod = new int[1] ;
      P01RB7_A344CliNom = new String[] {""} ;
      P01RB8_A3CliCod = new int[1] ;
      P01RB8_A344CliNom = new String[] {""} ;
      A1879CliReleaseDes = "" ;
      P01RB9_A3CliCod = new int[1] ;
      P01RB9_A1879CliReleaseDes = new String[] {""} ;
      P01RB9_A1885CliRelSec = new int[1] ;
      P01RB10_A1887CliUpdRelSec = new int[1] ;
      P01RB10_A1881CliUpdCliCod = new int[1] ;
      P01RB10_A3CliCod = new int[1] ;
      P01RB11_A3CliCod = new int[1] ;
      P01RB11_A1885CliRelSec = new int[1] ;
      P01RB11_A1879CliReleaseDes = new String[] {""} ;
      P01RB12_A3CliCod = new int[1] ;
      P01RB12_A1885CliRelSec = new int[1] ;
      P01RB12_A1879CliReleaseDes = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_updateloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01RB2_A344CliNom, P01RB2_A3CliCod
            }
            , new Object[] {
            P01RB3_A1887CliUpdRelSec, P01RB3_A1881CliUpdCliCod, P01RB3_A3CliCod, P01RB3_A344CliNom
            }
            , new Object[] {
            P01RB4_A3CliCod, P01RB4_A344CliNom
            }
            , new Object[] {
            P01RB5_A344CliNom, P01RB5_A3CliCod
            }
            , new Object[] {
            P01RB6_A1887CliUpdRelSec, P01RB6_A1881CliUpdCliCod, P01RB6_A3CliCod
            }
            , new Object[] {
            P01RB7_A3CliCod, P01RB7_A344CliNom
            }
            , new Object[] {
            P01RB8_A3CliCod, P01RB8_A344CliNom
            }
            , new Object[] {
            P01RB9_A3CliCod, P01RB9_A1879CliReleaseDes, P01RB9_A1885CliRelSec
            }
            , new Object[] {
            P01RB10_A1887CliUpdRelSec, P01RB10_A1881CliUpdCliCod, P01RB10_A3CliCod
            }
            , new Object[] {
            P01RB11_A3CliCod, P01RB11_A1885CliRelSec, P01RB11_A1879CliReleaseDes
            }
            , new Object[] {
            P01RB12_A3CliCod, P01RB12_A1885CliRelSec, P01RB12_A1879CliReleaseDes
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV27CliUpdCliCod ;
   private int AV28CliUpdRelSec ;
   private int AV31Cond_CliUpdCliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private int A1887CliUpdRelSec ;
   private int A1881CliUpdCliCod ;
   private int AV25CliCodAux ;
   private int A1885CliRelSec ;
   private int AV30Cond_Aux_CliUpdCliCod ;
   private int AV29CliRelSec ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV21Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV19SelectedValue ;
   private String AV20SelectedText ;
   private String lV12SearchTxt ;
   private String A344CliNom ;
   private String A1879CliReleaseDes ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01RB2_A344CliNom ;
   private int[] P01RB2_A3CliCod ;
   private int[] P01RB3_A1887CliUpdRelSec ;
   private int[] P01RB3_A1881CliUpdCliCod ;
   private int[] P01RB3_A3CliCod ;
   private String[] P01RB3_A344CliNom ;
   private int[] P01RB4_A3CliCod ;
   private String[] P01RB4_A344CliNom ;
   private String[] P01RB5_A344CliNom ;
   private int[] P01RB5_A3CliCod ;
   private int[] P01RB6_A1887CliUpdRelSec ;
   private int[] P01RB6_A1881CliUpdCliCod ;
   private int[] P01RB6_A3CliCod ;
   private int[] P01RB7_A3CliCod ;
   private String[] P01RB7_A344CliNom ;
   private int[] P01RB8_A3CliCod ;
   private String[] P01RB8_A344CliNom ;
   private int[] P01RB9_A3CliCod ;
   private String[] P01RB9_A1879CliReleaseDes ;
   private int[] P01RB9_A1885CliRelSec ;
   private int[] P01RB10_A1887CliUpdRelSec ;
   private int[] P01RB10_A1881CliUpdCliCod ;
   private int[] P01RB10_A3CliCod ;
   private int[] P01RB11_A3CliCod ;
   private int[] P01RB11_A1885CliRelSec ;
   private String[] P01RB11_A1879CliReleaseDes ;
   private int[] P01RB12_A3CliCod ;
   private int[] P01RB12_A1885CliRelSec ;
   private String[] P01RB12_A1879CliReleaseDes ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class cliente_updateloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RB2( ModelContext context ,
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

   protected Object[] conditional_P01RB5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A344CliNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT CliNom, CliCod FROM Cliente" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(CliNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliNom" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01RB9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1879CliReleaseDes ,
                                          int A3CliCod ,
                                          int AV31Cond_CliUpdCliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, CliReleaseDes, CliRelSec FROM Cliente_Release" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(CliReleaseDes) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliReleaseDes" ;
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
                  return conditional_P01RB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01RB5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 7 :
                  return conditional_P01RB9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RB3", "SELECT T1.CliUpdRelSec, T1.CliUpdCliCod, T1.CliCod, T2.CliNom FROM (Cliente_Update T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) WHERE T1.CliCod = ? and T1.CliUpdCliCod = ? and T1.CliUpdRelSec = ? ORDER BY T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB4", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RB6", "SELECT CliUpdRelSec, CliUpdCliCod, CliCod FROM Cliente_Update WHERE CliCod = ? and CliUpdCliCod = ? and CliUpdRelSec = ? ORDER BY CliCod, CliUpdCliCod, CliUpdRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB7", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB8", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RB10", "SELECT CliUpdRelSec, CliUpdCliCod, CliCod FROM Cliente_Update WHERE CliCod = ? and CliUpdCliCod = ? and CliUpdRelSec = ? ORDER BY CliCod, CliUpdCliCod, CliUpdRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB11", "SELECT CliCod, CliRelSec, CliReleaseDes FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RB12", "SELECT CliCod, CliRelSec, CliReleaseDes FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
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
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

