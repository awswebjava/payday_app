package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptomotivosegresoloaddvcombo extends GXProcedure
{
   public conceptomotivosegresoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptomotivosegresoloaddvcombo.class ), "" );
   }

   public conceptomotivosegresoloaddvcombo( int remoteHandle ,
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
                             short aP6 ,
                             int aP7 ,
                             String aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      conceptomotivosegresoloaddvcombo.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        short aP6 ,
                        int aP7 ,
                        String aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             short aP6 ,
                             int aP7 ,
                             String aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      conceptomotivosegresoloaddvcombo.this.AV15ComboName = aP0;
      conceptomotivosegresoloaddvcombo.this.AV16TrnMode = aP1;
      conceptomotivosegresoloaddvcombo.this.AV17IsDynamicCall = aP2;
      conceptomotivosegresoloaddvcombo.this.AV18CliCod = aP3;
      conceptomotivosegresoloaddvcombo.this.AV32ConCodigo = aP4;
      conceptomotivosegresoloaddvcombo.this.AV20MegCodigo = aP5;
      conceptomotivosegresoloaddvcombo.this.AV33ConMegSec = aP6;
      conceptomotivosegresoloaddvcombo.this.AV30Cond_CliCod = aP7;
      conceptomotivosegresoloaddvcombo.this.AV12SearchTxt = aP8;
      conceptomotivosegresoloaddvcombo.this.aP9 = aP9;
      conceptomotivosegresoloaddvcombo.this.aP10 = aP10;
      conceptomotivosegresoloaddvcombo.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoMotivosEgreso", GXv_boolean2) ;
      conceptomotivosegresoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         else if ( GXutil.strcmp(AV15ComboName, "MegCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MEGCODIGO' */
            S121 ();
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
         /* Using cursor P01KO2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A344CliNom = P01KO2_A344CliNom[0] ;
            A3CliCod = P01KO2_A3CliCod[0] ;
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
         AV26Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01KO3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV32ConCodigo, AV20MegCodigo, Short.valueOf(AV33ConMegSec)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2077ConMegSec = P01KO3_A2077ConMegSec[0] ;
               A11MegCodigo = P01KO3_A11MegCodigo[0] ;
               A26ConCodigo = P01KO3_A26ConCodigo[0] ;
               A3CliCod = P01KO3_A3CliCod[0] ;
               A344CliNom = P01KO3_A344CliNom[0] ;
               A344CliNom = P01KO3_A344CliNom[0] ;
               AV24SelectedValue = ((0==A3CliCod) ? "" : GXutil.trim( GXutil.str( A3CliCod, 6, 0))) ;
               AV25SelectedText = A344CliNom ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV18CliCod) )
            {
               AV24SelectedValue = GXutil.trim( GXutil.str( AV18CliCod, 6, 0)) ;
               /* Using cursor P01KO4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV18CliCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A3CliCod = P01KO4_A3CliCod[0] ;
                  A344CliNom = P01KO4_A344CliNom[0] ;
                  AV25SelectedText = A344CliNom ;
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
      /* 'LOADCOMBOITEMS_MEGCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A300MegDescrip ,
                                              Integer.valueOf(AV30Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KO5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV30Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A300MegDescrip = P01KO5_A300MegDescrip[0] ;
            A3CliCod = P01KO5_A3CliCod[0] ;
            A11MegCodigo = P01KO5_A11MegCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A11MegCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A300MegDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV26Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01KO6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), AV32ConCodigo, AV20MegCodigo, Short.valueOf(AV33ConMegSec)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A2077ConMegSec = P01KO6_A2077ConMegSec[0] ;
               A11MegCodigo = P01KO6_A11MegCodigo[0] ;
               A26ConCodigo = P01KO6_A26ConCodigo[0] ;
               A3CliCod = P01KO6_A3CliCod[0] ;
               A300MegDescrip = P01KO6_A300MegDescrip[0] ;
               A300MegDescrip = P01KO6_A300MegDescrip[0] ;
               AV24SelectedValue = A11MegCodigo ;
               AV25SelectedText = A300MegDescrip ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV20MegCodigo)==0) )
            {
               AV24SelectedValue = AV20MegCodigo ;
               /* Using cursor P01KO7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(AV30Cond_CliCod), AV20MegCodigo});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A3CliCod = P01KO7_A3CliCod[0] ;
                  A11MegCodigo = P01KO7_A11MegCodigo[0] ;
                  A300MegDescrip = P01KO7_A300MegDescrip[0] ;
                  AV25SelectedText = A300MegDescrip ;
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
      /* 'LOADCOMBOITEMS_CONCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A42ConCodYDesc ,
                                              Integer.valueOf(AV30Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01KO8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(AV30Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A42ConCodYDesc = P01KO8_A42ConCodYDesc[0] ;
            n42ConCodYDesc = P01KO8_n42ConCodYDesc[0] ;
            A3CliCod = P01KO8_A3CliCod[0] ;
            A26ConCodigo = P01KO8_A26ConCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(6);
         }
         pr_default.close(6);
         AV26Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01KO9 */
            pr_default.execute(7, new Object[] {Integer.valueOf(AV18CliCod), AV32ConCodigo, AV20MegCodigo, Short.valueOf(AV33ConMegSec)});
            while ( (pr_default.getStatus(7) != 101) )
            {
               A2077ConMegSec = P01KO9_A2077ConMegSec[0] ;
               A11MegCodigo = P01KO9_A11MegCodigo[0] ;
               A26ConCodigo = P01KO9_A26ConCodigo[0] ;
               A3CliCod = P01KO9_A3CliCod[0] ;
               A42ConCodYDesc = P01KO9_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P01KO9_n42ConCodYDesc[0] ;
               A42ConCodYDesc = P01KO9_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P01KO9_n42ConCodYDesc[0] ;
               AV24SelectedValue = A26ConCodigo ;
               AV25SelectedText = A42ConCodYDesc ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(7);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV32ConCodigo)==0) )
            {
               AV24SelectedValue = AV32ConCodigo ;
               /* Using cursor P01KO10 */
               pr_default.execute(8, new Object[] {Integer.valueOf(AV30Cond_CliCod), AV32ConCodigo});
               while ( (pr_default.getStatus(8) != 101) )
               {
                  A3CliCod = P01KO10_A3CliCod[0] ;
                  A26ConCodigo = P01KO10_A26ConCodigo[0] ;
                  A42ConCodYDesc = P01KO10_A42ConCodYDesc[0] ;
                  n42ConCodYDesc = P01KO10_n42ConCodYDesc[0] ;
                  AV25SelectedText = A42ConCodYDesc ;
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
      this.aP9[0] = conceptomotivosegresoloaddvcombo.this.AV24SelectedValue;
      this.aP10[0] = conceptomotivosegresoloaddvcombo.this.AV25SelectedText;
      this.aP11[0] = conceptomotivosegresoloaddvcombo.this.AV26Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24SelectedValue = "" ;
      AV25SelectedText = "" ;
      AV26Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A344CliNom = "" ;
      P01KO2_A344CliNom = new String[] {""} ;
      P01KO2_A3CliCod = new int[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01KO3_A2077ConMegSec = new short[1] ;
      P01KO3_A11MegCodigo = new String[] {""} ;
      P01KO3_A26ConCodigo = new String[] {""} ;
      P01KO3_A3CliCod = new int[1] ;
      P01KO3_A344CliNom = new String[] {""} ;
      A11MegCodigo = "" ;
      A26ConCodigo = "" ;
      P01KO4_A3CliCod = new int[1] ;
      P01KO4_A344CliNom = new String[] {""} ;
      A300MegDescrip = "" ;
      P01KO5_A300MegDescrip = new String[] {""} ;
      P01KO5_A3CliCod = new int[1] ;
      P01KO5_A11MegCodigo = new String[] {""} ;
      P01KO6_A2077ConMegSec = new short[1] ;
      P01KO6_A11MegCodigo = new String[] {""} ;
      P01KO6_A26ConCodigo = new String[] {""} ;
      P01KO6_A3CliCod = new int[1] ;
      P01KO6_A300MegDescrip = new String[] {""} ;
      P01KO7_A3CliCod = new int[1] ;
      P01KO7_A11MegCodigo = new String[] {""} ;
      P01KO7_A300MegDescrip = new String[] {""} ;
      A42ConCodYDesc = "" ;
      P01KO8_A42ConCodYDesc = new String[] {""} ;
      P01KO8_n42ConCodYDesc = new boolean[] {false} ;
      P01KO8_A3CliCod = new int[1] ;
      P01KO8_A26ConCodigo = new String[] {""} ;
      P01KO9_A2077ConMegSec = new short[1] ;
      P01KO9_A11MegCodigo = new String[] {""} ;
      P01KO9_A26ConCodigo = new String[] {""} ;
      P01KO9_A3CliCod = new int[1] ;
      P01KO9_A42ConCodYDesc = new String[] {""} ;
      P01KO9_n42ConCodYDesc = new boolean[] {false} ;
      P01KO10_A3CliCod = new int[1] ;
      P01KO10_A26ConCodigo = new String[] {""} ;
      P01KO10_A42ConCodYDesc = new String[] {""} ;
      P01KO10_n42ConCodYDesc = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptomotivosegresoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01KO2_A344CliNom, P01KO2_A3CliCod
            }
            , new Object[] {
            P01KO3_A2077ConMegSec, P01KO3_A11MegCodigo, P01KO3_A26ConCodigo, P01KO3_A3CliCod, P01KO3_A344CliNom
            }
            , new Object[] {
            P01KO4_A3CliCod, P01KO4_A344CliNom
            }
            , new Object[] {
            P01KO5_A300MegDescrip, P01KO5_A3CliCod, P01KO5_A11MegCodigo
            }
            , new Object[] {
            P01KO6_A2077ConMegSec, P01KO6_A11MegCodigo, P01KO6_A26ConCodigo, P01KO6_A3CliCod, P01KO6_A300MegDescrip
            }
            , new Object[] {
            P01KO7_A3CliCod, P01KO7_A11MegCodigo, P01KO7_A300MegDescrip
            }
            , new Object[] {
            P01KO8_A42ConCodYDesc, P01KO8_n42ConCodYDesc, P01KO8_A3CliCod, P01KO8_A26ConCodigo
            }
            , new Object[] {
            P01KO9_A2077ConMegSec, P01KO9_A11MegCodigo, P01KO9_A26ConCodigo, P01KO9_A3CliCod, P01KO9_A42ConCodYDesc, P01KO9_n42ConCodYDesc
            }
            , new Object[] {
            P01KO10_A3CliCod, P01KO10_A26ConCodigo, P01KO10_A42ConCodYDesc, P01KO10_n42ConCodYDesc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV33ConMegSec ;
   private short A2077ConMegSec ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV30Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV32ConCodigo ;
   private String AV20MegCodigo ;
   private String scmdbuf ;
   private String A11MegCodigo ;
   private String A26ConCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n42ConCodYDesc ;
   private String AV26Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV24SelectedValue ;
   private String AV25SelectedText ;
   private String lV12SearchTxt ;
   private String A344CliNom ;
   private String A300MegDescrip ;
   private String A42ConCodYDesc ;
   private String[] aP11 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private String[] P01KO2_A344CliNom ;
   private int[] P01KO2_A3CliCod ;
   private short[] P01KO3_A2077ConMegSec ;
   private String[] P01KO3_A11MegCodigo ;
   private String[] P01KO3_A26ConCodigo ;
   private int[] P01KO3_A3CliCod ;
   private String[] P01KO3_A344CliNom ;
   private int[] P01KO4_A3CliCod ;
   private String[] P01KO4_A344CliNom ;
   private String[] P01KO5_A300MegDescrip ;
   private int[] P01KO5_A3CliCod ;
   private String[] P01KO5_A11MegCodigo ;
   private short[] P01KO6_A2077ConMegSec ;
   private String[] P01KO6_A11MegCodigo ;
   private String[] P01KO6_A26ConCodigo ;
   private int[] P01KO6_A3CliCod ;
   private String[] P01KO6_A300MegDescrip ;
   private int[] P01KO7_A3CliCod ;
   private String[] P01KO7_A11MegCodigo ;
   private String[] P01KO7_A300MegDescrip ;
   private String[] P01KO8_A42ConCodYDesc ;
   private boolean[] P01KO8_n42ConCodYDesc ;
   private int[] P01KO8_A3CliCod ;
   private String[] P01KO8_A26ConCodigo ;
   private short[] P01KO9_A2077ConMegSec ;
   private String[] P01KO9_A11MegCodigo ;
   private String[] P01KO9_A26ConCodigo ;
   private int[] P01KO9_A3CliCod ;
   private String[] P01KO9_A42ConCodYDesc ;
   private boolean[] P01KO9_n42ConCodYDesc ;
   private int[] P01KO10_A3CliCod ;
   private String[] P01KO10_A26ConCodigo ;
   private String[] P01KO10_A42ConCodYDesc ;
   private boolean[] P01KO10_n42ConCodYDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class conceptomotivosegresoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KO2( ModelContext context ,
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

   protected Object[] conditional_P01KO5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A300MegDescrip ,
                                          int AV30Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT MegDescrip, CliCod, MegCodigo FROM MotivoEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(MegDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, MegDescrip" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01KO8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A42ConCodYDesc ,
                                          int AV30Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT ConCodYDesc, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConCodYDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodYDesc" ;
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
                  return conditional_P01KO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01KO5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
            case 6 :
                  return conditional_P01KO8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KO3", "SELECT T1.ConMegSec, T1.MegCodigo, T1.ConCodigo, T1.CliCod, T2.CliNom FROM (ConceptoMotivosEgreso T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.MegCodigo = ( ?) and T1.ConMegSec = ? ORDER BY T1.CliCod, T1.ConCodigo, T1.MegCodigo, T1.ConMegSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KO4", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KO5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KO6", "SELECT T1.ConMegSec, T1.MegCodigo, T1.ConCodigo, T1.CliCod, T2.MegDescrip FROM (ConceptoMotivosEgreso T1 INNER JOIN MotivoEgreso T2 ON T2.CliCod = T1.CliCod AND T2.MegCodigo = T1.MegCodigo) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.MegCodigo = ( ?) and T1.ConMegSec = ? ORDER BY T1.CliCod, T1.ConCodigo, T1.MegCodigo, T1.ConMegSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KO7", "SELECT CliCod, MegCodigo, MegDescrip FROM MotivoEgreso WHERE CliCod = ? and MegCodigo = ( ?) ORDER BY CliCod, MegCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KO8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KO9", "SELECT T1.ConMegSec, T1.MegCodigo, T1.ConCodigo, T1.CliCod, T2.ConCodYDesc FROM (ConceptoMotivosEgreso T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.MegCodigo = ( ?) and T1.ConMegSec = ? ORDER BY T1.CliCod, T1.ConCodigo, T1.MegCodigo, T1.ConMegSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01KO10", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

