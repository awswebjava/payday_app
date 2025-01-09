package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class add_sindicato extends GXProcedure
{
   public add_sindicato( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( add_sindicato.class ), "" );
   }

   public add_sindicato( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> executeUdp( int aP0 ,
                                                                               String aP1 ,
                                                                               String aP2 )
   {
      add_sindicato.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>[] aP3 )
   {
      add_sindicato.this.AV12CliCod = aP0;
      add_sindicato.this.AV11sinCod = aP1;
      add_sindicato.this.AV10SinDescrip = aP2;
      add_sindicato.this.AV9sdt_sindicato = aP3[0];
      this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV13PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.paisargentina(remoteHandle, context).execute( GXv_int2) ;
      add_sindicato.this.GXt_int1 = GXv_int2[0] ;
      AV13PaiCod = GXt_int1 ;
      AV11sinCod = GXutil.strReplace( AV11sinCod, ".", "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&sinCod ", "")+AV11sinCod) ;
      /*
         INSERT RECORD ON TABLE Sindicato

      */
      A46PaiCod = AV13PaiCod ;
      A14SinCod = AV11sinCod ;
      A331SinDescrip = AV10SinDescrip ;
      GXt_char3 = A680SinDescripSinAc ;
      GXv_char4[0] = GXt_char3 ;
      new web.sacaracentos2(remoteHandle, context).execute( AV10SinDescrip, GXv_char4) ;
      add_sindicato.this.GXt_char3 = GXv_char4[0] ;
      A680SinDescripSinAc = GXt_char3 ;
      A332SinHabilitado = true ;
      if ( ( GXutil.strcmp(AV11sinCod, httpContext.getMessage( "UOCRA", "")) == 0 ) || ( GXutil.strcmp(AV11sinCod, httpContext.getMessage( "UECARA", "")) == 0 ) || ( GXutil.strcmp(AV11sinCod, httpContext.getMessage( "UOCRAYAC", "")) == 0 ) )
      {
         GXt_char3 = A903ActComCodigo ;
         GXv_char4[0] = GXt_char3 ;
         new web.actcomconstruccion(remoteHandle, context).execute( GXv_char4) ;
         add_sindicato.this.GXt_char3 = GXv_char4[0] ;
         A903ActComCodigo = GXt_char3 ;
      }
      if ( GXutil.strcmp(AV11sinCod, httpContext.getMessage( "UOCRAYAC", "")) == 0 )
      {
         A930SinCuotaAli = DecimalUtil.stringToDec("0.025") ;
      }
      else
      {
         A930SinCuotaAli = DecimalUtil.stringToDec("0.02") ;
      }
      A1647SinSigla = AV11sinCod ;
      A906SinDefault = false ;
      /* Using cursor P00EH2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A14SinCod, A331SinDescrip, Boolean.valueOf(A332SinHabilitado), A680SinDescripSinAc, A903ActComCodigo, Boolean.valueOf(A906SinDefault), A930SinCuotaAli, A1647SinSigla});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Sindicato");
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "asdf &sinCod ", "")+AV11sinCod) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = add_sindicato.this.AV9sdt_sindicato;
      Application.commitDataStores(context, remoteHandle, pr_default, "add_sindicato");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      AV16Pgmname = "" ;
      A14SinCod = "" ;
      A331SinDescrip = "" ;
      A680SinDescripSinAc = "" ;
      A903ActComCodigo = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      A930SinCuotaAli = DecimalUtil.ZERO ;
      A1647SinSigla = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.add_sindicato__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV16Pgmname = "add_sindicato" ;
      /* GeneXus formulas. */
      AV16Pgmname = "add_sindicato" ;
      Gx_err = (short)(0) ;
   }

   private short AV13PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int GX_INS107 ;
   private java.math.BigDecimal A930SinCuotaAli ;
   private String AV11sinCod ;
   private String AV16Pgmname ;
   private String A14SinCod ;
   private String A903ActComCodigo ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String Gx_emsg ;
   private boolean A332SinHabilitado ;
   private boolean A906SinDefault ;
   private String AV10SinDescrip ;
   private String A331SinDescrip ;
   private String A680SinDescripSinAc ;
   private String A1647SinSigla ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> AV9sdt_sindicato ;
}

final  class add_sindicato__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00EH2", "SAVEPOINT gxupdate;INSERT INTO Sindicato(PaiCod, SinCod, SinDescrip, SinHabilitado, SinDescripSinAc, ActComCodigo, SinDefault, SinCuotaAli, SinSigla) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               return;
      }
   }

}

