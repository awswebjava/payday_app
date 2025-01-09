package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class feriadoloaddvcombo extends GXProcedure
{
   public feriadoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriadoloaddvcombo.class ), "" );
   }

   public feriadoloaddvcombo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             short aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      feriadoloaddvcombo.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        short aP5 ,
                        String aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             short aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      feriadoloaddvcombo.this.AV15ComboName = aP0;
      feriadoloaddvcombo.this.AV16TrnMode = aP1;
      feriadoloaddvcombo.this.AV17IsDynamicCall = aP2;
      feriadoloaddvcombo.this.AV18PaiCod = aP3;
      feriadoloaddvcombo.this.AV19FerId = aP4;
      feriadoloaddvcombo.this.AV30Cond_PaiCod = aP5;
      feriadoloaddvcombo.this.AV12SearchTxt = aP6;
      feriadoloaddvcombo.this.aP7 = aP7;
      feriadoloaddvcombo.this.aP8 = aP8;
      feriadoloaddvcombo.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado", GXv_boolean2) ;
      feriadoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "FerReligId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_FERRELIGID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "FerOrigId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_FERORIGID' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "FeriadoConvenio") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_FERIADOCONVENIO' */
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
      /* 'LOADCOMBOITEMS_FERRELIGID' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1286PaiRelNom ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV30Cond_PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P01HO2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV30Cond_PaiCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1229ReligId = P01HO2_A1229ReligId[0] ;
            A1283ReligNombre = P01HO2_A1283ReligNombre[0] ;
            A46PaiCod = P01HO2_A46PaiCod[0] ;
            A1253PaiReligion = P01HO2_A1253PaiReligion[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1253PaiReligion );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1286PaiRelNom );
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
               /* Using cursor P01HO3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV18PaiCod), AV19FerId});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1223FerId = P01HO3_A1223FerId[0] ;
                  A46PaiCod = P01HO3_A46PaiCod[0] ;
                  A1230FerReligId = P01HO3_A1230FerReligId[0] ;
                  n1230FerReligId = P01HO3_n1230FerReligId[0] ;
                  AV20SelectedValue = A1230FerReligId ;
                  AV27Cond_Aux_PaiCod = A46PaiCod ;
                  AV26PaiReligion = A1230FerReligId ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV26PaiReligion = AV12SearchTxt ;
               AV27Cond_Aux_PaiCod = AV30Cond_PaiCod ;
            }
            /* Using cursor P01HO4 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV27Cond_Aux_PaiCod), AV26PaiReligion});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1229ReligId = P01HO4_A1229ReligId[0] ;
               A1283ReligNombre = P01HO4_A1283ReligNombre[0] ;
               A46PaiCod = P01HO4_A46PaiCod[0] ;
               A1253PaiReligion = P01HO4_A1253PaiReligion[0] ;
               AV21SelectedText = A1286PaiRelNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_FERORIGID' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1285PaiOrigNom ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV30Cond_PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P01HO5 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV30Cond_PaiCod)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A1231OrigId = P01HO5_A1231OrigId[0] ;
            A1284OrigNombre = P01HO5_A1284OrigNombre[0] ;
            A46PaiCod = P01HO5_A46PaiCod[0] ;
            A1282PaiOrigen = P01HO5_A1282PaiOrigen[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1282PaiOrigen );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1285PaiOrigNom );
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
               /* Using cursor P01HO6 */
               pr_default.execute(4, new Object[] {Short.valueOf(AV18PaiCod), AV19FerId});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A1223FerId = P01HO6_A1223FerId[0] ;
                  A46PaiCod = P01HO6_A46PaiCod[0] ;
                  A1232FerOrigId = P01HO6_A1232FerOrigId[0] ;
                  n1232FerOrigId = P01HO6_n1232FerOrigId[0] ;
                  AV20SelectedValue = A1232FerOrigId ;
                  AV27Cond_Aux_PaiCod = A46PaiCod ;
                  AV28PaiOrigen = A1232FerOrigId ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV28PaiOrigen = AV12SearchTxt ;
               AV27Cond_Aux_PaiCod = AV30Cond_PaiCod ;
            }
            /* Using cursor P01HO7 */
            pr_default.execute(5, new Object[] {Short.valueOf(AV27Cond_Aux_PaiCod), AV28PaiOrigen});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A1231OrigId = P01HO7_A1231OrigId[0] ;
               A1284OrigNombre = P01HO7_A1284OrigNombre[0] ;
               A46PaiCod = P01HO7_A46PaiCod[0] ;
               A1282PaiOrigen = P01HO7_A1282PaiOrigen[0] ;
               AV21SelectedText = A1285PaiOrigNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(5);
         }
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_FERIADOCONVENIO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A160ConveDescri ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV30Cond_PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01HO8 */
         pr_default.execute(6, new Object[] {Short.valueOf(AV30Cond_PaiCod), lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A46PaiCod = P01HO8_A46PaiCod[0] ;
            A160ConveDescri = P01HO8_A160ConveDescri[0] ;
            A9ConveCodigo = P01HO8_A9ConveCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A9ConveCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A160ConveDescri );
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
               /* Using cursor P01HO9 */
               pr_default.execute(7, new Object[] {Short.valueOf(AV18PaiCod), AV19FerId});
               while ( (pr_default.getStatus(7) != 101) )
               {
                  A1223FerId = P01HO9_A1223FerId[0] ;
                  A46PaiCod = P01HO9_A46PaiCod[0] ;
                  A1234FeriadoConvenio = P01HO9_A1234FeriadoConvenio[0] ;
                  n1234FeriadoConvenio = P01HO9_n1234FeriadoConvenio[0] ;
                  AV20SelectedValue = A1234FeriadoConvenio ;
                  AV27Cond_Aux_PaiCod = A46PaiCod ;
                  AV33ConveCodigo = A1234FeriadoConvenio ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(7);
            }
            else
            {
               AV33ConveCodigo = AV12SearchTxt ;
               AV27Cond_Aux_PaiCod = AV30Cond_PaiCod ;
            }
            /* Using cursor P01HO10 */
            pr_default.execute(8, new Object[] {Short.valueOf(AV27Cond_Aux_PaiCod), AV33ConveCodigo});
            while ( (pr_default.getStatus(8) != 101) )
            {
               A46PaiCod = P01HO10_A46PaiCod[0] ;
               A9ConveCodigo = P01HO10_A9ConveCodigo[0] ;
               A160ConveDescri = P01HO10_A160ConveDescri[0] ;
               AV21SelectedText = A160ConveDescri ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(8);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = feriadoloaddvcombo.this.AV20SelectedValue;
      this.aP8[0] = feriadoloaddvcombo.this.AV21SelectedText;
      this.aP9[0] = feriadoloaddvcombo.this.AV22Combo_DataJson;
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
      A1286PaiRelNom = "" ;
      P01HO2_A1229ReligId = new String[] {""} ;
      P01HO2_A1283ReligNombre = new String[] {""} ;
      P01HO2_A46PaiCod = new short[1] ;
      P01HO2_A1253PaiReligion = new String[] {""} ;
      A1229ReligId = "" ;
      A1283ReligNombre = "" ;
      A1253PaiReligion = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01HO3_A1223FerId = new String[] {""} ;
      P01HO3_A46PaiCod = new short[1] ;
      P01HO3_A1230FerReligId = new String[] {""} ;
      P01HO3_n1230FerReligId = new boolean[] {false} ;
      A1223FerId = "" ;
      A1230FerReligId = "" ;
      AV26PaiReligion = "" ;
      P01HO4_A1229ReligId = new String[] {""} ;
      P01HO4_A1283ReligNombre = new String[] {""} ;
      P01HO4_A46PaiCod = new short[1] ;
      P01HO4_A1253PaiReligion = new String[] {""} ;
      A1285PaiOrigNom = "" ;
      P01HO5_A1231OrigId = new String[] {""} ;
      P01HO5_A1284OrigNombre = new String[] {""} ;
      P01HO5_A46PaiCod = new short[1] ;
      P01HO5_A1282PaiOrigen = new String[] {""} ;
      A1231OrigId = "" ;
      A1284OrigNombre = "" ;
      A1282PaiOrigen = "" ;
      P01HO6_A1223FerId = new String[] {""} ;
      P01HO6_A46PaiCod = new short[1] ;
      P01HO6_A1232FerOrigId = new String[] {""} ;
      P01HO6_n1232FerOrigId = new boolean[] {false} ;
      A1232FerOrigId = "" ;
      AV28PaiOrigen = "" ;
      P01HO7_A1231OrigId = new String[] {""} ;
      P01HO7_A1284OrigNombre = new String[] {""} ;
      P01HO7_A46PaiCod = new short[1] ;
      P01HO7_A1282PaiOrigen = new String[] {""} ;
      lV12SearchTxt = "" ;
      A160ConveDescri = "" ;
      P01HO8_A46PaiCod = new short[1] ;
      P01HO8_A160ConveDescri = new String[] {""} ;
      P01HO8_A9ConveCodigo = new String[] {""} ;
      A9ConveCodigo = "" ;
      P01HO9_A1223FerId = new String[] {""} ;
      P01HO9_A46PaiCod = new short[1] ;
      P01HO9_A1234FeriadoConvenio = new String[] {""} ;
      P01HO9_n1234FeriadoConvenio = new boolean[] {false} ;
      A1234FeriadoConvenio = "" ;
      AV33ConveCodigo = "" ;
      P01HO10_A46PaiCod = new short[1] ;
      P01HO10_A9ConveCodigo = new String[] {""} ;
      P01HO10_A160ConveDescri = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriadoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01HO2_A1229ReligId, P01HO2_A1283ReligNombre, P01HO2_A46PaiCod, P01HO2_A1253PaiReligion
            }
            , new Object[] {
            P01HO3_A1223FerId, P01HO3_A46PaiCod, P01HO3_A1230FerReligId, P01HO3_n1230FerReligId
            }
            , new Object[] {
            P01HO4_A1229ReligId, P01HO4_A1283ReligNombre, P01HO4_A46PaiCod, P01HO4_A1253PaiReligion
            }
            , new Object[] {
            P01HO5_A1231OrigId, P01HO5_A1284OrigNombre, P01HO5_A46PaiCod, P01HO5_A1282PaiOrigen
            }
            , new Object[] {
            P01HO6_A1223FerId, P01HO6_A46PaiCod, P01HO6_A1232FerOrigId, P01HO6_n1232FerOrigId
            }
            , new Object[] {
            P01HO7_A1231OrigId, P01HO7_A1284OrigNombre, P01HO7_A46PaiCod, P01HO7_A1282PaiOrigen
            }
            , new Object[] {
            P01HO8_A46PaiCod, P01HO8_A160ConveDescri, P01HO8_A9ConveCodigo
            }
            , new Object[] {
            P01HO9_A1223FerId, P01HO9_A46PaiCod, P01HO9_A1234FeriadoConvenio, P01HO9_n1234FeriadoConvenio
            }
            , new Object[] {
            P01HO10_A46PaiCod, P01HO10_A9ConveCodigo, P01HO10_A160ConveDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18PaiCod ;
   private short AV30Cond_PaiCod ;
   private short A46PaiCod ;
   private short AV27Cond_Aux_PaiCod ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV16TrnMode ;
   private String AV19FerId ;
   private String scmdbuf ;
   private String A1229ReligId ;
   private String A1253PaiReligion ;
   private String A1223FerId ;
   private String A1230FerReligId ;
   private String AV26PaiReligion ;
   private String A1231OrigId ;
   private String A1282PaiOrigen ;
   private String A1232FerOrigId ;
   private String AV28PaiOrigen ;
   private String A9ConveCodigo ;
   private String A1234FeriadoConvenio ;
   private String AV33ConveCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private String AV22Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV20SelectedValue ;
   private String AV21SelectedText ;
   private String A1286PaiRelNom ;
   private String A1283ReligNombre ;
   private String A1285PaiOrigNom ;
   private String A1284OrigNombre ;
   private String lV12SearchTxt ;
   private String A160ConveDescri ;
   private String[] aP9 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HO2_A1229ReligId ;
   private String[] P01HO2_A1283ReligNombre ;
   private short[] P01HO2_A46PaiCod ;
   private String[] P01HO2_A1253PaiReligion ;
   private String[] P01HO3_A1223FerId ;
   private short[] P01HO3_A46PaiCod ;
   private String[] P01HO3_A1230FerReligId ;
   private boolean[] P01HO3_n1230FerReligId ;
   private String[] P01HO4_A1229ReligId ;
   private String[] P01HO4_A1283ReligNombre ;
   private short[] P01HO4_A46PaiCod ;
   private String[] P01HO4_A1253PaiReligion ;
   private String[] P01HO5_A1231OrigId ;
   private String[] P01HO5_A1284OrigNombre ;
   private short[] P01HO5_A46PaiCod ;
   private String[] P01HO5_A1282PaiOrigen ;
   private String[] P01HO6_A1223FerId ;
   private short[] P01HO6_A46PaiCod ;
   private String[] P01HO6_A1232FerOrigId ;
   private boolean[] P01HO6_n1232FerOrigId ;
   private String[] P01HO7_A1231OrigId ;
   private String[] P01HO7_A1284OrigNombre ;
   private short[] P01HO7_A46PaiCod ;
   private String[] P01HO7_A1282PaiOrigen ;
   private short[] P01HO8_A46PaiCod ;
   private String[] P01HO8_A160ConveDescri ;
   private String[] P01HO8_A9ConveCodigo ;
   private String[] P01HO9_A1223FerId ;
   private short[] P01HO9_A46PaiCod ;
   private String[] P01HO9_A1234FeriadoConvenio ;
   private boolean[] P01HO9_n1234FeriadoConvenio ;
   private short[] P01HO10_A46PaiCod ;
   private String[] P01HO10_A9ConveCodigo ;
   private String[] P01HO10_A160ConveDescri ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class feriadoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1286PaiRelNom ,
                                          short A46PaiCod ,
                                          short AV30Cond_PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.ReligId, T2.ReligNombre, T1.PaiCod, T1.PaiReligion FROM (PaisReligion T1 INNER JOIN Religion T2 ON T2.ReligId = T1.PaiReligion)" ;
      addWhere(sWhereString, "(T1.PaiCod = ?)");
      scmdbuf += sWhereString ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01HO5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1285PaiOrigNom ,
                                          short A46PaiCod ,
                                          short AV30Cond_PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T2.OrigId, T2.OrigNombre, T1.PaiCod, T1.PaiOrigen FROM (PaisOrigen T1 INNER JOIN Origen T2 ON T2.OrigId = T1.PaiOrigen)" ;
      addWhere(sWhereString, "(T1.PaiCod = ?)");
      scmdbuf += sWhereString ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01HO8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A160ConveDescri ,
                                          short A46PaiCod ,
                                          short AV30Cond_PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PaiCod, ConveDescri, ConveCodigo FROM Convenio" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConveDescri) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveDescri" ;
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
                  return conditional_P01HO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
            case 3 :
                  return conditional_P01HO5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
            case 6 :
                  return conditional_P01HO8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HO3", "SELECT FerId, PaiCod, FerReligId FROM feriado WHERE PaiCod = ? and FerId = ( ?) ORDER BY PaiCod, FerId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HO4", "SELECT T2.ReligId, T2.ReligNombre, T1.PaiCod, T1.PaiReligion FROM (PaisReligion T1 INNER JOIN Religion T2 ON T2.ReligId = T1.PaiReligion) WHERE T1.PaiCod = ? and T1.PaiReligion = ( ?) ORDER BY T1.PaiCod, T1.PaiReligion  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HO5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HO6", "SELECT FerId, PaiCod, FerOrigId FROM feriado WHERE PaiCod = ? and FerId = ( ?) ORDER BY PaiCod, FerId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HO7", "SELECT T2.OrigId, T2.OrigNombre, T1.PaiCod, T1.PaiOrigen FROM (PaisOrigen T1 INNER JOIN Origen T2 ON T2.OrigId = T1.PaiOrigen) WHERE T1.PaiCod = ? and T1.PaiOrigen = ( ?) ORDER BY T1.PaiCod, T1.PaiOrigen  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HO8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HO9", "SELECT FerId, PaiCod, FeriadoConvenio FROM feriado WHERE PaiCod = ? and FerId = ( ?) ORDER BY PaiCod, FerId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HO10", "SELECT PaiCod, ConveCodigo, ConveDescri FROM Convenio WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
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
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

