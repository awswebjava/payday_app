package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconveniovacaciones extends GXProcedure
{
   public updateconveniovacaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconveniovacaciones.class ), "" );
   }

   public updateconveniovacaciones( int remoteHandle ,
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
      updateconveniovacaciones.this.AV16ClientePadre = aP0;
      updateconveniovacaciones.this.AV14CliCod = aP1;
      updateconveniovacaciones.this.AV19CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV23padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV16ClientePadre), AV19CliRelSec, GXv_dtime1) ;
      updateconveniovacaciones.this.AV23padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV16ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV19CliRelSec, 6, 0))) ;
      AV38GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV19CliRelSec) ,
                                           Integer.valueOf(A1902ConveVacRelSec) ,
                                           Long.valueOf(AV16ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RL2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV16ClientePadre), Integer.valueOf(AV19CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1902ConveVacRelSec = P01RL2_A1902ConveVacRelSec[0] ;
         A3CliCod = P01RL2_A3CliCod[0] ;
         A1564CliPaiConve = P01RL2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RL2_A1565CliConvenio[0] ;
         A1575CliConveVig = P01RL2_A1575CliConveVig[0] ;
         A1761CliConveVacDesAnt = P01RL2_A1761CliConveVacDesAnt[0] ;
         A1762CliConveVacHasAnt = P01RL2_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = P01RL2_A1763CliConveVacDias[0] ;
         AV38GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV34clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV14CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconveniovacaciones.this.AV34clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV34clienteConvenioTiene )
         {
            AV27item = (web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem)new web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem(remoteHandle, context);
            AV27item.setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio( A1565CliConvenio );
            AV27item.setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve( A1564CliPaiConve );
            AV27item.setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig( A1575CliConveVig );
            AV27item.setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant( A1761CliConveVacDesAnt );
            AV27item.setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant( A1762CliConveVacHasAnt );
            AV27item.setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias( A1763CliConveVacDias );
            AV29sdtConvenioVacaciones.add(AV27item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV38GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      if ( AV29sdtConvenioVacaciones.size() > 0 )
      {
         AV39GXLvl25 = (byte)(0) ;
         /* Using cursor P01RL3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RL3_A3CliCod[0] ;
            AV39GXLvl25 = (byte)(1) ;
            AV20hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "2") ;
            AV40GXV1 = 1 ;
            while ( AV40GXV1 <= AV29sdtConvenioVacaciones.size() )
            {
               AV27item = (web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem)((web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem)AV29sdtConvenioVacaciones.elementAt(-1+AV40GXV1));
               AV15CliConvenio = AV27item.getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio() ;
               AV18CliPaiConve = AV27item.getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve() ;
               AV31CliConveVig = AV27item.getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig() ;
               AV30CliConveVacDesAnt = AV27item.getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant() ;
               AV32CliConveVacHasAnt = AV27item.getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant() ;
               AV33CliConveVacDias = AV27item.getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV40GXV1 = (int)(AV40GXV1+1) ;
            }
            if ( ! (0==AV19CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV39GXLvl25 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "4") ;
      AV41GXLvl51 = (byte)(0) ;
      /* Using cursor P01RL4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV20hijoCliCod), Short.valueOf(AV18CliPaiConve), AV15CliConvenio, AV31CliConveVig, Byte.valueOf(AV30CliConveVacDesAnt)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1761CliConveVacDesAnt = P01RL4_A1761CliConveVacDesAnt[0] ;
         A1575CliConveVig = P01RL4_A1575CliConveVig[0] ;
         A1565CliConvenio = P01RL4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RL4_A1564CliPaiConve[0] ;
         A3CliCod = P01RL4_A3CliCod[0] ;
         A1902ConveVacRelSec = P01RL4_A1902ConveVacRelSec[0] ;
         A1762CliConveVacHasAnt = P01RL4_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = P01RL4_A1763CliConveVacDias[0] ;
         AV41GXLvl51 = (byte)(1) ;
         GXv_dtime1[0] = AV21hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1902ConveVacRelSec, GXv_dtime1) ;
         updateconveniovacaciones.this.AV21hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV23padreReleaseDateTime.after( AV21hijoReleaseDateTime ) )
         {
            A1902ConveVacRelSec = AV19CliRelSec ;
            A1762CliConveVacHasAnt = AV32CliConveVacHasAnt ;
            A1763CliConveVacDias = AV33CliConveVacDias ;
         }
         /* Using cursor P01RL5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1902ConveVacRelSec), Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV41GXLvl51 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "5") ;
         new web.newconveniovacaciones(remoteHandle, context).execute( AV20hijoCliCod, AV18CliPaiConve, AV15CliConvenio, AV31CliConveVig, AV30CliConveVacDesAnt, AV32CliConveVacHasAnt, AV33CliConveVacDias, AV19CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconveniovacaciones");
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
      AV37Pgmname = "" ;
      scmdbuf = "" ;
      P01RL2_A1902ConveVacRelSec = new int[1] ;
      P01RL2_A3CliCod = new int[1] ;
      P01RL2_A1564CliPaiConve = new short[1] ;
      P01RL2_A1565CliConvenio = new String[] {""} ;
      P01RL2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RL2_A1761CliConveVacDesAnt = new byte[1] ;
      P01RL2_A1762CliConveVacHasAnt = new byte[1] ;
      P01RL2_A1763CliConveVacDias = new byte[1] ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      AV27item = new web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem(remoteHandle, context);
      AV29sdtConvenioVacaciones = new GXBaseCollection<web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem>(web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem.class, "sdtConvenioVacacionesItem", "PayDay", remoteHandle);
      P01RL3_A3CliCod = new int[1] ;
      AV15CliConvenio = "" ;
      AV31CliConveVig = GXutil.nullDate() ;
      P01RL4_A1761CliConveVacDesAnt = new byte[1] ;
      P01RL4_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RL4_A1565CliConvenio = new String[] {""} ;
      P01RL4_A1564CliPaiConve = new short[1] ;
      P01RL4_A3CliCod = new int[1] ;
      P01RL4_A1902ConveVacRelSec = new int[1] ;
      P01RL4_A1762CliConveVacHasAnt = new byte[1] ;
      P01RL4_A1763CliConveVacDias = new byte[1] ;
      AV21hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconveniovacaciones__default(),
         new Object[] {
             new Object[] {
            P01RL2_A1902ConveVacRelSec, P01RL2_A3CliCod, P01RL2_A1564CliPaiConve, P01RL2_A1565CliConvenio, P01RL2_A1575CliConveVig, P01RL2_A1761CliConveVacDesAnt, P01RL2_A1762CliConveVacHasAnt, P01RL2_A1763CliConveVacDias
            }
            , new Object[] {
            P01RL3_A3CliCod
            }
            , new Object[] {
            P01RL4_A1761CliConveVacDesAnt, P01RL4_A1575CliConveVig, P01RL4_A1565CliConvenio, P01RL4_A1564CliPaiConve, P01RL4_A3CliCod, P01RL4_A1902ConveVacRelSec, P01RL4_A1762CliConveVacHasAnt, P01RL4_A1763CliConveVacDias
            }
            , new Object[] {
            }
         }
      );
      AV37Pgmname = "updateConvenioVacaciones" ;
      /* GeneXus formulas. */
      AV37Pgmname = "updateConvenioVacaciones" ;
      Gx_err = (short)(0) ;
   }

   private byte AV38GXLvl4 ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1763CliConveVacDias ;
   private byte AV39GXLvl25 ;
   private byte AV30CliConveVacDesAnt ;
   private byte AV32CliConveVacHasAnt ;
   private byte AV33CliConveVacDias ;
   private byte AV41GXLvl51 ;
   private short A1564CliPaiConve ;
   private short AV18CliPaiConve ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV19CliRelSec ;
   private int A1902ConveVacRelSec ;
   private int A3CliCod ;
   private int AV20hijoCliCod ;
   private int AV40GXV1 ;
   private long AV16ClientePadre ;
   private String AV37Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String AV15CliConvenio ;
   private java.util.Date AV23padreReleaseDateTime ;
   private java.util.Date AV21hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV31CliConveVig ;
   private boolean AV34clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P01RL2_A1902ConveVacRelSec ;
   private int[] P01RL2_A3CliCod ;
   private short[] P01RL2_A1564CliPaiConve ;
   private String[] P01RL2_A1565CliConvenio ;
   private java.util.Date[] P01RL2_A1575CliConveVig ;
   private byte[] P01RL2_A1761CliConveVacDesAnt ;
   private byte[] P01RL2_A1762CliConveVacHasAnt ;
   private byte[] P01RL2_A1763CliConveVacDias ;
   private int[] P01RL3_A3CliCod ;
   private byte[] P01RL4_A1761CliConveVacDesAnt ;
   private java.util.Date[] P01RL4_A1575CliConveVig ;
   private String[] P01RL4_A1565CliConvenio ;
   private short[] P01RL4_A1564CliPaiConve ;
   private int[] P01RL4_A3CliCod ;
   private int[] P01RL4_A1902ConveVacRelSec ;
   private byte[] P01RL4_A1762CliConveVacHasAnt ;
   private byte[] P01RL4_A1763CliConveVacDias ;
   private GXBaseCollection<web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem> AV29sdtConvenioVacaciones ;
   private web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem AV27item ;
}

final  class updateconveniovacaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV19CliRelSec ,
                                          int A1902ConveVacRelSec ,
                                          long AV16ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveVacRelSec, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias FROM ClienteConvenio_ParticularidadesVacacion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV19CliRelSec) )
      {
         addWhere(sWhereString, "(ConveVacRelSec = ?)");
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
                  return conditional_P01RL2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RL3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RL4", "SELECT CliConveVacDesAnt, CliConveVig, CliConvenio, CliPaiConve, CliCod, ConveVacRelSec, CliConveVacHasAnt, CliConveVacDias FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? and CliConveVacDesAnt = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt  FOR UPDATE OF ClienteConvenio_ParticularidadesVacacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RL5", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_ParticularidadesVacacion SET ConveVacRelSec=?, CliConveVacHasAnt=?, CliConveVacDias=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
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
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               return;
      }
   }

}

