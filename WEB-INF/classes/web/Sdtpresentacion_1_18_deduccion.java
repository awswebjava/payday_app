package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_deduccion extends GxUserType
{
   public Sdtpresentacion_1_18_deduccion( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_deduccion.class));
   }

   public Sdtpresentacion_1_18_deduccion( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_deduccion");
   }

   public Sdtpresentacion_1_18_deduccion( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_deduccion");
   }

   public Sdtpresentacion_1_18_deduccion( StructSdtpresentacion_1_18_deduccion struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      if ( oReader.existsAttribute("tipo") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_deduccion_Tipo = oReader.getAttributeByName("tipo") ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipoDoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nroDoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "denominacion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_deduccion_Denominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descBasica") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_deduccion_Descbasica = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descAdicional") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_deduccion_Descadicional = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "montoTotal") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_deduccion_Montototal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detalles") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_deduccion_Detalles == null )
               {
                  gxTv_Sdtpresentacion_1_18_deduccion_Detalles = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle>(web.Sdtpresentacion_1_18_deduccion_detalle.class, "presentacion_1_18.deduccion.detalle", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_deduccion_Detalles.readxmlcollection(oReader, "detalles", "detalle") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "detalles") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "periodos") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_deduccion_Periodos == null )
               {
                  gxTv_Sdtpresentacion_1_18_deduccion_Periodos = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo>(web.Sdtpresentacion_1_18_deduccion_periodo.class, "presentacion_1_18.deduccion.periodo", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_deduccion_Periodos.readxmlcollection(oReader, "periodos", "periodo") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "periodos") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "presentacion_1_18.deduccion" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeAttribute("tipo", gxTv_Sdtpresentacion_1_18_deduccion_Tipo);
      oWriter.writeElement("tipoDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nroDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("denominacion", gxTv_Sdtpresentacion_1_18_deduccion_Denominacion);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("descBasica", gxTv_Sdtpresentacion_1_18_deduccion_Descbasica);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("descAdicional", gxTv_Sdtpresentacion_1_18_deduccion_Descadicional);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("montoTotal", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_deduccion_Montototal, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Detalles != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_Sdtpresentacion_1_18_deduccion_Detalles.writexmlcollection(oWriter, "detalles", sNameSpace1, "detalle", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Periodos != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_Sdtpresentacion_1_18_deduccion_Periodos.writexmlcollection(oWriter, "periodos", sNameSpace1, "periodo", "");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("tipo", gxTv_Sdtpresentacion_1_18_deduccion_Tipo, false, false);
      AddObjectProperty("tipoDoc", gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc, false, false);
      AddObjectProperty("nroDoc", gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc, false, false);
      AddObjectProperty("denominacion", gxTv_Sdtpresentacion_1_18_deduccion_Denominacion, false, false);
      AddObjectProperty("descBasica", gxTv_Sdtpresentacion_1_18_deduccion_Descbasica, false, false);
      AddObjectProperty("descAdicional", gxTv_Sdtpresentacion_1_18_deduccion_Descadicional, false, false);
      AddObjectProperty("montoTotal", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_deduccion_Montototal, 18, 2)), false, false);
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Detalles != null )
      {
         AddObjectProperty("detalles", gxTv_Sdtpresentacion_1_18_deduccion_Detalles, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Periodos != null )
      {
         AddObjectProperty("periodos", gxTv_Sdtpresentacion_1_18_deduccion_Periodos, false, false);
      }
   }

   public String getgxTv_Sdtpresentacion_1_18_deduccion_Tipo( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Tipo ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Tipo( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Tipo = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_deduccion_Tipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Tipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc = value ;
   }

   public long getgxTv_Sdtpresentacion_1_18_deduccion_Nrodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Nrodoc( long value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_deduccion_Denominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Denominacion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Denominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Denominacion = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_deduccion_Descbasica( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Descbasica ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Descbasica( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descbasica = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_deduccion_Descadicional( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Descadicional ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Descadicional( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descadicional = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_deduccion_Montototal( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Montototal ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Montototal( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Montototal = value ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle> getgxTv_Sdtpresentacion_1_18_deduccion_Detalles( )
   {
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Detalles == null )
      {
         gxTv_Sdtpresentacion_1_18_deduccion_Detalles = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle>(web.Sdtpresentacion_1_18_deduccion_detalle.class, "presentacion_1_18.deduccion.detalle", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_deduccion_Detalles ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Detalles( GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle> value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Detalles_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_deduccion_Detalles_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Detalles == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_deduccion_Detalles_N( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo> getgxTv_Sdtpresentacion_1_18_deduccion_Periodos( )
   {
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Periodos == null )
      {
         gxTv_Sdtpresentacion_1_18_deduccion_Periodos = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo>(web.Sdtpresentacion_1_18_deduccion_periodo.class, "presentacion_1_18.deduccion.periodo", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_deduccion_Periodos ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Periodos( GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo> value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_Periodos_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_deduccion_Periodos_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_deduccion_Periodos == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_deduccion_Periodos_N( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Tipo = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descbasica = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descadicional = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Montototal = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_N ;
   }

   public web.Sdtpresentacion_1_18_deduccion Clone( )
   {
      return (web.Sdtpresentacion_1_18_deduccion)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_deduccion struct )
   {
      setgxTv_Sdtpresentacion_1_18_deduccion_Tipo(struct.getTipo());
      setgxTv_Sdtpresentacion_1_18_deduccion_Tipodoc(struct.getTipodoc());
      setgxTv_Sdtpresentacion_1_18_deduccion_Nrodoc(struct.getNrodoc());
      setgxTv_Sdtpresentacion_1_18_deduccion_Denominacion(struct.getDenominacion());
      setgxTv_Sdtpresentacion_1_18_deduccion_Descbasica(struct.getDescbasica());
      setgxTv_Sdtpresentacion_1_18_deduccion_Descadicional(struct.getDescadicional());
      setgxTv_Sdtpresentacion_1_18_deduccion_Montototal(struct.getMontototal());
      GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle> gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle>(web.Sdtpresentacion_1_18_deduccion_detalle.class, "presentacion_1_18.deduccion.detalle", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_deduccion_detalle> gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux1 = struct.getDetalles();
      if (gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux.add(new web.Sdtpresentacion_1_18_deduccion_detalle(gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_deduccion_Detalles(gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo> gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo>(web.Sdtpresentacion_1_18_deduccion_periodo.class, "presentacion_1_18.deduccion.periodo", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_deduccion_periodo> gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux1 = struct.getPeriodos();
      if (gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux.add(new web.Sdtpresentacion_1_18_deduccion_periodo(gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_deduccion_Periodos(gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_deduccion getStruct( )
   {
      web.StructSdtpresentacion_1_18_deduccion struct = new web.StructSdtpresentacion_1_18_deduccion ();
      struct.setTipo(getgxTv_Sdtpresentacion_1_18_deduccion_Tipo());
      struct.setTipodoc(getgxTv_Sdtpresentacion_1_18_deduccion_Tipodoc());
      struct.setNrodoc(getgxTv_Sdtpresentacion_1_18_deduccion_Nrodoc());
      struct.setDenominacion(getgxTv_Sdtpresentacion_1_18_deduccion_Denominacion());
      struct.setDescbasica(getgxTv_Sdtpresentacion_1_18_deduccion_Descbasica());
      struct.setDescadicional(getgxTv_Sdtpresentacion_1_18_deduccion_Descadicional());
      struct.setMontototal(getgxTv_Sdtpresentacion_1_18_deduccion_Montototal());
      struct.setDetalles(getgxTv_Sdtpresentacion_1_18_deduccion_Detalles().getStruct());
      struct.setPeriodos(getgxTv_Sdtpresentacion_1_18_deduccion_Periodos().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_deduccion_N ;
   protected byte gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N ;
   protected byte gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_deduccion_Montototal ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Tipo ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Denominacion ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Descbasica ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Descadicional ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle> gxTv_Sdtpresentacion_1_18_deduccion_Detalles_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo> gxTv_Sdtpresentacion_1_18_deduccion_Periodos_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_detalle> gxTv_Sdtpresentacion_1_18_deduccion_Detalles=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_deduccion_periodo> gxTv_Sdtpresentacion_1_18_deduccion_Periodos=null ;
}

