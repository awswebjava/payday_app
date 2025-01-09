package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadcombomigr2 extends GXProcedure
{
   public loadcombomigr2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadcombomigr2.class ), "" );
   }

   public loadcombomigr2( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              String aP4 ,
                              String aP5 ,
                              GXSimpleCollection<String>[] aP6 ,
                              GXSimpleCollection<String>[] aP7 ,
                              String[] aP8 ,
                              boolean[] aP9 ,
                              String[] aP10 ,
                              boolean[] aP11 )
   {
      loadcombomigr2.this.aP12 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        GXSimpleCollection<String>[] aP6 ,
                        GXSimpleCollection<String>[] aP7 ,
                        String[] aP8 ,
                        boolean[] aP9 ,
                        String[] aP10 ,
                        boolean[] aP11 ,
                        boolean[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             GXSimpleCollection<String>[] aP6 ,
                             GXSimpleCollection<String>[] aP7 ,
                             String[] aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 ,
                             boolean[] aP11 ,
                             boolean[] aP12 )
   {
      loadcombomigr2.this.AV8CliCod = aP0;
      loadcombomigr2.this.AV9EmpCod = aP1;
      loadcombomigr2.this.AV10MigrLegNumero = aP2;
      loadcombomigr2.this.AV19campo = aP3;
      loadcombomigr2.this.AV30dependenciaCodigo = aP4;
      loadcombomigr2.this.AV20valor = aP5;
      loadcombomigr2.this.aP6 = aP6;
      loadcombomigr2.this.aP7 = aP7;
      loadcombomigr2.this.aP8 = aP8;
      loadcombomigr2.this.aP9 = aP9;
      loadcombomigr2.this.aP10 = aP10;
      loadcombomigr2.this.aP11 = aP11;
      loadcombomigr2.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV27otras.clear();
      AV26similares.clear();
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&valor ", "")+AV20valor) ;
      GXt_int1 = AV32PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      loadcombomigr2.this.GXt_int1 = GXv_int2[0] ;
      AV32PaiCod = GXt_int1 ;
      GXt_char3 = AV36ParmValue ;
      GXt_char4 = AV36ParmValue ;
      GXv_char5[0] = GXt_char4 ;
      new web.algoritmoequivimportleg_codigo(remoteHandle, context).execute( GXv_char5) ;
      loadcombomigr2.this.GXt_char4 = GXv_char5[0] ;
      GXv_char6[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char4, GXv_char6) ;
      loadcombomigr2.this.GXt_char3 = GXv_char6[0] ;
      AV36ParmValue = GXt_char3 ;
      AV35AlgortimoEquivalenciasImpLeg = AV36ParmValue ;
      if ( ! (GXutil.strcmp("", AV20valor)==0) )
      {
         GXv_char6[0] = AV33ConveCodigo ;
         GXv_boolean7[0] = false ;
         new web.getconveniopordescrip(remoteHandle, context).execute( AV8CliCod, AV32PaiCod, "", GXutil.trim( AV30dependenciaCodigo), GXv_char6, GXv_boolean7) ;
         loadcombomigr2.this.AV33ConveCodigo = GXv_char6[0] ;
         if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Adherente", "")) == 0 )
         {
            GXv_boolean7[0] = AV38boolean ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char6[0] = "" ;
            GXv_boolean9[0] = AV17existe ;
            new web.traducirsinoaboolean(remoteHandle, context).execute( AV8CliCod, AV20valor, AV19campo, GXv_boolean7, GXv_objcol_svchar8, GXv_char6, GXv_boolean9) ;
            loadcombomigr2.this.AV38boolean = GXv_boolean7[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            loadcombomigr2.this.AV17existe = GXv_boolean9[0] ;
         }
         else
         {
            if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Género", "")) == 0 )
            {
               GXv_int10[0] = (byte)(0) ;
               GXv_objcol_svchar8[0] = AV14errores ;
               GXv_char6[0] = "" ;
               GXv_boolean9[0] = AV17existe ;
               new web.traducirsexo(remoteHandle, context).execute( AV8CliCod, AV20valor, GXv_int10, GXv_objcol_svchar8, GXv_char6, GXv_boolean9) ;
               AV14errores = GXv_objcol_svchar8[0] ;
               loadcombomigr2.this.AV17existe = GXv_boolean9[0] ;
            }
            else
            {
               GXv_char6[0] = "" ;
               GXv_objcol_svchar8[0] = AV14errores ;
               GXv_objcol_svchar11[0] = AV18warnings ;
               GXv_char5[0] = AV21likeValor ;
               GXv_boolean9[0] = AV13hayLike ;
               GXv_boolean7[0] = AV17existe ;
               GXv_boolean12[0] = AV25esCodigo ;
               GXv_char13[0] = "" ;
               new web.traducirmigracioncaracter(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV19campo, AV20valor, false, AV33ConveCodigo, AV35AlgortimoEquivalenciasImpLeg, "", "", GXv_char6, GXv_objcol_svchar8, GXv_objcol_svchar11, GXv_char5, GXv_boolean9, GXv_boolean7, GXv_boolean12, GXv_char13) ;
               AV14errores = GXv_objcol_svchar8[0] ;
               AV18warnings = GXv_objcol_svchar11[0] ;
               loadcombomigr2.this.AV21likeValor = GXv_char5[0] ;
               loadcombomigr2.this.AV13hayLike = GXv_boolean9[0] ;
               loadcombomigr2.this.AV17existe = GXv_boolean7[0] ;
               loadcombomigr2.this.AV25esCodigo = GXv_boolean12[0] ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&campo ", "")+AV19campo) ;
         GXt_char4 = AV20valor ;
         GXv_char13[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( AV20valor, GXv_char13) ;
         loadcombomigr2.this.GXt_char4 = GXv_char13[0] ;
         AV20valor = GXt_char4 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "existe ", "")+GXutil.trim( GXutil.booltostr( AV17existe))) ;
         AV23valor_devuelve = AV20valor ;
         if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Categoria", "")) == 0 )
         {
            GXt_char4 = AV28tituloVacio ;
            GXv_char13[0] = GXt_char4 ;
            new web.textofueradeconvenio(remoteHandle, context).execute( AV8CliCod, GXv_char13) ;
            loadcombomigr2.this.GXt_char4 = GXv_char13[0] ;
            AV28tituloVacio = httpContext.getMessage( "Ninguna (", "") + GXutil.trim( GXt_char4) + ")" ;
         }
         else
         {
            AV28tituloVacio = httpContext.getMessage( "(Ninguno)", "") ;
         }
      }
      else
      {
         AV28tituloVacio = httpContext.getMessage( "(Ninguno)", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "!&campo ", "")+AV19campo) ;
      if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Area", "")) == 0 )
      {
         /* Using cursor P00NK2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A675SecDescripSinAc = P00NK2_A675SecDescripSinAc[0] ;
            n675SecDescripSinAc = P00NK2_n675SecDescripSinAc[0] ;
            A3CliCod = P00NK2_A3CliCod[0] ;
            A13SecCodigo = P00NK2_A13SecCodigo[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A675SecDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A675SecDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.upper( GXutil.trim( A675SecDescripSinAc)), 0);
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Categoria", "")) == 0 )
      {
         GXt_int1 = AV32PaiCod ;
         GXv_int2[0] = GXt_int1 ;
         new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
         loadcombomigr2.this.GXt_int1 = GXv_int2[0] ;
         AV32PaiCod = GXt_int1 ;
         GXv_char13[0] = AV33ConveCodigo ;
         GXv_boolean12[0] = false ;
         new web.getconveniopordescrip(remoteHandle, context).execute( AV8CliCod, AV32PaiCod, "", GXutil.trim( AV30dependenciaCodigo), GXv_char13, GXv_boolean12) ;
         loadcombomigr2.this.AV33ConveCodigo = GXv_char13[0] ;
         GXv_int14[0] = AV31CliConveVer ;
         new web.getversiondeconvenio(remoteHandle, context).execute( AV8CliCod, AV32PaiCod, AV33ConveCodigo, GXv_int14) ;
         loadcombomigr2.this.AV31CliConveVer = GXv_int14[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&CliConveVer ", "")+GXutil.trim( GXutil.str( AV31CliConveVer, 6, 0))+httpContext.getMessage( " &&ConveCodigo ", "")+AV33ConveCodigo+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &PaiCod ", "")+GXutil.trim( GXutil.str( AV32PaiCod, 4, 0))+httpContext.getMessage( " &dependenciaCodigo ", "")+GXutil.trim( AV30dependenciaCodigo)+httpContext.getMessage( " valor ", "")+AV20valor) ;
         AV43GXLvl89 = (byte)(0) ;
         /* Using cursor P00NK3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV31CliConveVer), Short.valueOf(AV32PaiCod), AV33ConveCodigo, AV20valor});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A676CatDescripSinAc = P00NK3_A676CatDescripSinAc[0] ;
            A1565CliConvenio = P00NK3_A1565CliConvenio[0] ;
            A1564CliPaiConve = P00NK3_A1564CliPaiConve[0] ;
            A3CliCod = P00NK3_A3CliCod[0] ;
            A8CatCodigo = P00NK3_A8CatCodigo[0] ;
            AV43GXLvl89 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "CatDescripSinAc", "")) ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A676CatDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A676CatDescripSinAc)), 0);
               new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "add simi", "")) ;
            }
            else
            {
               AV27otras.add(GXutil.trim( A676CatDescripSinAc), 0);
               new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "add otra", "")) ;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV43GXLvl89 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Banco", "")) == 0 )
      {
         /* Using cursor P00NK4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A679BanDescripSinAc = P00NK4_A679BanDescripSinAc[0] ;
            A3CliCod = P00NK4_A3CliCod[0] ;
            A7BanCod = P00NK4_A7BanCod[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A679BanDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A679BanDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A679BanDescripSinAc), 0);
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Sindicato", "")) == 0 )
      {
         /* Using cursor P00NK5 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV32PaiCod), AV20valor});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A680SinDescripSinAc = P00NK5_A680SinDescripSinAc[0] ;
            A46PaiCod = P00NK5_A46PaiCod[0] ;
            A1647SinSigla = P00NK5_A1647SinSigla[0] ;
            A14SinCod = P00NK5_A14SinCod[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A680SinDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A1647SinSigla)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A1647SinSigla), 0);
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Obra Social", "")) == 0 )
      {
         GXt_boolean15 = AV24MigrEncontroOsoSigla ;
         GXv_boolean12[0] = GXt_boolean15 ;
         new web.getmigrencontroososigla(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10MigrLegNumero, GXv_boolean12) ;
         loadcombomigr2.this.GXt_boolean15 = GXv_boolean12[0] ;
         AV24MigrEncontroOsoSigla = GXt_boolean15 ;
         GXt_boolean15 = AV34MigrEncontroOsoAfip ;
         GXv_boolean12[0] = GXt_boolean15 ;
         new web.getmigrencontroososigla(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10MigrLegNumero, GXv_boolean12) ;
         loadcombomigr2.this.GXt_boolean15 = GXv_boolean12[0] ;
         AV34MigrEncontroOsoAfip = GXt_boolean15 ;
         if ( ! AV24MigrEncontroOsoSigla && ! AV34MigrEncontroOsoAfip )
         {
            /* Using cursor P00NK6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A681OsoDescripSinAc = P00NK6_A681OsoDescripSinAc[0] ;
               A3CliCod = P00NK6_A3CliCod[0] ;
               A5OsoCod = P00NK6_A5OsoCod[0] ;
               if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A681OsoDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
               {
                  AV26similares.add(GXutil.upper( GXutil.trim( A681OsoDescripSinAc)), 0);
               }
               else
               {
                  AV27otras.add(GXutil.trim( A681OsoDescripSinAc), 0);
               }
               pr_default.readNext(4);
            }
            pr_default.close(4);
         }
         else
         {
            if ( AV24MigrEncontroOsoSigla )
            {
               /* Using cursor P00NK7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A392OsoSigla = P00NK7_A392OsoSigla[0] ;
                  A3CliCod = P00NK7_A3CliCod[0] ;
                  A555OsoSiglaYDesc = P00NK7_A555OsoSiglaYDesc[0] ;
                  A5OsoCod = P00NK7_A5OsoCod[0] ;
                  if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A392OsoSigla, GXutil.trim( AV21likeValor), 1) != 0 ) )
                  {
                     AV26similares.add(GXutil.upper( GXutil.trim( A555OsoSiglaYDesc)), 0);
                  }
                  else
                  {
                     AV27otras.add(GXutil.trim( A555OsoSiglaYDesc), 0);
                  }
                  pr_default.readNext(5);
               }
               pr_default.close(5);
            }
            else
            {
               /* Using cursor P00NK8 */
               pr_default.execute(6, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A306OsoC3992 = P00NK8_A306OsoC3992[0] ;
                  n306OsoC3992 = P00NK8_n306OsoC3992[0] ;
                  A3CliCod = P00NK8_A3CliCod[0] ;
                  A681OsoDescripSinAc = P00NK8_A681OsoDescripSinAc[0] ;
                  A5OsoCod = P00NK8_A5OsoCod[0] ;
                  if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A306OsoC3992, GXutil.trim( AV21likeValor), 1) != 0 ) )
                  {
                     AV26similares.add(GXutil.upper( GXutil.trim( A306OsoC3992))+" - "+GXutil.trim( A681OsoDescripSinAc), 0);
                  }
                  else
                  {
                     AV27otras.add(GXutil.upper( GXutil.trim( A306OsoC3992))+" - "+GXutil.trim( A681OsoDescripSinAc), 0);
                  }
                  pr_default.readNext(6);
               }
               pr_default.close(6);
            }
         }
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Plan Medico", "")) == 0 )
      {
         /* Using cursor P00NK9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A682PmedDescripSinAc = P00NK9_A682PmedDescripSinAc[0] ;
            A3CliCod = P00NK9_A3CliCod[0] ;
            A12PmedCod = P00NK9_A12PmedCod[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A682PmedDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A682PmedDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A682PmedDescripSinAc), 0);
            }
            pr_default.readNext(7);
         }
         pr_default.close(7);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Actividad", "")) == 0 )
      {
         /* Using cursor P00NK10 */
         pr_default.execute(8, new Object[] {AV20valor});
         while ( (pr_default.getStatus(8) != 101) )
         {
            A3CliCod = P00NK10_A3CliCod[0] ;
            A1579LegSecCodigo = P00NK10_A1579LegSecCodigo[0] ;
            n1579LegSecCodigo = P00NK10_n1579LegSecCodigo[0] ;
            A1EmpCod = P00NK10_A1EmpCod[0] ;
            A43ActCodigo = P00NK10_A43ActCodigo[0] ;
            n43ActCodigo = P00NK10_n43ActCodigo[0] ;
            A675SecDescripSinAc = P00NK10_A675SecDescripSinAc[0] ;
            n675SecDescripSinAc = P00NK10_n675SecDescripSinAc[0] ;
            A683ActDescripSinAc = P00NK10_A683ActDescripSinAc[0] ;
            A6LegNumero = P00NK10_A6LegNumero[0] ;
            A675SecDescripSinAc = P00NK10_A675SecDescripSinAc[0] ;
            n675SecDescripSinAc = P00NK10_n675SecDescripSinAc[0] ;
            A43ActCodigo = P00NK10_A43ActCodigo[0] ;
            n43ActCodigo = P00NK10_n43ActCodigo[0] ;
            A683ActDescripSinAc = P00NK10_A683ActDescripSinAc[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A683ActDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A683ActDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A683ActDescripSinAc), 0);
            }
            pr_default.readNext(8);
         }
         pr_default.close(8);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Modalidad", "")) == 0 )
      {
         /* Using cursor P00NK11 */
         pr_default.execute(9, new Object[] {AV20valor});
         while ( (pr_default.getStatus(9) != 101) )
         {
            A684MprDescripSinAc = P00NK11_A684MprDescripSinAc[0] ;
            A18MprCod = P00NK11_A18MprCod[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A684MprDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A684MprDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A684MprDescripSinAc), 0);
            }
            pr_default.readNext(9);
         }
         pr_default.close(9);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Adherente", "")) == 0 )
      {
         AV26similares.add(httpContext.getMessage( "SI", ""), 0);
         AV26similares.add(httpContext.getMessage( "NO", ""), 0);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Parentesco", "")) == 0 )
      {
         /* Using cursor P00NK12 */
         pr_default.execute(10, new Object[] {Integer.valueOf(AV8CliCod), AV20valor});
         while ( (pr_default.getStatus(10) != 101) )
         {
            A2083ParDescripSinAc = P00NK12_A2083ParDescripSinAc[0] ;
            A3CliCod = P00NK12_A3CliCod[0] ;
            A30ParCod = P00NK12_A30ParCod[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A2083ParDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A2083ParDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A2083ParDescripSinAc), 0);
            }
            pr_default.readNext(10);
         }
         pr_default.close(10);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Zona", "")) == 0 )
      {
         /* Using cursor P00NK13 */
         pr_default.execute(11, new Object[] {AV20valor});
         while ( (pr_default.getStatus(11) != 101) )
         {
            A678ZonDescripSinAc = P00NK13_A678ZonDescripSinAc[0] ;
            A20ZonCod = P00NK13_A20ZonCod[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A678ZonDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A678ZonDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A678ZonDescripSinAc), 0);
            }
            pr_default.readNext(11);
         }
         pr_default.close(11);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Situacion", "")) == 0 )
      {
         /* Using cursor P00NK14 */
         pr_default.execute(12, new Object[] {AV20valor});
         while ( (pr_default.getStatus(12) != 101) )
         {
            A685SitDescripSinAc = P00NK14_A685SitDescripSinAc[0] ;
            A16SitCodigo = P00NK14_A16SitCodigo[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A685SitDescripSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A685SitDescripSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A685SitDescripSinAc), 0);
            }
            pr_default.readNext(12);
         }
         pr_default.close(12);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Convenio", "")) == 0 )
      {
         /* Using cursor P00NK15 */
         pr_default.execute(13, new Object[] {AV20valor});
         while ( (pr_default.getStatus(13) != 101) )
         {
            A687ConveDescriSinAc = P00NK15_A687ConveDescriSinAc[0] ;
            A46PaiCod = P00NK15_A46PaiCod[0] ;
            A9ConveCodigo = P00NK15_A9ConveCodigo[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A687ConveDescriSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A687ConveDescriSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A687ConveDescriSinAc), 0);
            }
            pr_default.readNext(13);
         }
         pr_default.close(13);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Condicion", "")) == 0 )
      {
         /* Using cursor P00NK16 */
         pr_default.execute(14, new Object[] {AV20valor});
         while ( (pr_default.getStatus(14) != 101) )
         {
            A686CondiDescriSinAc = P00NK16_A686CondiDescriSinAc[0] ;
            A17CondiCodigo = P00NK16_A17CondiCodigo[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A686CondiDescriSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A686CondiDescriSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A686CondiDescriSinAc), 0);
            }
            pr_default.readNext(14);
         }
         pr_default.close(14);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Siniestrado", "")) == 0 )
      {
         /* Using cursor P00NK17 */
         pr_default.execute(15, new Object[] {AV20valor});
         while ( (pr_default.getStatus(15) != 101) )
         {
            A688SinieDescriSinAc = P00NK17_A688SinieDescriSinAc[0] ;
            A19SinieCodigo = P00NK17_A19SinieCodigo[0] ;
            if ( ! AV17existe && ( AV13hayLike ) && ( GXutil.strSearch( A688SinieDescriSinAc, GXutil.trim( AV21likeValor), 1) != 0 ) )
            {
               AV26similares.add(GXutil.upper( GXutil.trim( A688SinieDescriSinAc)), 0);
            }
            else
            {
               AV27otras.add(GXutil.trim( A688SinieDescriSinAc), 0);
            }
            pr_default.readNext(15);
         }
         pr_default.close(15);
      }
      else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Género", "")) == 0 )
      {
         /* Using cursor P00NK18 */
         pr_default.execute(16, new Object[] {Short.valueOf(AV32PaiCod)});
         while ( (pr_default.getStatus(16) != 101) )
         {
            A1742SexoPaiCod = P00NK18_A1742SexoPaiCod[0] ;
            A1744SexoNombre = P00NK18_A1744SexoNombre[0] ;
            A1743SexoId = P00NK18_A1743SexoId[0] ;
            AV27otras.add(GXutil.trim( A1744SexoNombre), 0);
            pr_default.readNext(16);
         }
         pr_default.close(16);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = loadcombomigr2.this.AV26similares;
      this.aP7[0] = loadcombomigr2.this.AV27otras;
      this.aP8[0] = loadcombomigr2.this.AV28tituloVacio;
      this.aP9[0] = loadcombomigr2.this.AV13hayLike;
      this.aP10[0] = loadcombomigr2.this.AV23valor_devuelve;
      this.aP11[0] = loadcombomigr2.this.AV17existe;
      this.aP12[0] = loadcombomigr2.this.AV25esCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26similares = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27otras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28tituloVacio = "" ;
      AV23valor_devuelve = "" ;
      AV41Pgmname = "" ;
      AV36ParmValue = "" ;
      GXt_char3 = "" ;
      AV35AlgortimoEquivalenciasImpLeg = "" ;
      AV33ConveCodigo = "" ;
      AV14errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int10 = new byte[1] ;
      GXv_char6 = new String[1] ;
      GXv_objcol_svchar8 = new GXSimpleCollection[1] ;
      AV18warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar11 = new GXSimpleCollection[1] ;
      AV21likeValor = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXt_char4 = "" ;
      scmdbuf = "" ;
      P00NK2_A675SecDescripSinAc = new String[] {""} ;
      P00NK2_n675SecDescripSinAc = new boolean[] {false} ;
      P00NK2_A3CliCod = new int[1] ;
      P00NK2_A13SecCodigo = new String[] {""} ;
      A675SecDescripSinAc = "" ;
      A13SecCodigo = "" ;
      GXv_int2 = new short[1] ;
      GXv_char13 = new String[1] ;
      GXv_int14 = new int[1] ;
      P00NK3_A676CatDescripSinAc = new String[] {""} ;
      P00NK3_A1565CliConvenio = new String[] {""} ;
      P00NK3_A1564CliPaiConve = new short[1] ;
      P00NK3_A3CliCod = new int[1] ;
      P00NK3_A8CatCodigo = new String[] {""} ;
      A676CatDescripSinAc = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      P00NK4_A679BanDescripSinAc = new String[] {""} ;
      P00NK4_A3CliCod = new int[1] ;
      P00NK4_A7BanCod = new String[] {""} ;
      A679BanDescripSinAc = "" ;
      A7BanCod = "" ;
      P00NK5_A680SinDescripSinAc = new String[] {""} ;
      P00NK5_A46PaiCod = new short[1] ;
      P00NK5_A1647SinSigla = new String[] {""} ;
      P00NK5_A14SinCod = new String[] {""} ;
      A680SinDescripSinAc = "" ;
      A1647SinSigla = "" ;
      A14SinCod = "" ;
      GXv_boolean12 = new boolean[1] ;
      P00NK6_A681OsoDescripSinAc = new String[] {""} ;
      P00NK6_A3CliCod = new int[1] ;
      P00NK6_A5OsoCod = new String[] {""} ;
      A681OsoDescripSinAc = "" ;
      A5OsoCod = "" ;
      P00NK7_A392OsoSigla = new String[] {""} ;
      P00NK7_A3CliCod = new int[1] ;
      P00NK7_A555OsoSiglaYDesc = new String[] {""} ;
      P00NK7_A5OsoCod = new String[] {""} ;
      A392OsoSigla = "" ;
      A555OsoSiglaYDesc = "" ;
      P00NK8_A306OsoC3992 = new String[] {""} ;
      P00NK8_n306OsoC3992 = new boolean[] {false} ;
      P00NK8_A3CliCod = new int[1] ;
      P00NK8_A681OsoDescripSinAc = new String[] {""} ;
      P00NK8_A5OsoCod = new String[] {""} ;
      A306OsoC3992 = "" ;
      P00NK9_A682PmedDescripSinAc = new String[] {""} ;
      P00NK9_A3CliCod = new int[1] ;
      P00NK9_A12PmedCod = new String[] {""} ;
      A682PmedDescripSinAc = "" ;
      A12PmedCod = "" ;
      P00NK10_A3CliCod = new int[1] ;
      P00NK10_A1579LegSecCodigo = new String[] {""} ;
      P00NK10_n1579LegSecCodigo = new boolean[] {false} ;
      P00NK10_A1EmpCod = new short[1] ;
      P00NK10_A43ActCodigo = new String[] {""} ;
      P00NK10_n43ActCodigo = new boolean[] {false} ;
      P00NK10_A675SecDescripSinAc = new String[] {""} ;
      P00NK10_n675SecDescripSinAc = new boolean[] {false} ;
      P00NK10_A683ActDescripSinAc = new String[] {""} ;
      P00NK10_A6LegNumero = new int[1] ;
      A1579LegSecCodigo = "" ;
      A43ActCodigo = "" ;
      A683ActDescripSinAc = "" ;
      P00NK11_A684MprDescripSinAc = new String[] {""} ;
      P00NK11_A18MprCod = new String[] {""} ;
      A684MprDescripSinAc = "" ;
      A18MprCod = "" ;
      P00NK12_A2083ParDescripSinAc = new String[] {""} ;
      P00NK12_A3CliCod = new int[1] ;
      P00NK12_A30ParCod = new String[] {""} ;
      A2083ParDescripSinAc = "" ;
      A30ParCod = "" ;
      P00NK13_A678ZonDescripSinAc = new String[] {""} ;
      P00NK13_A20ZonCod = new String[] {""} ;
      A678ZonDescripSinAc = "" ;
      A20ZonCod = "" ;
      P00NK14_A685SitDescripSinAc = new String[] {""} ;
      P00NK14_A16SitCodigo = new String[] {""} ;
      A685SitDescripSinAc = "" ;
      A16SitCodigo = "" ;
      P00NK15_A687ConveDescriSinAc = new String[] {""} ;
      P00NK15_A46PaiCod = new short[1] ;
      P00NK15_A9ConveCodigo = new String[] {""} ;
      A687ConveDescriSinAc = "" ;
      A9ConveCodigo = "" ;
      P00NK16_A686CondiDescriSinAc = new String[] {""} ;
      P00NK16_A17CondiCodigo = new short[1] ;
      A686CondiDescriSinAc = "" ;
      P00NK17_A688SinieDescriSinAc = new String[] {""} ;
      P00NK17_A19SinieCodigo = new String[] {""} ;
      A688SinieDescriSinAc = "" ;
      A19SinieCodigo = "" ;
      P00NK18_A1742SexoPaiCod = new short[1] ;
      P00NK18_A1744SexoNombre = new String[] {""} ;
      P00NK18_A1743SexoId = new byte[1] ;
      A1744SexoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.loadcombomigr2__default(),
         new Object[] {
             new Object[] {
            P00NK2_A675SecDescripSinAc, P00NK2_A3CliCod, P00NK2_A13SecCodigo
            }
            , new Object[] {
            P00NK3_A676CatDescripSinAc, P00NK3_A1565CliConvenio, P00NK3_A1564CliPaiConve, P00NK3_A3CliCod, P00NK3_A8CatCodigo
            }
            , new Object[] {
            P00NK4_A679BanDescripSinAc, P00NK4_A3CliCod, P00NK4_A7BanCod
            }
            , new Object[] {
            P00NK5_A680SinDescripSinAc, P00NK5_A46PaiCod, P00NK5_A1647SinSigla, P00NK5_A14SinCod
            }
            , new Object[] {
            P00NK6_A681OsoDescripSinAc, P00NK6_A3CliCod, P00NK6_A5OsoCod
            }
            , new Object[] {
            P00NK7_A392OsoSigla, P00NK7_A3CliCod, P00NK7_A555OsoSiglaYDesc, P00NK7_A5OsoCod
            }
            , new Object[] {
            P00NK8_A306OsoC3992, P00NK8_n306OsoC3992, P00NK8_A3CliCod, P00NK8_A681OsoDescripSinAc, P00NK8_A5OsoCod
            }
            , new Object[] {
            P00NK9_A682PmedDescripSinAc, P00NK9_A3CliCod, P00NK9_A12PmedCod
            }
            , new Object[] {
            P00NK10_A3CliCod, P00NK10_A1579LegSecCodigo, P00NK10_n1579LegSecCodigo, P00NK10_A1EmpCod, P00NK10_A43ActCodigo, P00NK10_n43ActCodigo, P00NK10_A675SecDescripSinAc, P00NK10_n675SecDescripSinAc, P00NK10_A683ActDescripSinAc, P00NK10_A6LegNumero
            }
            , new Object[] {
            P00NK11_A684MprDescripSinAc, P00NK11_A18MprCod
            }
            , new Object[] {
            P00NK12_A2083ParDescripSinAc, P00NK12_A3CliCod, P00NK12_A30ParCod
            }
            , new Object[] {
            P00NK13_A678ZonDescripSinAc, P00NK13_A20ZonCod
            }
            , new Object[] {
            P00NK14_A685SitDescripSinAc, P00NK14_A16SitCodigo
            }
            , new Object[] {
            P00NK15_A687ConveDescriSinAc, P00NK15_A46PaiCod, P00NK15_A9ConveCodigo
            }
            , new Object[] {
            P00NK16_A686CondiDescriSinAc, P00NK16_A17CondiCodigo
            }
            , new Object[] {
            P00NK17_A688SinieDescriSinAc, P00NK17_A19SinieCodigo
            }
            , new Object[] {
            P00NK18_A1742SexoPaiCod, P00NK18_A1744SexoNombre, P00NK18_A1743SexoId
            }
         }
      );
      AV41Pgmname = "LoadComboMigr2" ;
      /* GeneXus formulas. */
      AV41Pgmname = "LoadComboMigr2" ;
      Gx_err = (short)(0) ;
   }

   private byte GXv_int10[] ;
   private byte AV43GXLvl89 ;
   private byte A1743SexoId ;
   private short AV9EmpCod ;
   private short AV32PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short A46PaiCod ;
   private short A1EmpCod ;
   private short A17CondiCodigo ;
   private short A1742SexoPaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10MigrLegNumero ;
   private int A3CliCod ;
   private int AV31CliConveVer ;
   private int GXv_int14[] ;
   private int A6LegNumero ;
   private String AV19campo ;
   private String AV30dependenciaCodigo ;
   private String AV28tituloVacio ;
   private String AV41Pgmname ;
   private String GXt_char3 ;
   private String AV35AlgortimoEquivalenciasImpLeg ;
   private String AV33ConveCodigo ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXt_char4 ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private String GXv_char13[] ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String A7BanCod ;
   private String A14SinCod ;
   private String A5OsoCod ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private String A12PmedCod ;
   private String A1579LegSecCodigo ;
   private String A43ActCodigo ;
   private String A18MprCod ;
   private String A30ParCod ;
   private String A20ZonCod ;
   private String A16SitCodigo ;
   private String A9ConveCodigo ;
   private String A19SinieCodigo ;
   private boolean AV13hayLike ;
   private boolean AV17existe ;
   private boolean AV25esCodigo ;
   private boolean AV38boolean ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean7[] ;
   private boolean n675SecDescripSinAc ;
   private boolean AV24MigrEncontroOsoSigla ;
   private boolean AV34MigrEncontroOsoAfip ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean12[] ;
   private boolean n306OsoC3992 ;
   private boolean n1579LegSecCodigo ;
   private boolean n43ActCodigo ;
   private String AV36ParmValue ;
   private String AV20valor ;
   private String AV23valor_devuelve ;
   private String AV21likeValor ;
   private String A675SecDescripSinAc ;
   private String A676CatDescripSinAc ;
   private String A679BanDescripSinAc ;
   private String A680SinDescripSinAc ;
   private String A1647SinSigla ;
   private String A681OsoDescripSinAc ;
   private String A555OsoSiglaYDesc ;
   private String A682PmedDescripSinAc ;
   private String A683ActDescripSinAc ;
   private String A684MprDescripSinAc ;
   private String A2083ParDescripSinAc ;
   private String A678ZonDescripSinAc ;
   private String A685SitDescripSinAc ;
   private String A687ConveDescriSinAc ;
   private String A686CondiDescriSinAc ;
   private String A688SinieDescriSinAc ;
   private String A1744SexoNombre ;
   private boolean[] aP12 ;
   private GXSimpleCollection<String>[] aP6 ;
   private GXSimpleCollection<String>[] aP7 ;
   private String[] aP8 ;
   private boolean[] aP9 ;
   private String[] aP10 ;
   private boolean[] aP11 ;
   private IDataStoreProvider pr_default ;
   private String[] P00NK2_A675SecDescripSinAc ;
   private boolean[] P00NK2_n675SecDescripSinAc ;
   private int[] P00NK2_A3CliCod ;
   private String[] P00NK2_A13SecCodigo ;
   private String[] P00NK3_A676CatDescripSinAc ;
   private String[] P00NK3_A1565CliConvenio ;
   private short[] P00NK3_A1564CliPaiConve ;
   private int[] P00NK3_A3CliCod ;
   private String[] P00NK3_A8CatCodigo ;
   private String[] P00NK4_A679BanDescripSinAc ;
   private int[] P00NK4_A3CliCod ;
   private String[] P00NK4_A7BanCod ;
   private String[] P00NK5_A680SinDescripSinAc ;
   private short[] P00NK5_A46PaiCod ;
   private String[] P00NK5_A1647SinSigla ;
   private String[] P00NK5_A14SinCod ;
   private String[] P00NK6_A681OsoDescripSinAc ;
   private int[] P00NK6_A3CliCod ;
   private String[] P00NK6_A5OsoCod ;
   private String[] P00NK7_A392OsoSigla ;
   private int[] P00NK7_A3CliCod ;
   private String[] P00NK7_A555OsoSiglaYDesc ;
   private String[] P00NK7_A5OsoCod ;
   private String[] P00NK8_A306OsoC3992 ;
   private boolean[] P00NK8_n306OsoC3992 ;
   private int[] P00NK8_A3CliCod ;
   private String[] P00NK8_A681OsoDescripSinAc ;
   private String[] P00NK8_A5OsoCod ;
   private String[] P00NK9_A682PmedDescripSinAc ;
   private int[] P00NK9_A3CliCod ;
   private String[] P00NK9_A12PmedCod ;
   private int[] P00NK10_A3CliCod ;
   private String[] P00NK10_A1579LegSecCodigo ;
   private boolean[] P00NK10_n1579LegSecCodigo ;
   private short[] P00NK10_A1EmpCod ;
   private String[] P00NK10_A43ActCodigo ;
   private boolean[] P00NK10_n43ActCodigo ;
   private String[] P00NK10_A675SecDescripSinAc ;
   private boolean[] P00NK10_n675SecDescripSinAc ;
   private String[] P00NK10_A683ActDescripSinAc ;
   private int[] P00NK10_A6LegNumero ;
   private String[] P00NK11_A684MprDescripSinAc ;
   private String[] P00NK11_A18MprCod ;
   private String[] P00NK12_A2083ParDescripSinAc ;
   private int[] P00NK12_A3CliCod ;
   private String[] P00NK12_A30ParCod ;
   private String[] P00NK13_A678ZonDescripSinAc ;
   private String[] P00NK13_A20ZonCod ;
   private String[] P00NK14_A685SitDescripSinAc ;
   private String[] P00NK14_A16SitCodigo ;
   private String[] P00NK15_A687ConveDescriSinAc ;
   private short[] P00NK15_A46PaiCod ;
   private String[] P00NK15_A9ConveCodigo ;
   private String[] P00NK16_A686CondiDescriSinAc ;
   private short[] P00NK16_A17CondiCodigo ;
   private String[] P00NK17_A688SinieDescriSinAc ;
   private String[] P00NK17_A19SinieCodigo ;
   private short[] P00NK18_A1742SexoPaiCod ;
   private String[] P00NK18_A1744SexoNombre ;
   private byte[] P00NK18_A1743SexoId ;
   private GXSimpleCollection<String> AV26similares ;
   private GXSimpleCollection<String> AV27otras ;
   private GXSimpleCollection<String> AV14errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar8[] ;
   private GXSimpleCollection<String> AV18warnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar11[] ;
}

