package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientecct_fondoceseloaddvcombo extends GXProcedure
{
   public clientecct_fondoceseloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_fondoceseloaddvcombo.class ), "" );
   }

   public clientecct_fondoceseloaddvcombo( int remoteHandle ,
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
                             String aP5 ,
                             java.util.Date aP6 ,
                             short aP7 ,
                             int aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      clientecct_fondoceseloaddvcombo.this.aP14 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        short aP7 ,
                        int aP8 ,
                        short aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             short aP7 ,
                             int aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 )
   {
      clientecct_fondoceseloaddvcombo.this.AV15ComboName = aP0;
      clientecct_fondoceseloaddvcombo.this.AV16TrnMode = aP1;
      clientecct_fondoceseloaddvcombo.this.AV17IsDynamicCall = aP2;
      clientecct_fondoceseloaddvcombo.this.AV18CliCod = aP3;
      clientecct_fondoceseloaddvcombo.this.AV19CliPaiConve = aP4;
      clientecct_fondoceseloaddvcombo.this.AV20CliConvenio = aP5;
      clientecct_fondoceseloaddvcombo.this.AV21CliConveVig = aP6;
      clientecct_fondoceseloaddvcombo.this.AV22CliConveFondoSec = aP7;
      clientecct_fondoceseloaddvcombo.this.AV29Cond_CliCod = aP8;
      clientecct_fondoceseloaddvcombo.this.AV30Cond_CliPaiConve = aP9;
      clientecct_fondoceseloaddvcombo.this.AV31Cond_CliConvenio = aP10;
      clientecct_fondoceseloaddvcombo.this.AV12SearchTxt = aP11;
      clientecct_fondoceseloaddvcombo.this.aP12 = aP12;
      clientecct_fondoceseloaddvcombo.this.aP13 = aP13;
      clientecct_fondoceseloaddvcombo.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese", GXv_boolean2) ;
      clientecct_fondoceseloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "CliConvenio") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLICONVENIO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "CliConveVig") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLICONVEVIG' */
            S121 ();
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
      /* 'LOADCOMBOITEMS_CLICONVENIO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1567CliConvenioDescrip ,
                                              Integer.valueOf(A3CliCod) ,
                                              Integer.valueOf(AV29Cond_CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              Short.valueOf(AV30Cond_CliPaiConve) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P02212 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV29Cond_CliCod), Short.valueOf(AV30Cond_CliPaiConve), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P02212_A3CliCod[0] ;
            A1564CliPaiConve = P02212_A1564CliPaiConve[0] ;
            A1567CliConvenioDescrip = P02212_A1567CliConvenioDescrip[0] ;
            A1565CliConvenio = P02212_A1565CliConvenio[0] ;
            A1567CliConvenioDescrip = P02212_A1567CliConvenioDescrip[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1565CliConvenio );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1567CliConvenioDescrip );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV25Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P02213 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19CliPaiConve), AV20CliConvenio, AV21CliConveVig, Short.valueOf(AV22CliConveFondoSec)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2147CliConveFondoSec = P02213_A2147CliConveFondoSec[0] ;
               A1575CliConveVig = P02213_A1575CliConveVig[0] ;
               A1565CliConvenio = P02213_A1565CliConvenio[0] ;
               A1564CliPaiConve = P02213_A1564CliPaiConve[0] ;
               A3CliCod = P02213_A3CliCod[0] ;
               A1567CliConvenioDescrip = P02213_A1567CliConvenioDescrip[0] ;
               A1567CliConvenioDescrip = P02213_A1567CliConvenioDescrip[0] ;
               AV23SelectedValue = A1565CliConvenio ;
               AV24SelectedText = A1567CliConvenioDescrip ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV20CliConvenio)==0) )
            {
               AV23SelectedValue = AV20CliConvenio ;
               /* Using cursor P02214 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV29Cond_CliCod), Short.valueOf(AV30Cond_CliPaiConve), AV20CliConvenio});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1564CliPaiConve = P02214_A1564CliPaiConve[0] ;
                  A3CliCod = P02214_A3CliCod[0] ;
                  A1565CliConvenio = P02214_A1565CliConvenio[0] ;
                  A1567CliConvenioDescrip = P02214_A1567CliConvenioDescrip[0] ;
                  A1567CliConvenioDescrip = P02214_A1567CliConvenioDescrip[0] ;
                  AV24SelectedText = A1567CliConvenioDescrip ;
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
      /* 'LOADCOMBOITEMS_CLICONVEVIG' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         /* Using cursor P02215 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV29Cond_CliCod), Short.valueOf(AV30Cond_CliPaiConve), AV31Cond_CliConvenio});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A3CliCod = P02215_A3CliCod[0] ;
            A1564CliPaiConve = P02215_A1564CliPaiConve[0] ;
            A1565CliConvenio = P02215_A1565CliConvenio[0] ;
            A1575CliConveVig = P02215_A1575CliConveVig[0] ;
            A905ConveDefault = P02215_A905ConveDefault[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( localUtil.dtoc( A1575CliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) );
            if ( GXutil.strcmp(GXutil.trim( GXutil.booltostr( A905ConveDefault)), httpContext.getMessage( "true", "")) == 0 )
            {
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( httpContext.getMessage( "true", "") );
            }
            else if ( GXutil.strcmp(GXutil.trim( GXutil.booltostr( A905ConveDefault)), httpContext.getMessage( "false", "")) == 0 )
            {
               AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( httpContext.getMessage( "false", "") );
            }
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV25Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P02216 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19CliPaiConve), AV20CliConvenio, AV21CliConveVig, Short.valueOf(AV22CliConveFondoSec)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A2147CliConveFondoSec = P02216_A2147CliConveFondoSec[0] ;
               A1575CliConveVig = P02216_A1575CliConveVig[0] ;
               A1565CliConvenio = P02216_A1565CliConvenio[0] ;
               A1564CliPaiConve = P02216_A1564CliPaiConve[0] ;
               A3CliCod = P02216_A3CliCod[0] ;
               A905ConveDefault = P02216_A905ConveDefault[0] ;
               A905ConveDefault = P02216_A905ConveDefault[0] ;
               AV23SelectedValue = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1575CliConveVig)) ? "" : GXutil.trim( localUtil.dtoc( A1575CliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               if ( GXutil.strcmp(GXutil.trim( GXutil.booltostr( A905ConveDefault)), httpContext.getMessage( "true", "")) == 0 )
               {
                  AV24SelectedText = httpContext.getMessage( "true", "") ;
               }
               else if ( GXutil.strcmp(GXutil.trim( GXutil.booltostr( A905ConveDefault)), httpContext.getMessage( "false", "")) == 0 )
               {
                  AV24SelectedText = httpContext.getMessage( "false", "") ;
               }
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
         }
         else
         {
            if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV21CliConveVig)) )
            {
               AV23SelectedValue = GXutil.trim( localUtil.dtoc( AV21CliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
               /* Using cursor P02217 */
               pr_default.execute(5, new Object[] {Integer.valueOf(AV29Cond_CliCod), Short.valueOf(AV30Cond_CliPaiConve), AV31Cond_CliConvenio, AV21CliConveVig});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A1565CliConvenio = P02217_A1565CliConvenio[0] ;
                  A1564CliPaiConve = P02217_A1564CliPaiConve[0] ;
                  A3CliCod = P02217_A3CliCod[0] ;
                  A1575CliConveVig = P02217_A1575CliConveVig[0] ;
                  A905ConveDefault = P02217_A905ConveDefault[0] ;
                  if ( GXutil.strcmp(GXutil.trim( GXutil.booltostr( A905ConveDefault)), httpContext.getMessage( "true", "")) == 0 )
                  {
                     AV24SelectedText = httpContext.getMessage( "true", "") ;
                  }
                  else if ( GXutil.strcmp(GXutil.trim( GXutil.booltostr( A905ConveDefault)), httpContext.getMessage( "false", "")) == 0 )
                  {
                     AV24SelectedText = httpContext.getMessage( "false", "") ;
                  }
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

   protected void cleanup( )
   {
      this.aP12[0] = clientecct_fondoceseloaddvcombo.this.AV23SelectedValue;
      this.aP13[0] = clientecct_fondoceseloaddvcombo.this.AV24SelectedText;
      this.aP14[0] = clientecct_fondoceseloaddvcombo.this.AV25Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23SelectedValue = "" ;
      AV24SelectedText = "" ;
      AV25Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A1567CliConvenioDescrip = "" ;
      P02212_A3CliCod = new int[1] ;
      P02212_A1564CliPaiConve = new short[1] ;
      P02212_A1567CliConvenioDescrip = new String[] {""} ;
      P02212_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P02213_A2147CliConveFondoSec = new short[1] ;
      P02213_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02213_A1565CliConvenio = new String[] {""} ;
      P02213_A1564CliPaiConve = new short[1] ;
      P02213_A3CliCod = new int[1] ;
      P02213_A1567CliConvenioDescrip = new String[] {""} ;
      A1575CliConveVig = GXutil.nullDate() ;
      P02214_A1564CliPaiConve = new short[1] ;
      P02214_A3CliCod = new int[1] ;
      P02214_A1565CliConvenio = new String[] {""} ;
      P02214_A1567CliConvenioDescrip = new String[] {""} ;
      P02215_A3CliCod = new int[1] ;
      P02215_A1564CliPaiConve = new short[1] ;
      P02215_A1565CliConvenio = new String[] {""} ;
      P02215_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02215_A905ConveDefault = new boolean[] {false} ;
      P02216_A2147CliConveFondoSec = new short[1] ;
      P02216_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02216_A1565CliConvenio = new String[] {""} ;
      P02216_A1564CliPaiConve = new short[1] ;
      P02216_A3CliCod = new int[1] ;
      P02216_A905ConveDefault = new boolean[] {false} ;
      P02217_A1565CliConvenio = new String[] {""} ;
      P02217_A1564CliPaiConve = new short[1] ;
      P02217_A3CliCod = new int[1] ;
      P02217_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02217_A905ConveDefault = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_fondoceseloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P02212_A3CliCod, P02212_A1564CliPaiConve, P02212_A1567CliConvenioDescrip, P02212_A1565CliConvenio
            }
            , new Object[] {
            P02213_A2147CliConveFondoSec, P02213_A1575CliConveVig, P02213_A1565CliConvenio, P02213_A1564CliPaiConve, P02213_A3CliCod, P02213_A1567CliConvenioDescrip
            }
            , new Object[] {
            P02214_A1564CliPaiConve, P02214_A3CliCod, P02214_A1565CliConvenio, P02214_A1567CliConvenioDescrip
            }
            , new Object[] {
            P02215_A3CliCod, P02215_A1564CliPaiConve, P02215_A1565CliConvenio, P02215_A1575CliConveVig, P02215_A905ConveDefault
            }
            , new Object[] {
            P02216_A2147CliConveFondoSec, P02216_A1575CliConveVig, P02216_A1565CliConvenio, P02216_A1564CliPaiConve, P02216_A3CliCod, P02216_A905ConveDefault
            }
            , new Object[] {
            P02217_A1565CliConvenio, P02217_A1564CliPaiConve, P02217_A3CliCod, P02217_A1575CliConveVig, P02217_A905ConveDefault
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19CliPaiConve ;
   private short AV22CliConveFondoSec ;
   private short AV30Cond_CliPaiConve ;
   private short A1564CliPaiConve ;
   private short A2147CliConveFondoSec ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV29Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV20CliConvenio ;
   private String AV31Cond_CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date AV21CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A905ConveDefault ;
   private String AV25Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV23SelectedValue ;
   private String AV24SelectedText ;
   private String lV12SearchTxt ;
   private String A1567CliConvenioDescrip ;
   private String[] aP14 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private IDataStoreProvider pr_default ;
   private int[] P02212_A3CliCod ;
   private short[] P02212_A1564CliPaiConve ;
   private String[] P02212_A1567CliConvenioDescrip ;
   private String[] P02212_A1565CliConvenio ;
   private short[] P02213_A2147CliConveFondoSec ;
   private java.util.Date[] P02213_A1575CliConveVig ;
   private String[] P02213_A1565CliConvenio ;
   private short[] P02213_A1564CliPaiConve ;
   private int[] P02213_A3CliCod ;
   private String[] P02213_A1567CliConvenioDescrip ;
   private short[] P02214_A1564CliPaiConve ;
   private int[] P02214_A3CliCod ;
   private String[] P02214_A1565CliConvenio ;
   private String[] P02214_A1567CliConvenioDescrip ;
   private int[] P02215_A3CliCod ;
   private short[] P02215_A1564CliPaiConve ;
   private String[] P02215_A1565CliConvenio ;
   private java.util.Date[] P02215_A1575CliConveVig ;
   private boolean[] P02215_A905ConveDefault ;
   private short[] P02216_A2147CliConveFondoSec ;
   private java.util.Date[] P02216_A1575CliConveVig ;
   private String[] P02216_A1565CliConvenio ;
   private short[] P02216_A1564CliPaiConve ;
   private int[] P02216_A3CliCod ;
   private boolean[] P02216_A905ConveDefault ;
   private String[] P02217_A1565CliConvenio ;
   private short[] P02217_A1564CliPaiConve ;
   private int[] P02217_A3CliCod ;
   private java.util.Date[] P02217_A1575CliConveVig ;
   private boolean[] P02217_A905ConveDefault ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class clientecct_fondoceseloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02212( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1567CliConvenioDescrip ,
                                          int A3CliCod ,
                                          int AV29Cond_CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV30Cond_CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[3];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.CliPaiConve AS CliPaiConve, T2.ConveDescri AS CliConvenioDescrip, T1.CliConvenio AS CliConvenio FROM (ClienteConvenios T1 INNER JOIN Convenio" ;
      scmdbuf += " T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.CliPaiConve = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.ConveDescri" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P02212(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02212", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02213", "SELECT T1.CliConveFondoSec, T1.CliConveVig, T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T1.CliCod, T2.ConveDescri AS CliConvenioDescrip FROM (Clientecct_fondocese T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.CliConveVig = ? and T1.CliConveFondoSec = ? ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CliConveVig, T1.CliConveFondoSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02214", "SELECT T1.CliPaiConve AS CliPaiConve, T1.CliCod, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02215", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveDefault FROM ClienteConvenio_Particularidades WHERE (CliCod = ?) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) ORDER BY ConveDefault ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02216", "SELECT T1.CliConveFondoSec, T1.CliConveVig, T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T1.CliCod, T2.ConveDefault FROM (Clientecct_fondocese T1 INNER JOIN ClienteConvenio_Particularidades T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.CliConveVig = T1.CliConveVig) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.CliConveVig = ? and T1.CliConveFondoSec = ? ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CliConveVig, T1.CliConveFondoSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02217", "SELECT CliConvenio, CliPaiConve, CliCod, CliConveVig, ConveDefault FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

