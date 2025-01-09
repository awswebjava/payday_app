package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizacionescliente extends GXProcedure
{
   public actualizacionescliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizacionescliente.class ), "" );
   }

   public actualizacionescliente( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      actualizacionescliente.this.AV14modoPalabra = aP0;
      actualizacionescliente.this.AV8CliCod = aP1;
      actualizacionescliente.this.AV17CliRelSec = aP2;
      actualizacionescliente.this.AV18CliRelease = aP3;
      actualizacionescliente.this.AV19CliReleaseDes = aP4;
      actualizacionescliente.this.AV22CliRelNombre = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16CliUpdRelSec = AV17CliRelSec ;
      AV12CliUpdRelDesc = GXutil.trim( AV22CliRelNombre) + " - " + AV19CliReleaseDes ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "1 modopalabra ", "")+AV14modoPalabra+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      GXt_boolean1 = AV20ClienteConveniador ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV8CliCod, GXv_boolean2) ;
      actualizacionescliente.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV20ClienteConveniador = GXt_boolean1 ;
      if ( AV20ClienteConveniador )
      {
         /* Using cursor P01RA2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1566CliConveVer = P01RA2_A1566CliConveVer[0] ;
            n1566CliConveVer = P01RA2_n1566CliConveVer[0] ;
            A3CliCod = P01RA2_A3CliCod[0] ;
            A1564CliPaiConve = P01RA2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01RA2_A1565CliConvenio[0] ;
            AV21conveniadorActualizoEseConvenio = true ;
            if ( AV21conveniadorActualizoEseConvenio )
            {
               AV15hijo_CliCod = A3CliCod ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "asdf &hijo_CliCod ", "")+GXutil.trim( GXutil.str( AV15hijo_CliCod, 6, 0))) ;
               if ( GXutil.strcmp(AV14modoPalabra, httpContext.getMessage( "INS", "")) == 0 )
               {
                  /* Execute user subroutine: 'NEW' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV14modoPalabra, httpContext.getMessage( "UPD", "")) == 0 )
                  {
                     /* Execute user subroutine: 'UPDATE' */
                     S121 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
                  else
                  {
                     if ( GXutil.strcmp(AV14modoPalabra, httpContext.getMessage( "DLT", "")) == 0 )
                     {
                        /* Execute user subroutine: 'DELETE' */
                        S131 ();
                        if ( returnInSub )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
               }
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P01RA3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A546ClientePadre = P01RA3_A546ClientePadre[0] ;
            n546ClientePadre = P01RA3_n546ClientePadre[0] ;
            A3CliCod = P01RA3_A3CliCod[0] ;
            AV15hijo_CliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&hijo_CliCod ", "")+GXutil.trim( GXutil.str( AV15hijo_CliCod, 6, 0))) ;
            if ( GXutil.strcmp(AV14modoPalabra, httpContext.getMessage( "INS", "")) == 0 )
            {
               /* Execute user subroutine: 'NEW' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               if ( GXutil.strcmp(AV14modoPalabra, httpContext.getMessage( "UPD", "")) == 0 )
               {
                  /* Execute user subroutine: 'UPDATE' */
                  S121 ();
                  if ( returnInSub )
                  {
                     pr_default.close(1);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV14modoPalabra, httpContext.getMessage( "DLT", "")) == 0 )
                  {
                     /* Execute user subroutine: 'DELETE' */
                     S131 ();
                     if ( returnInSub )
                     {
                        pr_default.close(1);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
               }
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'NEW' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&CliUpdRelSec ", "")+GXutil.trim( GXutil.str( AV16CliUpdRelSec, 6, 0))+httpContext.getMessage( " &CliUpdRelSec ", "")+GXutil.trim( GXutil.str( AV16CliUpdRelSec, 6, 0))) ;
      new web.newcliente_update(remoteHandle, context).execute( AV15hijo_CliCod, AV16CliUpdRelSec, AV8CliCod, AV12CliUpdRelDesc, AV23DateTime) ;
   }

   public void S121( )
   {
      /* 'UPDATE' Routine */
      returnInSub = false ;
      /* Optimized UPDATE. */
      /* Using cursor P01RA4 */
      pr_default.execute(2, new Object[] {AV12CliUpdRelDesc, Integer.valueOf(AV15hijo_CliCod), Integer.valueOf(AV16CliUpdRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
      /* End optimized UPDATE. */
   }

   public void S131( )
   {
      /* 'DELETE' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P01RA5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV15hijo_CliCod), Integer.valueOf(AV16CliUpdRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
      /* End optimized DELETE. */
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizacionescliente");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12CliUpdRelDesc = "" ;
      AV26Pgmname = "" ;
      GXv_boolean2 = new boolean[1] ;
      scmdbuf = "" ;
      P01RA2_A1566CliConveVer = new int[1] ;
      P01RA2_n1566CliConveVer = new boolean[] {false} ;
      P01RA2_A3CliCod = new int[1] ;
      P01RA2_A1564CliPaiConve = new short[1] ;
      P01RA2_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      P01RA3_A546ClientePadre = new long[1] ;
      P01RA3_n546ClientePadre = new boolean[] {false} ;
      P01RA3_A3CliCod = new int[1] ;
      AV23DateTime = GXutil.resetTime( GXutil.nullDate() );
      A1884CliUpdRelDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizacionescliente__default(),
         new Object[] {
             new Object[] {
            P01RA2_A1566CliConveVer, P01RA2_n1566CliConveVer, P01RA2_A3CliCod, P01RA2_A1564CliPaiConve, P01RA2_A1565CliConvenio
            }
            , new Object[] {
            P01RA3_A546ClientePadre, P01RA3_n546ClientePadre, P01RA3_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV26Pgmname = "ActualizacionesCliente" ;
      /* GeneXus formulas. */
      AV26Pgmname = "ActualizacionesCliente" ;
      Gx_err = (short)(0) ;
   }

   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17CliRelSec ;
   private int AV16CliUpdRelSec ;
   private int A1566CliConveVer ;
   private int A3CliCod ;
   private int AV15hijo_CliCod ;
   private long A546ClientePadre ;
   private String AV14modoPalabra ;
   private String AV26Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date AV18CliRelease ;
   private java.util.Date AV23DateTime ;
   private boolean AV20ClienteConveniador ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean n1566CliConveVer ;
   private boolean AV21conveniadorActualizoEseConvenio ;
   private boolean returnInSub ;
   private boolean n546ClientePadre ;
   private String AV19CliReleaseDes ;
   private String AV22CliRelNombre ;
   private String AV12CliUpdRelDesc ;
   private String A1884CliUpdRelDesc ;
   private IDataStoreProvider pr_default ;
   private int[] P01RA2_A1566CliConveVer ;
   private boolean[] P01RA2_n1566CliConveVer ;
   private int[] P01RA2_A3CliCod ;
   private short[] P01RA2_A1564CliPaiConve ;
   private String[] P01RA2_A1565CliConvenio ;
   private long[] P01RA3_A546ClientePadre ;
   private boolean[] P01RA3_n546ClientePadre ;
   private int[] P01RA3_A3CliCod ;
}

final  class actualizacionescliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RA2", "SELECT CliConveVer, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliConveVer = ? ORDER BY CliConveVer ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RA3", "SELECT ClientePadre, CliCod FROM Cliente WHERE ClientePadre = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01RA4", "UPDATE Cliente_Update SET CliUpdRelDesc=?  WHERE (CliCod = ?) AND ((CliUpdDTApl = DATE '00010101')) AND (CliUpdRelSec = ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01RA5", "DELETE FROM Cliente_Update  WHERE (CliCod = ?) AND ((CliUpdDTApl = DATE '00010101')) AND (CliUpdRelSec = ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

