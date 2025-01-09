package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrdatos2 extends GXProcedure
{
   public getmigrdatos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrdatos2.class ), "" );
   }

   public getmigrdatos2( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String[] aP3 ,
                              String[] aP4 ,
                              String[] aP5 ,
                              String[] aP6 ,
                              String[] aP7 ,
                              String[] aP8 ,
                              String[] aP9 ,
                              String[] aP10 ,
                              String[] aP11 ,
                              String[] aP12 ,
                              String[] aP13 ,
                              String[] aP14 ,
                              String[] aP15 ,
                              String[] aP16 ,
                              String[] aP17 ,
                              String[] aP18 ,
                              String[] aP19 ,
                              String[] aP20 ,
                              String[] aP21 ,
                              String[] aP22 ,
                              String[] aP23 ,
                              String[] aP24 ,
                              String[] aP25 ,
                              String[] aP26 ,
                              boolean[] aP27 )
   {
      getmigrdatos2.this.aP28 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28);
      return aP28[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 ,
                        String[] aP17 ,
                        String[] aP18 ,
                        String[] aP19 ,
                        String[] aP20 ,
                        String[] aP21 ,
                        String[] aP22 ,
                        String[] aP23 ,
                        String[] aP24 ,
                        String[] aP25 ,
                        String[] aP26 ,
                        boolean[] aP27 ,
                        boolean[] aP28 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             String[] aP17 ,
                             String[] aP18 ,
                             String[] aP19 ,
                             String[] aP20 ,
                             String[] aP21 ,
                             String[] aP22 ,
                             String[] aP23 ,
                             String[] aP24 ,
                             String[] aP25 ,
                             String[] aP26 ,
                             boolean[] aP27 ,
                             boolean[] aP28 )
   {
      getmigrdatos2.this.AV8CliCod = aP0;
      getmigrdatos2.this.AV9EmpCod = aP1;
      getmigrdatos2.this.AV13MigrLegNumero = aP2;
      getmigrdatos2.this.aP3 = aP3;
      getmigrdatos2.this.aP4 = aP4;
      getmigrdatos2.this.aP5 = aP5;
      getmigrdatos2.this.aP6 = aP6;
      getmigrdatos2.this.aP7 = aP7;
      getmigrdatos2.this.aP8 = aP8;
      getmigrdatos2.this.aP9 = aP9;
      getmigrdatos2.this.aP10 = aP10;
      getmigrdatos2.this.aP11 = aP11;
      getmigrdatos2.this.aP12 = aP12;
      getmigrdatos2.this.aP13 = aP13;
      getmigrdatos2.this.aP14 = aP14;
      getmigrdatos2.this.aP15 = aP15;
      getmigrdatos2.this.aP16 = aP16;
      getmigrdatos2.this.aP17 = aP17;
      getmigrdatos2.this.aP18 = aP18;
      getmigrdatos2.this.aP19 = aP19;
      getmigrdatos2.this.aP20 = aP20;
      getmigrdatos2.this.aP21 = aP21;
      getmigrdatos2.this.aP22 = aP22;
      getmigrdatos2.this.aP23 = aP23;
      getmigrdatos2.this.aP24 = aP24;
      getmigrdatos2.this.aP25 = aP25;
      getmigrdatos2.this.aP26 = aP26;
      getmigrdatos2.this.aP27 = aP27;
      getmigrdatos2.this.aP28 = aP28;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV13MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P002W2_A87MigrLegNumero[0] ;
         A1EmpCod = P002W2_A1EmpCod[0] ;
         A3CliCod = P002W2_A3CliCod[0] ;
         A605MigrLegArea = P002W2_A605MigrLegArea[0] ;
         A606MigrLegLugarDePago = P002W2_A606MigrLegLugarDePago[0] ;
         A604MigrLegCategoria = P002W2_A604MigrLegCategoria[0] ;
         A610MigrLegBanco = P002W2_A610MigrLegBanco[0] ;
         A613MigrLegSindicato = P002W2_A613MigrLegSindicato[0] ;
         A614MigrLegObraSocial = P002W2_A614MigrLegObraSocial[0] ;
         A615MigrLegPlanMedico = P002W2_A615MigrLegPlanMedico[0] ;
         A616MigrLegActividad = P002W2_A616MigrLegActividad[0] ;
         A617MigrLegModalidad = P002W2_A617MigrLegModalidad[0] ;
         A620MigrLegZona = P002W2_A620MigrLegZona[0] ;
         A623MigrLegSituacionRevista = P002W2_A623MigrLegSituacionRevista[0] ;
         A627MigrLegConvenio = P002W2_A627MigrLegConvenio[0] ;
         A624MigrLegCondicion = P002W2_A624MigrLegCondicion[0] ;
         A625MigrLegSiniestrado = P002W2_A625MigrLegSiniestrado[0] ;
         A595MigrLegSexo = P002W2_A595MigrLegSexo[0] ;
         A2415MigrLegModTra = P002W2_A2415MigrLegModTra[0] ;
         A2427MigrLegTipoTarifa = P002W2_A2427MigrLegTipoTarifa[0] ;
         A607MigrLegClase = P002W2_A607MigrLegClase[0] ;
         A596MigrLegEstadoCivil = P002W2_A596MigrLegEstadoCivil[0] ;
         A598MigrLegDiscapacidad = P002W2_A598MigrLegDiscapacidad[0] ;
         A609MigrLegFormaPago = P002W2_A609MigrLegFormaPago[0] ;
         A622MigrLegSCVO = P002W2_A622MigrLegSCVO[0] ;
         A631MigrTieneConyuge = P002W2_A631MigrTieneConyuge[0] ;
         A612MigrLegBanTipCuen = P002W2_A612MigrLegBanTipCuen[0] ;
         A1820MigrEncontroOsoAfip = P002W2_A1820MigrEncontroOsoAfip[0] ;
         A635MigrEncontroOsoSigla = P002W2_A635MigrEncontroOsoSigla[0] ;
         AV10MigrLegArea = A605MigrLegArea ;
         AV12MigrLegLugarDePago = A606MigrLegLugarDePago ;
         AV14MigrLegCategoria = A604MigrLegCategoria ;
         AV24MigrLegBanco = A610MigrLegBanco ;
         AV15MigrLegSindicato = A613MigrLegSindicato ;
         AV16MigrLegObraSocial = A614MigrLegObraSocial ;
         AV23MigrLegPlanMedico = A615MigrLegPlanMedico ;
         AV22MigrLegActividad = A616MigrLegActividad ;
         AV21MigrLegModalidad = A617MigrLegModalidad ;
         AV11MigrLegZona = A620MigrLegZona ;
         AV20MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
         AV19MigrLegConvenio = A627MigrLegConvenio ;
         AV18MigrLegCondicion = A624MigrLegCondicion ;
         AV17MigrLegSiniestrado = A625MigrLegSiniestrado ;
         AV28MigrLegSexo = A595MigrLegSexo ;
         AV35MigrLegModTra = A2415MigrLegModTra ;
         AV36MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
         AV29MigrLegClase = A607MigrLegClase ;
         AV30MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
         AV27MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
         new web.msgdebug7(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "rarito", "")+A609MigrLegFormaPago) ;
         AV31MigrLegFormaPago = A609MigrLegFormaPago ;
         new web.msgdebug7(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "raritosss ", "")+AV31MigrLegFormaPago) ;
         AV26MigrLegSCVO = A622MigrLegSCVO ;
         AV25MigrTieneConyuge = A631MigrTieneConyuge ;
         AV32MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
         AV33MigrEncontroOsoAfip = A1820MigrEncontroOsoAfip ;
         AV34MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug7(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "nadita", "")+AV31MigrLegFormaPago) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrdatos2.this.AV10MigrLegArea;
      this.aP4[0] = getmigrdatos2.this.AV12MigrLegLugarDePago;
      this.aP5[0] = getmigrdatos2.this.AV14MigrLegCategoria;
      this.aP6[0] = getmigrdatos2.this.AV24MigrLegBanco;
      this.aP7[0] = getmigrdatos2.this.AV15MigrLegSindicato;
      this.aP8[0] = getmigrdatos2.this.AV16MigrLegObraSocial;
      this.aP9[0] = getmigrdatos2.this.AV23MigrLegPlanMedico;
      this.aP10[0] = getmigrdatos2.this.AV22MigrLegActividad;
      this.aP11[0] = getmigrdatos2.this.AV21MigrLegModalidad;
      this.aP12[0] = getmigrdatos2.this.AV11MigrLegZona;
      this.aP13[0] = getmigrdatos2.this.AV20MigrLegSituacionRevista;
      this.aP14[0] = getmigrdatos2.this.AV19MigrLegConvenio;
      this.aP15[0] = getmigrdatos2.this.AV18MigrLegCondicion;
      this.aP16[0] = getmigrdatos2.this.AV17MigrLegSiniestrado;
      this.aP17[0] = getmigrdatos2.this.AV28MigrLegSexo;
      this.aP18[0] = getmigrdatos2.this.AV35MigrLegModTra;
      this.aP19[0] = getmigrdatos2.this.AV36MigrLegTipoTarifa;
      this.aP20[0] = getmigrdatos2.this.AV29MigrLegClase;
      this.aP21[0] = getmigrdatos2.this.AV30MigrLegEstadoCivil;
      this.aP22[0] = getmigrdatos2.this.AV32MigrLegBanTipCuen;
      this.aP23[0] = getmigrdatos2.this.AV27MigrLegDiscapacidad;
      this.aP24[0] = getmigrdatos2.this.AV31MigrLegFormaPago;
      this.aP25[0] = getmigrdatos2.this.AV26MigrLegSCVO;
      this.aP26[0] = getmigrdatos2.this.AV25MigrTieneConyuge;
      this.aP27[0] = getmigrdatos2.this.AV33MigrEncontroOsoAfip;
      this.aP28[0] = getmigrdatos2.this.AV34MigrEncontroOsoSigla;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10MigrLegArea = "" ;
      AV12MigrLegLugarDePago = "" ;
      AV14MigrLegCategoria = "" ;
      AV24MigrLegBanco = "" ;
      AV15MigrLegSindicato = "" ;
      AV16MigrLegObraSocial = "" ;
      AV23MigrLegPlanMedico = "" ;
      AV22MigrLegActividad = "" ;
      AV21MigrLegModalidad = "" ;
      AV11MigrLegZona = "" ;
      AV20MigrLegSituacionRevista = "" ;
      AV19MigrLegConvenio = "" ;
      AV18MigrLegCondicion = "" ;
      AV17MigrLegSiniestrado = "" ;
      AV28MigrLegSexo = "" ;
      AV35MigrLegModTra = "" ;
      AV36MigrLegTipoTarifa = "" ;
      AV29MigrLegClase = "" ;
      AV30MigrLegEstadoCivil = "" ;
      AV32MigrLegBanTipCuen = "" ;
      AV27MigrLegDiscapacidad = "" ;
      AV31MigrLegFormaPago = "" ;
      AV26MigrLegSCVO = "" ;
      AV25MigrTieneConyuge = "" ;
      scmdbuf = "" ;
      P002W2_A87MigrLegNumero = new int[1] ;
      P002W2_A1EmpCod = new short[1] ;
      P002W2_A3CliCod = new int[1] ;
      P002W2_A605MigrLegArea = new String[] {""} ;
      P002W2_A606MigrLegLugarDePago = new String[] {""} ;
      P002W2_A604MigrLegCategoria = new String[] {""} ;
      P002W2_A610MigrLegBanco = new String[] {""} ;
      P002W2_A613MigrLegSindicato = new String[] {""} ;
      P002W2_A614MigrLegObraSocial = new String[] {""} ;
      P002W2_A615MigrLegPlanMedico = new String[] {""} ;
      P002W2_A616MigrLegActividad = new String[] {""} ;
      P002W2_A617MigrLegModalidad = new String[] {""} ;
      P002W2_A620MigrLegZona = new String[] {""} ;
      P002W2_A623MigrLegSituacionRevista = new String[] {""} ;
      P002W2_A627MigrLegConvenio = new String[] {""} ;
      P002W2_A624MigrLegCondicion = new String[] {""} ;
      P002W2_A625MigrLegSiniestrado = new String[] {""} ;
      P002W2_A595MigrLegSexo = new String[] {""} ;
      P002W2_A2415MigrLegModTra = new String[] {""} ;
      P002W2_A2427MigrLegTipoTarifa = new String[] {""} ;
      P002W2_A607MigrLegClase = new String[] {""} ;
      P002W2_A596MigrLegEstadoCivil = new String[] {""} ;
      P002W2_A598MigrLegDiscapacidad = new String[] {""} ;
      P002W2_A609MigrLegFormaPago = new String[] {""} ;
      P002W2_A622MigrLegSCVO = new String[] {""} ;
      P002W2_A631MigrTieneConyuge = new String[] {""} ;
      P002W2_A612MigrLegBanTipCuen = new String[] {""} ;
      P002W2_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      P002W2_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      A605MigrLegArea = "" ;
      A606MigrLegLugarDePago = "" ;
      A604MigrLegCategoria = "" ;
      A610MigrLegBanco = "" ;
      A613MigrLegSindicato = "" ;
      A614MigrLegObraSocial = "" ;
      A615MigrLegPlanMedico = "" ;
      A616MigrLegActividad = "" ;
      A617MigrLegModalidad = "" ;
      A620MigrLegZona = "" ;
      A623MigrLegSituacionRevista = "" ;
      A627MigrLegConvenio = "" ;
      A624MigrLegCondicion = "" ;
      A625MigrLegSiniestrado = "" ;
      A595MigrLegSexo = "" ;
      A2415MigrLegModTra = "" ;
      A2427MigrLegTipoTarifa = "" ;
      A607MigrLegClase = "" ;
      A596MigrLegEstadoCivil = "" ;
      A598MigrLegDiscapacidad = "" ;
      A609MigrLegFormaPago = "" ;
      A622MigrLegSCVO = "" ;
      A631MigrTieneConyuge = "" ;
      A612MigrLegBanTipCuen = "" ;
      AV40Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrdatos2__default(),
         new Object[] {
             new Object[] {
            P002W2_A87MigrLegNumero, P002W2_A1EmpCod, P002W2_A3CliCod, P002W2_A605MigrLegArea, P002W2_A606MigrLegLugarDePago, P002W2_A604MigrLegCategoria, P002W2_A610MigrLegBanco, P002W2_A613MigrLegSindicato, P002W2_A614MigrLegObraSocial, P002W2_A615MigrLegPlanMedico,
            P002W2_A616MigrLegActividad, P002W2_A617MigrLegModalidad, P002W2_A620MigrLegZona, P002W2_A623MigrLegSituacionRevista, P002W2_A627MigrLegConvenio, P002W2_A624MigrLegCondicion, P002W2_A625MigrLegSiniestrado, P002W2_A595MigrLegSexo, P002W2_A2415MigrLegModTra, P002W2_A2427MigrLegTipoTarifa,
            P002W2_A607MigrLegClase, P002W2_A596MigrLegEstadoCivil, P002W2_A598MigrLegDiscapacidad, P002W2_A609MigrLegFormaPago, P002W2_A622MigrLegSCVO, P002W2_A631MigrTieneConyuge, P002W2_A612MigrLegBanTipCuen, P002W2_A1820MigrEncontroOsoAfip, P002W2_A635MigrEncontroOsoSigla
            }
         }
      );
      AV40Pgmname = "getMigrDatos2" ;
      /* GeneXus formulas. */
      AV40Pgmname = "getMigrDatos2" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String AV28MigrLegSexo ;
   private String AV27MigrLegDiscapacidad ;
   private String AV26MigrLegSCVO ;
   private String AV25MigrTieneConyuge ;
   private String scmdbuf ;
   private String A595MigrLegSexo ;
   private String A598MigrLegDiscapacidad ;
   private String A622MigrLegSCVO ;
   private String A631MigrTieneConyuge ;
   private String AV40Pgmname ;
   private boolean AV33MigrEncontroOsoAfip ;
   private boolean AV34MigrEncontroOsoSigla ;
   private boolean A1820MigrEncontroOsoAfip ;
   private boolean A635MigrEncontroOsoSigla ;
   private String AV10MigrLegArea ;
   private String AV12MigrLegLugarDePago ;
   private String AV14MigrLegCategoria ;
   private String AV24MigrLegBanco ;
   private String AV15MigrLegSindicato ;
   private String AV16MigrLegObraSocial ;
   private String AV23MigrLegPlanMedico ;
   private String AV22MigrLegActividad ;
   private String AV21MigrLegModalidad ;
   private String AV11MigrLegZona ;
   private String AV20MigrLegSituacionRevista ;
   private String AV19MigrLegConvenio ;
   private String AV18MigrLegCondicion ;
   private String AV17MigrLegSiniestrado ;
   private String AV35MigrLegModTra ;
   private String AV36MigrLegTipoTarifa ;
   private String AV29MigrLegClase ;
   private String AV30MigrLegEstadoCivil ;
   private String AV32MigrLegBanTipCuen ;
   private String AV31MigrLegFormaPago ;
   private String A605MigrLegArea ;
   private String A606MigrLegLugarDePago ;
   private String A604MigrLegCategoria ;
   private String A610MigrLegBanco ;
   private String A613MigrLegSindicato ;
   private String A614MigrLegObraSocial ;
   private String A615MigrLegPlanMedico ;
   private String A616MigrLegActividad ;
   private String A617MigrLegModalidad ;
   private String A620MigrLegZona ;
   private String A623MigrLegSituacionRevista ;
   private String A627MigrLegConvenio ;
   private String A624MigrLegCondicion ;
   private String A625MigrLegSiniestrado ;
   private String A2415MigrLegModTra ;
   private String A2427MigrLegTipoTarifa ;
   private String A607MigrLegClase ;
   private String A596MigrLegEstadoCivil ;
   private String A609MigrLegFormaPago ;
   private String A612MigrLegBanTipCuen ;
   private boolean[] aP28 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private String[] aP14 ;
   private String[] aP15 ;
   private String[] aP16 ;
   private String[] aP17 ;
   private String[] aP18 ;
   private String[] aP19 ;
   private String[] aP20 ;
   private String[] aP21 ;
   private String[] aP22 ;
   private String[] aP23 ;
   private String[] aP24 ;
   private String[] aP25 ;
   private String[] aP26 ;
   private boolean[] aP27 ;
   private IDataStoreProvider pr_default ;
   private int[] P002W2_A87MigrLegNumero ;
   private short[] P002W2_A1EmpCod ;
   private int[] P002W2_A3CliCod ;
   private String[] P002W2_A605MigrLegArea ;
   private String[] P002W2_A606MigrLegLugarDePago ;
   private String[] P002W2_A604MigrLegCategoria ;
   private String[] P002W2_A610MigrLegBanco ;
   private String[] P002W2_A613MigrLegSindicato ;
   private String[] P002W2_A614MigrLegObraSocial ;
   private String[] P002W2_A615MigrLegPlanMedico ;
   private String[] P002W2_A616MigrLegActividad ;
   private String[] P002W2_A617MigrLegModalidad ;
   private String[] P002W2_A620MigrLegZona ;
   private String[] P002W2_A623MigrLegSituacionRevista ;
   private String[] P002W2_A627MigrLegConvenio ;
   private String[] P002W2_A624MigrLegCondicion ;
   private String[] P002W2_A625MigrLegSiniestrado ;
   private String[] P002W2_A595MigrLegSexo ;
   private String[] P002W2_A2415MigrLegModTra ;
   private String[] P002W2_A2427MigrLegTipoTarifa ;
   private String[] P002W2_A607MigrLegClase ;
   private String[] P002W2_A596MigrLegEstadoCivil ;
   private String[] P002W2_A598MigrLegDiscapacidad ;
   private String[] P002W2_A609MigrLegFormaPago ;
   private String[] P002W2_A622MigrLegSCVO ;
   private String[] P002W2_A631MigrTieneConyuge ;
   private String[] P002W2_A612MigrLegBanTipCuen ;
   private boolean[] P002W2_A1820MigrEncontroOsoAfip ;
   private boolean[] P002W2_A635MigrEncontroOsoSigla ;
}

final  class getmigrdatos2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002W2", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegArea, MigrLegLugarDePago, MigrLegCategoria, MigrLegBanco, MigrLegSindicato, MigrLegObraSocial, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegZona, MigrLegSituacionRevista, MigrLegConvenio, MigrLegCondicion, MigrLegSiniestrado, MigrLegSexo, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegEstadoCivil, MigrLegDiscapacidad, MigrLegFormaPago, MigrLegSCVO, MigrTieneConyuge, MigrLegBanTipCuen, MigrEncontroOsoAfip, MigrEncontroOsoSigla FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 2);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(29);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

