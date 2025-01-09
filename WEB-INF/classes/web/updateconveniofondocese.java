package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconveniofondocese extends GXProcedure
{
   public updateconveniofondocese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconveniofondocese.class ), "" );
   }

   public updateconveniofondocese( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      updateconveniofondocese.this.AV17ClientePadre = aP0;
      updateconveniofondocese.this.AV8CliCod = aP1;
      updateconveniofondocese.this.AV19CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV23padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV17ClientePadre), AV19CliRelSec, GXv_dtime1) ;
      updateconveniofondocese.this.AV23padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV17ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV19CliRelSec, 6, 0))) ;
      AV29GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV19CliRelSec) ,
                                           Integer.valueOf(A2154CliConveFondoRelSec) ,
                                           Long.valueOf(AV17ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P02222 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV17ClientePadre), Integer.valueOf(AV19CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2154CliConveFondoRelSec = P02222_A2154CliConveFondoRelSec[0] ;
         A3CliCod = P02222_A3CliCod[0] ;
         A1564CliPaiConve = P02222_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02222_A1565CliConvenio[0] ;
         A1575CliConveVig = P02222_A1575CliConveVig[0] ;
         A2153CliConveFondoDes = P02222_A2153CliConveFondoDes[0] ;
         A2148CliConveFondoMeses = P02222_A2148CliConveFondoMeses[0] ;
         A2152CliConveFondoNre = P02222_A2152CliConveFondoNre[0] ;
         A2150CliConveFondoPrc = P02222_A2150CliConveFondoPrc[0] ;
         A2151CliConveFondoRem = P02222_A2151CliConveFondoRem[0] ;
         A2147CliConveFondoSec = P02222_A2147CliConveFondoSec[0] ;
         AV29GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV25clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV8CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconveniofondocese.this.AV25clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV25clienteConvenioTiene )
         {
            AV22item = (web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem)new web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem(remoteHandle, context);
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio( A1565CliConvenio );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve( A1564CliPaiConve );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig( A1575CliConveVig );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes( A2153CliConveFondoDes );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses( A2148CliConveFondoMeses );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre( A2152CliConveFondoNre );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc( A2150CliConveFondoPrc );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem( A2151CliConveFondoRem );
            AV22item.setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec( A2147CliConveFondoSec );
            AV24sdtConvenioFondocese.add(AV22item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV29GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      if ( AV24sdtConvenioFondocese.size() > 0 )
      {
         AV30GXLvl30 = (byte)(0) ;
         /* Using cursor P02223 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P02223_A3CliCod[0] ;
            AV30GXLvl30 = (byte)(1) ;
            AV20hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "2") ;
            AV31GXV1 = 1 ;
            while ( AV31GXV1 <= AV24sdtConvenioFondocese.size() )
            {
               AV22item = (web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem)((web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem)AV24sdtConvenioFondocese.elementAt(-1+AV31GXV1));
               AV15CliConvenio = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio() ;
               AV18CliPaiConve = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve() ;
               AV16CliConveVig = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig() ;
               AV9CliConveFondoDes = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes() ;
               AV10CliConveFondoMeses = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses() ;
               AV11CliConveFondoNre = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre() ;
               AV12CliConveFondoPrc = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc() ;
               AV13CliConveFondoRem = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem() ;
               AV14CliConveFondoSec = AV22item.getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV31GXV1 = (int)(AV31GXV1+1) ;
            }
            if ( ! (0==AV19CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV30GXLvl30 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "4") ;
      AV32GXLvl61 = (byte)(0) ;
      /* Using cursor P02224 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV20hijoCliCod), Short.valueOf(AV18CliPaiConve), AV15CliConvenio, AV16CliConveVig, Short.valueOf(AV14CliConveFondoSec)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A2147CliConveFondoSec = P02224_A2147CliConveFondoSec[0] ;
         A1575CliConveVig = P02224_A1575CliConveVig[0] ;
         A1565CliConvenio = P02224_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02224_A1564CliPaiConve[0] ;
         A3CliCod = P02224_A3CliCod[0] ;
         A2154CliConveFondoRelSec = P02224_A2154CliConveFondoRelSec[0] ;
         A2153CliConveFondoDes = P02224_A2153CliConveFondoDes[0] ;
         A2148CliConveFondoMeses = P02224_A2148CliConveFondoMeses[0] ;
         A2152CliConveFondoNre = P02224_A2152CliConveFondoNre[0] ;
         A2150CliConveFondoPrc = P02224_A2150CliConveFondoPrc[0] ;
         A2151CliConveFondoRem = P02224_A2151CliConveFondoRem[0] ;
         AV32GXLvl61 = (byte)(1) ;
         GXv_dtime1[0] = AV21hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A2154CliConveFondoRelSec, GXv_dtime1) ;
         updateconveniofondocese.this.AV21hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV23padreReleaseDateTime.after( AV21hijoReleaseDateTime ) )
         {
            A2154CliConveFondoRelSec = AV19CliRelSec ;
            A2153CliConveFondoDes = AV9CliConveFondoDes ;
            A2148CliConveFondoMeses = AV10CliConveFondoMeses ;
            A2152CliConveFondoNre = AV11CliConveFondoNre ;
            A2150CliConveFondoPrc = AV12CliConveFondoPrc ;
            A2151CliConveFondoRem = AV13CliConveFondoRem ;
         }
         /* Using cursor P02225 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A2154CliConveFondoRelSec), Boolean.valueOf(A2153CliConveFondoDes), Short.valueOf(A2148CliConveFondoMeses), Boolean.valueOf(A2152CliConveFondoNre), A2150CliConveFondoPrc, Boolean.valueOf(A2151CliConveFondoRem), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clientecct_fondocese");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV32GXLvl61 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "5") ;
         new web.newconveniofondocese(remoteHandle, context).execute( AV20hijoCliCod, AV18CliPaiConve, AV15CliConvenio, AV16CliConveVig, AV14CliConveFondoSec, AV10CliConveFondoMeses, AV12CliConveFondoPrc, AV13CliConveFondoRem, AV11CliConveFondoNre, AV9CliConveFondoDes, AV19CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconveniofondocese");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV28Pgmname = "" ;
      scmdbuf = "" ;
      P02222_A2154CliConveFondoRelSec = new int[1] ;
      P02222_A3CliCod = new int[1] ;
      P02222_A1564CliPaiConve = new short[1] ;
      P02222_A1565CliConvenio = new String[] {""} ;
      P02222_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02222_A2153CliConveFondoDes = new boolean[] {false} ;
      P02222_A2148CliConveFondoMeses = new short[1] ;
      P02222_A2152CliConveFondoNre = new boolean[] {false} ;
      P02222_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02222_A2151CliConveFondoRem = new boolean[] {false} ;
      P02222_A2147CliConveFondoSec = new short[1] ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      GXv_boolean2 = new boolean[1] ;
      AV22item = new web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem(remoteHandle, context);
      AV24sdtConvenioFondocese = new GXBaseCollection<web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem>(web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem.class, "sdtConvenioFondoceseItem", "PayDay", remoteHandle);
      P02223_A3CliCod = new int[1] ;
      AV15CliConvenio = "" ;
      AV16CliConveVig = GXutil.nullDate() ;
      AV12CliConveFondoPrc = DecimalUtil.ZERO ;
      P02224_A2147CliConveFondoSec = new short[1] ;
      P02224_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02224_A1565CliConvenio = new String[] {""} ;
      P02224_A1564CliPaiConve = new short[1] ;
      P02224_A3CliCod = new int[1] ;
      P02224_A2154CliConveFondoRelSec = new int[1] ;
      P02224_A2153CliConveFondoDes = new boolean[] {false} ;
      P02224_A2148CliConveFondoMeses = new short[1] ;
      P02224_A2152CliConveFondoNre = new boolean[] {false} ;
      P02224_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02224_A2151CliConveFondoRem = new boolean[] {false} ;
      AV21hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconveniofondocese__default(),
         new Object[] {
             new Object[] {
            P02222_A2154CliConveFondoRelSec, P02222_A3CliCod, P02222_A1564CliPaiConve, P02222_A1565CliConvenio, P02222_A1575CliConveVig, P02222_A2153CliConveFondoDes, P02222_A2148CliConveFondoMeses, P02222_A2152CliConveFondoNre, P02222_A2150CliConveFondoPrc, P02222_A2151CliConveFondoRem,
            P02222_A2147CliConveFondoSec
            }
            , new Object[] {
            P02223_A3CliCod
            }
            , new Object[] {
            P02224_A2147CliConveFondoSec, P02224_A1575CliConveVig, P02224_A1565CliConvenio, P02224_A1564CliPaiConve, P02224_A3CliCod, P02224_A2154CliConveFondoRelSec, P02224_A2153CliConveFondoDes, P02224_A2148CliConveFondoMeses, P02224_A2152CliConveFondoNre, P02224_A2150CliConveFondoPrc,
            P02224_A2151CliConveFondoRem
            }
            , new Object[] {
            }
         }
      );
      AV28Pgmname = "updateConvenioFondocese" ;
      /* GeneXus formulas. */
      AV28Pgmname = "updateConvenioFondocese" ;
      Gx_err = (short)(0) ;
   }

   private byte AV29GXLvl4 ;
   private byte AV30GXLvl30 ;
   private byte AV32GXLvl61 ;
   private short A1564CliPaiConve ;
   private short A2148CliConveFondoMeses ;
   private short A2147CliConveFondoSec ;
   private short AV18CliPaiConve ;
   private short AV10CliConveFondoMeses ;
   private short AV14CliConveFondoSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV19CliRelSec ;
   private int A2154CliConveFondoRelSec ;
   private int A3CliCod ;
   private int AV20hijoCliCod ;
   private int AV31GXV1 ;
   private long AV17ClientePadre ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private java.math.BigDecimal AV12CliConveFondoPrc ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String AV15CliConvenio ;
   private java.util.Date AV23padreReleaseDateTime ;
   private java.util.Date AV21hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV16CliConveVig ;
   private boolean A2153CliConveFondoDes ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2151CliConveFondoRem ;
   private boolean AV25clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean AV9CliConveFondoDes ;
   private boolean AV11CliConveFondoNre ;
   private boolean AV13CliConveFondoRem ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P02222_A2154CliConveFondoRelSec ;
   private int[] P02222_A3CliCod ;
   private short[] P02222_A1564CliPaiConve ;
   private String[] P02222_A1565CliConvenio ;
   private java.util.Date[] P02222_A1575CliConveVig ;
   private boolean[] P02222_A2153CliConveFondoDes ;
   private short[] P02222_A2148CliConveFondoMeses ;
   private boolean[] P02222_A2152CliConveFondoNre ;
   private java.math.BigDecimal[] P02222_A2150CliConveFondoPrc ;
   private boolean[] P02222_A2151CliConveFondoRem ;
   private short[] P02222_A2147CliConveFondoSec ;
   private int[] P02223_A3CliCod ;
   private short[] P02224_A2147CliConveFondoSec ;
   private java.util.Date[] P02224_A1575CliConveVig ;
   private String[] P02224_A1565CliConvenio ;
   private short[] P02224_A1564CliPaiConve ;
   private int[] P02224_A3CliCod ;
   private int[] P02224_A2154CliConveFondoRelSec ;
   private boolean[] P02224_A2153CliConveFondoDes ;
   private short[] P02224_A2148CliConveFondoMeses ;
   private boolean[] P02224_A2152CliConveFondoNre ;
   private java.math.BigDecimal[] P02224_A2150CliConveFondoPrc ;
   private boolean[] P02224_A2151CliConveFondoRem ;
   private GXBaseCollection<web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem> AV24sdtConvenioFondocese ;
   private web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem AV22item ;
}

final  class updateconveniofondocese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02222( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV19CliRelSec ,
                                          int A2154CliConveFondoRelSec ,
                                          long AV17ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT CliConveFondoRelSec, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoDes, CliConveFondoMeses, CliConveFondoNre, CliConveFondoPrc, CliConveFondoRem," ;
      scmdbuf += " CliConveFondoSec FROM Clientecct_fondocese" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV19CliRelSec) )
      {
         addWhere(sWhereString, "(CliConveFondoRelSec = ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P02222(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02222", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02223", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02224", "SELECT CliConveFondoSec, CliConveVig, CliConvenio, CliPaiConve, CliCod, CliConveFondoRelSec, CliConveFondoDes, CliConveFondoMeses, CliConveFondoNre, CliConveFondoPrc, CliConveFondoRem FROM Clientecct_fondocese WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? and CliConveFondoSec = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec  FOR UPDATE OF Clientecct_fondocese",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02225", "SAVEPOINT gxupdate;UPDATE Clientecct_fondocese SET CliConveFondoRelSec=?, CliConveFondoDes=?, CliConveFondoMeses=?, CliConveFondoNre=?, CliConveFondoPrc=?, CliConveFondoRem=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,4);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
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
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               return;
      }
   }

}