final  class loadcombomigr2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00NK2", "SELECT SecDescripSinAc, CliCod, SecCodigo FROM Seccion WHERE (CliCod = ?) AND (SecDescripSinAc <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK3", "SELECT CatDescripSinAc, CliConvenio, CliPaiConve, CliCod, CatCodigo FROM Categoria1 WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (CatDescripSinAc <> ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK4", "SELECT BanDescripSinAc, CliCod, BanCod FROM Banco WHERE (CliCod = ?) AND (BanDescripSinAc <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK5", "SELECT SinDescripSinAc, PaiCod, SinSigla, SinCod FROM Sindicato WHERE (PaiCod = ?) AND (SinDescripSinAc <> ( ?)) ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK6", "SELECT OsoDescripSinAc, CliCod, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoDescripSinAc <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK7", "SELECT OsoSigla, CliCod, OsoSiglaYDesc, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoSigla <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK8", "SELECT OsoC3992, CliCod, OsoDescripSinAc, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoC3992 <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK9", "SELECT PmedDescripSinAc, CliCod, PmedCod FROM PlanMedico WHERE (CliCod = ?) AND (PmedDescripSinAc <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK10", "SELECT T1.CliCod, T1.LegSecCodigo AS LegSecCodigo, T1.EmpCod, T3.ActCodigo, T2.SecDescripSinAc, T4.ActDescripSinAc, T1.LegNumero FROM (((Legajo T1 LEFT JOIN Seccion T2 ON T2.CliCod = T1.CliCod AND T2.SecCodigo = T1.LegSecCodigo) INNER JOIN Empresa T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod) LEFT JOIN Actividad T4 ON T4.ActCodigo = T3.ActCodigo) WHERE T2.SecDescripSinAc <> ( ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK11", "SELECT MprDescripSinAc, MprCod FROM ModalidadAFIP WHERE MprDescripSinAc <> ( ?) ORDER BY MprCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK12", "SELECT ParDescripSinAc, CliCod, ParCod FROM Parentesco WHERE (CliCod = ?) AND (ParDescripSinAc <> ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK13", "SELECT ZonDescripSinAc, ZonCod FROM Zona WHERE ZonDescripSinAc <> ( ?) ORDER BY ZonCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK14", "SELECT SitDescripSinAc, SitCodigo FROM Estado WHERE SitDescripSinAc <> ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK15", "SELECT ConveDescriSinAc, PaiCod, ConveCodigo FROM Convenio WHERE ConveDescriSinAc <> ( ?) ORDER BY PaiCod, ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK16", "SELECT CondiDescriSinAc, CondiCodigo FROM CondicionAFIP WHERE CondiDescriSinAc <> ( ?) ORDER BY CondiCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK17", "SELECT SinieDescriSinAc, SinieCodigo FROM Siniestrado WHERE SinieDescriSinAc <> ( ?) ORDER BY SinieCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NK18", "SELECT SexoPaiCod, SexoNombre, SexoId FROM Sexos WHERE SexoPaiCod = ? ORDER BY SexoPaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 8);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 14 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 15 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

