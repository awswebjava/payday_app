package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconvenioadicionalcancelan extends GXProcedure
{
   public updateconvenioadicionalcancelan( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconvenioadicionalcancelan.class ), "" );
   }

   public updateconvenioadicionalcancelan( int remoteHandle ,
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
      updateconvenioadicionalcancelan.this.AV12ClientePadre = aP0;
      updateconvenioadicionalcancelan.this.AV10CliCod = aP1;
      updateconvenioadicionalcancelan.this.AV15CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV19padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV12ClientePadre), AV15CliRelSec, GXv_dtime1) ;
      updateconvenioadicionalcancelan.this.AV19padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV12ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV15CliRelSec, 6, 0))) ;
      AV25GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV15CliRelSec) ,
                                           Integer.valueOf(A1898ConveAdiSitCanRelSec) ,
                                           Long.valueOf(AV12ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RI2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV12ClientePadre), Integer.valueOf(AV15CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1898ConveAdiSitCanRelSec = P01RI2_A1898ConveAdiSitCanRelSec[0] ;
         A3CliCod = P01RI2_A3CliCod[0] ;
         A1564CliPaiConve = P01RI2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RI2_A1565CliConvenio[0] ;
         A996ConveAdicod = P01RI2_A996ConveAdicod[0] ;
         A1824ConveAdiSitCancela = P01RI2_A1824ConveAdiSitCancela[0] ;
         AV25GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV21clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV10CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconvenioadicionalcancelan.this.AV21clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV21clienteConvenioTiene )
         {
            AV18item = (web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem)new web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem(remoteHandle, context);
            AV18item.setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve( A1564CliPaiConve );
            AV18item.setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio( A1565CliConvenio );
            AV18item.setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod( A996ConveAdicod );
            AV18item.setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela( A1824ConveAdiSitCancela );
            AV20sdtAdicionalCancelan.add(AV18item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      if ( AV20sdtAdicionalCancelan.size() > 0 )
      {
         AV26GXLvl24 = (byte)(0) ;
         /* Using cursor P01RI3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RI3_A3CliCod[0] ;
            AV26GXLvl24 = (byte)(1) ;
            AV16hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, "2") ;
            AV27GXV1 = 1 ;
            while ( AV27GXV1 <= AV20sdtAdicionalCancelan.size() )
            {
               AV18item = (web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem)((web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem)AV20sdtAdicionalCancelan.elementAt(-1+AV27GXV1));
               AV14CliPaiConve = AV18item.getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve() ;
               AV11CliConvenio = AV18item.getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio() ;
               AV8ConveAdicod = AV18item.getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod() ;
               AV9ConveAdiSitCancela = AV18item.getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV27GXV1 = (int)(AV27GXV1+1) ;
            }
            if ( ! (0==AV15CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV26GXLvl24 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, "4") ;
      AV28GXLvl50 = (byte)(0) ;
      /* Using cursor P01RI4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV16hijoCliCod), Short.valueOf(AV14CliPaiConve), AV11CliConvenio, AV8ConveAdicod, AV9ConveAdiSitCancela});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1824ConveAdiSitCancela = P01RI4_A1824ConveAdiSitCancela[0] ;
         A996ConveAdicod = P01RI4_A996ConveAdicod[0] ;
         A1565CliConvenio = P01RI4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RI4_A1564CliPaiConve[0] ;
         A3CliCod = P01RI4_A3CliCod[0] ;
         A1898ConveAdiSitCanRelSec = P01RI4_A1898ConveAdiSitCanRelSec[0] ;
         AV28GXLvl50 = (byte)(1) ;
         GXv_dtime1[0] = AV17hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1898ConveAdiSitCanRelSec, GXv_dtime1) ;
         updateconvenioadicionalcancelan.this.AV17hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV19padreReleaseDateTime.after( AV17hijoReleaseDateTime ) )
         {
            A1898ConveAdiSitCanRelSec = AV15CliRelSec ;
         }
         /* Using cursor P01RI5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1898ConveAdiSitCanRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV28GXLvl50 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, "5") ;
         new web.newconvenioadicionalcancelan(remoteHandle, context).execute( AV16hijoCliCod, AV14CliPaiConve, AV11CliConvenio, AV8ConveAdicod, AV9ConveAdiSitCancela, AV15CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconvenioadicionalcancelan");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV24Pgmname = "" ;
      scmdbuf = "" ;
      P01RI2_A1898ConveAdiSitCanRelSec = new int[1] ;
      P01RI2_A3CliCod = new int[1] ;
      P01RI2_A1564CliPaiConve = new short[1] ;
      P01RI2_A1565CliConvenio = new String[] {""} ;
      P01RI2_A996ConveAdicod = new String[] {""} ;
      P01RI2_A1824ConveAdiSitCancela = new String[] {""} ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1824ConveAdiSitCancela = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV18item = new web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem(remoteHandle, context);
      AV20sdtAdicionalCancelan = new GXBaseCollection<web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem>(web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem.class, "sdtAdicionalCancelanItem", "PayDay", remoteHandle);
      P01RI3_A3CliCod = new int[1] ;
      AV11CliConvenio = "" ;
      AV8ConveAdicod = "" ;
      AV9ConveAdiSitCancela = "" ;
      P01RI4_A1824ConveAdiSitCancela = new String[] {""} ;
      P01RI4_A996ConveAdicod = new String[] {""} ;
      P01RI4_A1565CliConvenio = new String[] {""} ;
      P01RI4_A1564CliPaiConve = new short[1] ;
      P01RI4_A3CliCod = new int[1] ;
      P01RI4_A1898ConveAdiSitCanRelSec = new int[1] ;
      AV17hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconvenioadicionalcancelan__default(),
         new Object[] {
             new Object[] {
            P01RI2_A1898ConveAdiSitCanRelSec, P01RI2_A3CliCod, P01RI2_A1564CliPaiConve, P01RI2_A1565CliConvenio, P01RI2_A996ConveAdicod, P01RI2_A1824ConveAdiSitCancela
            }
            , new Object[] {
            P01RI3_A3CliCod
            }
            , new Object[] {
            P01RI4_A1824ConveAdiSitCancela, P01RI4_A996ConveAdicod, P01RI4_A1565CliConvenio, P01RI4_A1564CliPaiConve, P01RI4_A3CliCod, P01RI4_A1898ConveAdiSitCanRelSec
            }
            , new Object[] {
            }
         }
      );
      AV24Pgmname = "updateConvenioAdicionalCancelan" ;
      /* GeneXus formulas. */
      AV24Pgmname = "updateConvenioAdicionalCancelan" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl4 ;
   private byte AV26GXLvl24 ;
   private byte AV28GXLvl50 ;
   private short A1564CliPaiConve ;
   private short AV14CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV15CliRelSec ;
   private int A1898ConveAdiSitCanRelSec ;
   private int A3CliCod ;
   private int AV16hijoCliCod ;
   private int AV27GXV1 ;
   private long AV12ClientePadre ;
   private String AV24Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1824ConveAdiSitCancela ;
   private String AV11CliConvenio ;
   private String AV8ConveAdicod ;
   private String AV9ConveAdiSitCancela ;
   private java.util.Date AV19padreReleaseDateTime ;
   private java.util.Date AV17hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean AV21clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P01RI2_A1898ConveAdiSitCanRelSec ;
   private int[] P01RI2_A3CliCod ;
   private short[] P01RI2_A1564CliPaiConve ;
   private String[] P01RI2_A1565CliConvenio ;
   private String[] P01RI2_A996ConveAdicod ;
   private String[] P01RI2_A1824ConveAdiSitCancela ;
   private int[] P01RI3_A3CliCod ;
   private String[] P01RI4_A1824ConveAdiSitCancela ;
   private String[] P01RI4_A996ConveAdicod ;
   private String[] P01RI4_A1565CliConvenio ;
   private short[] P01RI4_A1564CliPaiConve ;
   private int[] P01RI4_A3CliCod ;
   private int[] P01RI4_A1898ConveAdiSitCanRelSec ;
   private GXBaseCollection<web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem> AV20sdtAdicionalCancelan ;
   private web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem AV18item ;
}

final  class updateconvenioadicionalcancelan__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV15CliRelSec ,
                                          int A1898ConveAdiSitCanRelSec ,
                                          long AV12ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveAdiSitCanRelSec, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV15CliRelSec) )
      {
         addWhere(sWhereString, "(ConveAdiSitCanRelSec = ?)");
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
                  return conditional_P01RI2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RI3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RI4", "SELECT ConveAdiSitCancela, ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiSitCanRelSec FROM convenio_adicionalCancela WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiSitCancela = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela  FOR UPDATE OF convenio_adicionalCancela",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RI5", "SAVEPOINT gxupdate;UPDATE convenio_adicionalCancela SET ConveAdiSitCanRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[5])[0] = rslt.getString(6, 4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 4);
               return;
      }
   }

}

