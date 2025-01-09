package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getbreadcrumb extends GXProcedure
{
   public getbreadcrumb( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getbreadcrumb.class ), "" );
   }

   public getbreadcrumb( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             byte aP1 ,
                             byte aP2 ,
                             long aP3 ,
                             GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>[] aP4 ,
                             String[] aP5 )
   {
      getbreadcrumb.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( String aP0 ,
                        byte aP1 ,
                        byte aP2 ,
                        long aP3 ,
                        GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( String aP0 ,
                             byte aP1 ,
                             byte aP2 ,
                             long aP3 ,
                             GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      getbreadcrumb.this.AV9MenuOpcCod = aP0;
      getbreadcrumb.this.AV39parmRolId = aP1;
      getbreadcrumb.this.AV40parmPerfilId = aP2;
      getbreadcrumb.this.AV41parmMenuverId = aP3;
      getbreadcrumb.this.aP4 = aP4;
      getbreadcrumb.this.aP5 = aP5;
      getbreadcrumb.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV39parmRolId) )
      {
         GXt_int1 = AV22SecUserId ;
         GXv_int2[0] = GXt_int1 ;
         new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
         getbreadcrumb.this.GXt_int1 = GXv_int2[0] ;
         AV22SecUserId = GXt_int1 ;
         GXv_int3[0] = AV12RolId ;
         GXv_int4[0] = AV13PerfilId ;
         GXv_int5[0] = AV14MenuVerId ;
         new web.getusumenu(remoteHandle, context).execute( AV22SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
         getbreadcrumb.this.AV12RolId = GXv_int3[0] ;
         getbreadcrumb.this.AV13PerfilId = GXv_int4[0] ;
         getbreadcrumb.this.AV14MenuVerId = GXv_int5[0] ;
      }
      else
      {
         AV12RolId = AV39parmRolId ;
         AV13PerfilId = AV40parmPerfilId ;
         AV14MenuVerId = AV41parmMenuverId ;
      }
      AV10sdt_breadCrumb.clear();
      AV24modoTxt = AV25websession.getValue(httpContext.getMessage( "&sel_Menu_Modo", "")) ;
      GXv_int2[0] = AV16EmpCod ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      getbreadcrumb.this.AV16EmpCod = GXv_int2[0] ;
      GXv_int6[0] = AV17CliCod ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      getbreadcrumb.this.AV17CliCod = GXv_int6[0] ;
      if ( ! (GXutil.strcmp("", AV24modoTxt)==0) )
      {
         AV11i = (short)(AV11i+1) ;
         AV15itemBreadCrumb = (web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)new web.Sdtsdt_breadCrumb_sdt_breadCrumbItem(remoteHandle, context);
         AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url( "" );
         AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( AV24modoTxt) );
         AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel( AV11i );
         AV10sdt_breadCrumb.add(AV15itemBreadCrumb, 0);
         AV25websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), "");
      }
      else
      {
         AV26sel_HeadTitle = AV25websession.getValue(httpContext.getMessage( "&sel_HeadTitle", "")) ;
         if ( ! (GXutil.strcmp("", AV26sel_HeadTitle)==0) )
         {
            AV11i = (short)(AV11i+1) ;
            AV15itemBreadCrumb = (web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)new web.Sdtsdt_breadCrumb_sdt_breadCrumbItem(remoteHandle, context);
            AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url( "" );
            AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( AV26sel_HeadTitle) );
            AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel( AV11i );
            AV10sdt_breadCrumb.add(AV15itemBreadCrumb, 0);
            AV25websession.setValue(httpContext.getMessage( "&sel_HeadTitle", ""), "");
         }
      }
      AV8auxMenuOpcCod = GXutil.trim( AV9MenuOpcCod) ;
      if ( false )
      {
         new web.revisartematrimsporperformance(remoteHandle, context).execute( ) ;
      }
      while ( AV11i <= 10 )
      {
         AV11i = (short)(AV11i+1) ;
         /* Using cursor P01UW2 */
         pr_default.execute(0, new Object[] {Byte.valueOf(AV12RolId), Byte.valueOf(AV13PerfilId), Long.valueOf(AV14MenuVerId), AV8auxMenuOpcCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1929MenuOpcCod = P01UW2_A1929MenuOpcCod[0] ;
            A1928MenuVerId = P01UW2_A1928MenuVerId[0] ;
            A1925PerfilId = P01UW2_A1925PerfilId[0] ;
            A1923RolId = P01UW2_A1923RolId[0] ;
            A1937MenuItemId = P01UW2_A1937MenuItemId[0] ;
            A1931MenuOpcTitulo = P01UW2_A1931MenuOpcTitulo[0] ;
            A1933MenuOpcPadre = P01UW2_A1933MenuOpcPadre[0] ;
            n1933MenuOpcPadre = P01UW2_n1933MenuOpcPadre[0] ;
            AV15itemBreadCrumb = (web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)new web.Sdtsdt_breadCrumb_sdt_breadCrumbItem(remoteHandle, context);
            if ( GXutil.strcmp(GXutil.trim( GXutil.upper( A1937MenuItemId)), httpContext.getMessage( "EMPRESA", "")) == 0 )
            {
               if ( (0==AV39parmRolId) )
               {
                  GXv_boolean7[0] = AV38multiEs ;
                  new web.clienteempresamultiple(remoteHandle, context).execute( AV17CliCod, GXv_boolean7) ;
                  getbreadcrumb.this.AV38multiEs = GXv_boolean7[0] ;
               }
               if ( ! AV38multiEs )
               {
                  AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( A1931MenuOpcTitulo) );
               }
               else
               {
                  GXv_char8[0] = AV21EmpNom ;
                  new web.getempnom(remoteHandle, context).execute( AV17CliCod, AV16EmpCod, GXv_char8) ;
                  getbreadcrumb.this.AV21EmpNom = GXv_char8[0] ;
                  AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( A1931MenuOpcTitulo)+" \""+GXutil.trim( AV21EmpNom)+"\"" );
               }
            }
            else
            {
               if ( GXutil.strcmp(GXutil.trim( GXutil.upper( A1937MenuItemId)), httpContext.getMessage( "PERIODOVIEW", "")) == 0 )
               {
                  GXv_char8[0] = AV34value ;
                  new web.obtenerdesesion(remoteHandle, context).execute( httpContext.getMessage( "&PeriodoLiq", ""), GXv_char8) ;
                  getbreadcrumb.this.AV34value = GXv_char8[0] ;
                  AV31PeriodoLiq = localUtil.ctod( AV34value, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
                  GXv_char8[0] = AV30PeriodoDescrip ;
                  new web.getperiododescrip(remoteHandle, context).execute( AV17CliCod, AV16EmpCod, AV31PeriodoLiq, GXv_char8) ;
                  getbreadcrumb.this.AV30PeriodoDescrip = GXv_char8[0] ;
                  AV32auxPeriodoDescrip = GXutil.lower( AV30PeriodoDescrip) ;
                  AV30PeriodoDescrip = GXutil.substring( GXutil.upper( AV30PeriodoDescrip), 1, 1) + GXutil.substring( AV32auxPeriodoDescrip, 2, GXutil.len( AV32auxPeriodoDescrip)) ;
                  AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( AV30PeriodoDescrip) );
                  if ( ( GXutil.strcmp(GXutil.trim( GXutil.upper( A1937MenuItemId)), httpContext.getMessage( "PERIODOVIEW", "")) == 0 ) && ( AV11i == 1 ) )
                  {
                     if ( (GXutil.strcmp("", AV28headTitle)==0) )
                     {
                        AV28headTitle = GXutil.trim( AV30PeriodoDescrip) ;
                     }
                  }
               }
               else
               {
                  if ( GXutil.strcmp(GXutil.trim( GXutil.upper( A1937MenuItemId)), httpContext.getMessage( "LIQUIDACIONES", "")) == 0 )
                  {
                     GXv_char8[0] = AV34value ;
                     new web.obtenerdesesion(remoteHandle, context).execute( httpContext.getMessage( "&LiqNro", ""), GXv_char8) ;
                     getbreadcrumb.this.AV34value = GXv_char8[0] ;
                     AV33LiqNro = (int)(GXutil.lval( AV34value)) ;
                     GXv_char8[0] = AV36LiqNombre ;
                     new web.getliqnombre(remoteHandle, context).execute( AV17CliCod, AV16EmpCod, AV33LiqNro, GXv_char8) ;
                     getbreadcrumb.this.AV36LiqNombre = GXv_char8[0] ;
                     AV35auxLiqNombre = GXutil.lower( AV36LiqNombre) ;
                     AV36LiqNombre = GXutil.substring( GXutil.upper( AV36LiqNombre), 1, 1) + GXutil.substring( AV35auxLiqNombre, 2, GXutil.len( AV35auxLiqNombre)) ;
                     AV37charCol = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV36LiqNombre,"-")) ;
                     if ( AV37charCol.size() > 1 )
                     {
                        AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( (String)AV37charCol.elementAt(-1+2)) );
                     }
                     else
                     {
                        AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( A1931MenuOpcTitulo) );
                     }
                     if ( (GXutil.strcmp("", AV28headTitle)==0) )
                     {
                        AV28headTitle = AV35auxLiqNombre ;
                     }
                  }
                  else
                  {
                     if ( GXutil.strcmp(GXutil.trim( GXutil.upper( A1937MenuItemId)), httpContext.getMessage( "LIQUIDACIONRECIBO", "")) == 0 )
                     {
                        AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( A1931MenuOpcTitulo) );
                        if ( (GXutil.strcmp("", AV28headTitle)==0) )
                        {
                           AV28headTitle = httpContext.getMessage( "Detalle de recibo", "") ;
                        }
                     }
                     else
                     {
                        AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo( GXutil.trim( A1931MenuOpcTitulo) );
                     }
                  }
               }
            }
            AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel( AV11i );
            AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod( A1929MenuOpcCod );
            AV10sdt_breadCrumb.add(AV15itemBreadCrumb, 0);
            AV8auxMenuOpcCod = A1933MenuOpcPadre ;
            if ( (GXutil.strcmp("", AV28headTitle)==0) )
            {
               if ( AV11i == 1 )
               {
                  AV28headTitle = GXutil.trim( A1931MenuOpcTitulo) ;
               }
            }
            if ( AV11i > 1 )
            {
               GXt_char9 = "" ;
               GXv_char8[0] = GXt_char9 ;
               new web.getlinkmenu(remoteHandle, context).execute( AV17CliCod, AV16EmpCod, AV13PerfilId, A1937MenuItemId, A1929MenuOpcCod, GXv_char8) ;
               getbreadcrumb.this.GXt_char9 = GXv_char8[0] ;
               AV15itemBreadCrumb.setgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url( GXt_char9 );
            }
            if ( (GXutil.strcmp("", A1933MenuOpcPadre)==0) || P01UW2_n1933MenuOpcPadre[0] )
            {
               AV27primeroMenuOpcCod = A1929MenuOpcCod ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( (GXutil.strcmp("", AV8auxMenuOpcCod)==0) )
         {
            if (true) break;
         }
      }
      AV10sdt_breadCrumb.sort(httpContext.getMessage( "(nivel)", ""));
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getbreadcrumb.this.AV10sdt_breadCrumb;
      this.aP5[0] = getbreadcrumb.this.AV27primeroMenuOpcCod;
      this.aP6[0] = getbreadcrumb.this.AV28headTitle;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10sdt_breadCrumb = new GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>(web.Sdtsdt_breadCrumb_sdt_breadCrumbItem.class, "sdt_breadCrumbItem", "PayDay", remoteHandle);
      AV27primeroMenuOpcCod = "" ;
      AV28headTitle = "" ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      AV24modoTxt = "" ;
      AV25websession = httpContext.getWebSession();
      GXv_int2 = new short[1] ;
      GXv_int6 = new int[1] ;
      AV15itemBreadCrumb = new web.Sdtsdt_breadCrumb_sdt_breadCrumbItem(remoteHandle, context);
      AV26sel_HeadTitle = "" ;
      AV8auxMenuOpcCod = "" ;
      scmdbuf = "" ;
      P01UW2_A1929MenuOpcCod = new String[] {""} ;
      P01UW2_A1928MenuVerId = new long[1] ;
      P01UW2_A1925PerfilId = new byte[1] ;
      P01UW2_A1923RolId = new byte[1] ;
      P01UW2_A1937MenuItemId = new String[] {""} ;
      P01UW2_A1931MenuOpcTitulo = new String[] {""} ;
      P01UW2_A1933MenuOpcPadre = new String[] {""} ;
      P01UW2_n1933MenuOpcPadre = new boolean[] {false} ;
      A1929MenuOpcCod = "" ;
      A1937MenuItemId = "" ;
      A1931MenuOpcTitulo = "" ;
      A1933MenuOpcPadre = "" ;
      GXv_boolean7 = new boolean[1] ;
      AV21EmpNom = "" ;
      AV34value = "" ;
      AV31PeriodoLiq = GXutil.nullDate() ;
      AV30PeriodoDescrip = "" ;
      AV32auxPeriodoDescrip = "" ;
      AV36LiqNombre = "" ;
      AV35auxLiqNombre = "" ;
      AV37charCol = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_char9 = "" ;
      GXv_char8 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getbreadcrumb__default(),
         new Object[] {
             new Object[] {
            P01UW2_A1929MenuOpcCod, P01UW2_A1928MenuVerId, P01UW2_A1925PerfilId, P01UW2_A1923RolId, P01UW2_A1937MenuItemId, P01UW2_A1931MenuOpcTitulo, P01UW2_A1933MenuOpcPadre, P01UW2_n1933MenuOpcPadre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV39parmRolId ;
   private byte AV40parmPerfilId ;
   private byte AV12RolId ;
   private byte GXv_int3[] ;
   private byte AV13PerfilId ;
   private byte GXv_int4[] ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short AV22SecUserId ;
   private short GXt_int1 ;
   private short AV16EmpCod ;
   private short GXv_int2[] ;
   private short AV11i ;
   private short Gx_err ;
   private int AV17CliCod ;
   private int GXv_int6[] ;
   private int AV33LiqNro ;
   private long AV41parmMenuverId ;
   private long AV14MenuVerId ;
   private long GXv_int5[] ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String A1933MenuOpcPadre ;
   private String GXt_char9 ;
   private String GXv_char8[] ;
   private java.util.Date AV31PeriodoLiq ;
   private boolean n1933MenuOpcPadre ;
   private boolean AV38multiEs ;
   private boolean GXv_boolean7[] ;
   private String AV9MenuOpcCod ;
   private String AV27primeroMenuOpcCod ;
   private String AV28headTitle ;
   private String AV24modoTxt ;
   private String AV26sel_HeadTitle ;
   private String AV8auxMenuOpcCod ;
   private String A1929MenuOpcCod ;
   private String A1937MenuItemId ;
   private String A1931MenuOpcTitulo ;
   private String AV21EmpNom ;
   private String AV34value ;
   private String AV30PeriodoDescrip ;
   private String AV32auxPeriodoDescrip ;
   private String AV36LiqNombre ;
   private String AV35auxLiqNombre ;
   private com.genexus.webpanels.WebSession AV25websession ;
   private String[] aP6 ;
   private GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>[] aP4 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UW2_A1929MenuOpcCod ;
   private long[] P01UW2_A1928MenuVerId ;
   private byte[] P01UW2_A1925PerfilId ;
   private byte[] P01UW2_A1923RolId ;
   private String[] P01UW2_A1937MenuItemId ;
   private String[] P01UW2_A1931MenuOpcTitulo ;
   private String[] P01UW2_A1933MenuOpcPadre ;
   private boolean[] P01UW2_n1933MenuOpcPadre ;
   private GXSimpleCollection<String> AV37charCol ;
   private GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem> AV10sdt_breadCrumb ;
   private web.Sdtsdt_breadCrumb_sdt_breadCrumbItem AV15itemBreadCrumb ;
}

final  class getbreadcrumb__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UW2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuItemId, MenuOpcTitulo, MenuOpcPadre FROM MenuVersionesOpciones WHERE (RolId = ? and PerfilId = ? and MenuVerId = ?) AND (MenuOpcCod = ( RTRIM(LTRIM(?)))) ORDER BY RolId, PerfilId, MenuVerId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100);
               return;
      }
   }

}

