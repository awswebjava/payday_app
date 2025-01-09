package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteconvenio_importesloaddvcombo extends GXProcedure
{
   public clienteconvenio_importesloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_importesloaddvcombo.class ), "" );
   }

   public clienteconvenio_importesloaddvcombo( int remoteHandle ,
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
                             String aP7 ,
                             int aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      clienteconvenio_importesloaddvcombo.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        int aP8 ,
                        short aP9 ,
                        String aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             int aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      clienteconvenio_importesloaddvcombo.this.AV15ComboName = aP0;
      clienteconvenio_importesloaddvcombo.this.AV16TrnMode = aP1;
      clienteconvenio_importesloaddvcombo.this.AV17IsDynamicCall = aP2;
      clienteconvenio_importesloaddvcombo.this.AV18CliCod = aP3;
      clienteconvenio_importesloaddvcombo.this.AV19CliPaiConve = aP4;
      clienteconvenio_importesloaddvcombo.this.AV20CliConvenio = aP5;
      clienteconvenio_importesloaddvcombo.this.AV21CliConveImpVig = aP6;
      clienteconvenio_importesloaddvcombo.this.AV22CliConveImpTipo = aP7;
      clienteconvenio_importesloaddvcombo.this.AV29Cond_CliCod = aP8;
      clienteconvenio_importesloaddvcombo.this.AV30Cond_CliPaiConve = aP9;
      clienteconvenio_importesloaddvcombo.this.AV12SearchTxt = aP10;
      clienteconvenio_importesloaddvcombo.this.aP11 = aP11;
      clienteconvenio_importesloaddvcombo.this.aP12 = aP12;
      clienteconvenio_importesloaddvcombo.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWclienteConvenio_importes", GXv_boolean2) ;
      clienteconvenio_importesloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         /* Using cursor P01R62 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV29Cond_CliCod), Short.valueOf(AV30Cond_CliPaiConve), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P01R62_A3CliCod[0] ;
            A1564CliPaiConve = P01R62_A1564CliPaiConve[0] ;
            A1567CliConvenioDescrip = P01R62_A1567CliConvenioDescrip[0] ;
            A1565CliConvenio = P01R62_A1565CliConvenio[0] ;
            A1567CliConvenioDescrip = P01R62_A1567CliConvenioDescrip[0] ;
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
            /* Using cursor P01R63 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19CliPaiConve), AV20CliConvenio, AV21CliConveImpVig, AV22CliConveImpTipo});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1588CliConveImpTipo = P01R63_A1588CliConveImpTipo[0] ;
               A1587CliConveImpVig = P01R63_A1587CliConveImpVig[0] ;
               A1565CliConvenio = P01R63_A1565CliConvenio[0] ;
               A1564CliPaiConve = P01R63_A1564CliPaiConve[0] ;
               A3CliCod = P01R63_A3CliCod[0] ;
               A1567CliConvenioDescrip = P01R63_A1567CliConvenioDescrip[0] ;
               A1567CliConvenioDescrip = P01R63_A1567CliConvenioDescrip[0] ;
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
               /* Using cursor P01R64 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV29Cond_CliCod), Short.valueOf(AV30Cond_CliPaiConve), AV20CliConvenio});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1564CliPaiConve = P01R64_A1564CliPaiConve[0] ;
                  A3CliCod = P01R64_A3CliCod[0] ;
                  A1565CliConvenio = P01R64_A1565CliConvenio[0] ;
                  A1567CliConvenioDescrip = P01R64_A1567CliConvenioDescrip[0] ;
                  A1567CliConvenioDescrip = P01R64_A1567CliConvenioDescrip[0] ;
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

   protected void cleanup( )
   {
      this.aP11[0] = clienteconvenio_importesloaddvcombo.this.AV23SelectedValue;
      this.aP12[0] = clienteconvenio_importesloaddvcombo.this.AV24SelectedText;
      this.aP13[0] = clienteconvenio_importesloaddvcombo.this.AV25Combo_DataJson;
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
      P01R62_A3CliCod = new int[1] ;
      P01R62_A1564CliPaiConve = new short[1] ;
      P01R62_A1567CliConvenioDescrip = new String[] {""} ;
      P01R62_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01R63_A1588CliConveImpTipo = new String[] {""} ;
      P01R63_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01R63_A1565CliConvenio = new String[] {""} ;
      P01R63_A1564CliPaiConve = new short[1] ;
      P01R63_A3CliCod = new int[1] ;
      P01R63_A1567CliConvenioDescrip = new String[] {""} ;
      A1588CliConveImpTipo = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      P01R64_A1564CliPaiConve = new short[1] ;
      P01R64_A3CliCod = new int[1] ;
      P01R64_A1565CliConvenio = new String[] {""} ;
      P01R64_A1567CliConvenioDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_importesloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01R62_A3CliCod, P01R62_A1564CliPaiConve, P01R62_A1567CliConvenioDescrip, P01R62_A1565CliConvenio
            }
            , new Object[] {
            P01R63_A1588CliConveImpTipo, P01R63_A1587CliConveImpVig, P01R63_A1565CliConvenio, P01R63_A1564CliPaiConve, P01R63_A3CliCod, P01R63_A1567CliConvenioDescrip
            }
            , new Object[] {
            P01R64_A1564CliPaiConve, P01R64_A3CliCod, P01R64_A1565CliConvenio, P01R64_A1567CliConvenioDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19CliPaiConve ;
   private short AV30Cond_CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV29Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV20CliConvenio ;
   private String AV22CliConveImpTipo ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private java.util.Date AV21CliConveImpVig ;
   private java.util.Date A1587CliConveImpVig ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV25Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV23SelectedValue ;
   private String AV24SelectedText ;
   private String lV12SearchTxt ;
   private String A1567CliConvenioDescrip ;
   private String[] aP13 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private int[] P01R62_A3CliCod ;
   private short[] P01R62_A1564CliPaiConve ;
   private String[] P01R62_A1567CliConvenioDescrip ;
   private String[] P01R62_A1565CliConvenio ;
   private String[] P01R63_A1588CliConveImpTipo ;
   private java.util.Date[] P01R63_A1587CliConveImpVig ;
   private String[] P01R63_A1565CliConvenio ;
   private short[] P01R63_A1564CliPaiConve ;
   private int[] P01R63_A3CliCod ;
   private String[] P01R63_A1567CliConvenioDescrip ;
   private short[] P01R64_A1564CliPaiConve ;
   private int[] P01R64_A3CliCod ;
   private String[] P01R64_A1565CliConvenio ;
   private String[] P01R64_A1567CliConvenioDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class clienteconvenio_importesloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01R62( ModelContext context ,
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
                  return conditional_P01R62(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01R62", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01R63", "SELECT T1.CliConveImpTipo, T1.CliConveImpVig, T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T1.CliCod, T2.ConveDescri AS CliConvenioDescrip FROM (clienteConvenio_importes T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.CliConveImpVig = ? and T1.CliConveImpTipo = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CliConveImpVig, T1.CliConveImpTipo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01R64", "SELECT T1.CliPaiConve AS CliPaiConve, T1.CliCod, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

