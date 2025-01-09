package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18 extends GxUserType
{
   public Sdtpresentacion_1_18( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18.class));
   }

   public Sdtpresentacion_1_18( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18");
   }

   public Sdtpresentacion_1_18( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18");
   }

   public Sdtpresentacion_1_18( StructSdtpresentacion_1_18 struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "periodo") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_Periodo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nroPresentacion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_Nropresentacion = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fechaPresentacion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtpresentacion_1_18_Fechapresentacion = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_Sdtpresentacion_1_18_Fechapresentacion_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtpresentacion_1_18_Fechapresentacion_N = (byte)(0) ;
                  gxTv_Sdtpresentacion_1_18_Fechapresentacion = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "empleado") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Empleado == null )
               {
                  gxTv_Sdtpresentacion_1_18_Empleado = new web.Sdtpresentacion_1_18_empleado(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtpresentacion_1_18_Empleado.readxml(oReader, "empleado") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cargasFamilia") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Cargasfamilia == null )
               {
                  gxTv_Sdtpresentacion_1_18_Cargasfamilia = new GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia>(web.Sdtpresentacion_1_18_cargaFamilia.class, "presentacion_1_18.cargaFamilia", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_Cargasfamilia.readxmlcollection(oReader, "cargasFamilia", "cargaFamilia") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "cargasFamilia") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ganLiqOtrosEmpEnt") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Ganliqotrosempent == null )
               {
                  gxTv_Sdtpresentacion_1_18_Ganliqotrosempent = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt>(web.Sdtpresentacion_1_18_empEnt.class, "presentacion_1_18.empEnt", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_Ganliqotrosempent.readxmlcollection(oReader, "ganLiqOtrosEmpEnt", "empEnt") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ganLiqOtrosEmpEnt") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "deducciones") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Deducciones == null )
               {
                  gxTv_Sdtpresentacion_1_18_Deducciones = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion>(web.Sdtpresentacion_1_18_deduccion.class, "presentacion_1_18.deduccion", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_Deducciones.readxmlcollection(oReader, "deducciones", "deduccion") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "deducciones") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ajustes") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Ajustes == null )
               {
                  gxTv_Sdtpresentacion_1_18_Ajustes = new GXBaseCollection<web.Sdtpresentacion_1_18_ajuste>(web.Sdtpresentacion_1_18_ajuste.class, "presentacion_1_18.ajuste", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_Ajustes.readxmlcollection(oReader, "ajustes", "ajuste") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ajustes") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "retPerPagos") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Retperpagos == null )
               {
                  gxTv_Sdtpresentacion_1_18_Retperpagos = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago>(web.Sdtpresentacion_1_18_retPerPago.class, "presentacion_1_18.retPerPago", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_Retperpagos.readxmlcollection(oReader, "retPerPagos", "retPerPago") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "retPerPagos") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "datosAdicionales") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_Datosadicionales == null )
               {
                  gxTv_Sdtpresentacion_1_18_Datosadicionales = new GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional>(web.Sdtpresentacion_1_18_datoAdicional.class, "presentacion_1_18.datoAdicional", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_Datosadicionales.readxmlcollection(oReader, "datosAdicionales", "datoAdicional") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "datosAdicionales") )
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
         sName = "presentacion" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "" ;
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
      oWriter.writeElement("periodo", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_Periodo, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nroPresentacion", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_Nropresentacion, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_Sdtpresentacion_1_18_Fechapresentacion) && ( gxTv_Sdtpresentacion_1_18_Fechapresentacion_N == 1 ) )
      {
         oWriter.writeElement("fechaPresentacion", "");
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtpresentacion_1_18_Fechapresentacion), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtpresentacion_1_18_Fechapresentacion), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtpresentacion_1_18_Fechapresentacion), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtpresentacion_1_18_Fechapresentacion), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtpresentacion_1_18_Fechapresentacion), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtpresentacion_1_18_Fechapresentacion), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("fechaPresentacion", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "") != 0 )
         {
            oWriter.writeAttribute("xmlns", "");
         }
      }
      if ( gxTv_Sdtpresentacion_1_18_Empleado != null )
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
         gxTv_Sdtpresentacion_1_18_Empleado.writexml(oWriter, "empleado", sNameSpace1);
      }
      if ( gxTv_Sdtpresentacion_1_18_Cargasfamilia != null )
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
         gxTv_Sdtpresentacion_1_18_Cargasfamilia.writexmlcollection(oWriter, "cargasFamilia", sNameSpace1, "cargaFamilia", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_Ganliqotrosempent != null )
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
         gxTv_Sdtpresentacion_1_18_Ganliqotrosempent.writexmlcollection(oWriter, "ganLiqOtrosEmpEnt", sNameSpace1, "empEnt", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_Deducciones != null )
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
         gxTv_Sdtpresentacion_1_18_Deducciones.writexmlcollection(oWriter, "deducciones", sNameSpace1, "deduccion", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_Ajustes != null )
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
         gxTv_Sdtpresentacion_1_18_Ajustes.writexmlcollection(oWriter, "ajustes", sNameSpace1, "ajuste", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_Retperpagos != null )
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
         gxTv_Sdtpresentacion_1_18_Retperpagos.writexmlcollection(oWriter, "retPerPagos", sNameSpace1, "retPerPago", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_Datosadicionales != null )
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
         gxTv_Sdtpresentacion_1_18_Datosadicionales.writexmlcollection(oWriter, "datosAdicionales", sNameSpace1, "datoAdicional", "");
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
      AddObjectProperty("periodo", gxTv_Sdtpresentacion_1_18_Periodo, false, false);
      AddObjectProperty("nroPresentacion", gxTv_Sdtpresentacion_1_18_Nropresentacion, false, false);
      datetime_STZ = gxTv_Sdtpresentacion_1_18_Fechapresentacion ;
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
      AddObjectProperty("fechaPresentacion", sDateCnv, false, false);
      if ( gxTv_Sdtpresentacion_1_18_Empleado != null )
      {
         AddObjectProperty("empleado", gxTv_Sdtpresentacion_1_18_Empleado, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_Cargasfamilia != null )
      {
         AddObjectProperty("cargasFamilia", gxTv_Sdtpresentacion_1_18_Cargasfamilia, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_Ganliqotrosempent != null )
      {
         AddObjectProperty("ganLiqOtrosEmpEnt", gxTv_Sdtpresentacion_1_18_Ganliqotrosempent, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_Deducciones != null )
      {
         AddObjectProperty("deducciones", gxTv_Sdtpresentacion_1_18_Deducciones, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_Ajustes != null )
      {
         AddObjectProperty("ajustes", gxTv_Sdtpresentacion_1_18_Ajustes, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_Retperpagos != null )
      {
         AddObjectProperty("retPerPagos", gxTv_Sdtpresentacion_1_18_Retperpagos, false, false);
      }
      if ( gxTv_Sdtpresentacion_1_18_Datosadicionales != null )
      {
         AddObjectProperty("datosAdicionales", gxTv_Sdtpresentacion_1_18_Datosadicionales, false, false);
      }
   }

   public short getgxTv_Sdtpresentacion_1_18_Periodo( )
   {
      return gxTv_Sdtpresentacion_1_18_Periodo ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Periodo( short value )
   {
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Periodo = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Nropresentacion( )
   {
      return gxTv_Sdtpresentacion_1_18_Nropresentacion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Nropresentacion( byte value )
   {
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Nropresentacion = value ;
   }

   public java.util.Date getgxTv_Sdtpresentacion_1_18_Fechapresentacion( )
   {
      return gxTv_Sdtpresentacion_1_18_Fechapresentacion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Fechapresentacion( java.util.Date value )
   {
      gxTv_Sdtpresentacion_1_18_Fechapresentacion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Fechapresentacion = value ;
   }

   public web.Sdtpresentacion_1_18_empleado getgxTv_Sdtpresentacion_1_18_Empleado( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Empleado == null )
      {
         gxTv_Sdtpresentacion_1_18_Empleado = new web.Sdtpresentacion_1_18_empleado(remoteHandle, context);
      }
      gxTv_Sdtpresentacion_1_18_Empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Empleado ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Empleado( web.Sdtpresentacion_1_18_empleado value )
   {
      gxTv_Sdtpresentacion_1_18_Empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Empleado = value;
   }

   public void setgxTv_Sdtpresentacion_1_18_Empleado_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Empleado_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Empleado = (web.Sdtpresentacion_1_18_empleado)null;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Empleado_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Empleado == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Empleado_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Empleado_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia> getgxTv_Sdtpresentacion_1_18_Cargasfamilia( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Cargasfamilia == null )
      {
         gxTv_Sdtpresentacion_1_18_Cargasfamilia = new GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia>(web.Sdtpresentacion_1_18_cargaFamilia.class, "presentacion_1_18.cargaFamilia", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_Cargasfamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Cargasfamilia ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Cargasfamilia( GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia> value )
   {
      gxTv_Sdtpresentacion_1_18_Cargasfamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Cargasfamilia = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Cargasfamilia_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Cargasfamilia_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Cargasfamilia = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Cargasfamilia_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Cargasfamilia == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Cargasfamilia_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Cargasfamilia_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_empEnt> getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Ganliqotrosempent == null )
      {
         gxTv_Sdtpresentacion_1_18_Ganliqotrosempent = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt>(web.Sdtpresentacion_1_18_empEnt.class, "presentacion_1_18.empEnt", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Ganliqotrosempent ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Ganliqotrosempent( GXBaseCollection<web.Sdtpresentacion_1_18_empEnt> value )
   {
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Ganliqotrosempent_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Ganliqotrosempent == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_deduccion> getgxTv_Sdtpresentacion_1_18_Deducciones( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Deducciones == null )
      {
         gxTv_Sdtpresentacion_1_18_Deducciones = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion>(web.Sdtpresentacion_1_18_deduccion.class, "presentacion_1_18.deduccion", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_Deducciones_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Deducciones ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Deducciones( GXBaseCollection<web.Sdtpresentacion_1_18_deduccion> value )
   {
      gxTv_Sdtpresentacion_1_18_Deducciones_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Deducciones = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Deducciones_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Deducciones_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Deducciones = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Deducciones_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Deducciones == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Deducciones_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Deducciones_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_ajuste> getgxTv_Sdtpresentacion_1_18_Ajustes( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Ajustes == null )
      {
         gxTv_Sdtpresentacion_1_18_Ajustes = new GXBaseCollection<web.Sdtpresentacion_1_18_ajuste>(web.Sdtpresentacion_1_18_ajuste.class, "presentacion_1_18.ajuste", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_Ajustes_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Ajustes ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Ajustes( GXBaseCollection<web.Sdtpresentacion_1_18_ajuste> value )
   {
      gxTv_Sdtpresentacion_1_18_Ajustes_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Ajustes = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Ajustes_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Ajustes_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Ajustes = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Ajustes_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Ajustes == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Ajustes_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Ajustes_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago> getgxTv_Sdtpresentacion_1_18_Retperpagos( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Retperpagos == null )
      {
         gxTv_Sdtpresentacion_1_18_Retperpagos = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago>(web.Sdtpresentacion_1_18_retPerPago.class, "presentacion_1_18.retPerPago", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_Retperpagos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Retperpagos ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Retperpagos( GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago> value )
   {
      gxTv_Sdtpresentacion_1_18_Retperpagos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Retperpagos = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Retperpagos_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Retperpagos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Retperpagos = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Retperpagos_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Retperpagos == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Retperpagos_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Retperpagos_N ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional> getgxTv_Sdtpresentacion_1_18_Datosadicionales( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Datosadicionales == null )
      {
         gxTv_Sdtpresentacion_1_18_Datosadicionales = new GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional>(web.Sdtpresentacion_1_18_datoAdicional.class, "presentacion_1_18.datoAdicional", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_Datosadicionales_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_Datosadicionales ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Datosadicionales( GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional> value )
   {
      gxTv_Sdtpresentacion_1_18_Datosadicionales_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Datosadicionales = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_Datosadicionales_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_Datosadicionales_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Datosadicionales = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_Datosadicionales_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_Datosadicionales == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_Datosadicionales_N( )
   {
      return gxTv_Sdtpresentacion_1_18_Datosadicionales_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Fechapresentacion = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtpresentacion_1_18_Fechapresentacion_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Empleado_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Cargasfamilia_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Deducciones_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Ajustes_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Retperpagos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Datosadicionales_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_N ;
   }

   public web.Sdtpresentacion_1_18 Clone( )
   {
      return (web.Sdtpresentacion_1_18)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18 struct )
   {
      setgxTv_Sdtpresentacion_1_18_Periodo(struct.getPeriodo());
      setgxTv_Sdtpresentacion_1_18_Nropresentacion(struct.getNropresentacion());
      if ( struct.gxTv_Sdtpresentacion_1_18_Fechapresentacion_N == 0 )
      {
         setgxTv_Sdtpresentacion_1_18_Fechapresentacion(struct.getFechapresentacion());
      }
      setgxTv_Sdtpresentacion_1_18_Empleado(new web.Sdtpresentacion_1_18_empleado(struct.getEmpleado()));
      GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia> gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia>(web.Sdtpresentacion_1_18_cargaFamilia.class, "presentacion_1_18.cargaFamilia", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_cargaFamilia> gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux1 = struct.getCargasfamilia();
      if (gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux.add(new web.Sdtpresentacion_1_18_cargaFamilia(gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_Cargasfamilia(gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_empEnt> gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt>(web.Sdtpresentacion_1_18_empEnt.class, "presentacion_1_18.empEnt", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_empEnt> gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux1 = struct.getGanliqotrosempent();
      if (gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux.add(new web.Sdtpresentacion_1_18_empEnt(gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_Ganliqotrosempent(gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_deduccion> gxTv_Sdtpresentacion_1_18_Deducciones_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_deduccion>(web.Sdtpresentacion_1_18_deduccion.class, "presentacion_1_18.deduccion", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_deduccion> gxTv_Sdtpresentacion_1_18_Deducciones_aux1 = struct.getDeducciones();
      if (gxTv_Sdtpresentacion_1_18_Deducciones_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_Deducciones_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_Deducciones_aux.add(new web.Sdtpresentacion_1_18_deduccion(gxTv_Sdtpresentacion_1_18_Deducciones_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_Deducciones(gxTv_Sdtpresentacion_1_18_Deducciones_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_ajuste> gxTv_Sdtpresentacion_1_18_Ajustes_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_ajuste>(web.Sdtpresentacion_1_18_ajuste.class, "presentacion_1_18.ajuste", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_ajuste> gxTv_Sdtpresentacion_1_18_Ajustes_aux1 = struct.getAjustes();
      if (gxTv_Sdtpresentacion_1_18_Ajustes_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_Ajustes_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_Ajustes_aux.add(new web.Sdtpresentacion_1_18_ajuste(gxTv_Sdtpresentacion_1_18_Ajustes_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_Ajustes(gxTv_Sdtpresentacion_1_18_Ajustes_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago> gxTv_Sdtpresentacion_1_18_Retperpagos_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago>(web.Sdtpresentacion_1_18_retPerPago.class, "presentacion_1_18.retPerPago", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_retPerPago> gxTv_Sdtpresentacion_1_18_Retperpagos_aux1 = struct.getRetperpagos();
      if (gxTv_Sdtpresentacion_1_18_Retperpagos_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_Retperpagos_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_Retperpagos_aux.add(new web.Sdtpresentacion_1_18_retPerPago(gxTv_Sdtpresentacion_1_18_Retperpagos_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_Retperpagos(gxTv_Sdtpresentacion_1_18_Retperpagos_aux);
      GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional> gxTv_Sdtpresentacion_1_18_Datosadicionales_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional>(web.Sdtpresentacion_1_18_datoAdicional.class, "presentacion_1_18.datoAdicional", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_datoAdicional> gxTv_Sdtpresentacion_1_18_Datosadicionales_aux1 = struct.getDatosadicionales();
      if (gxTv_Sdtpresentacion_1_18_Datosadicionales_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_Datosadicionales_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_Datosadicionales_aux.add(new web.Sdtpresentacion_1_18_datoAdicional(gxTv_Sdtpresentacion_1_18_Datosadicionales_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_Datosadicionales(gxTv_Sdtpresentacion_1_18_Datosadicionales_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18 getStruct( )
   {
      web.StructSdtpresentacion_1_18 struct = new web.StructSdtpresentacion_1_18 ();
      struct.setPeriodo(getgxTv_Sdtpresentacion_1_18_Periodo());
      struct.setNropresentacion(getgxTv_Sdtpresentacion_1_18_Nropresentacion());
      if ( gxTv_Sdtpresentacion_1_18_Fechapresentacion_N == 0 )
      {
         struct.setFechapresentacion(getgxTv_Sdtpresentacion_1_18_Fechapresentacion());
      }
      struct.setEmpleado(getgxTv_Sdtpresentacion_1_18_Empleado().getStruct());
      struct.setCargasfamilia(getgxTv_Sdtpresentacion_1_18_Cargasfamilia().getStruct());
      struct.setGanliqotrosempent(getgxTv_Sdtpresentacion_1_18_Ganliqotrosempent().getStruct());
      struct.setDeducciones(getgxTv_Sdtpresentacion_1_18_Deducciones().getStruct());
      struct.setAjustes(getgxTv_Sdtpresentacion_1_18_Ajustes().getStruct());
      struct.setRetperpagos(getgxTv_Sdtpresentacion_1_18_Retperpagos().getStruct());
      struct.setDatosadicionales(getgxTv_Sdtpresentacion_1_18_Datosadicionales().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Nropresentacion ;
   protected byte gxTv_Sdtpresentacion_1_18_Fechapresentacion_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Empleado_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Cargasfamilia_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Deducciones_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Ajustes_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Retperpagos_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Datosadicionales_N ;
   protected short gxTv_Sdtpresentacion_1_18_Periodo ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtpresentacion_1_18_Fechapresentacion ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia> gxTv_Sdtpresentacion_1_18_Cargasfamilia_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_empEnt> gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_deduccion> gxTv_Sdtpresentacion_1_18_Deducciones_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_ajuste> gxTv_Sdtpresentacion_1_18_Ajustes_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago> gxTv_Sdtpresentacion_1_18_Retperpagos_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional> gxTv_Sdtpresentacion_1_18_Datosadicionales_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_cargaFamilia> gxTv_Sdtpresentacion_1_18_Cargasfamilia=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_empEnt> gxTv_Sdtpresentacion_1_18_Ganliqotrosempent=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_deduccion> gxTv_Sdtpresentacion_1_18_Deducciones=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_ajuste> gxTv_Sdtpresentacion_1_18_Ajustes=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_retPerPago> gxTv_Sdtpresentacion_1_18_Retperpagos=null ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_datoAdicional> gxTv_Sdtpresentacion_1_18_Datosadicionales=null ;
   protected web.Sdtpresentacion_1_18_empleado gxTv_Sdtpresentacion_1_18_Empleado=null ;
}

