package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newferiado extends GXProcedure
{
   public newferiado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newferiado.class ), "" );
   }

   public newferiado( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        byte aP2 ,
                        byte aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             byte aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 )
   {
      newferiado.this.AV16PaiCod = aP0;
      newferiado.this.AV12FerId = aP1;
      newferiado.this.AV9FerDia = aP2;
      newferiado.this.AV13FerMes = aP3;
      newferiado.this.AV8FerDescrip = aP4;
      newferiado.this.AV15FerReligId = aP5;
      newferiado.this.AV14FerOrigId = aP6;
      newferiado.this.AV17feriadoTipoPalabra = aP7;
      newferiado.this.AV10FeriadoConvenio = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11FeriadoTipo = AV17feriadoTipoPalabra ;
      /*
         INSERT RECORD ON TABLE feriado

      */
      A46PaiCod = AV16PaiCod ;
      A1223FerId = AV12FerId ;
      A1224FerDia = AV9FerDia ;
      A1225FerMes = AV13FerMes ;
      A1228FerDescrip = AV8FerDescrip ;
      if ( ! (GXutil.strcmp("", AV15FerReligId)==0) )
      {
         A1230FerReligId = AV15FerReligId ;
         n1230FerReligId = false ;
      }
      else
      {
         A1230FerReligId = "" ;
         n1230FerReligId = false ;
         n1230FerReligId = true ;
      }
      if ( ! (GXutil.strcmp("", AV14FerOrigId)==0) )
      {
         A1232FerOrigId = AV14FerOrigId ;
         n1232FerOrigId = false ;
      }
      else
      {
         A1232FerOrigId = "" ;
         n1232FerOrigId = false ;
         n1232FerOrigId = true ;
      }
      if ( GXutil.strcmp(GXutil.trim( AV11FeriadoTipo), httpContext.getMessage( "inamovible", "")) == 0 )
      {
         A1233FeriadoTipo = "inamovible" ;
      }
      else if ( GXutil.strcmp(GXutil.trim( AV11FeriadoTipo), httpContext.getMessage( "trasladable", "")) == 0 )
      {
         A1233FeriadoTipo = "trasladable" ;
      }
      else if ( GXutil.strcmp(GXutil.trim( AV11FeriadoTipo), httpContext.getMessage( "puente", "")) == 0 )
      {
         A1233FeriadoTipo = "puente" ;
      }
      else if ( GXutil.strcmp(GXutil.trim( AV11FeriadoTipo), httpContext.getMessage( "nolaborable", "")) == 0 )
      {
         A1233FeriadoTipo = "nolaborable" ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "ok", "")) ;
      if ( (GXutil.strcmp("", AV10FeriadoConvenio)==0) )
      {
         A1234FeriadoConvenio = "" ;
         n1234FeriadoConvenio = false ;
         n1234FeriadoConvenio = true ;
      }
      else
      {
         A1234FeriadoConvenio = GXutil.trim( AV10FeriadoConvenio) ;
         n1234FeriadoConvenio = false ;
      }
      /* Using cursor P01YK2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Byte.valueOf(A1224FerDia), Byte.valueOf(A1225FerMes), A1228FerDescrip, Boolean.valueOf(n1230FerReligId), A1230FerReligId, Boolean.valueOf(n1232FerOrigId), A1232FerOrigId, A1233FeriadoTipo, Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newferiado");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11FeriadoTipo = "" ;
      A1223FerId = "" ;
      A1228FerDescrip = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1233FeriadoTipo = "" ;
      AV20Pgmname = "" ;
      A1234FeriadoConvenio = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newferiado__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV20Pgmname = "newFeriado" ;
      /* GeneXus formulas. */
      AV20Pgmname = "newFeriado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9FerDia ;
   private byte AV13FerMes ;
   private byte A1224FerDia ;
   private byte A1225FerMes ;
   private short AV16PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int GX_INS140 ;
   private String AV12FerId ;
   private String AV15FerReligId ;
   private String AV14FerOrigId ;
   private String AV17feriadoTipoPalabra ;
   private String AV10FeriadoConvenio ;
   private String AV11FeriadoTipo ;
   private String A1223FerId ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1233FeriadoTipo ;
   private String AV20Pgmname ;
   private String A1234FeriadoConvenio ;
   private String Gx_emsg ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private String AV8FerDescrip ;
   private String A1228FerDescrip ;
   private IDataStoreProvider pr_default ;
}

final  class newferiado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01YK2", "SAVEPOINT gxupdate;INSERT INTO feriado(PaiCod, FerId, FerDia, FerMes, FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[8], 20);
               }
               stmt.setString(8, (String)parms[9], 20);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[11], 20);
               }
               return;
      }
   }

}

