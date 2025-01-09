package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconvenioadicionalalicuotas extends GXProcedure
{
   public updateconvenioadicionalalicuotas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconvenioadicionalalicuotas.class ), "" );
   }

   public updateconvenioadicionalalicuotas( int remoteHandle ,
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
      updateconvenioadicionalalicuotas.this.AV11ClientePadre = aP0;
      updateconvenioadicionalalicuotas.this.AV9CliCod = aP1;
      updateconvenioadicionalalicuotas.this.AV14CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV18padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV11ClientePadre), AV14CliRelSec, GXv_dtime1) ;
      updateconvenioadicionalalicuotas.this.AV18padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV11ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0))) ;
      AV29GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV14CliRelSec) ,
                                           Integer.valueOf(A1900ConveAdiOpcRelSec) ,
                                           Long.valueOf(AV11ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RJ2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV11ClientePadre), Integer.valueOf(AV14CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1900ConveAdiOpcRelSec = P01RJ2_A1900ConveAdiOpcRelSec[0] ;
         A3CliCod = P01RJ2_A3CliCod[0] ;
         A1564CliPaiConve = P01RJ2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RJ2_A1565CliConvenio[0] ;
         A996ConveAdicod = P01RJ2_A996ConveAdicod[0] ;
         A1011ConveAdiOpcCod = P01RJ2_A1011ConveAdiOpcCod[0] ;
         A1021ConveAdiOpcFor = P01RJ2_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = P01RJ2_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = P01RJ2_A1013ConveAdiOpcAli[0] ;
         AV29GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV25clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV9CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconvenioadicionalalicuotas.this.AV25clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV25clienteConvenioTiene )
         {
            AV17item = (web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem)new web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem(remoteHandle, context);
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve( A1564CliPaiConve );
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio( A1565CliConvenio );
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod( A996ConveAdicod );
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod( A1011ConveAdiOpcCod );
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor( A1021ConveAdiOpcFor );
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes( A1012ConveAdiOpcDes );
            AV17item.setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali( A1013ConveAdiOpcAli );
            AV20sdtAdicionalAlicuotas.add(AV17item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV29GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))) ;
      if ( AV20sdtAdicionalAlicuotas.size() > 0 )
      {
         AV30GXLvl27 = (byte)(0) ;
         /* Using cursor P01RJ3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RJ3_A3CliCod[0] ;
            AV30GXLvl27 = (byte)(1) ;
            AV15hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "2") ;
            AV31GXV1 = 1 ;
            while ( AV31GXV1 <= AV20sdtAdicionalAlicuotas.size() )
            {
               AV17item = (web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem)((web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem)AV20sdtAdicionalAlicuotas.elementAt(-1+AV31GXV1));
               AV13CliPaiConve = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve() ;
               AV10CliConvenio = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio() ;
               AV8ConveAdicod = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod() ;
               AV23ConveAdiOpcCod = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod() ;
               AV22ConveAdiOpcFor = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor() ;
               AV21ConveAdiOpcDes = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes() ;
               AV24ConveAdiOpcAli = AV17item.getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali() ;
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
            if ( ! (0==AV14CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV30GXLvl27 == 0 )
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
      AV32GXLvl56 = (byte)(0) ;
      /* Using cursor P01RJ4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV15hijoCliCod), Short.valueOf(AV13CliPaiConve), AV10CliConvenio, AV8ConveAdicod, Short.valueOf(AV23ConveAdiOpcCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1011ConveAdiOpcCod = P01RJ4_A1011ConveAdiOpcCod[0] ;
         A996ConveAdicod = P01RJ4_A996ConveAdicod[0] ;
         A1565CliConvenio = P01RJ4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RJ4_A1564CliPaiConve[0] ;
         A3CliCod = P01RJ4_A3CliCod[0] ;
         A1900ConveAdiOpcRelSec = P01RJ4_A1900ConveAdiOpcRelSec[0] ;
         A1021ConveAdiOpcFor = P01RJ4_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = P01RJ4_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = P01RJ4_A1013ConveAdiOpcAli[0] ;
         AV32GXLvl56 = (byte)(1) ;
         GXv_dtime1[0] = AV16hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1900ConveAdiOpcRelSec, GXv_dtime1) ;
         updateconvenioadicionalalicuotas.this.AV16hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV18padreReleaseDateTime.after( AV16hijoReleaseDateTime ) )
         {
            A1900ConveAdiOpcRelSec = AV14CliRelSec ;
            A1021ConveAdiOpcFor = AV22ConveAdiOpcFor ;
            A1012ConveAdiOpcDes = AV21ConveAdiOpcDes ;
            A1013ConveAdiOpcAli = AV24ConveAdiOpcAli ;
         }
         /* Using cursor P01RJ5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1900ConveAdiOpcRelSec), A1021ConveAdiOpcFor, A1012ConveAdiOpcDes, A1013ConveAdiOpcAli, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV32GXLvl56 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "5") ;
         new web.newconvenioadicionalopciones(remoteHandle, context).execute( AV15hijoCliCod, AV13CliPaiConve, AV10CliConvenio, AV8ConveAdicod, AV23ConveAdiOpcCod, AV22ConveAdiOpcFor, AV21ConveAdiOpcDes, AV24ConveAdiOpcAli, AV14CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconvenioadicionalalicuotas");
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
      AV28Pgmname = "" ;
      scmdbuf = "" ;
      P01RJ2_A1900ConveAdiOpcRelSec = new int[1] ;
      P01RJ2_A3CliCod = new int[1] ;
      P01RJ2_A1564CliPaiConve = new short[1] ;
      P01RJ2_A1565CliConvenio = new String[] {""} ;
      P01RJ2_A996ConveAdicod = new String[] {""} ;
      P01RJ2_A1011ConveAdiOpcCod = new short[1] ;
      P01RJ2_A1021ConveAdiOpcFor = new String[] {""} ;
      P01RJ2_A1012ConveAdiOpcDes = new String[] {""} ;
      P01RJ2_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      GXv_boolean2 = new boolean[1] ;
      AV17item = new web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem(remoteHandle, context);
      AV20sdtAdicionalAlicuotas = new GXBaseCollection<web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem>(web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem.class, "sdtAdicionalAlicuotasItem", "PayDay", remoteHandle);
      P01RJ3_A3CliCod = new int[1] ;
      AV10CliConvenio = "" ;
      AV8ConveAdicod = "" ;
      AV22ConveAdiOpcFor = "" ;
      AV21ConveAdiOpcDes = "" ;
      AV24ConveAdiOpcAli = DecimalUtil.ZERO ;
      P01RJ4_A1011ConveAdiOpcCod = new short[1] ;
      P01RJ4_A996ConveAdicod = new String[] {""} ;
      P01RJ4_A1565CliConvenio = new String[] {""} ;
      P01RJ4_A1564CliPaiConve = new short[1] ;
      P01RJ4_A3CliCod = new int[1] ;
      P01RJ4_A1900ConveAdiOpcRelSec = new int[1] ;
      P01RJ4_A1021ConveAdiOpcFor = new String[] {""} ;
      P01RJ4_A1012ConveAdiOpcDes = new String[] {""} ;
      P01RJ4_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV16hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconvenioadicionalalicuotas__default(),
         new Object[] {
             new Object[] {
            P01RJ2_A1900ConveAdiOpcRelSec, P01RJ2_A3CliCod, P01RJ2_A1564CliPaiConve, P01RJ2_A1565CliConvenio, P01RJ2_A996ConveAdicod, P01RJ2_A1011ConveAdiOpcCod, P01RJ2_A1021ConveAdiOpcFor, P01RJ2_A1012ConveAdiOpcDes, P01RJ2_A1013ConveAdiOpcAli
            }
            , new Object[] {
            P01RJ3_A3CliCod
            }
            , new Object[] {
            P01RJ4_A1011ConveAdiOpcCod, P01RJ4_A996ConveAdicod, P01RJ4_A1565CliConvenio, P01RJ4_A1564CliPaiConve, P01RJ4_A3CliCod, P01RJ4_A1900ConveAdiOpcRelSec, P01RJ4_A1021ConveAdiOpcFor, P01RJ4_A1012ConveAdiOpcDes, P01RJ4_A1013ConveAdiOpcAli
            }
            , new Object[] {
            }
         }
      );
      AV28Pgmname = "updateConvenioAdicionalAlicuotas" ;
      /* GeneXus formulas. */
      AV28Pgmname = "updateConvenioAdicionalAlicuotas" ;
      Gx_err = (short)(0) ;
   }

   private byte AV29GXLvl4 ;
   private byte AV30GXLvl27 ;
   private byte AV32GXLvl56 ;
   private short A1564CliPaiConve ;
   private short A1011ConveAdiOpcCod ;
   private short AV13CliPaiConve ;
   private short AV23ConveAdiOpcCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV14CliRelSec ;
   private int A1900ConveAdiOpcRelSec ;
   private int A3CliCod ;
   private int AV15hijoCliCod ;
   private int AV31GXV1 ;
   private long AV11ClientePadre ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private java.math.BigDecimal AV24ConveAdiOpcAli ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1021ConveAdiOpcFor ;
   private String AV10CliConvenio ;
   private String AV8ConveAdicod ;
   private String AV22ConveAdiOpcFor ;
   private java.util.Date AV18padreReleaseDateTime ;
   private java.util.Date AV16hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean AV25clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String A1012ConveAdiOpcDes ;
   private String AV21ConveAdiOpcDes ;
   private IDataStoreProvider pr_default ;
   private int[] P01RJ2_A1900ConveAdiOpcRelSec ;
   private int[] P01RJ2_A3CliCod ;
   private short[] P01RJ2_A1564CliPaiConve ;
   private String[] P01RJ2_A1565CliConvenio ;
   private String[] P01RJ2_A996ConveAdicod ;
   private short[] P01RJ2_A1011ConveAdiOpcCod ;
   private String[] P01RJ2_A1021ConveAdiOpcFor ;
   private String[] P01RJ2_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] P01RJ2_A1013ConveAdiOpcAli ;
   private int[] P01RJ3_A3CliCod ;
   private short[] P01RJ4_A1011ConveAdiOpcCod ;
   private String[] P01RJ4_A996ConveAdicod ;
   private String[] P01RJ4_A1565CliConvenio ;
   private short[] P01RJ4_A1564CliPaiConve ;
   private int[] P01RJ4_A3CliCod ;
   private int[] P01RJ4_A1900ConveAdiOpcRelSec ;
   private String[] P01RJ4_A1021ConveAdiOpcFor ;
   private String[] P01RJ4_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] P01RJ4_A1013ConveAdiOpcAli ;
   private GXBaseCollection<web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem> AV20sdtAdicionalAlicuotas ;
   private web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem AV17item ;
}

final  class updateconvenioadicionalalicuotas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV14CliRelSec ,
                                          int A1900ConveAdiOpcRelSec ,
                                          long AV11ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveAdiOpcRelSec, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV14CliRelSec) )
      {
         addWhere(sWhereString, "(ConveAdiOpcRelSec = ?)");
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
                  return conditional_P01RJ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RJ3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RJ4", "SELECT ConveAdiOpcCod, ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiOpcRelSec, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiOpcCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod  FOR UPDATE OF convenio_adicionalalicuotas",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RJ5", "SAVEPOINT gxupdate;UPDATE convenio_adicionalalicuotas SET ConveAdiOpcRelSec=?, ConveAdiOpcFor=?, ConveAdiOpcDes=?, ConveAdiOpcAli=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
      }
   }

}

