package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarconceptotipoliqparaganancias extends GXProcedure
{
   public inicializarconceptotipoliqparaganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarconceptotipoliqparaganancias.class ), "" );
   }

   public inicializarconceptotipoliqparaganancias( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      inicializarconceptotipoliqparaganancias.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9gansubtipo1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipoganancias(remoteHandle, context).execute( GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char2[0] ;
      AV9gansubtipo1 = GXt_char1 ;
      GXt_char1 = AV15gansubtipo2 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipocalculoganancias(remoteHandle, context).execute( GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char2[0] ;
      AV15gansubtipo2 = GXt_char1 ;
      GXt_char1 = AV12mensualTLiqCod ;
      GXt_char3 = AV12mensualTLiqCod ;
      GXv_char2[0] = GXt_char3 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char4[0] ;
      AV12mensualTLiqCod = GXt_char1 ;
      AV11TLiqCod.add(AV12mensualTLiqCod, 0);
      GXt_char3 = AV13finalTLiqCod ;
      GXt_char1 = AV13finalTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char2[0] ;
      AV13finalTLiqCod = GXt_char3 ;
      AV11TLiqCod.add(AV13finalTLiqCod, 0);
      GXt_char3 = AV17adelantoRetencionConCodigo ;
      GXt_char1 = AV17adelantoRetencionConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.adelantoretencionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char2[0] ;
      AV17adelantoRetencionConCodigo = GXt_char3 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&gansubtipo1 ", "")+AV9gansubtipo1) ;
      if ( false )
      {
         AV32GXLvl17 = (byte)(0) ;
         /* Using cursor P00UD2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9gansubtipo1, AV15gansubtipo2});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A26ConCodigo = P00UD2_A26ConCodigo[0] ;
            A3CliCod = P00UD2_A3CliCod[0] ;
            A38SubTipoConCod1 = P00UD2_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P00UD2_n38SubTipoConCod1[0] ;
            A41ConDescrip = P00UD2_A41ConDescrip[0] ;
            AV32GXLvl17 = (byte)(1) ;
            if ( ( GXutil.strcmp(A26ConCodigo, AV17adelantoRetencionConCodigo) != 0 ) && ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "SUELDO BRUTO", "")) != 0 ) )
            {
               AV10i = (short)(1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&TLiqCod.Count ", "")+GXutil.trim( GXutil.str( AV11TLiqCod.size(), 9, 0))) ;
               while ( AV10i <= AV11TLiqCod.size() )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "new ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &TLiqCod.Item(&i) ", "")+GXutil.trim( (String)AV11TLiqCod.elementAt(-1+AV10i))) ;
                  /*
                     INSERT RECORD ON TABLE ConceptoTipoLiquidacion

                  */
                  W26ConCodigo = A26ConCodigo ;
                  A32TLiqCod = (String)AV11TLiqCod.elementAt(-1+AV10i) ;
                  /* Using cursor P00UD3 */
                  pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
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
                  A26ConCodigo = W26ConCodigo ;
                  /* End Insert */
                  AV10i = (short)(AV10i+1) ;
               }
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV32GXLvl17 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "none", "")) ;
         }
         AV33GXLvl38 = (byte)(0) ;
         /* Using cursor P00UD4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A26ConCodigo = P00UD4_A26ConCodigo[0] ;
            A3CliCod = P00UD4_A3CliCod[0] ;
            A41ConDescrip = P00UD4_A41ConDescrip[0] ;
            if ( ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "SUELDO BRUTO SIN SAC", "")) == 0 ) || ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DEVOLUCIÓN GANANCIAS", "")) == 0 ) )
            {
               AV33GXLvl38 = (byte)(1) ;
               AV10i = (short)(1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&TLiqCod.Count ", "")+GXutil.trim( GXutil.str( AV11TLiqCod.size(), 9, 0))) ;
               while ( AV10i <= AV11TLiqCod.size() )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "new ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &TLiqCod.Item(&i) ", "")+GXutil.trim( (String)AV11TLiqCod.elementAt(-1+AV10i))) ;
                  /*
                     INSERT RECORD ON TABLE ConceptoTipoLiquidacion

                  */
                  W26ConCodigo = A26ConCodigo ;
                  A32TLiqCod = (String)AV11TLiqCod.elementAt(-1+AV10i) ;
                  /* Using cursor P00UD5 */
                  pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(3) == 1) )
                  {
                     Gx_err = (short)(1) ;
                     Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                  }
                  else
                  {
                     Gx_err = (short)(0) ;
                     Gx_emsg = "" ;
                  }
                  A26ConCodigo = W26ConCodigo ;
                  /* End Insert */
                  AV10i = (short)(AV10i+1) ;
               }
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV33GXLvl38 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      GXv_char4[0] = AV16aguiTLiqCod ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.AV16aguiTLiqCod = GXv_char4[0] ;
      GXv_char4[0] = AV23anticTLiqCod ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.tipoliqanticipo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.AV23anticTLiqCod = GXv_char4[0] ;
      GXv_char4[0] = AV24varTLiqCod ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.tipoliqvarios_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.AV24varTLiqCod = GXv_char4[0] ;
      GXt_char3 = AV25sacConDescrip ;
      GXv_char4[0] = GXt_char3 ;
      new web.sac_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char4[0] ;
      AV25sacConDescrip = GXt_char3 ;
      GXt_char3 = AV26sacProporConDescrip ;
      GXv_char4[0] = GXt_char3 ;
      new web.sac_propor_descripcion_fija(remoteHandle, context).execute( GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char4[0] ;
      AV26sacProporConDescrip = GXt_char3 ;
      AV34GXLvl70 = (byte)(0) ;
      /* Using cursor P00UD6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV8CliCod), AV25sacConDescrip, AV26sacProporConDescrip});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A26ConCodigo = P00UD6_A26ConCodigo[0] ;
         A3CliCod = P00UD6_A3CliCod[0] ;
         A41ConDescrip = P00UD6_A41ConDescrip[0] ;
         AV34GXLvl70 = (byte)(1) ;
         AV10i = (short)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&TLiqCod.Count ", "")+GXutil.trim( GXutil.str( AV11TLiqCod.size(), 9, 0))) ;
         while ( AV10i <= AV11TLiqCod.size() )
         {
            if ( GXutil.strcmp((String)AV11TLiqCod.elementAt(-1+AV10i), AV14gananciasTLiqCod) != 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "new ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &TLiqCod.Item(&i) ", "")+GXutil.trim( (String)AV11TLiqCod.elementAt(-1+AV10i))) ;
               /*
                  INSERT RECORD ON TABLE ConceptoTipoLiquidacion

               */
               W26ConCodigo = A26ConCodigo ;
               A32TLiqCod = (String)AV11TLiqCod.elementAt(-1+AV10i) ;
               /* Using cursor P00UD7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
               if ( (pr_default.getStatus(5) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               A26ConCodigo = W26ConCodigo ;
               /* End Insert */
            }
            AV10i = (short)(AV10i+1) ;
         }
         /*
            INSERT RECORD ON TABLE ConceptoTipoLiquidacion

         */
         W26ConCodigo = A26ConCodigo ;
         A32TLiqCod = AV16aguiTLiqCod ;
         /* Using cursor P00UD8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
         if ( (pr_default.getStatus(6) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         A26ConCodigo = W26ConCodigo ;
         /* End Insert */
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( AV34GXLvl70 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "none", "")) ;
      }
      GXt_char3 = AV22vacTLiqCod ;
      GXt_char1 = AV22vacTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char2[0] ;
      AV22vacTLiqCod = GXt_char3 ;
      /* Using cursor P00UD9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A3CliCod = P00UD9_A3CliCod[0] ;
         A32TLiqCod = P00UD9_A32TLiqCod[0] ;
         AV21todasTLiqCod.add(A32TLiqCod, 0);
         pr_default.readNext(7);
      }
      pr_default.close(7);
      GXt_char3 = AV27redondeoConCodigo ;
      GXt_char1 = AV27redondeoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_redondeo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      inicializarconceptotipoliqparaganancias.this.GXt_char3 = GXv_char2[0] ;
      AV27redondeoConCodigo = GXt_char3 ;
      /* Using cursor P00UD10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A26ConCodigo = P00UD10_A26ConCodigo[0] ;
         A3CliCod = P00UD10_A3CliCod[0] ;
         A37TipoConCod = P00UD10_A37TipoConCod[0] ;
         A162ConVigencia = P00UD10_A162ConVigencia[0] ;
         GXv_objcol_char5[0] = AV19collectionTLiqCod ;
         new web.gettiposliqdeconcepto(remoteHandle, context).execute( AV8CliCod, A26ConCodigo, GXv_objcol_char5) ;
         AV19collectionTLiqCod = GXv_objcol_char5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &collectionTLiqCod ", "")+GXutil.trim( GXutil.str( AV19collectionTLiqCod.size(), 9, 0))) ;
         if ( AV19collectionTLiqCod.size() == 0 )
         {
            AV20e = (short)(1) ;
            while ( AV20e <= AV21todasTLiqCod.size() )
            {
               AV28ok = false ;
               if ( GXutil.strcmp(A26ConCodigo, AV27redondeoConCodigo) == 0 )
               {
                  AV28ok = true ;
               }
               else
               {
                  if ( ( GXutil.strcmp((String)AV21todasTLiqCod.elementAt(-1+AV20e), AV22vacTLiqCod) != 0 ) && ( GXutil.strcmp((String)AV21todasTLiqCod.elementAt(-1+AV20e), AV16aguiTLiqCod) != 0 ) && ( GXutil.strcmp((String)AV21todasTLiqCod.elementAt(-1+AV20e), AV23anticTLiqCod) != 0 ) )
                  {
                     if ( ( GXutil.strcmp((String)AV21todasTLiqCod.elementAt(-1+AV20e), AV24varTLiqCod) != 0 ) || ( A162ConVigencia == 1 ) )
                     {
                        AV28ok = true ;
                     }
                  }
               }
               if ( AV28ok )
               {
                  /*
                     INSERT RECORD ON TABLE ConceptoTipoLiquidacion

                  */
                  W26ConCodigo = A26ConCodigo ;
                  A32TLiqCod = (String)AV21todasTLiqCod.elementAt(-1+AV20e) ;
                  /* Using cursor P00UD11 */
                  pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(9) == 1) )
                  {
                     Gx_err = (short)(1) ;
                     Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                  }
                  else
                  {
                     Gx_err = (short)(0) ;
                     Gx_emsg = "" ;
                  }
                  A26ConCodigo = W26ConCodigo ;
                  /* End Insert */
                  new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( " neeeeew ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &todasTLiqCod.Item(&e) ", "")+(String)AV21todasTLiqCod.elementAt(-1+AV20e)) ;
               }
               AV20e = (short)(AV20e+1) ;
            }
         }
         pr_default.readNext(8);
      }
      pr_default.close(8);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarconceptotipoliqparaganancias");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9gansubtipo1 = "" ;
      AV15gansubtipo2 = "" ;
      AV12mensualTLiqCod = "" ;
      AV11TLiqCod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13finalTLiqCod = "" ;
      AV17adelantoRetencionConCodigo = "" ;
      AV31Pgmname = "" ;
      scmdbuf = "" ;
      P00UD2_A26ConCodigo = new String[] {""} ;
      P00UD2_A3CliCod = new int[1] ;
      P00UD2_A38SubTipoConCod1 = new String[] {""} ;
      P00UD2_n38SubTipoConCod1 = new boolean[] {false} ;
      P00UD2_A41ConDescrip = new String[] {""} ;
      A26ConCodigo = "" ;
      A38SubTipoConCod1 = "" ;
      A41ConDescrip = "" ;
      W26ConCodigo = "" ;
      A32TLiqCod = "" ;
      Gx_emsg = "" ;
      P00UD4_A26ConCodigo = new String[] {""} ;
      P00UD4_A3CliCod = new int[1] ;
      P00UD4_A41ConDescrip = new String[] {""} ;
      AV16aguiTLiqCod = "" ;
      AV23anticTLiqCod = "" ;
      AV24varTLiqCod = "" ;
      AV25sacConDescrip = "" ;
      AV26sacProporConDescrip = "" ;
      P00UD6_A26ConCodigo = new String[] {""} ;
      P00UD6_A3CliCod = new int[1] ;
      P00UD6_A41ConDescrip = new String[] {""} ;
      AV14gananciasTLiqCod = "" ;
      AV22vacTLiqCod = "" ;
      P00UD9_A3CliCod = new int[1] ;
      P00UD9_A32TLiqCod = new String[] {""} ;
      AV21todasTLiqCod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27redondeoConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char2 = new String[1] ;
      P00UD10_A26ConCodigo = new String[] {""} ;
      P00UD10_A3CliCod = new int[1] ;
      P00UD10_A37TipoConCod = new String[] {""} ;
      P00UD10_A162ConVigencia = new byte[1] ;
      A37TipoConCod = "" ;
      AV19collectionTLiqCod = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char5 = new GXSimpleCollection[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarconceptotipoliqparaganancias__default(),
         new Object[] {
             new Object[] {
            P00UD2_A26ConCodigo, P00UD2_A3CliCod, P00UD2_A38SubTipoConCod1, P00UD2_n38SubTipoConCod1, P00UD2_A41ConDescrip
            }
            , new Object[] {
            }
            , new Object[] {
            P00UD4_A26ConCodigo, P00UD4_A3CliCod, P00UD4_A41ConDescrip
            }
            , new Object[] {
            }
            , new Object[] {
            P00UD6_A26ConCodigo, P00UD6_A3CliCod, P00UD6_A41ConDescrip
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P00UD9_A3CliCod, P00UD9_A32TLiqCod
            }
            , new Object[] {
            P00UD10_A26ConCodigo, P00UD10_A3CliCod, P00UD10_A37TipoConCod, P00UD10_A162ConVigencia
            }
            , new Object[] {
            }
         }
      );
      AV31Pgmname = "inicializarConceptoTipoLiqParaGanancias" ;
      /* GeneXus formulas. */
      AV31Pgmname = "inicializarConceptoTipoLiqParaGanancias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV32GXLvl17 ;
   private byte AV33GXLvl38 ;
   private byte AV34GXLvl70 ;
   private byte A162ConVigencia ;
   private short AV10i ;
   private short Gx_err ;
   private short AV20e ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int GX_INS8 ;
   private String AV9gansubtipo1 ;
   private String AV15gansubtipo2 ;
   private String AV12mensualTLiqCod ;
   private String AV13finalTLiqCod ;
   private String AV17adelantoRetencionConCodigo ;
   private String AV31Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A38SubTipoConCod1 ;
   private String W26ConCodigo ;
   private String A32TLiqCod ;
   private String Gx_emsg ;
   private String AV16aguiTLiqCod ;
   private String AV23anticTLiqCod ;
   private String AV24varTLiqCod ;
   private String AV14gananciasTLiqCod ;
   private String AV22vacTLiqCod ;
   private String AV27redondeoConCodigo ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char2[] ;
   private String A37TipoConCod ;
   private boolean n38SubTipoConCod1 ;
   private boolean AV28ok ;
   private String A41ConDescrip ;
   private String AV25sacConDescrip ;
   private String AV26sacProporConDescrip ;
   private IDataStoreProvider pr_default ;
   private String[] P00UD2_A26ConCodigo ;
   private int[] P00UD2_A3CliCod ;
   private String[] P00UD2_A38SubTipoConCod1 ;
   private boolean[] P00UD2_n38SubTipoConCod1 ;
   private String[] P00UD2_A41ConDescrip ;
   private String[] P00UD4_A26ConCodigo ;
   private int[] P00UD4_A3CliCod ;
   private String[] P00UD4_A41ConDescrip ;
   private String[] P00UD6_A26ConCodigo ;
   private int[] P00UD6_A3CliCod ;
   private String[] P00UD6_A41ConDescrip ;
   private int[] P00UD9_A3CliCod ;
   private String[] P00UD9_A32TLiqCod ;
   private String[] P00UD10_A26ConCodigo ;
   private int[] P00UD10_A3CliCod ;
   private String[] P00UD10_A37TipoConCod ;
   private byte[] P00UD10_A162ConVigencia ;
   private GXSimpleCollection<String> AV11TLiqCod ;
   private GXSimpleCollection<String> AV21todasTLiqCod ;
   private GXSimpleCollection<String> AV19collectionTLiqCod ;
   private GXSimpleCollection<String> GXv_objcol_char5[] ;
}

final  class inicializarconceptotipoliqparaganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UD2", "SELECT ConCodigo, CliCod, SubTipoConCod1, ConDescrip FROM Concepto WHERE (CliCod = ?) AND (SubTipoConCod1 = ( ?) or SubTipoConCod1 = ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00UD3", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00UD4", "SELECT ConCodigo, CliCod, ConDescrip FROM Concepto WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00UD5", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00UD6", "SELECT ConCodigo, CliCod, ConDescrip FROM Concepto WHERE (CliCod = ?) AND (ConDescrip = ( ?) or ConDescrip = ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00UD7", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00UD8", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00UD9", "SELECT CliCod, TLiqCod FROM TipoLiquidacion WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00UD10", "SELECT ConCodigo, CliCod, TipoConCod, ConVigencia FROM Concepto WHERE (CliCod = ?) AND (TipoConCod = ( 'REM_ARG') or TipoConCod = ( 'NRE_ARG')) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00UD11", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               stmt.setVarchar(3, (String)parms[2], 400);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

