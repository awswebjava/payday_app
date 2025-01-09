package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newesquematarifario extends GXProcedure
{
   public newesquematarifario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newesquematarifario.class ), "" );
   }

   public newesquematarifario( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      newesquematarifario.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      newesquematarifario.this.AV8CliCod = aP0;
      newesquematarifario.this.AV14PaiCod = aP1;
      newesquematarifario.this.AV13ConveDescri = aP2;
      newesquematarifario.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12GUID = java.util.UUID.randomUUID( ) ;
      AV10CliConvenio = GXutil.substring( AV12GUID.toString(), 1, 20) ;
      /*
         INSERT RECORD ON TABLE Convenio

      */
      A46PaiCod = AV14PaiCod ;
      A9ConveCodigo = AV10CliConvenio ;
      A160ConveDescri = AV13ConveDescri ;
      A161ConveHabilitada = true ;
      A2131ConveEscFrecAct = (short)(0) ;
      A935ConveSinCod = "" ;
      n935ConveSinCod = false ;
      n935ConveSinCod = true ;
      A2428ConveEsquemaEs = true ;
      /* Using cursor P02LS2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod, Short.valueOf(A2131ConveEscFrecAct), Boolean.valueOf(A2428ConveEsquemaEs)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
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
      /*
         INSERT RECORD ON TABLE ClienteConvenios

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV14PaiCod ;
      A1565CliConvenio = AV10CliConvenio ;
      A1566CliConveVer = 0 ;
      n1566CliConveVer = false ;
      n1566CliConveVer = true ;
      A1639CliConveHab = false ;
      A2130CliConveActObl = true ;
      A2429CliConveEsquemaEs = true ;
      /* Using cursor P02LS3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer), Boolean.valueOf(A1639CliConveHab), Boolean.valueOf(A2130CliConveActObl), Boolean.valueOf(A2429CliConveEsquemaEs)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenios");
      if ( (pr_default.getStatus(1) == 1) )
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
      this.aP3[0] = newesquematarifario.this.AV10CliConvenio;
      Application.commitDataStores(context, remoteHandle, pr_default, "newesquematarifario");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10CliConvenio = "" ;
      AV12GUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A9ConveCodigo = "" ;
      A160ConveDescri = "" ;
      A935ConveSinCod = "" ;
      Gx_emsg = "" ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newesquematarifario__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14PaiCod ;
   private short A46PaiCod ;
   private short A2131ConveEscFrecAct ;
   private short Gx_err ;
   private short A1564CliPaiConve ;
   private int AV8CliCod ;
   private int GX_INS106 ;
   private int GX_INS202 ;
   private int A3CliCod ;
   private int A1566CliConveVer ;
   private String AV10CliConvenio ;
   private String A9ConveCodigo ;
   private String A935ConveSinCod ;
   private String Gx_emsg ;
   private String A1565CliConvenio ;
   private boolean A161ConveHabilitada ;
   private boolean n935ConveSinCod ;
   private boolean A2428ConveEsquemaEs ;
   private boolean n1566CliConveVer ;
   private boolean A1639CliConveHab ;
   private boolean A2130CliConveActObl ;
   private boolean A2429CliConveEsquemaEs ;
   private String AV13ConveDescri ;
   private String A160ConveDescri ;
   private java.util.UUID AV12GUID ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
}

final  class newesquematarifario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02LS2", "SAVEPOINT gxupdate;INSERT INTO Convenio(PaiCod, ConveCodigo, ConveDescri, ConveHabilitada, ConveSinCod, ConveEscFrecAct, ConveEsquemaEs, ConveDescriSinAc, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc) VALUES(?, ?, ?, ?, ?, ?, ?, '', '', '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02LS3", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenios(CliCod, CliPaiConve, CliConvenio, CliConveVer, CliConveHab, CliConveActObl, CliConveEsquemaEs) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 20);
               }
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               return;
      }
   }

}

