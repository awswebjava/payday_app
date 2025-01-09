package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconvenioparticularidades extends GXProcedure
{
   public updateconvenioparticularidades( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconvenioparticularidades.class ), "" );
   }

   public updateconvenioparticularidades( int remoteHandle ,
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
      updateconvenioparticularidades.this.AV10ClientePadre = aP0;
      updateconvenioparticularidades.this.AV8CliCod = aP1;
      updateconvenioparticularidades.this.AV13CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV17padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV10ClientePadre), AV13CliRelSec, GXv_dtime1) ;
      updateconvenioparticularidades.this.AV17padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV10ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV13CliRelSec, 6, 0))) ;
      AV32GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV13CliRelSec) ,
                                           Integer.valueOf(A1897ConveRelSec) ,
                                           Long.valueOf(AV10ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RK2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV10ClientePadre), Integer.valueOf(AV13CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1897ConveRelSec = P01RK2_A1897ConveRelSec[0] ;
         A3CliCod = P01RK2_A3CliCod[0] ;
         A1564CliPaiConve = P01RK2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RK2_A1565CliConvenio[0] ;
         A1575CliConveVig = P01RK2_A1575CliConveVig[0] ;
         A905ConveDefault = P01RK2_A905ConveDefault[0] ;
         A1043ConveInterDiasJor = P01RK2_A1043ConveInterDiasJor[0] ;
         A1046ConveMinMesesVac = P01RK2_A1046ConveMinMesesVac[0] ;
         A1269ConveMesHsPExt = P01RK2_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = P01RK2_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = P01RK2_n1270ConveDiaHsPExt[0] ;
         A1401ConveFondoCese = P01RK2_A1401ConveFondoCese[0] ;
         A1627ConveGuarEdadMin = P01RK2_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = P01RK2_n1627ConveGuarEdadMin[0] ;
         A1628ConveGuarEdadMax = P01RK2_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = P01RK2_n1628ConveGuarEdadMax[0] ;
         AV32GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV28clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV8CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconvenioparticularidades.this.AV28clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV28clienteConvenioTiene )
         {
            AV16item = (web.SdtsdtClienteConvenio_sdtClienteConvenioItem)new web.SdtsdtClienteConvenio_sdtClienteConvenioItem(remoteHandle, context);
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve( A1564CliPaiConve );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio( A1565CliConvenio );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig( A1575CliConveVig );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault( A905ConveDefault );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor( A1043ConveInterDiasJor );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac( A1046ConveMinMesesVac );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext( A1269ConveMesHsPExt );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext( A1270ConveDiaHsPExt );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese( A1401ConveFondoCese );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin( A1627ConveGuarEdadMin );
            AV16item.setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax( A1628ConveGuarEdadMax );
            AV18sdtClienteConvenio.add(AV16item, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV32GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      if ( AV18sdtClienteConvenio.size() > 0 )
      {
         AV33GXLvl31 = (byte)(0) ;
         /* Using cursor P01RK3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RK3_A3CliCod[0] ;
            AV33GXLvl31 = (byte)(1) ;
            AV14hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, "2") ;
            AV34GXV1 = 1 ;
            while ( AV34GXV1 <= AV18sdtClienteConvenio.size() )
            {
               AV16item = (web.SdtsdtClienteConvenio_sdtClienteConvenioItem)((web.SdtsdtClienteConvenio_sdtClienteConvenioItem)AV18sdtClienteConvenio.elementAt(-1+AV34GXV1));
               AV12CliPaiConve = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve() ;
               AV9CliConvenio = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio() ;
               AV20CliConveVig = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig() ;
               AV21ConveDefault = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault() ;
               AV22ConveInterDiasJor = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor() ;
               AV23ConveMinMesesVac = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac() ;
               AV25ConveMesHsPExt = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext() ;
               AV24ConveDiaHsPExt = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext() ;
               AV26ConveFondoCese = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese() ;
               AV19ConveGuarEdadMin = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin() ;
               AV27ConveGuarEdadMax = AV16item.getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV34GXV1 = (int)(AV34GXV1+1) ;
            }
            if ( ! (0==AV13CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV33GXLvl31 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, "4") ;
      AV35GXLvl62 = (byte)(0) ;
      /* Using cursor P01RK4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV14hijoCliCod), Short.valueOf(AV12CliPaiConve), AV9CliConvenio, AV20CliConveVig});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1575CliConveVig = P01RK4_A1575CliConveVig[0] ;
         A1565CliConvenio = P01RK4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RK4_A1564CliPaiConve[0] ;
         A3CliCod = P01RK4_A3CliCod[0] ;
         A1897ConveRelSec = P01RK4_A1897ConveRelSec[0] ;
         A905ConveDefault = P01RK4_A905ConveDefault[0] ;
         A1043ConveInterDiasJor = P01RK4_A1043ConveInterDiasJor[0] ;
         A1046ConveMinMesesVac = P01RK4_A1046ConveMinMesesVac[0] ;
         A1269ConveMesHsPExt = P01RK4_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = P01RK4_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = P01RK4_n1270ConveDiaHsPExt[0] ;
         A1401ConveFondoCese = P01RK4_A1401ConveFondoCese[0] ;
         A1627ConveGuarEdadMin = P01RK4_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = P01RK4_n1627ConveGuarEdadMin[0] ;
         A1628ConveGuarEdadMax = P01RK4_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = P01RK4_n1628ConveGuarEdadMax[0] ;
         AV35GXLvl62 = (byte)(1) ;
         GXv_dtime1[0] = AV15hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1897ConveRelSec, GXv_dtime1) ;
         updateconvenioparticularidades.this.AV15hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV17padreReleaseDateTime.after( AV15hijoReleaseDateTime ) )
         {
            A1897ConveRelSec = AV13CliRelSec ;
            A905ConveDefault = AV21ConveDefault ;
            A1043ConveInterDiasJor = AV22ConveInterDiasJor ;
            A1046ConveMinMesesVac = AV23ConveMinMesesVac ;
            A1269ConveMesHsPExt = AV25ConveMesHsPExt ;
            A1270ConveDiaHsPExt = AV24ConveDiaHsPExt ;
            n1270ConveDiaHsPExt = false ;
            A1401ConveFondoCese = AV26ConveFondoCese ;
            A1627ConveGuarEdadMin = AV19ConveGuarEdadMin ;
            n1627ConveGuarEdadMin = false ;
            A1628ConveGuarEdadMax = AV27ConveGuarEdadMax ;
            n1628ConveGuarEdadMax = false ;
         }
         /* Using cursor P01RK5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1897ConveRelSec), Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Boolean.valueOf(n1627ConveGuarEdadMin), Byte.valueOf(A1627ConveGuarEdadMin), Boolean.valueOf(n1628ConveGuarEdadMax), Byte.valueOf(A1628ConveGuarEdadMax), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV35GXLvl62 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, "5") ;
         new web.newconvenioparticularidades(remoteHandle, context).execute( AV14hijoCliCod, AV12CliPaiConve, AV9CliConvenio, AV20CliConveVig, AV21ConveDefault, AV22ConveInterDiasJor, AV23ConveMinMesesVac, AV25ConveMesHsPExt, AV24ConveDiaHsPExt, AV26ConveFondoCese, AV19ConveGuarEdadMin, AV27ConveGuarEdadMax, AV13CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconvenioparticularidades");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV31Pgmname = "" ;
      scmdbuf = "" ;
      P01RK2_A1897ConveRelSec = new int[1] ;
      P01RK2_A3CliCod = new int[1] ;
      P01RK2_A1564CliPaiConve = new short[1] ;
      P01RK2_A1565CliConvenio = new String[] {""} ;
      P01RK2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RK2_A905ConveDefault = new boolean[] {false} ;
      P01RK2_A1043ConveInterDiasJor = new short[1] ;
      P01RK2_A1046ConveMinMesesVac = new byte[1] ;
      P01RK2_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RK2_A1270ConveDiaHsPExt = new String[] {""} ;
      P01RK2_n1270ConveDiaHsPExt = new boolean[] {false} ;
      P01RK2_A1401ConveFondoCese = new boolean[] {false} ;
      P01RK2_A1627ConveGuarEdadMin = new byte[1] ;
      P01RK2_n1627ConveGuarEdadMin = new boolean[] {false} ;
      P01RK2_A1628ConveGuarEdadMax = new byte[1] ;
      P01RK2_n1628ConveGuarEdadMax = new boolean[] {false} ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV16item = new web.SdtsdtClienteConvenio_sdtClienteConvenioItem(remoteHandle, context);
      AV18sdtClienteConvenio = new GXBaseCollection<web.SdtsdtClienteConvenio_sdtClienteConvenioItem>(web.SdtsdtClienteConvenio_sdtClienteConvenioItem.class, "sdtClienteConvenioItem", "PayDay", remoteHandle);
      P01RK3_A3CliCod = new int[1] ;
      AV9CliConvenio = "" ;
      AV20CliConveVig = GXutil.nullDate() ;
      AV25ConveMesHsPExt = DecimalUtil.ZERO ;
      AV24ConveDiaHsPExt = "" ;
      P01RK4_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RK4_A1565CliConvenio = new String[] {""} ;
      P01RK4_A1564CliPaiConve = new short[1] ;
      P01RK4_A3CliCod = new int[1] ;
      P01RK4_A1897ConveRelSec = new int[1] ;
      P01RK4_A905ConveDefault = new boolean[] {false} ;
      P01RK4_A1043ConveInterDiasJor = new short[1] ;
      P01RK4_A1046ConveMinMesesVac = new byte[1] ;
      P01RK4_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RK4_A1270ConveDiaHsPExt = new String[] {""} ;
      P01RK4_n1270ConveDiaHsPExt = new boolean[] {false} ;
      P01RK4_A1401ConveFondoCese = new boolean[] {false} ;
      P01RK4_A1627ConveGuarEdadMin = new byte[1] ;
      P01RK4_n1627ConveGuarEdadMin = new boolean[] {false} ;
      P01RK4_A1628ConveGuarEdadMax = new byte[1] ;
      P01RK4_n1628ConveGuarEdadMax = new boolean[] {false} ;
      AV15hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconvenioparticularidades__default(),
         new Object[] {
             new Object[] {
            P01RK2_A1897ConveRelSec, P01RK2_A3CliCod, P01RK2_A1564CliPaiConve, P01RK2_A1565CliConvenio, P01RK2_A1575CliConveVig, P01RK2_A905ConveDefault, P01RK2_A1043ConveInterDiasJor, P01RK2_A1046ConveMinMesesVac, P01RK2_A1269ConveMesHsPExt, P01RK2_A1270ConveDiaHsPExt,
            P01RK2_n1270ConveDiaHsPExt, P01RK2_A1401ConveFondoCese, P01RK2_A1627ConveGuarEdadMin, P01RK2_n1627ConveGuarEdadMin, P01RK2_A1628ConveGuarEdadMax, P01RK2_n1628ConveGuarEdadMax
            }
            , new Object[] {
            P01RK3_A3CliCod
            }
            , new Object[] {
            P01RK4_A1575CliConveVig, P01RK4_A1565CliConvenio, P01RK4_A1564CliPaiConve, P01RK4_A3CliCod, P01RK4_A1897ConveRelSec, P01RK4_A905ConveDefault, P01RK4_A1043ConveInterDiasJor, P01RK4_A1046ConveMinMesesVac, P01RK4_A1269ConveMesHsPExt, P01RK4_A1270ConveDiaHsPExt,
            P01RK4_n1270ConveDiaHsPExt, P01RK4_A1401ConveFondoCese, P01RK4_A1627ConveGuarEdadMin, P01RK4_n1627ConveGuarEdadMin, P01RK4_A1628ConveGuarEdadMax, P01RK4_n1628ConveGuarEdadMax
            }
            , new Object[] {
            }
         }
      );
      AV31Pgmname = "updateConvenioParticularidades" ;
      /* GeneXus formulas. */
      AV31Pgmname = "updateConvenioParticularidades" ;
      Gx_err = (short)(0) ;
   }

   private byte AV32GXLvl4 ;
   private byte A1046ConveMinMesesVac ;
   private byte A1627ConveGuarEdadMin ;
   private byte A1628ConveGuarEdadMax ;
   private byte AV33GXLvl31 ;
   private byte AV23ConveMinMesesVac ;
   private byte AV19ConveGuarEdadMin ;
   private byte AV27ConveGuarEdadMax ;
   private byte AV35GXLvl62 ;
   private short A1564CliPaiConve ;
   private short A1043ConveInterDiasJor ;
   private short AV12CliPaiConve ;
   private short AV22ConveInterDiasJor ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13CliRelSec ;
   private int A1897ConveRelSec ;
   private int A3CliCod ;
   private int AV14hijoCliCod ;
   private int AV34GXV1 ;
   private long AV10ClientePadre ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private java.math.BigDecimal AV25ConveMesHsPExt ;
   private String AV31Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1270ConveDiaHsPExt ;
   private String AV9CliConvenio ;
   private String AV24ConveDiaHsPExt ;
   private java.util.Date AV17padreReleaseDateTime ;
   private java.util.Date AV15hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV20CliConveVig ;
   private boolean A905ConveDefault ;
   private boolean n1270ConveDiaHsPExt ;
   private boolean A1401ConveFondoCese ;
   private boolean n1627ConveGuarEdadMin ;
   private boolean n1628ConveGuarEdadMax ;
   private boolean AV28clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean AV21ConveDefault ;
   private boolean AV26ConveFondoCese ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P01RK2_A1897ConveRelSec ;
   private int[] P01RK2_A3CliCod ;
   private short[] P01RK2_A1564CliPaiConve ;
   private String[] P01RK2_A1565CliConvenio ;
   private java.util.Date[] P01RK2_A1575CliConveVig ;
   private boolean[] P01RK2_A905ConveDefault ;
   private short[] P01RK2_A1043ConveInterDiasJor ;
   private byte[] P01RK2_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] P01RK2_A1269ConveMesHsPExt ;
   private String[] P01RK2_A1270ConveDiaHsPExt ;
   private boolean[] P01RK2_n1270ConveDiaHsPExt ;
   private boolean[] P01RK2_A1401ConveFondoCese ;
   private byte[] P01RK2_A1627ConveGuarEdadMin ;
   private boolean[] P01RK2_n1627ConveGuarEdadMin ;
   private byte[] P01RK2_A1628ConveGuarEdadMax ;
   private boolean[] P01RK2_n1628ConveGuarEdadMax ;
   private int[] P01RK3_A3CliCod ;
   private java.util.Date[] P01RK4_A1575CliConveVig ;
   private String[] P01RK4_A1565CliConvenio ;
   private short[] P01RK4_A1564CliPaiConve ;
   private int[] P01RK4_A3CliCod ;
   private int[] P01RK4_A1897ConveRelSec ;
   private boolean[] P01RK4_A905ConveDefault ;
   private short[] P01RK4_A1043ConveInterDiasJor ;
   private byte[] P01RK4_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] P01RK4_A1269ConveMesHsPExt ;
   private String[] P01RK4_A1270ConveDiaHsPExt ;
   private boolean[] P01RK4_n1270ConveDiaHsPExt ;
   private boolean[] P01RK4_A1401ConveFondoCese ;
   private byte[] P01RK4_A1627ConveGuarEdadMin ;
   private boolean[] P01RK4_n1627ConveGuarEdadMin ;
   private byte[] P01RK4_A1628ConveGuarEdadMax ;
   private boolean[] P01RK4_n1628ConveGuarEdadMax ;
   private GXBaseCollection<web.SdtsdtClienteConvenio_sdtClienteConvenioItem> AV18sdtClienteConvenio ;
   private web.SdtsdtClienteConvenio_sdtClienteConvenioItem AV16item ;
}

