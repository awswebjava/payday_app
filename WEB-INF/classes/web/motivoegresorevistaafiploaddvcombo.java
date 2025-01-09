package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class motivoegresorevistaafiploaddvcombo extends GXProcedure
{
   public motivoegresorevistaafiploaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresorevistaafiploaddvcombo.class ), "" );
   }

   public motivoegresorevistaafiploaddvcombo( int remoteHandle ,
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
                             short aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      motivoegresorevistaafiploaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        short aP5 ,
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
                             short aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      motivoegresorevistaafiploaddvcombo.this.AV15ComboName = aP0;
      motivoegresorevistaafiploaddvcombo.this.AV16TrnMode = aP1;
      motivoegresorevistaafiploaddvcombo.this.AV17IsDynamicCall = aP2;
      motivoegresorevistaafiploaddvcombo.this.AV18CliCod = aP3;
      motivoegresorevistaafiploaddvcombo.this.AV19MegCodigo = aP4;
      motivoegresorevistaafiploaddvcombo.this.AV20MegSitRevista = aP5;
      motivoegresorevistaafiploaddvcombo.this.AV28Cond_CliCod = aP6;
      motivoegresorevistaafiploaddvcombo.this.AV12SearchTxt = aP7;
      motivoegresorevistaafiploaddvcombo.this.aP8 = aP8;
      motivoegresorevistaafiploaddvcombo.this.aP9 = aP9;
      motivoegresorevistaafiploaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip", GXv_boolean2) ;
      motivoegresorevistaafiploaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         else if ( GXutil.strcmp(AV15ComboName, "MegSitRevista") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MEGSITREVISTA' */
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
         /* Using cursor P01JX2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A344CliNom = P01JX2_A344CliNom[0] ;
            A3CliCod = P01JX2_A3CliCod[0] ;
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
            /* Using cursor P01JX3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19MegCodigo, Short.valueOf(AV20MegSitRevista)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1601MegSitRevista = P01JX3_A1601MegSitRevista[0] ;
               A11MegCodigo = P01JX3_A11MegCodigo[0] ;
               A3CliCod = P01JX3_A3CliCod[0] ;
               A344CliNom = P01JX3_A344CliNom[0] ;
               A344CliNom = P01JX3_A344CliNom[0] ;
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
               /* Using cursor P01JX4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV18CliCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A3CliCod = P01JX4_A3CliCod[0] ;
                  A344CliNom = P01JX4_A344CliNom[0] ;
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
      /* 'LOADCOMBOITEMS_MEGCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A300MegDescrip ,
                                              Integer.valueOf(AV28Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01JX5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV28Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A300MegDescrip = P01JX5_A300MegDescrip[0] ;
            A3CliCod = P01JX5_A3CliCod[0] ;
            A11MegCodigo = P01JX5_A11MegCodigo[0] ;
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
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01JX6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), AV19MegCodigo, Short.valueOf(AV20MegSitRevista)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A1601MegSitRevista = P01JX6_A1601MegSitRevista[0] ;
               A11MegCodigo = P01JX6_A11MegCodigo[0] ;
               A3CliCod = P01JX6_A3CliCod[0] ;
               A300MegDescrip = P01JX6_A300MegDescrip[0] ;
               A300MegDescrip = P01JX6_A300MegDescrip[0] ;
               AV21SelectedValue = A11MegCodigo ;
               AV22SelectedText = A300MegDescrip ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV19MegCodigo)==0) )
            {
               AV21SelectedValue = AV19MegCodigo ;
               /* Using cursor P01JX7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(AV28Cond_CliCod), AV19MegCodigo});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A3CliCod = P01JX7_A3CliCod[0] ;
                  A11MegCodigo = P01JX7_A11MegCodigo[0] ;
                  A300MegDescrip = P01JX7_A300MegDescrip[0] ;
                  AV22SelectedText = A300MegDescrip ;
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
      /* 'LOADCOMBOITEMS_MEGSITREVISTA' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1596SitRevDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01JX8 */
         pr_default.execute(6, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A1596SitRevDescrip = P01JX8_A1596SitRevDescrip[0] ;
            A1595SitRevCodigo = P01JX8_A1595SitRevCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1595SitRevCodigo, 3, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1596SitRevDescrip );
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
            /* Using cursor P01JX9 */
            pr_default.execute(7, new Object[] {Integer.valueOf(AV18CliCod), AV19MegCodigo, Short.valueOf(AV20MegSitRevista)});
            while ( (pr_default.getStatus(7) != 101) )
            {
               A1601MegSitRevista = P01JX9_A1601MegSitRevista[0] ;
               A11MegCodigo = P01JX9_A11MegCodigo[0] ;
               A3CliCod = P01JX9_A3CliCod[0] ;
               AV21SelectedValue = ((0==A1601MegSitRevista) ? "" : GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0))) ;
               AV27SitRevCodigo = A1601MegSitRevista ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(7);
            /* Using cursor P01JX10 */
            pr_default.execute(8, new Object[] {Short.valueOf(AV27SitRevCodigo)});
            while ( (pr_default.getStatus(8) != 101) )
            {
               A1595SitRevCodigo = P01JX10_A1595SitRevCodigo[0] ;
               A1596SitRevDescrip = P01JX10_A1596SitRevDescrip[0] ;
               AV22SelectedText = A1596SitRevDescrip ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(8);
         }
         else
         {
            if ( ! (0==AV20MegSitRevista) )
            {
               AV21SelectedValue = GXutil.trim( GXutil.str( AV20MegSitRevista, 3, 0)) ;
               /* Using cursor P01JX11 */
               pr_default.execute(9, new Object[] {Short.valueOf(AV20MegSitRevista)});
               while ( (pr_default.getStatus(9) != 101) )
               {
                  A1595SitRevCodigo = P01JX11_A1595SitRevCodigo[0] ;
                  A1596SitRevDescrip = P01JX11_A1596SitRevDescrip[0] ;
                  AV22SelectedText = A1596SitRevDescrip ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(9);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = motivoegresorevistaafiploaddvcombo.this.AV21SelectedValue;
      this.aP9[0] = motivoegresorevistaafiploaddvcombo.this.AV22SelectedText;
      this.aP10[0] = motivoegresorevistaafiploaddvcombo.this.AV23Combo_DataJson;
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
      P01JX2_A344CliNom = new String[] {""} ;
      P01JX2_A3CliCod = new int[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01JX3_A1601MegSitRevista = new short[1] ;
      P01JX3_A11MegCodigo = new String[] {""} ;
      P01JX3_A3CliCod = new int[1] ;
      P01JX3_A344CliNom = new String[] {""} ;
      A11MegCodigo = "" ;
      P01JX4_A3CliCod = new int[1] ;
      P01JX4_A344CliNom = new String[] {""} ;
      A300MegDescrip = "" ;
      P01JX5_A300MegDescrip = new String[] {""} ;
      P01JX5_A3CliCod = new int[1] ;
      P01JX5_A11MegCodigo = new String[] {""} ;
      P01JX6_A1601MegSitRevista = new short[1] ;
      P01JX6_A11MegCodigo = new String[] {""} ;
      P01JX6_A3CliCod = new int[1] ;
      P01JX6_A300MegDescrip = new String[] {""} ;
      P01JX7_A3CliCod = new int[1] ;
      P01JX7_A11MegCodigo = new String[] {""} ;
      P01JX7_A300MegDescrip = new String[] {""} ;
      A1596SitRevDescrip = "" ;
      P01JX8_A1596SitRevDescrip = new String[] {""} ;
      P01JX8_A1595SitRevCodigo = new short[1] ;
      P01JX9_A1601MegSitRevista = new short[1] ;
      P01JX9_A11MegCodigo = new String[] {""} ;
      P01JX9_A3CliCod = new int[1] ;
      P01JX10_A1595SitRevCodigo = new short[1] ;
      P01JX10_A1596SitRevDescrip = new String[] {""} ;
      P01JX11_A1595SitRevCodigo = new short[1] ;
      P01JX11_A1596SitRevDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegresorevistaafiploaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01JX2_A344CliNom, P01JX2_A3CliCod
            }
            , new Object[] {
            P01JX3_A1601MegSitRevista, P01JX3_A11MegCodigo, P01JX3_A3CliCod, P01JX3_A344CliNom
            }
            , new Object[] {
            P01JX4_A3CliCod, P01JX4_A344CliNom
            }
            , new Object[] {
            P01JX5_A300MegDescrip, P01JX5_A3CliCod, P01JX5_A11MegCodigo
            }
            , new Object[] {
            P01JX6_A1601MegSitRevista, P01JX6_A11MegCodigo, P01JX6_A3CliCod, P01JX6_A300MegDescrip
            }
            , new Object[] {
            P01JX7_A3CliCod, P01JX7_A11MegCodigo, P01JX7_A300MegDescrip
            }
            , new Object[] {
            P01JX8_A1596SitRevDescrip, P01JX8_A1595SitRevCodigo
            }
            , new Object[] {
            P01JX9_A1601MegSitRevista, P01JX9_A11MegCodigo, P01JX9_A3CliCod
            }
            , new Object[] {
            P01JX10_A1595SitRevCodigo, P01JX10_A1596SitRevDescrip
            }
            , new Object[] {
            P01JX11_A1595SitRevCodigo, P01JX11_A1596SitRevDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV20MegSitRevista ;
   private short A1601MegSitRevista ;
   private short A1595SitRevCodigo ;
   private short AV27SitRevCodigo ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV28Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV19MegCodigo ;
   private String scmdbuf ;
   private String A11MegCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV23Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A344CliNom ;
   private String A300MegDescrip ;
   private String A1596SitRevDescrip ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01JX2_A344CliNom ;
   private int[] P01JX2_A3CliCod ;
   private short[] P01JX3_A1601MegSitRevista ;
   private String[] P01JX3_A11MegCodigo ;
   private int[] P01JX3_A3CliCod ;
   private String[] P01JX3_A344CliNom ;
   private int[] P01JX4_A3CliCod ;
   private String[] P01JX4_A344CliNom ;
   private String[] P01JX5_A300MegDescrip ;
   private int[] P01JX5_A3CliCod ;
   private String[] P01JX5_A11MegCodigo ;
   private short[] P01JX6_A1601MegSitRevista ;
   private String[] P01JX6_A11MegCodigo ;
   private int[] P01JX6_A3CliCod ;
   private String[] P01JX6_A300MegDescrip ;
   private int[] P01JX7_A3CliCod ;
   private String[] P01JX7_A11MegCodigo ;
   private String[] P01JX7_A300MegDescrip ;
   private String[] P01JX8_A1596SitRevDescrip ;
   private short[] P01JX8_A1595SitRevCodigo ;
   private short[] P01JX9_A1601MegSitRevista ;
   private String[] P01JX9_A11MegCodigo ;
   private int[] P01JX9_A3CliCod ;
   private short[] P01JX10_A1595SitRevCodigo ;
   private String[] P01JX10_A1596SitRevDescrip ;
   private short[] P01JX11_A1595SitRevCodigo ;
   private String[] P01JX11_A1596SitRevDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class motivoegresorevistaafiploaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JX2( ModelContext context ,
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

   protected Object[] conditional_P01JX5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A300MegDescrip ,
                                          int AV28Cond_CliCod ,
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

   protected Object[] conditional_P01JX8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1596SitRevDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT SitRevDescrip, SitRevCodigo FROM SituacionRevistaAFIP" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SitRevDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitRevDescrip" ;
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
                  return conditional_P01JX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01JX5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
            case 6 :
                  return conditional_P01JX8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JX3", "SELECT T1.MegSitRevista, T1.MegCodigo, T1.CliCod, T2.CliNom FROM (MotivoEgresoRevistaAfip T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) and T1.MegSitRevista = ? ORDER BY T1.CliCod, T1.MegCodigo, T1.MegSitRevista ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JX4", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JX5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JX6", "SELECT T1.MegSitRevista, T1.MegCodigo, T1.CliCod, T2.MegDescrip FROM (MotivoEgresoRevistaAfip T1 INNER JOIN MotivoEgreso T2 ON T2.CliCod = T1.CliCod AND T2.MegCodigo = T1.MegCodigo) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) and T1.MegSitRevista = ? ORDER BY T1.CliCod, T1.MegCodigo, T1.MegSitRevista ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JX7", "SELECT CliCod, MegCodigo, MegDescrip FROM MotivoEgreso WHERE CliCod = ? and MegCodigo = ( ?) ORDER BY CliCod, MegCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JX8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JX9", "SELECT MegSitRevista, MegCodigo, CliCod FROM MotivoEgresoRevistaAfip WHERE CliCod = ? and MegCodigo = ( ?) and MegSitRevista = ? ORDER BY CliCod, MegCodigo, MegSitRevista ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JX10", "SELECT SitRevCodigo, SitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ORDER BY SitRevCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JX11", "SELECT SitRevCodigo, SitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ORDER BY SitRevCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 9 :
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

