package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatecategoriaprovincias extends GXProcedure
{
   public updatecategoriaprovincias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatecategoriaprovincias.class ), "" );
   }

   public updatecategoriaprovincias( int remoteHandle ,
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
      updatecategoriaprovincias.this.AV14ClientePadre = aP0;
      updatecategoriaprovincias.this.AV12CliCod = aP1;
      updatecategoriaprovincias.this.AV17CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV21padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV14ClientePadre), AV17CliRelSec, GXv_dtime1) ;
      updatecategoriaprovincias.this.AV21padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV14ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV17CliRelSec, 6, 0))) ;
      AV27GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV17CliRelSec) ,
                                           Integer.valueOf(A2202CatProvRelSec) ,
                                           Long.valueOf(AV14ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P02542 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV14ClientePadre), Integer.valueOf(AV17CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2202CatProvRelSec = P02542_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = P02542_n2202CatProvRelSec[0] ;
         A3CliCod = P02542_A3CliCod[0] ;
         A1564CliPaiConve = P02542_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02542_A1565CliConvenio[0] ;
         A8CatCodigo = P02542_A8CatCodigo[0] ;
         A2201CatProvCod = P02542_A2201CatProvCod[0] ;
         A2200CatPaiCod = P02542_A2200CatPaiCod[0] ;
         AV27GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV23clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV12CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updatecategoriaprovincias.this.AV23clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV23clienteConvenioTiene )
         {
            AV20itemCatProv = (web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem)new web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem(remoteHandle, context);
            AV20itemCatProv.setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio( A1565CliConvenio );
            AV20itemCatProv.setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve( A1564CliPaiConve );
            AV20itemCatProv.setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo( A8CatCodigo );
            AV20itemCatProv.setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod( A2201CatProvCod );
            AV20itemCatProv.setgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod( A2200CatPaiCod );
            AV22sdt_CategoriaProvincia.add(AV20itemCatProv, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV27GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      if ( AV22sdt_CategoriaProvincia.size() > 0 )
      {
         AV28GXLvl26 = (byte)(0) ;
         /* Using cursor P02543 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV12CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P02543_A3CliCod[0] ;
            AV28GXLvl26 = (byte)(1) ;
            AV18hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "2") ;
            AV29GXV1 = 1 ;
            while ( AV29GXV1 <= AV22sdt_CategoriaProvincia.size() )
            {
               AV20itemCatProv = (web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem)((web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem)AV22sdt_CategoriaProvincia.elementAt(-1+AV29GXV1));
               AV16CliPaiConve = AV20itemCatProv.getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve() ;
               AV13CliConvenio = AV20itemCatProv.getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio() ;
               AV8CatCodigo = AV20itemCatProv.getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo() ;
               AV9CatPaiCod = AV20itemCatProv.getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod() ;
               AV10CatProvCod = AV20itemCatProv.getgxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV29GXV1 = (int)(AV29GXV1+1) ;
            }
            if ( ! (0==AV17CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV28GXLvl26 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "4") ;
      AV30GXLvl52 = (byte)(0) ;
      /* Using cursor P02544 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV18hijoCliCod), Short.valueOf(AV16CliPaiConve), AV13CliConvenio, AV8CatCodigo, Short.valueOf(AV9CatPaiCod), Short.valueOf(AV10CatProvCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A2201CatProvCod = P02544_A2201CatProvCod[0] ;
         A2200CatPaiCod = P02544_A2200CatPaiCod[0] ;
         A8CatCodigo = P02544_A8CatCodigo[0] ;
         A1565CliConvenio = P02544_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02544_A1564CliPaiConve[0] ;
         A3CliCod = P02544_A3CliCod[0] ;
         A2202CatProvRelSec = P02544_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = P02544_n2202CatProvRelSec[0] ;
         AV30GXLvl52 = (byte)(1) ;
         GXv_dtime1[0] = AV19hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A2202CatProvRelSec, GXv_dtime1) ;
         updatecategoriaprovincias.this.AV19hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV21padreReleaseDateTime.after( AV19hijoReleaseDateTime ) )
         {
            A2202CatProvRelSec = AV17CliRelSec ;
            n2202CatProvRelSec = false ;
         }
         /* Using cursor P02545 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV30GXLvl52 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "5") ;
         new web.newcategoriaprovincia(remoteHandle, context).execute( AV18hijoCliCod, AV16CliPaiConve, AV13CliConvenio, AV8CatCodigo, AV9CatPaiCod, AV10CatProvCod, AV17CliRelSec, "", "") ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updatecategoriaprovincias");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV26Pgmname = "" ;
      scmdbuf = "" ;
      P02542_A2202CatProvRelSec = new int[1] ;
      P02542_n2202CatProvRelSec = new boolean[] {false} ;
      P02542_A3CliCod = new int[1] ;
      P02542_A1564CliPaiConve = new short[1] ;
      P02542_A1565CliConvenio = new String[] {""} ;
      P02542_A8CatCodigo = new String[] {""} ;
      P02542_A2201CatProvCod = new short[1] ;
      P02542_A2200CatPaiCod = new short[1] ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV20itemCatProv = new web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem(remoteHandle, context);
      AV22sdt_CategoriaProvincia = new GXBaseCollection<web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem>(web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem.class, "sdt_CategoriaProvinciaItem", "PayDay", remoteHandle);
      P02543_A3CliCod = new int[1] ;
      AV13CliConvenio = "" ;
      AV8CatCodigo = "" ;
      P02544_A2201CatProvCod = new short[1] ;
      P02544_A2200CatPaiCod = new short[1] ;
      P02544_A8CatCodigo = new String[] {""} ;
      P02544_A1565CliConvenio = new String[] {""} ;
      P02544_A1564CliPaiConve = new short[1] ;
      P02544_A3CliCod = new int[1] ;
      P02544_A2202CatProvRelSec = new int[1] ;
      P02544_n2202CatProvRelSec = new boolean[] {false} ;
      AV19hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updatecategoriaprovincias__default(),
         new Object[] {
             new Object[] {
            P02542_A2202CatProvRelSec, P02542_n2202CatProvRelSec, P02542_A3CliCod, P02542_A1564CliPaiConve, P02542_A1565CliConvenio, P02542_A8CatCodigo, P02542_A2201CatProvCod, P02542_A2200CatPaiCod
            }
            , new Object[] {
            P02543_A3CliCod
            }
            , new Object[] {
            P02544_A2201CatProvCod, P02544_A2200CatPaiCod, P02544_A8CatCodigo, P02544_A1565CliConvenio, P02544_A1564CliPaiConve, P02544_A3CliCod, P02544_A2202CatProvRelSec, P02544_n2202CatProvRelSec
            }
            , new Object[] {
            }
         }
      );
      AV26Pgmname = "updateCategoriaProvincias" ;
      /* GeneXus formulas. */
      AV26Pgmname = "updateCategoriaProvincias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV27GXLvl4 ;
   private byte AV28GXLvl26 ;
   private byte AV30GXLvl52 ;
   private short A1564CliPaiConve ;
   private short A2201CatProvCod ;
   private short A2200CatPaiCod ;
   private short AV16CliPaiConve ;
   private short AV9CatPaiCod ;
   private short AV10CatProvCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV17CliRelSec ;
   private int A2202CatProvRelSec ;
   private int A3CliCod ;
   private int AV18hijoCliCod ;
   private int AV29GXV1 ;
   private long AV14ClientePadre ;
   private String AV26Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV13CliConvenio ;
   private String AV8CatCodigo ;
   private java.util.Date AV21padreReleaseDateTime ;
   private java.util.Date AV19hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean n2202CatProvRelSec ;
   private boolean AV23clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P02542_A2202CatProvRelSec ;
   private boolean[] P02542_n2202CatProvRelSec ;
   private int[] P02542_A3CliCod ;
   private short[] P02542_A1564CliPaiConve ;
   private String[] P02542_A1565CliConvenio ;
   private String[] P02542_A8CatCodigo ;
   private short[] P02542_A2201CatProvCod ;
   private short[] P02542_A2200CatPaiCod ;
   private int[] P02543_A3CliCod ;
   private short[] P02544_A2201CatProvCod ;
   private short[] P02544_A2200CatPaiCod ;
   private String[] P02544_A8CatCodigo ;
   private String[] P02544_A1565CliConvenio ;
   private short[] P02544_A1564CliPaiConve ;
   private int[] P02544_A3CliCod ;
   private int[] P02544_A2202CatProvRelSec ;
   private boolean[] P02544_n2202CatProvRelSec ;
   private GXBaseCollection<web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem> AV22sdt_CategoriaProvincia ;
   private web.Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem AV20itemCatProv ;
}

final  class updatecategoriaprovincias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02542( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV17CliRelSec ,
                                          int A2202CatProvRelSec ,
                                          long AV14ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT CatProvRelSec, CliCod, CliPaiConve, CliConvenio, CatCodigo, CatProvCod, CatPaiCod FROM CategoriaProvincias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV17CliRelSec) )
      {
         addWhere(sWhereString, "(CatProvRelSec = ?)");
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
                  return conditional_P02542(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02542", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02543", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02544", "SELECT CatProvCod, CatPaiCod, CatCodigo, CliConvenio, CliPaiConve, CliCod, CatProvRelSec FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatPaiCod = ? and CatProvCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod  FOR UPDATE OF CategoriaProvincias",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02545", "SAVEPOINT gxupdate;UPDATE CategoriaProvincias SET CatProvRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setString(4, (String)parms[4], 20);
               stmt.setString(5, (String)parms[5], 40);
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               return;
      }
   }

}

