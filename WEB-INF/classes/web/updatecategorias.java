package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatecategorias extends GXProcedure
{
   public updatecategorias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatecategorias.class ), "" );
   }

   public updatecategorias( int remoteHandle ,
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
      updatecategorias.this.AV16ClientePadre = aP0;
      updatecategorias.this.AV14CliCod = aP1;
      updatecategorias.this.AV19CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV23padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV16ClientePadre), AV19CliRelSec, GXv_dtime1) ;
      updatecategorias.this.AV23padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV16ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV19CliRelSec, 6, 0))) ;
      AV40GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV19CliRelSec) ,
                                           Short.valueOf(A1894CatRelSec) ,
                                           Long.valueOf(AV16ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RD2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV16ClientePadre), Integer.valueOf(AV19CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1894CatRelSec = P01RD2_A1894CatRelSec[0] ;
         n1894CatRelSec = P01RD2_n1894CatRelSec[0] ;
         A3CliCod = P01RD2_A3CliCod[0] ;
         A1564CliPaiConve = P01RD2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RD2_A1565CliConvenio[0] ;
         A1838CatClase = P01RD2_A1838CatClase[0] ;
         A8CatCodigo = P01RD2_A8CatCodigo[0] ;
         A123CatDescrip = P01RD2_A123CatDescrip[0] ;
         A1914CatFrecAct = P01RD2_A1914CatFrecAct[0] ;
         A2198CatAfipCod = P01RD2_A2198CatAfipCod[0] ;
         n2198CatAfipCod = P01RD2_n2198CatAfipCod[0] ;
         A2416CatTipoTarifa = P01RD2_A2416CatTipoTarifa[0] ;
         AV40GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV35clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV14CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updatecategorias.this.AV35clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV35clienteConvenioTiene )
         {
            AV27itemCategoria = (web.SdtSDTCategorias_SDTCategoriasItem)new web.SdtSDTCategorias_SDTCategoriasItem(remoteHandle, context);
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase( A1838CatClase );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo( A8CatCodigo );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip( A123CatDescrip );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio( A1565CliConvenio );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve( A1564CliPaiConve );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact( A1914CatFrecAct );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod( A2198CatAfipCod );
            AV27itemCategoria.setgxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa( A2416CatTipoTarifa );
            AV28sdtCategorias.add(AV27itemCategoria, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV40GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      if ( AV28sdtCategorias.size() > 0 )
      {
         AV41GXLvl25 = (byte)(0) ;
         /* Using cursor P01RD3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RD3_A3CliCod[0] ;
            AV41GXLvl25 = (byte)(1) ;
            AV20hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "2") ;
            AV42GXV1 = 1 ;
            while ( AV42GXV1 <= AV28sdtCategorias.size() )
            {
               AV27itemCategoria = (web.SdtSDTCategorias_SDTCategoriasItem)((web.SdtSDTCategorias_SDTCategoriasItem)AV28sdtCategorias.elementAt(-1+AV42GXV1));
               AV30CatClase = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase() ;
               AV11CatCodigo = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo() ;
               AV29CatDescrip = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip() ;
               AV15CliConvenio = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio() ;
               AV18CliPaiConve = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve() ;
               AV32CatFrecAct = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact() ;
               AV33CatAfipCod = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod() ;
               AV36CatTipoTarifa = AV27itemCategoria.getgxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "3 &CatAfipCod ", "")+AV33CatAfipCod) ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV42GXV1 = (int)(AV42GXV1+1) ;
            }
            if ( ! (0==AV19CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV41GXLvl25 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "4") ;
      AV43GXLvl54 = (byte)(0) ;
      /* Using cursor P01RD4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV20hijoCliCod), Short.valueOf(AV18CliPaiConve), AV15CliConvenio, AV11CatCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A8CatCodigo = P01RD4_A8CatCodigo[0] ;
         A1565CliConvenio = P01RD4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RD4_A1564CliPaiConve[0] ;
         A3CliCod = P01RD4_A3CliCod[0] ;
         A1894CatRelSec = P01RD4_A1894CatRelSec[0] ;
         n1894CatRelSec = P01RD4_n1894CatRelSec[0] ;
         A123CatDescrip = P01RD4_A123CatDescrip[0] ;
         A676CatDescripSinAc = P01RD4_A676CatDescripSinAc[0] ;
         A1838CatClase = P01RD4_A1838CatClase[0] ;
         A1914CatFrecAct = P01RD4_A1914CatFrecAct[0] ;
         A2198CatAfipCod = P01RD4_A2198CatAfipCod[0] ;
         n2198CatAfipCod = P01RD4_n2198CatAfipCod[0] ;
         AV43GXLvl54 = (byte)(1) ;
         GXv_dtime1[0] = AV21hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1894CatRelSec, GXv_dtime1) ;
         updatecategorias.this.AV21hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV23padreReleaseDateTime.after( AV21hijoReleaseDateTime ) )
         {
            A123CatDescrip = AV29CatDescrip ;
            GXt_char3 = AV31CatDescripSinAc ;
            GXv_char4[0] = GXt_char3 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV29CatDescrip, GXv_char4) ;
            updatecategorias.this.GXt_char3 = GXv_char4[0] ;
            AV31CatDescripSinAc = GXt_char3 ;
            A676CatDescripSinAc = GXutil.upper( AV31CatDescripSinAc) ;
            A1838CatClase = AV30CatClase ;
            A1894CatRelSec = (short)(AV19CliRelSec) ;
            n1894CatRelSec = false ;
            A1914CatFrecAct = AV32CatFrecAct ;
            A2198CatAfipCod = AV33CatAfipCod ;
            n2198CatAfipCod = false ;
         }
         /* Using cursor P01RD5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), Byte.valueOf(A1914CatFrecAct), Boolean.valueOf(n2198CatAfipCod), A2198CatAfipCod, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV43GXLvl54 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "5") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&CatAfipCod ", "")+AV33CatAfipCod) ;
         new web.newcategoria(remoteHandle, context).execute( AV20hijoCliCod, AV18CliPaiConve, AV15CliConvenio, AV11CatCodigo, AV29CatDescrip, AV30CatClase, (short)(AV19CliRelSec), AV32CatFrecAct, AV33CatAfipCod, AV36CatTipoTarifa) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updatecategorias");
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
      AV39Pgmname = "" ;
      scmdbuf = "" ;
      P01RD2_A1894CatRelSec = new short[1] ;
      P01RD2_n1894CatRelSec = new boolean[] {false} ;
      P01RD2_A3CliCod = new int[1] ;
      P01RD2_A1564CliPaiConve = new short[1] ;
      P01RD2_A1565CliConvenio = new String[] {""} ;
      P01RD2_A1838CatClase = new byte[1] ;
      P01RD2_A8CatCodigo = new String[] {""} ;
      P01RD2_A123CatDescrip = new String[] {""} ;
      P01RD2_A1914CatFrecAct = new byte[1] ;
      P01RD2_A2198CatAfipCod = new String[] {""} ;
      P01RD2_n2198CatAfipCod = new boolean[] {false} ;
      P01RD2_A2416CatTipoTarifa = new String[] {""} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      A2198CatAfipCod = "" ;
      A2416CatTipoTarifa = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV27itemCategoria = new web.SdtSDTCategorias_SDTCategoriasItem(remoteHandle, context);
      AV28sdtCategorias = new GXBaseCollection<web.SdtSDTCategorias_SDTCategoriasItem>(web.SdtSDTCategorias_SDTCategoriasItem.class, "SDTCategoriasItem", "PayDay", remoteHandle);
      P01RD3_A3CliCod = new int[1] ;
      AV11CatCodigo = "" ;
      AV29CatDescrip = "" ;
      AV15CliConvenio = "" ;
      AV33CatAfipCod = "" ;
      AV36CatTipoTarifa = "" ;
      A676CatDescripSinAc = "" ;
      P01RD4_A8CatCodigo = new String[] {""} ;
      P01RD4_A1565CliConvenio = new String[] {""} ;
      P01RD4_A1564CliPaiConve = new short[1] ;
      P01RD4_A3CliCod = new int[1] ;
      P01RD4_A1894CatRelSec = new short[1] ;
      P01RD4_n1894CatRelSec = new boolean[] {false} ;
      P01RD4_A123CatDescrip = new String[] {""} ;
      P01RD4_A676CatDescripSinAc = new String[] {""} ;
      P01RD4_A1838CatClase = new byte[1] ;
      P01RD4_A1914CatFrecAct = new byte[1] ;
      P01RD4_A2198CatAfipCod = new String[] {""} ;
      P01RD4_n2198CatAfipCod = new boolean[] {false} ;
      AV21hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      AV31CatDescripSinAc = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updatecategorias__default(),
         new Object[] {
             new Object[] {
            P01RD2_A1894CatRelSec, P01RD2_n1894CatRelSec, P01RD2_A3CliCod, P01RD2_A1564CliPaiConve, P01RD2_A1565CliConvenio, P01RD2_A1838CatClase, P01RD2_A8CatCodigo, P01RD2_A123CatDescrip, P01RD2_A1914CatFrecAct, P01RD2_A2198CatAfipCod,
            P01RD2_n2198CatAfipCod, P01RD2_A2416CatTipoTarifa
            }
            , new Object[] {
            P01RD3_A3CliCod
            }
            , new Object[] {
            P01RD4_A8CatCodigo, P01RD4_A1565CliConvenio, P01RD4_A1564CliPaiConve, P01RD4_A3CliCod, P01RD4_A1894CatRelSec, P01RD4_n1894CatRelSec, P01RD4_A123CatDescrip, P01RD4_A676CatDescripSinAc, P01RD4_A1838CatClase, P01RD4_A1914CatFrecAct,
            P01RD4_A2198CatAfipCod, P01RD4_n2198CatAfipCod
            }
            , new Object[] {
            }
         }
      );
      AV39Pgmname = "updateCategorias" ;
      /* GeneXus formulas. */
      AV39Pgmname = "updateCategorias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV40GXLvl4 ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private byte AV41GXLvl25 ;
   private byte AV30CatClase ;
   private byte AV32CatFrecAct ;
   private byte AV43GXLvl54 ;
   private short A1894CatRelSec ;
   private short A1564CliPaiConve ;
   private short AV18CliPaiConve ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV19CliRelSec ;
   private int A3CliCod ;
   private int AV20hijoCliCod ;
   private int AV42GXV1 ;
   private long AV16ClientePadre ;
   private String AV39Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String A2198CatAfipCod ;
   private String A2416CatTipoTarifa ;
   private String AV11CatCodigo ;
   private String AV15CliConvenio ;
   private String AV33CatAfipCod ;
   private String AV36CatTipoTarifa ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private java.util.Date AV23padreReleaseDateTime ;
   private java.util.Date AV21hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean n1894CatRelSec ;
   private boolean n2198CatAfipCod ;
   private boolean AV35clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String A123CatDescrip ;
   private String AV29CatDescrip ;
   private String A676CatDescripSinAc ;
   private String AV31CatDescripSinAc ;
   private IDataStoreProvider pr_default ;
   private short[] P01RD2_A1894CatRelSec ;
   private boolean[] P01RD2_n1894CatRelSec ;
   private int[] P01RD2_A3CliCod ;
   private short[] P01RD2_A1564CliPaiConve ;
   private String[] P01RD2_A1565CliConvenio ;
   private byte[] P01RD2_A1838CatClase ;
   private String[] P01RD2_A8CatCodigo ;
   private String[] P01RD2_A123CatDescrip ;
   private byte[] P01RD2_A1914CatFrecAct ;
   private String[] P01RD2_A2198CatAfipCod ;
   private boolean[] P01RD2_n2198CatAfipCod ;
   private String[] P01RD2_A2416CatTipoTarifa ;
   private int[] P01RD3_A3CliCod ;
   private String[] P01RD4_A8CatCodigo ;
   private String[] P01RD4_A1565CliConvenio ;
   private short[] P01RD4_A1564CliPaiConve ;
   private int[] P01RD4_A3CliCod ;
   private short[] P01RD4_A1894CatRelSec ;
   private boolean[] P01RD4_n1894CatRelSec ;
   private String[] P01RD4_A123CatDescrip ;
   private String[] P01RD4_A676CatDescripSinAc ;
   private byte[] P01RD4_A1838CatClase ;
   private byte[] P01RD4_A1914CatFrecAct ;
   private String[] P01RD4_A2198CatAfipCod ;
   private boolean[] P01RD4_n2198CatAfipCod ;
   private GXBaseCollection<web.SdtSDTCategorias_SDTCategoriasItem> AV28sdtCategorias ;
   private web.SdtSDTCategorias_SDTCategoriasItem AV27itemCategoria ;
}

final  class updatecategorias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV19CliRelSec ,
                                          short A1894CatRelSec ,
                                          long AV16ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[2];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CatRelSec, CliCod, CliPaiConve, CliConvenio, CatClase, CatCodigo, CatDescrip, CatFrecAct, CatAfipCod, CatTipoTarifa FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV19CliRelSec) )
      {
         addWhere(sWhereString, "(CatRelSec = ?)");
      }
      else
      {
         GXv_int5[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P01RD2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RD3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RD4", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatRelSec, CatDescrip, CatDescripSinAc, CatClase, CatFrecAct, CatAfipCod FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo  FOR UPDATE OF Categoria1",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RD5", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatRelSec=?, CatDescrip=?, CatDescripSinAc=?, CatClase=?, CatFrecAct=?, CatAfipCod=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 40);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(10, 1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
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
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setVarchar(3, (String)parms[3], 400, false);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 6);
               }
               stmt.setInt(7, ((Number) parms[8]).intValue());
               stmt.setShort(8, ((Number) parms[9]).shortValue());
               stmt.setString(9, (String)parms[10], 20);
               stmt.setString(10, (String)parms[11], 40);
               return;
      }
   }

}