final  class updateconvenioparticularidades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV13CliRelSec ,
                                          int A1897ConveRelSec ,
                                          long AV10ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveRelSec, CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveDefault, ConveInterDiasJor, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese," ;
      scmdbuf += " ConveGuarEdadMin, ConveGuarEdadMax FROM ClienteConvenio_Particularidades" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV13CliRelSec) )
      {
         addWhere(sWhereString, "(ConveRelSec = ?)");
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
                  return conditional_P01RK2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RK3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RK4", "SELECT CliConveVig, CliConvenio, CliPaiConve, CliCod, ConveRelSec, ConveDefault, ConveInterDiasJor, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig  FOR UPDATE OF ClienteConvenio_Particularidades",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RK5", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_Particularidades SET ConveRelSec=?, ConveDefault=?, ConveInterDiasJor=?, ConveMinMesesVac=?, ConveMesHsPExt=?, ConveDiaHsPExt=?, ConveFondoCese=?, ConveGuarEdadMin=?, ConveGuarEdadMax=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(11);
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(11);
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
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
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(8, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[11]).byteValue());
               }
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setShort(11, ((Number) parms[13]).shortValue());
               stmt.setString(12, (String)parms[14], 20);
               stmt.setDate(13, (java.util.Date)parms[15]);
               return;
      }
   }

}

