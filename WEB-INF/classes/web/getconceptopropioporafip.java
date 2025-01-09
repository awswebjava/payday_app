package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptopropioporafip extends GXProcedure
{
   public getconceptopropioporafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptopropioporafip.class ), "" );
   }

   public getconceptopropioporafip( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      getconceptopropioporafip.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             String[] aP6 )
   {
      getconceptopropioporafip.this.AV8CliCod = aP0;
      getconceptopropioporafip.this.AV9ConAFIPConcepto = aP1;
      getconceptopropioporafip.this.AV16ImpLiqConExtDescrip = aP2;
      getconceptopropioporafip.this.AV29AfipConTipoConCod = aP3;
      getconceptopropioporafip.this.aP4 = aP4;
      getconceptopropioporafip.this.aP5 = aP5;
      getconceptopropioporafip.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "!&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &ConAFIPConcepto ", "")+AV9ConAFIPConcepto) ;
      AV28i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV26buscoConNada = false ;
         AV13exactoEs = false ;
         AV24palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV16ImpLiqConExtDescrip," ")) ;
         if ( AV24palabras.size() != 1 )
         {
            AV22externoDescrip = GXutil.trim( AV16ImpLiqConExtDescrip) ;
         }
         else
         {
            AV22externoDescrip = GXutil.substring( AV16ImpLiqConExtDescrip, 1, GXutil.len( AV16ImpLiqConExtDescrip)-3) ;
         }
         AV25auxExternoDescrip = GXutil.trim( AV22externoDescrip) ;
         AV27aux2ExternoDescrip = GXutil.strReplace( AV22externoDescrip, httpContext.getMessage( " DE ", ""), " ") ;
         AV27aux2ExternoDescrip = GXutil.strReplace( AV27aux2ExternoDescrip, httpContext.getMessage( " de ", ""), " ") ;
         AV27aux2ExternoDescrip = GXutil.strReplace( AV27aux2ExternoDescrip, ".", "") ;
         AV27aux2ExternoDescrip = GXutil.strReplace( AV27aux2ExternoDescrip, ",", "") ;
         if ( AV28i <= 2 )
         {
            if ( ! (GXutil.strcmp("", AV29AfipConTipoConCod)==0) )
            {
               AV19TipoConCod = AV29AfipConTipoConCod ;
            }
            else
            {
               /* Execute user subroutine: 'BUSCAR TIPO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         while ( ! AV26buscoConNada && ! AV13exactoEs )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&i ", "")+GXutil.trim( GXutil.str( AV28i, 4, 0))+httpContext.getMessage( " busca &externoDescrip \"", "")+GXutil.trim( AV22externoDescrip)+httpContext.getMessage( "\" &auxExternoDescrip ", "")+GXutil.trim( AV25auxExternoDescrip)+httpContext.getMessage( " &ConAFIPConcepto ", "")+AV9ConAFIPConcepto+httpContext.getMessage( " &&TipoConCod ", "")+AV19TipoConCod) ;
            AV31encontro = false ;
            AV35GXLvl40 = (byte)(0) ;
            pr_default.dynParam(0, new Object[]{ new Object[]{
                                                 Short.valueOf(AV28i) ,
                                                 A1648ConCodAfip ,
                                                 AV9ConAFIPConcepto ,
                                                 A37TipoConCod ,
                                                 AV19TipoConCod ,
                                                 A2185ConDescripSinAc ,
                                                 AV22externoDescrip ,
                                                 A2187ConOblPalabra ,
                                                 AV16ImpLiqConExtDescrip ,
                                                 Boolean.valueOf(A150ConHabilitado) ,
                                                 Integer.valueOf(AV8CliCod) ,
                                                 Integer.valueOf(A3CliCod) } ,
                                                 new int[]{
                                                 TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                                 TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                                 }
            });
            lV22externoDescrip = GXutil.concat( GXutil.rtrim( AV22externoDescrip), "%", "") ;
            /* Using cursor P00N52 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV16ImpLiqConExtDescrip, AV9ConAFIPConcepto, AV19TipoConCod, lV22externoDescrip, AV22externoDescrip});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A2187ConOblPalabra = P00N52_A2187ConOblPalabra[0] ;
               n2187ConOblPalabra = P00N52_n2187ConOblPalabra[0] ;
               A150ConHabilitado = P00N52_A150ConHabilitado[0] ;
               A2185ConDescripSinAc = P00N52_A2185ConDescripSinAc[0] ;
               A37TipoConCod = P00N52_A37TipoConCod[0] ;
               A1648ConCodAfip = P00N52_A1648ConCodAfip[0] ;
               A3CliCod = P00N52_A3CliCod[0] ;
               A26ConCodigo = P00N52_A26ConCodigo[0] ;
               A1769ConCntPa = P00N52_A1769ConCntPa[0] ;
               A39SubTipoConCod2 = P00N52_A39SubTipoConCod2[0] ;
               n39SubTipoConCod2 = P00N52_n39SubTipoConCod2[0] ;
               AV35GXLvl40 = (byte)(1) ;
               AV13exactoEs = true ;
               if ( ( GXutil.strcmp(GXutil.trim( AV9ConAFIPConcepto), "120001") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV9ConAFIPConcepto), "120002") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV9ConAFIPConcepto), "120003") != 0 ) )
               {
                  if ( AV28i == 3 )
                  {
                     AV30ImpLiqConWarning = httpContext.getMessage( "El concepto de AFIP coincide pero no la descripción", "") ;
                  }
                  else
                  {
                     if ( ( AV28i == 1 ) && ( GXutil.strcmp(A37TipoConCod, AV19TipoConCod) != 0 ) )
                     {
                        AV30ImpLiqConWarning = httpContext.getMessage( "El concepto de AFIP y la descripción coinciden, pero no el tipo de concepto", "") ;
                     }
                  }
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "encuentra ", "")) ;
               AV31encontro = true ;
               AV10ConCodPropio = A26ConCodigo ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( AV35GXLvl40 == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "none &externoDescrip \"", "")+GXutil.lower( GXutil.trim( AV22externoDescrip))+"\"") ;
               if ( GXutil.strSearch( AV27aux2ExternoDescrip, " ", 1) != 0 )
               {
                  AV24palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV27aux2ExternoDescrip," ")) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "none 2 &palabras.Count ", "")+GXutil.trim( GXutil.str( AV24palabras.size(), 9, 0))) ;
                  if ( AV24palabras.size() > 0 )
                  {
                     AV22externoDescrip = GXutil.trim( (String)AV24palabras.elementAt(-1+AV24palabras.size())) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&aux2ExternoDescrip ", "")+AV27aux2ExternoDescrip+httpContext.getMessage( " &externoDescrip ", "")+AV22externoDescrip) ;
                     AV27aux2ExternoDescrip = GXutil.strReplace( AV27aux2ExternoDescrip, AV22externoDescrip, "") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "con reemplazo &&aux2ExternoDescrip ", "")+AV27aux2ExternoDescrip) ;
                     AV27aux2ExternoDescrip = GXutil.trim( AV27aux2ExternoDescrip) ;
                     if ( GXutil.len( AV22externoDescrip) > 5 )
                     {
                        AV22externoDescrip = GXutil.substring( AV22externoDescrip, 1, GXutil.len( AV22externoDescrip)-3) ;
                     }
                  }
                  else
                  {
                     AV26buscoConNada = true ;
                  }
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "noine 3 &aux2ExternoDescrip ", "")+AV27aux2ExternoDescrip) ;
                  if ( (GXutil.strcmp("", AV27aux2ExternoDescrip)==0) )
                  {
                     if ( (GXutil.strcmp("", AV22externoDescrip)==0) )
                     {
                        AV26buscoConNada = true ;
                     }
                     else
                     {
                        AV22externoDescrip = "" ;
                     }
                  }
                  else
                  {
                     AV22externoDescrip = GXutil.trim( AV27aux2ExternoDescrip) ;
                     if ( GXutil.len( AV22externoDescrip) > 5 )
                     {
                        AV22externoDescrip = GXutil.substring( AV22externoDescrip, 1, GXutil.len( AV22externoDescrip)-1) ;
                     }
                     AV27aux2ExternoDescrip = "" ;
                  }
               }
            }
         }
         if ( AV28i == 3 )
         {
            if (true) break;
         }
         else
         {
            if ( AV13exactoEs )
            {
               if (true) break;
            }
         }
         AV28i = (short)(AV28i+1) ;
      }
      if ( ! AV13exactoEs )
      {
         /* Execute user subroutine: 'BUSCAR TIPO' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (GXutil.strcmp("", AV19TipoConCod)==0) )
         {
            /* Execute user subroutine: 'BUSCAR CONCEPTO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'BUSCAR CONCEPTO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "buscar concepto 1 &SubTipoConCod1 ", "")+AV14SubTipoConCod1) ;
      AV36GXLvl152 = (byte)(0) ;
      /* Using cursor P00N53 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), AV19TipoConCod, AV14SubTipoConCod1});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P00N53_A3CliCod[0] ;
         A38SubTipoConCod1 = P00N53_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00N53_n38SubTipoConCod1[0] ;
         A37TipoConCod = P00N53_A37TipoConCod[0] ;
         A375SubTRangoDesde = P00N53_A375SubTRangoDesde[0] ;
         A41ConDescrip = P00N53_A41ConDescrip[0] ;
         A26ConCodigo = P00N53_A26ConCodigo[0] ;
         A1769ConCntPa = P00N53_A1769ConCntPa[0] ;
         A39SubTipoConCod2 = P00N53_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P00N53_n39SubTipoConCod2[0] ;
         A375SubTRangoDesde = P00N53_A375SubTRangoDesde[0] ;
         AV36GXLvl152 = (byte)(1) ;
         AV18SubTRangoDesde = (int)(A375SubTRangoDesde-1000) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "buscar concepto ", "")+GXutil.trim( GXutil.str( AV18SubTRangoDesde, 8, 0))+httpContext.getMessage( " SubTRangoDesde ", "")+GXutil.trim( GXutil.str( A375SubTRangoDesde, 8, 0))+httpContext.getMessage( " SubTipoConCod2 ", "")+GXutil.trim( A39SubTipoConCod2)+httpContext.getMessage( " ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " CONESCRIP ", "")+GXutil.trim( A41ConDescrip)) ;
         if ( ( AV18SubTRangoDesde == CommonUtil.decimalVal( A39SubTipoConCod2, ".").doubleValue() ) || ( AV18SubTRangoDesde == CommonUtil.decimalVal( A38SubTipoConCod1, ".").doubleValue() ) )
         {
            AV10ConCodPropio = A26ConCodigo ;
            if ( ( GXutil.strcmp(GXutil.trim( AV9ConAFIPConcepto), "120001") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV9ConAFIPConcepto), "120002") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV9ConAFIPConcepto), "120003") != 0 ) )
            {
               AV30ImpLiqConWarning = httpContext.getMessage( "El concepto coincide en tipo y en rango de códigos de AFIP, pero no se encontró el código de AFIP exacto en el sistema", "") ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "buscar concepto &ConCodPropio ", "")+AV10ConCodPropio) ;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV36GXLvl152 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "BUSCAR CONCEPTO NONE", "")) ;
      }
   }

   public void S121( )
   {
      /* 'BUSCAR TIPO' Routine */
      returnInSub = false ;
      AV19TipoConCod = "" ;
      AV17ImpLiqConAfipCodNum = (int)(GXutil.lval( AV9ConAFIPConcepto)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "none &ImpLiqConAfipCodNum ", "")+GXutil.trim( GXutil.str( AV17ImpLiqConAfipCodNum, 6, 0))) ;
      AV37GXLvl180 = (byte)(0) ;
      /* Using cursor P00N54 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV17ImpLiqConAfipCodNum), Integer.valueOf(AV17ImpLiqConAfipCodNum)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A376SubTRangoHasta = P00N54_A376SubTRangoHasta[0] ;
         A375SubTRangoDesde = P00N54_A375SubTRangoDesde[0] ;
         A37TipoConCod = P00N54_A37TipoConCod[0] ;
         A38SubTipoConCod1 = P00N54_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00N54_n38SubTipoConCod1[0] ;
         AV37GXLvl180 = (byte)(1) ;
         AV19TipoConCod = A37TipoConCod ;
         AV14SubTipoConCod1 = A38SubTipoConCod1 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "encuentra 2 SubTipoConCod1 ", "")+A38SubTipoConCod1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV37GXLvl180 == 0 )
      {
         AV17ImpLiqConAfipCodNum = (int)(AV17ImpLiqConAfipCodNum+1000) ;
         AV38GXLvl190 = (byte)(0) ;
         /* Using cursor P00N55 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV17ImpLiqConAfipCodNum), Integer.valueOf(AV17ImpLiqConAfipCodNum)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A376SubTRangoHasta = P00N55_A376SubTRangoHasta[0] ;
            A375SubTRangoDesde = P00N55_A375SubTRangoDesde[0] ;
            A37TipoConCod = P00N55_A37TipoConCod[0] ;
            A38SubTipoConCod1 = P00N55_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P00N55_n38SubTipoConCod1[0] ;
            AV38GXLvl190 = (byte)(1) ;
            AV19TipoConCod = A37TipoConCod ;
            AV14SubTipoConCod1 = A38SubTipoConCod1 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "SEGUNDA OPORTUNIDAD encuentra 2 SubTipoConCod1 ", "")+A38SubTipoConCod1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( AV38GXLvl190 == 0 )
         {
         }
      }
   }

   protected void cleanup( )
   {
      this.aP4[0] = getconceptopropioporafip.this.AV10ConCodPropio;
      this.aP5[0] = getconceptopropioporafip.this.AV13exactoEs;
      this.aP6[0] = getconceptopropioporafip.this.AV30ImpLiqConWarning;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodPropio = "" ;
      AV30ImpLiqConWarning = "" ;
      AV34Pgmname = "" ;
      AV24palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22externoDescrip = "" ;
      AV25auxExternoDescrip = "" ;
      AV27aux2ExternoDescrip = "" ;
      AV19TipoConCod = "" ;
      scmdbuf = "" ;
      lV22externoDescrip = "" ;
      A1648ConCodAfip = "" ;
      A37TipoConCod = "" ;
      A2185ConDescripSinAc = "" ;
      A2187ConOblPalabra = "" ;
      P00N52_A2187ConOblPalabra = new String[] {""} ;
      P00N52_n2187ConOblPalabra = new boolean[] {false} ;
      P00N52_A150ConHabilitado = new boolean[] {false} ;
      P00N52_A2185ConDescripSinAc = new String[] {""} ;
      P00N52_A37TipoConCod = new String[] {""} ;
      P00N52_A1648ConCodAfip = new String[] {""} ;
      P00N52_A3CliCod = new int[1] ;
      P00N52_A26ConCodigo = new String[] {""} ;
      P00N52_A1769ConCntPa = new byte[1] ;
      P00N52_A39SubTipoConCod2 = new String[] {""} ;
      P00N52_n39SubTipoConCod2 = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A39SubTipoConCod2 = "" ;
      A41ConDescrip = "" ;
      A38SubTipoConCod1 = "" ;
      AV14SubTipoConCod1 = "" ;
      P00N53_A3CliCod = new int[1] ;
      P00N53_A38SubTipoConCod1 = new String[] {""} ;
      P00N53_n38SubTipoConCod1 = new boolean[] {false} ;
      P00N53_A37TipoConCod = new String[] {""} ;
      P00N53_A375SubTRangoDesde = new int[1] ;
      P00N53_A41ConDescrip = new String[] {""} ;
      P00N53_A26ConCodigo = new String[] {""} ;
      P00N53_A1769ConCntPa = new byte[1] ;
      P00N53_A39SubTipoConCod2 = new String[] {""} ;
      P00N53_n39SubTipoConCod2 = new boolean[] {false} ;
      P00N54_A376SubTRangoHasta = new int[1] ;
      P00N54_A375SubTRangoDesde = new int[1] ;
      P00N54_A37TipoConCod = new String[] {""} ;
      P00N54_A38SubTipoConCod1 = new String[] {""} ;
      P00N54_n38SubTipoConCod1 = new boolean[] {false} ;
      P00N55_A376SubTRangoHasta = new int[1] ;
      P00N55_A375SubTRangoDesde = new int[1] ;
      P00N55_A37TipoConCod = new String[] {""} ;
      P00N55_A38SubTipoConCod1 = new String[] {""} ;
      P00N55_n38SubTipoConCod1 = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptopropioporafip__default(),
         new Object[] {
             new Object[] {
            P00N52_A2187ConOblPalabra, P00N52_n2187ConOblPalabra, P00N52_A150ConHabilitado, P00N52_A2185ConDescripSinAc, P00N52_A37TipoConCod, P00N52_A1648ConCodAfip, P00N52_A3CliCod, P00N52_A26ConCodigo, P00N52_A1769ConCntPa, P00N52_A39SubTipoConCod2,
            P00N52_n39SubTipoConCod2
            }
            , new Object[] {
            P00N53_A3CliCod, P00N53_A38SubTipoConCod1, P00N53_n38SubTipoConCod1, P00N53_A37TipoConCod, P00N53_A375SubTRangoDesde, P00N53_A41ConDescrip, P00N53_A26ConCodigo, P00N53_A1769ConCntPa, P00N53_A39SubTipoConCod2, P00N53_n39SubTipoConCod2
            }
            , new Object[] {
            P00N54_A376SubTRangoHasta, P00N54_A375SubTRangoDesde, P00N54_A37TipoConCod, P00N54_A38SubTipoConCod1
            }
            , new Object[] {
            P00N55_A376SubTRangoHasta, P00N55_A375SubTRangoDesde, P00N55_A37TipoConCod, P00N55_A38SubTipoConCod1
            }
         }
      );
      AV34Pgmname = "getConceptoPropioPorAfip" ;
      /* GeneXus formulas. */
      AV34Pgmname = "getConceptoPropioPorAfip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV35GXLvl40 ;
   private byte A1769ConCntPa ;
   private byte AV36GXLvl152 ;
   private byte AV37GXLvl180 ;
   private byte AV38GXLvl190 ;
   private short AV28i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int A375SubTRangoDesde ;
   private int AV18SubTRangoDesde ;
   private int AV17ImpLiqConAfipCodNum ;
   private int A376SubTRangoHasta ;
   private String AV9ConAFIPConcepto ;
   private String AV29AfipConTipoConCod ;
   private String AV10ConCodPropio ;
   private String AV34Pgmname ;
   private String AV19TipoConCod ;
   private String scmdbuf ;
   private String A1648ConCodAfip ;
   private String A37TipoConCod ;
   private String A2187ConOblPalabra ;
   private String A26ConCodigo ;
   private String A39SubTipoConCod2 ;
   private String A38SubTipoConCod1 ;
   private String AV14SubTipoConCod1 ;
   private boolean AV13exactoEs ;
   private boolean gxexitloop ;
   private boolean AV26buscoConNada ;
   private boolean returnInSub ;
   private boolean AV31encontro ;
   private boolean A150ConHabilitado ;
   private boolean n2187ConOblPalabra ;
   private boolean n39SubTipoConCod2 ;
   private boolean n38SubTipoConCod1 ;
   private String AV16ImpLiqConExtDescrip ;
   private String AV30ImpLiqConWarning ;
   private String AV22externoDescrip ;
   private String AV25auxExternoDescrip ;
   private String AV27aux2ExternoDescrip ;
   private String lV22externoDescrip ;
   private String A2185ConDescripSinAc ;
   private String A41ConDescrip ;
   private String[] aP6 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00N52_A2187ConOblPalabra ;
   private boolean[] P00N52_n2187ConOblPalabra ;
   private boolean[] P00N52_A150ConHabilitado ;
   private String[] P00N52_A2185ConDescripSinAc ;
   private String[] P00N52_A37TipoConCod ;
   private String[] P00N52_A1648ConCodAfip ;
   private int[] P00N52_A3CliCod ;
   private String[] P00N52_A26ConCodigo ;
   private byte[] P00N52_A1769ConCntPa ;
   private String[] P00N52_A39SubTipoConCod2 ;
   private boolean[] P00N52_n39SubTipoConCod2 ;
   private int[] P00N53_A3CliCod ;
   private String[] P00N53_A38SubTipoConCod1 ;
   private boolean[] P00N53_n38SubTipoConCod1 ;
   private String[] P00N53_A37TipoConCod ;
   private int[] P00N53_A375SubTRangoDesde ;
   private String[] P00N53_A41ConDescrip ;
   private String[] P00N53_A26ConCodigo ;
   private byte[] P00N53_A1769ConCntPa ;
   private String[] P00N53_A39SubTipoConCod2 ;
   private boolean[] P00N53_n39SubTipoConCod2 ;
   private int[] P00N54_A376SubTRangoHasta ;
   private int[] P00N54_A375SubTRangoDesde ;
   private String[] P00N54_A37TipoConCod ;
   private String[] P00N54_A38SubTipoConCod1 ;
   private boolean[] P00N54_n38SubTipoConCod1 ;
   private int[] P00N55_A376SubTRangoHasta ;
   private int[] P00N55_A375SubTRangoDesde ;
   private String[] P00N55_A37TipoConCod ;
   private String[] P00N55_A38SubTipoConCod1 ;
   private boolean[] P00N55_n38SubTipoConCod1 ;
   private GXSimpleCollection<String> AV24palabras ;
}

