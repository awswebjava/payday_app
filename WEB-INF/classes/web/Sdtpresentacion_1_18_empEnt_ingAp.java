package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_empEnt_ingAp extends GxUserType
{
   public Sdtpresentacion_1_18_empEnt_ingAp( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_empEnt_ingAp.class));
   }

   public Sdtpresentacion_1_18_empEnt_ingAp( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_empEnt_ingAp");
   }

   public Sdtpresentacion_1_18_empEnt_ingAp( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_empEnt_ingAp");
   }

   public Sdtpresentacion_1_18_empEnt_ingAp( StructSdtpresentacion_1_18_empEnt_ingAp struct )
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
      if ( oReader.existsAttribute("mes") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes = (byte)(getnumericvalue(oReader.getAttributeByName("mes"))) ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "obraSoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "segSoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sind") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ganBrut") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "retGan") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "retribNoHab") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sac") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "horasExtGr") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ajuste") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "exeNoAlc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "horasExtEx") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "matDid") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "gastosMovViat") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "bonosProd") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fallosCaja") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "conSimNat") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "remunExentaLey27549") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549 = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "suplemParticLey19101") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101 = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "teletrabajoExento") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "presentacion_1_18.empEnt.ingAp" ;
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
      oWriter.writeAttribute("mes", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes, 2, 0)));
      oWriter.writeElement("obraSoc", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("segSoc", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("sind", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("ganBrut", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("retGan", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("retribNoHab", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("sac", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("horasExtGr", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("ajuste", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("exeNoAlc", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("horasExtEx", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("matDid", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("gastosMovViat", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("bonosProd", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("fallosCaja", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("conSimNat", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("remunExentaLey27549", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("suplemParticLey19101", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101, 18, 2)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("teletrabajoExento", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento, 18, 2)));
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
      AddObjectProperty("mes", gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes, false, false);
      AddObjectProperty("obraSoc", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc, 18, 2)), false, false);
      AddObjectProperty("segSoc", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc, 18, 2)), false, false);
      AddObjectProperty("sind", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind, 18, 2)), false, false);
      AddObjectProperty("ganBrut", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut, 18, 2)), false, false);
      AddObjectProperty("retGan", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan, 18, 2)), false, false);
      AddObjectProperty("retribNoHab", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab, 18, 2)), false, false);
      AddObjectProperty("sac", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac, 18, 2)), false, false);
      AddObjectProperty("horasExtGr", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr, 18, 2)), false, false);
      AddObjectProperty("ajuste", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste, 18, 2)), false, false);
      AddObjectProperty("exeNoAlc", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc, 18, 2)), false, false);
      AddObjectProperty("horasExtEx", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex, 18, 2)), false, false);
      AddObjectProperty("matDid", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid, 18, 2)), false, false);
      AddObjectProperty("gastosMovViat", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat, 18, 2)), false, false);
      AddObjectProperty("bonosProd", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod, 18, 2)), false, false);
      AddObjectProperty("fallosCaja", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja, 18, 2)), false, false);
      AddObjectProperty("conSimNat", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat, 18, 2)), false, false);
      AddObjectProperty("remunExentaLey27549", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549, 18, 2)), false, false);
      AddObjectProperty("suplemParticLey19101", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101, 18, 2)), false, false);
      AddObjectProperty("teletrabajoExento", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento, 18, 2)), false, false);
   }

   public byte getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549 ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549 = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101 ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101 = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549 = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101 = DecimalUtil.ZERO ;
      gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N ;
   }

   public web.Sdtpresentacion_1_18_empEnt_ingAp Clone( )
   {
      return (web.Sdtpresentacion_1_18_empEnt_ingAp)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_empEnt_ingAp struct )
   {
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes(struct.getMes());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc(struct.getObrasoc());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc(struct.getSegsoc());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind(struct.getSind());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut(struct.getGanbrut());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan(struct.getRetgan());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab(struct.getRetribnohab());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac(struct.getSac());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr(struct.getHorasextgr());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste(struct.getAjuste());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc(struct.getExenoalc());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex(struct.getHorasextex());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid(struct.getMatdid());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat(struct.getGastosmovviat());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod(struct.getBonosprod());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja(struct.getFalloscaja());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat(struct.getConsimnat());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549(struct.getRemunexentaley27549());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101(struct.getSuplemparticley19101());
      setgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento(struct.getTeletrabajoexento());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_empEnt_ingAp getStruct( )
   {
      web.StructSdtpresentacion_1_18_empEnt_ingAp struct = new web.StructSdtpresentacion_1_18_empEnt_ingAp ();
      struct.setMes(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes());
      struct.setObrasoc(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc());
      struct.setSegsoc(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc());
      struct.setSind(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind());
      struct.setGanbrut(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut());
      struct.setRetgan(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan());
      struct.setRetribnohab(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab());
      struct.setSac(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac());
      struct.setHorasextgr(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr());
      struct.setAjuste(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste());
      struct.setExenoalc(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc());
      struct.setHorasextex(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex());
      struct.setMatdid(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid());
      struct.setGastosmovviat(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat());
      struct.setBonosprod(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod());
      struct.setFalloscaja(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja());
      struct.setConsimnat(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat());
      struct.setRemunexentaley27549(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549());
      struct.setSuplemparticley19101(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101());
      struct.setTeletrabajoexento(getgxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Mes ;
   protected byte gxTv_Sdtpresentacion_1_18_empEnt_ingAp_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Obrasoc ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Segsoc ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sind ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ganbrut ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retgan ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Retribnohab ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Sac ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextgr ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Ajuste ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Exenoalc ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Horasextex ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Matdid ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Gastosmovviat ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Bonosprod ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Falloscaja ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Consimnat ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Remunexentaley27549 ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Suplemparticley19101 ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_empEnt_ingAp_Teletrabajoexento ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

