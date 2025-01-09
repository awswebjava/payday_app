package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconvenioimportes extends GXProcedure
{
   public updateconvenioimportes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconvenioimportes.class ), "" );
   }

   public updateconvenioimportes( int remoteHandle ,
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
      updateconvenioimportes.this.AV16ClientePadre = aP0;
      updateconvenioimportes.this.AV14CliCod = aP1;
      updateconvenioimportes.this.AV19CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV23padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV16ClientePadre), AV19CliRelSec, GXv_dtime1) ;
      updateconvenioimportes.this.AV23padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV16ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV19CliRelSec, 6, 0))) ;
      AV36GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV19CliRelSec) ,
                                           Integer.valueOf(A1896CliConveImpRelSec) ,
                                           Long.valueOf(AV16ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RF2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV16ClientePadre), Integer.valueOf(AV19CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1896CliConveImpRelSec = P01RF2_A1896CliConveImpRelSec[0] ;
         A3CliCod = P01RF2_A3CliCod[0] ;
         A1564CliPaiConve = P01RF2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RF2_A1565CliConvenio[0] ;
         A1589CliConveImporte = P01RF2_A1589CliConveImporte[0] ;
         A1588CliConveImpTipo = P01RF2_A1588CliConveImpTipo[0] ;
         A1587CliConveImpVig = P01RF2_A1587CliConveImpVig[0] ;
         AV36GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV32clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV14CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconvenioimportes.this.AV32clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV32clienteConvenioTiene )
         {
            AV27item = (web.SdtsdtConvenioImportes_sdtConvenioImportesItem)new web.SdtsdtConvenioImportes_sdtConvenioImportesItem(remoteHandle, context);
            AV27item.setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte( A1589CliConveImporte );
            AV27item.setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo( A1588CliConveImpTipo );
            AV27item.setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig( A1587CliConveImpVig );
            AV27item.setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio( A1565CliConvenio );
            AV27item.setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve( A1564CliPaiConve );
            AV28sdtConvenioImportes.add(AV27item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      if ( AV28sdtConvenioImportes.size() > 0 )
      {
         AV37GXLvl24 = (byte)(0) ;
         /* Using cursor P01RF3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RF3_A3CliCod[0] ;
            AV37GXLvl24 = (byte)(1) ;
            AV20hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "2") ;
            AV38GXV1 = 1 ;
            while ( AV38GXV1 <= AV28sdtConvenioImportes.size() )
            {
               AV27item = (web.SdtsdtConvenioImportes_sdtConvenioImportesItem)((web.SdtsdtConvenioImportes_sdtConvenioImportesItem)AV28sdtConvenioImportes.elementAt(-1+AV38GXV1));
               AV31CliConveImporte = AV27item.getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte() ;
               AV29CliConveImpTipo = AV27item.getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo() ;
               AV30CliConveImpVig = AV27item.getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig() ;
               AV15CliConvenio = AV27item.getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio() ;
               AV18CliPaiConve = AV27item.getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV38GXV1 = (int)(AV38GXV1+1) ;
            }
            if ( ! (0==AV19CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV37GXLvl24 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "4") ;
      AV39GXLvl54 = (byte)(0) ;
      /* Using cursor P01RF4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV20hijoCliCod), Short.valueOf(AV18CliPaiConve), AV15CliConvenio, AV30CliConveImpVig, AV29CliConveImpTipo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1588CliConveImpTipo = P01RF4_A1588CliConveImpTipo[0] ;
         A1587CliConveImpVig = P01RF4_A1587CliConveImpVig[0] ;
         A1565CliConvenio = P01RF4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RF4_A1564CliPaiConve[0] ;
         A3CliCod = P01RF4_A3CliCod[0] ;
         A1896CliConveImpRelSec = P01RF4_A1896CliConveImpRelSec[0] ;
         A1589CliConveImporte = P01RF4_A1589CliConveImporte[0] ;
         AV39GXLvl54 = (byte)(1) ;
         GXv_dtime1[0] = AV21hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1896CliConveImpRelSec, GXv_dtime1) ;
         updateconvenioimportes.this.AV21hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV23padreReleaseDateTime.after( AV21hijoReleaseDateTime ) )
         {
            A1896CliConveImpRelSec = AV19CliRelSec ;
            A1589CliConveImporte = AV31CliConveImporte ;
         }
         /* Using cursor P01RF5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1896CliConveImpRelSec), A1589CliConveImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV39GXLvl54 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "5") ;
         new web.newconvenioimportes(remoteHandle, context).execute( AV20hijoCliCod, AV18CliPaiConve, AV15CliConvenio, AV30CliConveImpVig, AV29CliConveImpTipo, AV31CliConveImporte, AV19CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconvenioimportes");
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
      AV35Pgmname = "" ;
      scmdbuf = "" ;
      P01RF2_A1896CliConveImpRelSec = new int[1] ;
      P01RF2_A3CliCod = new int[1] ;
      P01RF2_A1564CliPaiConve = new short[1] ;
      P01RF2_A1565CliConvenio = new String[] {""} ;
      P01RF2_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RF2_A1588CliConveImpTipo = new String[] {""} ;
      P01RF2_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      A1588CliConveImpTipo = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      AV27item = new web.SdtsdtConvenioImportes_sdtConvenioImportesItem(remoteHandle, context);
      AV28sdtConvenioImportes = new GXBaseCollection<web.SdtsdtConvenioImportes_sdtConvenioImportesItem>(web.SdtsdtConvenioImportes_sdtConvenioImportesItem.class, "sdtConvenioImportesItem", "PayDay", remoteHandle);
      P01RF3_A3CliCod = new int[1] ;
      AV31CliConveImporte = DecimalUtil.ZERO ;
      AV29CliConveImpTipo = "" ;
      AV30CliConveImpVig = GXutil.nullDate() ;
      AV15CliConvenio = "" ;
      P01RF4_A1588CliConveImpTipo = new String[] {""} ;
      P01RF4_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RF4_A1565CliConvenio = new String[] {""} ;
      P01RF4_A1564CliPaiConve = new short[1] ;
      P01RF4_A3CliCod = new int[1] ;
      P01RF4_A1896CliConveImpRelSec = new int[1] ;
      P01RF4_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV21hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconvenioimportes__default(),
         new Object[] {
             new Object[] {
            P01RF2_A1896CliConveImpRelSec, P01RF2_A3CliCod, P01RF2_A1564CliPaiConve, P01RF2_A1565CliConvenio, P01RF2_A1589CliConveImporte, P01RF2_A1588CliConveImpTipo, P01RF2_A1587CliConveImpVig
            }
            , new Object[] {
            P01RF3_A3CliCod
            }
            , new Object[] {
            P01RF4_A1588CliConveImpTipo, P01RF4_A1587CliConveImpVig, P01RF4_A1565CliConvenio, P01RF4_A1564CliPaiConve, P01RF4_A3CliCod, P01RF4_A1896CliConveImpRelSec, P01RF4_A1589CliConveImporte
            }
            , new Object[] {
            }
         }
      );
      AV35Pgmname = "updateConvenioImportes" ;
      /* GeneXus formulas. */
      AV35Pgmname = "updateConvenioImportes" ;
      Gx_err = (short)(0) ;
   }

   private byte AV36GXLvl4 ;
   private byte AV37GXLvl24 ;
   private byte AV39GXLvl54 ;
   private short A1564CliPaiConve ;
   private short AV18CliPaiConve ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV19CliRelSec ;
   private int A1896CliConveImpRelSec ;
   private int A3CliCod ;
   private int AV20hijoCliCod ;
   private int AV38GXV1 ;
   private long AV16ClientePadre ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private java.math.BigDecimal AV31CliConveImporte ;
   private String AV35Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private String AV29CliConveImpTipo ;
   private String AV15CliConvenio ;
   private java.util.Date AV23padreReleaseDateTime ;
   private java.util.Date AV21hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A1587CliConveImpVig ;
   private java.util.Date AV30CliConveImpVig ;
   private boolean AV32clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P01RF2_A1896CliConveImpRelSec ;
   private int[] P01RF2_A3CliCod ;
   private short[] P01RF2_A1564CliPaiConve ;
   private String[] P01RF2_A1565CliConvenio ;
   private java.math.BigDecimal[] P01RF2_A1589CliConveImporte ;
   private String[] P01RF2_A1588CliConveImpTipo ;
   private java.util.Date[] P01RF2_A1587CliConveImpVig ;
   private int[] P01RF3_A3CliCod ;
   private String[] P01RF4_A1588CliConveImpTipo ;
   private java.util.Date[] P01RF4_A1587CliConveImpVig ;
   private String[] P01RF4_A1565CliConvenio ;
   private short[] P01RF4_A1564CliPaiConve ;
   private int[] P01RF4_A3CliCod ;
   private int[] P01RF4_A1896CliConveImpRelSec ;
   private java.math.BigDecimal[] P01RF4_A1589CliConveImporte ;
   private GXBaseCollection<web.SdtsdtConvenioImportes_sdtConvenioImportesItem> AV28sdtConvenioImportes ;
   private web.SdtsdtConvenioImportes_sdtConvenioImportesItem AV27item ;
}

final  class updateconvenioimportes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RF2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV19CliRelSec ,
                                          int A1896CliConveImpRelSec ,
                                          long AV16ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT CliConveImpRelSec, CliCod, CliPaiConve, CliConvenio, CliConveImporte, CliConveImpTipo, CliConveImpVig FROM clienteConvenio_importes" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV19CliRelSec) )
      {
         addWhere(sWhereString, "(CliConveImpRelSec = ?)");
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
                  return conditional_P01RF2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RF2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RF3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RF4", "SELECT CliConveImpTipo, CliConveImpVig, CliConvenio, CliPaiConve, CliCod, CliConveImpRelSec, CliConveImporte FROM clienteConvenio_importes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig = ? and CliConveImpTipo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo  FOR UPDATE OF clienteConvenio_importes",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RF5", "SAVEPOINT gxupdate;UPDATE clienteConvenio_importes SET CliConveImpRelSec=?, CliConveImporte=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveImpVig = ? AND CliConveImpTipo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
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
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 20);
               return;
      }
   }

}

