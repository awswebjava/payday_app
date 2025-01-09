package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconvenioadicional extends GXProcedure
{
   public updateconvenioadicional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconvenioadicional.class ), "" );
   }

   public updateconvenioadicional( int remoteHandle ,
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
      updateconvenioadicional.this.AV15ClientePadre = aP0;
      updateconvenioadicional.this.AV13CliCod = aP1;
      updateconvenioadicional.this.AV18CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV22padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV15ClientePadre), AV18CliRelSec, GXv_dtime1) ;
      updateconvenioadicional.this.AV22padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV15ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV18CliRelSec, 6, 0))) ;
      AV28GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV18CliRelSec) ,
                                           Integer.valueOf(A1901ConveAdiRelSec) ,
                                           Long.valueOf(AV15ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RG2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV15ClientePadre), Integer.valueOf(AV18CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1901ConveAdiRelSec = P01RG2_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = P01RG2_n1901ConveAdiRelSec[0] ;
         A3CliCod = P01RG2_A3CliCod[0] ;
         A1564CliPaiConve = P01RG2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RG2_A1565CliConvenio[0] ;
         A998ConveAdiAli = P01RG2_A998ConveAdiAli[0] ;
         A996ConveAdicod = P01RG2_A996ConveAdicod[0] ;
         A997ConveAdiDescri = P01RG2_A997ConveAdiDescri[0] ;
         A1019ConveAdiInfo = P01RG2_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = P01RG2_n1019ConveAdiInfo[0] ;
         A1803ConveAdiTipo = P01RG2_A1803ConveAdiTipo[0] ;
         AV28GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV24clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV13CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconvenioadicional.this.AV24clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV24clienteConvenioTiene )
         {
            AV21item = (web.SdtsdtAdicional_sdtAdicionalItem)new web.SdtsdtAdicional_sdtAdicionalItem(remoteHandle, context);
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio( A1565CliConvenio );
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve( A1564CliPaiConve );
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali( A998ConveAdiAli );
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod( A996ConveAdicod );
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri( A997ConveAdiDescri );
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo( A1019ConveAdiInfo );
            AV21item.setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo( A1803ConveAdiTipo );
            AV23sdtConvenioAdicional.add(AV21item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV28GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      if ( AV23sdtConvenioAdicional.size() > 0 )
      {
         AV29GXLvl27 = (byte)(0) ;
         /* Using cursor P01RG3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RG3_A3CliCod[0] ;
            AV29GXLvl27 = (byte)(1) ;
            AV19hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "2") ;
            AV30GXV1 = 1 ;
            while ( AV30GXV1 <= AV23sdtConvenioAdicional.size() )
            {
               AV21item = (web.SdtsdtAdicional_sdtAdicionalItem)((web.SdtsdtAdicional_sdtAdicionalItem)AV23sdtConvenioAdicional.elementAt(-1+AV30GXV1));
               AV17CliPaiConve = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve() ;
               AV14CliConvenio = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio() ;
               AV9ConveAdicod = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod() ;
               AV10ConveAdiDescri = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri() ;
               AV8ConveAdiAli = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali() ;
               AV11ConveAdiInfo = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo() ;
               AV12ConveAdiTipo = AV21item.getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV30GXV1 = (int)(AV30GXV1+1) ;
            }
            if ( ! (0==AV18CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV29GXLvl27 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "none 2....", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "4") ;
      AV31GXLvl56 = (byte)(0) ;
      /* Using cursor P01RG4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV19hijoCliCod), Short.valueOf(AV17CliPaiConve), AV14CliConvenio, AV9ConveAdicod});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A996ConveAdicod = P01RG4_A996ConveAdicod[0] ;
         A1565CliConvenio = P01RG4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RG4_A1564CliPaiConve[0] ;
         A3CliCod = P01RG4_A3CliCod[0] ;
         A1901ConveAdiRelSec = P01RG4_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = P01RG4_n1901ConveAdiRelSec[0] ;
         A997ConveAdiDescri = P01RG4_A997ConveAdiDescri[0] ;
         A998ConveAdiAli = P01RG4_A998ConveAdiAli[0] ;
         A1019ConveAdiInfo = P01RG4_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = P01RG4_n1019ConveAdiInfo[0] ;
         A1803ConveAdiTipo = P01RG4_A1803ConveAdiTipo[0] ;
         AV31GXLvl56 = (byte)(1) ;
         GXv_dtime1[0] = AV20hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1901ConveAdiRelSec, GXv_dtime1) ;
         updateconvenioadicional.this.AV20hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV22padreReleaseDateTime.after( AV20hijoReleaseDateTime ) )
         {
            A997ConveAdiDescri = AV10ConveAdiDescri ;
            A998ConveAdiAli = AV8ConveAdiAli ;
            A1019ConveAdiInfo = AV11ConveAdiInfo ;
            n1019ConveAdiInfo = false ;
            A1803ConveAdiTipo = AV12ConveAdiTipo ;
            A1901ConveAdiRelSec = AV18CliRelSec ;
            n1901ConveAdiRelSec = false ;
         }
         /* Using cursor P01RG5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n1901ConveAdiRelSec), Integer.valueOf(A1901ConveAdiRelSec), A997ConveAdiDescri, A998ConveAdiAli, Boolean.valueOf(n1019ConveAdiInfo), A1019ConveAdiInfo, A1803ConveAdiTipo, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV31GXLvl56 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "5") ;
         new web.newconvenioadicional(remoteHandle, context).execute( AV19hijoCliCod, AV17CliPaiConve, AV14CliConvenio, AV10ConveAdiDescri, AV9ConveAdicod, AV8ConveAdiAli, AV12ConveAdiTipo, AV18CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconvenioadicional");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV27Pgmname = "" ;
      scmdbuf = "" ;
      P01RG2_A1901ConveAdiRelSec = new int[1] ;
      P01RG2_n1901ConveAdiRelSec = new boolean[] {false} ;
      P01RG2_A3CliCod = new int[1] ;
      P01RG2_A1564CliPaiConve = new short[1] ;
      P01RG2_A1565CliConvenio = new String[] {""} ;
      P01RG2_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RG2_A996ConveAdicod = new String[] {""} ;
      P01RG2_A997ConveAdiDescri = new String[] {""} ;
      P01RG2_A1019ConveAdiInfo = new String[] {""} ;
      P01RG2_n1019ConveAdiInfo = new boolean[] {false} ;
      P01RG2_A1803ConveAdiTipo = new String[] {""} ;
      A1565CliConvenio = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      A996ConveAdicod = "" ;
      A997ConveAdiDescri = "" ;
      A1019ConveAdiInfo = "" ;
      A1803ConveAdiTipo = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV21item = new web.SdtsdtAdicional_sdtAdicionalItem(remoteHandle, context);
      AV23sdtConvenioAdicional = new GXBaseCollection<web.SdtsdtAdicional_sdtAdicionalItem>(web.SdtsdtAdicional_sdtAdicionalItem.class, "sdtAdicionalItem", "PayDay", remoteHandle);
      P01RG3_A3CliCod = new int[1] ;
      AV14CliConvenio = "" ;
      AV9ConveAdicod = "" ;
      AV10ConveAdiDescri = "" ;
      AV8ConveAdiAli = DecimalUtil.ZERO ;
      AV11ConveAdiInfo = "" ;
      AV12ConveAdiTipo = "" ;
      P01RG4_A996ConveAdicod = new String[] {""} ;
      P01RG4_A1565CliConvenio = new String[] {""} ;
      P01RG4_A1564CliPaiConve = new short[1] ;
      P01RG4_A3CliCod = new int[1] ;
      P01RG4_A1901ConveAdiRelSec = new int[1] ;
      P01RG4_n1901ConveAdiRelSec = new boolean[] {false} ;
      P01RG4_A997ConveAdiDescri = new String[] {""} ;
      P01RG4_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RG4_A1019ConveAdiInfo = new String[] {""} ;
      P01RG4_n1019ConveAdiInfo = new boolean[] {false} ;
      P01RG4_A1803ConveAdiTipo = new String[] {""} ;
      AV20hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconvenioadicional__default(),
         new Object[] {
             new Object[] {
            P01RG2_A1901ConveAdiRelSec, P01RG2_n1901ConveAdiRelSec, P01RG2_A3CliCod, P01RG2_A1564CliPaiConve, P01RG2_A1565CliConvenio, P01RG2_A998ConveAdiAli, P01RG2_A996ConveAdicod, P01RG2_A997ConveAdiDescri, P01RG2_A1019ConveAdiInfo, P01RG2_n1019ConveAdiInfo,
            P01RG2_A1803ConveAdiTipo
            }
            , new Object[] {
            P01RG3_A3CliCod
            }
            , new Object[] {
            P01RG4_A996ConveAdicod, P01RG4_A1565CliConvenio, P01RG4_A1564CliPaiConve, P01RG4_A3CliCod, P01RG4_A1901ConveAdiRelSec, P01RG4_n1901ConveAdiRelSec, P01RG4_A997ConveAdiDescri, P01RG4_A998ConveAdiAli, P01RG4_A1019ConveAdiInfo, P01RG4_n1019ConveAdiInfo,
            P01RG4_A1803ConveAdiTipo
            }
            , new Object[] {
            }
         }
      );
      AV27Pgmname = "updateConvenioAdicional" ;
      /* GeneXus formulas. */
      AV27Pgmname = "updateConvenioAdicional" ;
      Gx_err = (short)(0) ;
   }

   private byte AV28GXLvl4 ;
   private byte AV29GXLvl27 ;
   private byte AV31GXLvl56 ;
   private short A1564CliPaiConve ;
   private short AV17CliPaiConve ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV18CliRelSec ;
   private int A1901ConveAdiRelSec ;
   private int A3CliCod ;
   private int AV19hijoCliCod ;
   private int AV30GXV1 ;
   private long AV15ClientePadre ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private java.math.BigDecimal AV8ConveAdiAli ;
   private String AV27Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1803ConveAdiTipo ;
   private String AV14CliConvenio ;
   private String AV9ConveAdicod ;
   private String AV12ConveAdiTipo ;
   private java.util.Date AV22padreReleaseDateTime ;
   private java.util.Date AV20hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean n1901ConveAdiRelSec ;
   private boolean n1019ConveAdiInfo ;
   private boolean AV24clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String A1019ConveAdiInfo ;
   private String AV11ConveAdiInfo ;
   private String A997ConveAdiDescri ;
   private String AV10ConveAdiDescri ;
   private IDataStoreProvider pr_default ;
   private int[] P01RG2_A1901ConveAdiRelSec ;
   private boolean[] P01RG2_n1901ConveAdiRelSec ;
   private int[] P01RG2_A3CliCod ;
   private short[] P01RG2_A1564CliPaiConve ;
   private String[] P01RG2_A1565CliConvenio ;
   private java.math.BigDecimal[] P01RG2_A998ConveAdiAli ;
   private String[] P01RG2_A996ConveAdicod ;
   private String[] P01RG2_A997ConveAdiDescri ;
   private String[] P01RG2_A1019ConveAdiInfo ;
   private boolean[] P01RG2_n1019ConveAdiInfo ;
   private String[] P01RG2_A1803ConveAdiTipo ;
   private int[] P01RG3_A3CliCod ;
   private String[] P01RG4_A996ConveAdicod ;
   private String[] P01RG4_A1565CliConvenio ;
   private short[] P01RG4_A1564CliPaiConve ;
   private int[] P01RG4_A3CliCod ;
   private int[] P01RG4_A1901ConveAdiRelSec ;
   private boolean[] P01RG4_n1901ConveAdiRelSec ;
   private String[] P01RG4_A997ConveAdiDescri ;
   private java.math.BigDecimal[] P01RG4_A998ConveAdiAli ;
   private String[] P01RG4_A1019ConveAdiInfo ;
   private boolean[] P01RG4_n1019ConveAdiInfo ;
   private String[] P01RG4_A1803ConveAdiTipo ;
   private GXBaseCollection<web.SdtsdtAdicional_sdtAdicionalItem> AV23sdtConvenioAdicional ;
   private web.SdtsdtAdicional_sdtAdicionalItem AV21item ;
}

final  class updateconvenioadicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV18CliRelSec ,
                                          int A1901ConveAdiRelSec ,
                                          long AV15ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveAdiRelSec, CliCod, CliPaiConve, CliConvenio, ConveAdiAli, ConveAdicod, ConveAdiDescri, ConveAdiInfo, ConveAdiTipo FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV18CliRelSec) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec = ?)");
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
                  return conditional_P01RG2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RG3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RG4", "SELECT ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiRelSec, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo FROM convenio_adicional WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod  FOR UPDATE OF convenio_adicional",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RG5", "SAVEPOINT gxupdate;UPDATE convenio_adicional SET ConveAdiRelSec=?, ConveAdiDescri=?, ConveAdiAli=?, ConveAdiInfo=?, ConveAdiTipo=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
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
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 4);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[5]);
               }
               stmt.setString(5, (String)parms[6], 20);
               stmt.setInt(6, ((Number) parms[7]).intValue());
               stmt.setShort(7, ((Number) parms[8]).shortValue());
               stmt.setString(8, (String)parms[9], 20);
               stmt.setString(9, (String)parms[10], 20);
               return;
      }
   }

}

