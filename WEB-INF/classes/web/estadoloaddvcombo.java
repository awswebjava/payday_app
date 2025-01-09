package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estadoloaddvcombo extends GXProcedure
{
   public estadoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estadoloaddvcombo.class ), "" );
   }

   public estadoloaddvcombo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      estadoloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      estadoloaddvcombo.this.AV15ComboName = aP0;
      estadoloaddvcombo.this.AV16TrnMode = aP1;
      estadoloaddvcombo.this.AV17IsDynamicCall = aP2;
      estadoloaddvcombo.this.AV18SitCodigo = aP3;
      estadoloaddvcombo.this.AV12SearchTxt = aP4;
      estadoloaddvcombo.this.aP5 = aP5;
      estadoloaddvcombo.this.aP6 = aP6;
      estadoloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion", GXv_boolean2) ;
      estadoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "EstadoSitRevista") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ESTADOSITREVISTA' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "EstadoSiniestro") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ESTADOSINIESTRO' */
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
      /* 'LOADCOMBOITEMS_ESTADOSITREVISTA' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1596SitRevDescrip } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01NU2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1596SitRevDescrip = P01NU2_A1596SitRevDescrip[0] ;
            A1595SitRevCodigo = P01NU2_A1595SitRevCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1595SitRevCodigo, 3, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1596SitRevDescrip );
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
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01NU3 */
               pr_default.execute(1, new Object[] {AV18SitCodigo});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A16SitCodigo = P01NU3_A16SitCodigo[0] ;
                  A1598EstadoSitRevista = P01NU3_A1598EstadoSitRevista[0] ;
                  n1598EstadoSitRevista = P01NU3_n1598EstadoSitRevista[0] ;
                  AV19SelectedValue = ((0==A1598EstadoSitRevista) ? "" : GXutil.trim( GXutil.str( A1598EstadoSitRevista, 3, 0))) ;
                  AV25SitRevCodigo = A1598EstadoSitRevista ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV25SitRevCodigo = (short)(GXutil.lval( AV12SearchTxt)) ;
            }
            /* Using cursor P01NU4 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV25SitRevCodigo)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1595SitRevCodigo = P01NU4_A1595SitRevCodigo[0] ;
               A1596SitRevDescrip = P01NU4_A1596SitRevDescrip[0] ;
               AV20SelectedText = A1596SitRevDescrip ;
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
      /* 'LOADCOMBOITEMS_ESTADOSINIESTRO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A333SinieDescri } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01NU5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A333SinieDescri = P01NU5_A333SinieDescri[0] ;
            A19SinieCodigo = P01NU5_A19SinieCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A19SinieCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A333SinieDescri );
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
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P01NU6 */
               pr_default.execute(4, new Object[] {AV18SitCodigo});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A16SitCodigo = P01NU6_A16SitCodigo[0] ;
                  A1600EstadoSiniestro = P01NU6_A1600EstadoSiniestro[0] ;
                  n1600EstadoSiniestro = P01NU6_n1600EstadoSiniestro[0] ;
                  AV19SelectedValue = A1600EstadoSiniestro ;
                  AV26SinieCodigo = A1600EstadoSiniestro ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV26SinieCodigo = AV12SearchTxt ;
            }
            /* Using cursor P01NU7 */
            pr_default.execute(5, new Object[] {AV26SinieCodigo});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A19SinieCodigo = P01NU7_A19SinieCodigo[0] ;
               A333SinieDescri = P01NU7_A333SinieDescri[0] ;
               AV20SelectedText = A333SinieDescri ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(5);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = estadoloaddvcombo.this.AV19SelectedValue;
      this.aP6[0] = estadoloaddvcombo.this.AV20SelectedText;
      this.aP7[0] = estadoloaddvcombo.this.AV21Combo_DataJson;
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
      A1596SitRevDescrip = "" ;
      P01NU2_A1596SitRevDescrip = new String[] {""} ;
      P01NU2_A1595SitRevCodigo = new short[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01NU3_A16SitCodigo = new String[] {""} ;
      P01NU3_A1598EstadoSitRevista = new short[1] ;
      P01NU3_n1598EstadoSitRevista = new boolean[] {false} ;
      A16SitCodigo = "" ;
      P01NU4_A1595SitRevCodigo = new short[1] ;
      P01NU4_A1596SitRevDescrip = new String[] {""} ;
      A333SinieDescri = "" ;
      P01NU5_A333SinieDescri = new String[] {""} ;
      P01NU5_A19SinieCodigo = new String[] {""} ;
      A19SinieCodigo = "" ;
      P01NU6_A16SitCodigo = new String[] {""} ;
      P01NU6_A1600EstadoSiniestro = new String[] {""} ;
      P01NU6_n1600EstadoSiniestro = new boolean[] {false} ;
      A1600EstadoSiniestro = "" ;
      AV26SinieCodigo = "" ;
      P01NU7_A19SinieCodigo = new String[] {""} ;
      P01NU7_A333SinieDescri = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estadoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01NU2_A1596SitRevDescrip, P01NU2_A1595SitRevCodigo
            }
            , new Object[] {
            P01NU3_A16SitCodigo, P01NU3_A1598EstadoSitRevista, P01NU3_n1598EstadoSitRevista
            }
            , new Object[] {
            P01NU4_A1595SitRevCodigo, P01NU4_A1596SitRevDescrip
            }
            , new Object[] {
            P01NU5_A333SinieDescri, P01NU5_A19SinieCodigo
            }
            , new Object[] {
            P01NU6_A16SitCodigo, P01NU6_A1600EstadoSiniestro, P01NU6_n1600EstadoSiniestro
            }
            , new Object[] {
            P01NU7_A19SinieCodigo, P01NU7_A333SinieDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1595SitRevCodigo ;
   private short A1598EstadoSitRevista ;
   private short AV25SitRevCodigo ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV16TrnMode ;
   private String AV18SitCodigo ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private String A19SinieCodigo ;
   private String A1600EstadoSiniestro ;
   private String AV26SinieCodigo ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n1598EstadoSitRevista ;
   private boolean n1600EstadoSiniestro ;
   private String AV21Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV19SelectedValue ;
   private String AV20SelectedText ;
   private String lV12SearchTxt ;
   private String A1596SitRevDescrip ;
   private String A333SinieDescri ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01NU2_A1596SitRevDescrip ;
   private short[] P01NU2_A1595SitRevCodigo ;
   private String[] P01NU3_A16SitCodigo ;
   private short[] P01NU3_A1598EstadoSitRevista ;
   private boolean[] P01NU3_n1598EstadoSitRevista ;
   private short[] P01NU4_A1595SitRevCodigo ;
   private String[] P01NU4_A1596SitRevDescrip ;
   private String[] P01NU5_A333SinieDescri ;
   private String[] P01NU5_A19SinieCodigo ;
   private String[] P01NU6_A16SitCodigo ;
   private String[] P01NU6_A1600EstadoSiniestro ;
   private boolean[] P01NU6_n1600EstadoSiniestro ;
   private String[] P01NU7_A19SinieCodigo ;
   private String[] P01NU7_A333SinieDescri ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class estadoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01NU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1596SitRevDescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT SitRevDescrip, SitRevCodigo FROM SituacionRevistaAFIP" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SitRevDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitRevDescrip" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01NU5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A333SinieDescri )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT SinieDescri, SinieCodigo FROM Siniestrado" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SinieDescri) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SinieDescri" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P01NU2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01NU5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01NU3", "SELECT SitCodigo, EstadoSitRevista FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01NU4", "SELECT SitRevCodigo, SitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ORDER BY SitRevCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01NU5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01NU6", "SELECT SitCodigo, EstadoSiniestro FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01NU7", "SELECT SinieCodigo, SinieDescri FROM Siniestrado WHERE SinieCodigo = ( ?) ORDER BY SinieCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

