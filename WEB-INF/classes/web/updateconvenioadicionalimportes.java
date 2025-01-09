package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconvenioadicionalimportes extends GXProcedure
{
   public updateconvenioadicionalimportes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconvenioadicionalimportes.class ), "" );
   }

   public updateconvenioadicionalimportes( int remoteHandle ,
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
      updateconvenioadicionalimportes.this.AV11ClientePadre = aP0;
      updateconvenioadicionalimportes.this.AV9CliCod = aP1;
      updateconvenioadicionalimportes.this.AV14CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV18padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV11ClientePadre), AV14CliRelSec, GXv_dtime1) ;
      updateconvenioadicionalimportes.this.AV18padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV11ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0))) ;
      AV26GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV14CliRelSec) ,
                                           Integer.valueOf(A1899ConveAdiImpRelSec) ,
                                           Long.valueOf(AV11ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RH2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV11ClientePadre), Integer.valueOf(AV14CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1899ConveAdiImpRelSec = P01RH2_A1899ConveAdiImpRelSec[0] ;
         A3CliCod = P01RH2_A3CliCod[0] ;
         A1564CliPaiConve = P01RH2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RH2_A1565CliConvenio[0] ;
         A996ConveAdicod = P01RH2_A996ConveAdicod[0] ;
         A1000ConveAdiImporte = P01RH2_A1000ConveAdiImporte[0] ;
         A999ConveAdiVig = P01RH2_A999ConveAdiVig[0] ;
         AV26GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV22clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV9CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconvenioadicionalimportes.this.AV22clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV22clienteConvenioTiene )
         {
            AV17item = (web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem)new web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem(remoteHandle, context);
            AV17item.setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio( A1565CliConvenio );
            AV17item.setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve( A1564CliPaiConve );
            AV17item.setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod( A996ConveAdicod );
            AV17item.setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte( A1000ConveAdiImporte );
            AV17item.setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig( A999ConveAdiVig );
            AV19sdtAdicionalImporte.add(AV17item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV26GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))) ;
      if ( AV19sdtAdicionalImporte.size() > 0 )
      {
         AV27GXLvl24 = (byte)(0) ;
         /* Using cursor P01RH3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RH3_A3CliCod[0] ;
            AV27GXLvl24 = (byte)(1) ;
            AV15hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "2") ;
            AV28GXV1 = 1 ;
            while ( AV28GXV1 <= AV19sdtAdicionalImporte.size() )
            {
               AV17item = (web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem)((web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem)AV19sdtAdicionalImporte.elementAt(-1+AV28GXV1));
               AV13CliPaiConve = AV17item.getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve() ;
               AV10CliConvenio = AV17item.getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio() ;
               AV8ConveAdicod = AV17item.getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod() ;
               AV20ConveAdiVig = AV17item.getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig() ;
               AV21ConveAdiImporte = AV17item.getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV28GXV1 = (int)(AV28GXV1+1) ;
            }
            if ( ! (0==AV14CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV27GXLvl24 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "4") ;
      AV29GXLvl51 = (byte)(0) ;
      /* Using cursor P01RH4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV15hijoCliCod), Short.valueOf(AV13CliPaiConve), AV10CliConvenio, AV8ConveAdicod, AV20ConveAdiVig});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A999ConveAdiVig = P01RH4_A999ConveAdiVig[0] ;
         A996ConveAdicod = P01RH4_A996ConveAdicod[0] ;
         A1565CliConvenio = P01RH4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RH4_A1564CliPaiConve[0] ;
         A3CliCod = P01RH4_A3CliCod[0] ;
         A1899ConveAdiImpRelSec = P01RH4_A1899ConveAdiImpRelSec[0] ;
         A1000ConveAdiImporte = P01RH4_A1000ConveAdiImporte[0] ;
         AV29GXLvl51 = (byte)(1) ;
         GXv_dtime1[0] = AV16hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1899ConveAdiImpRelSec, GXv_dtime1) ;
         updateconvenioadicionalimportes.this.AV16hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV18padreReleaseDateTime.after( AV16hijoReleaseDateTime ) )
         {
            A1000ConveAdiImporte = AV21ConveAdiImporte ;
            A1899ConveAdiImpRelSec = AV14CliRelSec ;
         }
         /* Using cursor P01RH5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1899ConveAdiImpRelSec), A1000ConveAdiImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV29GXLvl51 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "5") ;
         new web.newconvenioadicionalimporte(remoteHandle, context).execute( AV15hijoCliCod, AV13CliPaiConve, AV10CliConvenio, AV8ConveAdicod, AV20ConveAdiVig, AV21ConveAdiImporte, AV14CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconvenioadicionalimportes");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV25Pgmname = "" ;
      scmdbuf = "" ;
      P01RH2_A1899ConveAdiImpRelSec = new int[1] ;
      P01RH2_A3CliCod = new int[1] ;
      P01RH2_A1564CliPaiConve = new short[1] ;
      P01RH2_A1565CliConvenio = new String[] {""} ;
      P01RH2_A996ConveAdicod = new String[] {""} ;
      P01RH2_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RH2_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A999ConveAdiVig = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      AV17item = new web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem(remoteHandle, context);
      AV19sdtAdicionalImporte = new GXBaseCollection<web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem>(web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem.class, "sdtAdicionalImporteItem", "PayDay", remoteHandle);
      P01RH3_A3CliCod = new int[1] ;
      AV10CliConvenio = "" ;
      AV8ConveAdicod = "" ;
      AV20ConveAdiVig = GXutil.nullDate() ;
      AV21ConveAdiImporte = DecimalUtil.ZERO ;
      P01RH4_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RH4_A996ConveAdicod = new String[] {""} ;
      P01RH4_A1565CliConvenio = new String[] {""} ;
      P01RH4_A1564CliPaiConve = new short[1] ;
      P01RH4_A3CliCod = new int[1] ;
      P01RH4_A1899ConveAdiImpRelSec = new int[1] ;
      P01RH4_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV16hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconvenioadicionalimportes__default(),
         new Object[] {
             new Object[] {
            P01RH2_A1899ConveAdiImpRelSec, P01RH2_A3CliCod, P01RH2_A1564CliPaiConve, P01RH2_A1565CliConvenio, P01RH2_A996ConveAdicod, P01RH2_A1000ConveAdiImporte, P01RH2_A999ConveAdiVig
            }
            , new Object[] {
            P01RH3_A3CliCod
            }
            , new Object[] {
            P01RH4_A999ConveAdiVig, P01RH4_A996ConveAdicod, P01RH4_A1565CliConvenio, P01RH4_A1564CliPaiConve, P01RH4_A3CliCod, P01RH4_A1899ConveAdiImpRelSec, P01RH4_A1000ConveAdiImporte
            }
            , new Object[] {
            }
         }
      );
      AV25Pgmname = "updateConvenioAdicionalImportes" ;
      /* GeneXus formulas. */
      AV25Pgmname = "updateConvenioAdicionalImportes" ;
      Gx_err = (short)(0) ;
   }

   private byte AV26GXLvl4 ;
   private byte AV27GXLvl24 ;
   private byte AV29GXLvl51 ;
   private short A1564CliPaiConve ;
   private short AV13CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV14CliRelSec ;
   private int A1899ConveAdiImpRelSec ;
   private int A3CliCod ;
   private int AV15hijoCliCod ;
   private int AV28GXV1 ;
   private long AV11ClientePadre ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private java.math.BigDecimal AV21ConveAdiImporte ;
   private String AV25Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String AV10CliConvenio ;
   private String AV8ConveAdicod ;
   private java.util.Date AV18padreReleaseDateTime ;
   private java.util.Date AV16hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A999ConveAdiVig ;
   private java.util.Date AV20ConveAdiVig ;
   private boolean AV22clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P01RH2_A1899ConveAdiImpRelSec ;
   private int[] P01RH2_A3CliCod ;
   private short[] P01RH2_A1564CliPaiConve ;
   private String[] P01RH2_A1565CliConvenio ;
   private String[] P01RH2_A996ConveAdicod ;
   private java.math.BigDecimal[] P01RH2_A1000ConveAdiImporte ;
   private java.util.Date[] P01RH2_A999ConveAdiVig ;
   private int[] P01RH3_A3CliCod ;
   private java.util.Date[] P01RH4_A999ConveAdiVig ;
   private String[] P01RH4_A996ConveAdicod ;
   private String[] P01RH4_A1565CliConvenio ;
   private short[] P01RH4_A1564CliPaiConve ;
   private int[] P01RH4_A3CliCod ;
   private int[] P01RH4_A1899ConveAdiImpRelSec ;
   private java.math.BigDecimal[] P01RH4_A1000ConveAdiImporte ;
   private GXBaseCollection<web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem> AV19sdtAdicionalImporte ;
   private web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem AV17item ;
}

final  class updateconvenioadicionalimportes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RH2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV14CliRelSec ,
                                          int A1899ConveAdiImpRelSec ,
                                          long AV11ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveAdiImpRelSec, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiImporte, ConveAdiVig FROM convenio_adicionalimportes" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV14CliRelSec) )
      {
         addWhere(sWhereString, "(ConveAdiImpRelSec = ?)");
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
                  return conditional_P01RH2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RH2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RH3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RH4", "SELECT ConveAdiVig, ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiImpRelSec, ConveAdiImporte FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig  FOR UPDATE OF convenio_adicionalimportes",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RH5", "SAVEPOINT gxupdate;UPDATE convenio_adicionalimportes SET ConveAdiImpRelSec=?, ConveAdiImporte=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
      }
   }

}