final  class getconceptopropioporafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00N52( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV28i ,
                                          String A1648ConCodAfip ,
                                          String AV9ConAFIPConcepto ,
                                          String A37TipoConCod ,
                                          String AV19TipoConCod ,
                                          String A2185ConDescripSinAc ,
                                          String AV22externoDescrip ,
                                          String A2187ConOblPalabra ,
                                          String AV16ImpLiqConExtDescrip ,
                                          boolean A150ConHabilitado ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[6];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ConOblPalabra, ConHabilitado, ConDescripSinAc, TipoConCod, ConCodAfip, CliCod, ConCodigo, ConCntPa, SubTipoConCod2 FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "((char_length(trim(trailing ' ' from ConOblPalabra))=0) or ConOblPalabra IS NULL or POSITION(RTRIM(UPPER(RTRIM(LTRIM(ConOblPalabra)))) IN UPPER(RTRIM(LTRIM(?)))) <> 0)");
      addWhere(sWhereString, "(ConHabilitado = TRUE)");
      if ( ( AV28i == 1 ) || ( AV28i == 3 ) )
      {
         addWhere(sWhereString, "(ConCodAfip = ( ?))");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( AV28i == 2 )
      {
         addWhere(sWhereString, "(TipoConCod = ( ?))");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( AV28i < 3 )
      {
         addWhere(sWhereString, "(LOWER(ConDescripSinAc) like '%' || LOWER(RTRIM(LTRIM(?))) and Not (char_length(trim(trailing ' ' from ?))=0))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
         GXv_int1[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SubTipoConCod2, ConCntPa" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P00N52(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Boolean) dynConstraints[9]).booleanValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00N52", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00N53", "SELECT T1.CliCod, T1.SubTipoConCod1, T1.TipoConCod, T2.SubTRangoDesde, T1.ConDescrip, T1.ConCodigo, T1.ConCntPa, T1.SubTipoConCod2 FROM (Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) WHERE T1.CliCod = ? and T1.TipoConCod = ( ?) and T1.SubTipoConCod1 = ( ?) ORDER BY T1.CliCod, T1.TipoConCod, T1.SubTipoConCod1, T1.SubTipoConCod2, T1.ConCntPa  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00N54", "SELECT SubTRangoHasta, SubTRangoDesde, TipoConCod, SubTipoConCod1 FROM TipoDeConceptoSubtipo1 WHERE (SubTRangoDesde <= ?) AND (SubTRangoHasta >= ?) ORDER BY TipoConCod, SubTipoConCod1  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00N55", "SELECT SubTRangoHasta, SubTRangoDesde, TipoConCod, SubTipoConCod1 FROM TipoDeConceptoSubtipo1 WHERE (SubTRangoDesde <= ?) AND (SubTRangoHasta >= ?) ORDER BY TipoConCod, SubTipoConCod1  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((boolean[]) buf[2])[0] = rslt.getBoolean(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 6);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 10);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 400);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

