package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_cargaFamilia extends GxUserType
{
   public Sdtpresentacion_1_18_cargaFamilia( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_cargaFamilia.class));
   }

   public Sdtpresentacion_1_18_cargaFamilia( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_cargaFamilia");
   }

   public Sdtpresentacion_1_18_cargaFamilia( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_cargaFamilia");
   }

   public Sdtpresentacion_1_18_cargaFamilia( StructSdtpresentacion_1_18_cargaFamilia struct )
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
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nroDoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "apellido") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nombre") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fechaNac") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N = (byte)(0) ;
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "mesDesde") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "mesHasta") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parentesco") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "vigenteProximosPeriodos") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fechaLimite") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N = (byte)(0) ;
                  gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "porcentajeDeduccion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "presentacion_1_18.cargaFamilia" ;
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
      oWriter.writeElement("tipoDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nroDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("apellido", gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nombre", gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac) && ( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N == 1 ) )
      {
         oWriter.writeElement("fechaNac", "");
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("fechaNac", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      oWriter.writeElement("mesDesde", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("mesHasta", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("parentesco", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("vigenteProximosPeriodos", gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite) && ( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N == 1 ) )
      {
         oWriter.writeElement("fechaLimite", "");
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("fechaLimite", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      oWriter.writeElement("porcentajeDeduccion", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
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
      AddObjectProperty("tipoDoc", gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc, false, false);
      AddObjectProperty("nroDoc", gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc, false, false);
      AddObjectProperty("apellido", gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido, false, false);
      AddObjectProperty("nombre", gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre, false, false);
      datetime_STZ = gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("fechaNac", sDateCnv, false, false);
      AddObjectProperty("mesDesde", gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde, false, false);
      AddObjectProperty("mesHasta", gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta, false, false);
      AddObjectProperty("parentesco", gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco, false, false);
      AddObjectProperty("vigenteProximosPeriodos", gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos, false, false);
      datetime_STZ = gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("fechaLimite", sDateCnv, false, false);
      AddObjectProperty("porcentajeDeduccion", gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion, false, false);
   }

   public byte getgxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc = value ;
   }

   public long getgxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc( long value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido( String value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre = value ;
   }

   public java.util.Date getgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac( java.util.Date value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos( String value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos = value ;
   }

   public java.util.Date getgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite( java.util.Date value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido = "" ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos = "" ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_N ;
   }

   public web.Sdtpresentacion_1_18_cargaFamilia Clone( )
   {
      return (web.Sdtpresentacion_1_18_cargaFamilia)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_cargaFamilia struct )
   {
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc(struct.getTipodoc());
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc(struct.getNrodoc());
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido(struct.getApellido());
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre(struct.getNombre());
      if ( struct.gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N == 0 )
      {
         setgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac(struct.getFechanac());
      }
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde(struct.getMesdesde());
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta(struct.getMeshasta());
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco(struct.getParentesco());
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos(struct.getVigenteproximosperiodos());
      if ( struct.gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N == 0 )
      {
         setgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite(struct.getFechalimite());
      }
      setgxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion(struct.getPorcentajededuccion());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_cargaFamilia getStruct( )
   {
      web.StructSdtpresentacion_1_18_cargaFamilia struct = new web.StructSdtpresentacion_1_18_cargaFamilia ();
      struct.setTipodoc(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc());
      struct.setNrodoc(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc());
      struct.setApellido(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido());
      struct.setNombre(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre());
      if ( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N == 0 )
      {
         struct.setFechanac(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac());
      }
      struct.setMesdesde(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde());
      struct.setMeshasta(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta());
      struct.setParentesco(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco());
      struct.setVigenteproximosperiodos(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos());
      if ( gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N == 0 )
      {
         struct.setFechalimite(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite());
      }
      struct.setPorcentajededuccion(getgxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_N ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc ;
   protected String gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido ;
   protected String gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac ;
   protected java.util.Date gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
}

