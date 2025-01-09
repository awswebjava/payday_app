package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_import_LegFam_sdt_import_LegFamItem extends GxUserType
{
   public Sdtsdt_import_LegFam_sdt_import_LegFamItem( )
   {
      this(  new ModelContext(Sdtsdt_import_LegFam_sdt_import_LegFamItem.class));
   }

   public Sdtsdt_import_LegFam_sdt_import_LegFamItem( ModelContext context )
   {
      super( context, "Sdtsdt_import_LegFam_sdt_import_LegFamItem");
   }

   public Sdtsdt_import_LegFam_sdt_import_LegFamItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_import_LegFam_sdt_import_LegFamItem");
   }

   public Sdtsdt_import_LegFam_sdt_import_LegFamItem( StructSdtsdt_import_LegFam_sdt_import_LegFamItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod") )
            {
               gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap") )
            {
               gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNroDoc") )
            {
               gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamTomaDeducImpGan") )
            {
               gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAdherente") )
            {
               gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac = GXutil.nullDate() ;
                  gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N = (byte)(0) ;
                  gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNomApe") )
            {
               gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape = oReader.getValue() ;
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
         sName = "sdt_import_LegFam.sdt_import_LegFamItem" ;
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
      oWriter.writeElement("ParCod", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamDiscap", GXutil.booltostr( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamNroDoc", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamTomaDeducImpGan", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamAdherente", GXutil.booltostr( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac)) && ( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N == 1 ) )
      {
         oWriter.writeElement("FamFecNac", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FamFecNac", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("FamNomApe", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("ParCod", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod, false, false);
      AddObjectProperty("FamDiscap", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap, false, false);
      AddObjectProperty("FamNroDoc", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc, false, false);
      AddObjectProperty("FamTomaDeducImpGan", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan, false, false);
      AddObjectProperty("FamAdherente", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FamFecNac", sDateCnv, false, false);
      AddObjectProperty("FamNomApe", gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape, false, false);
   }

   public String getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod( String value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod = value ;
   }

   public boolean getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap( boolean value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap = value ;
   }

   public String getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc( String value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan = value ;
   }

   public boolean getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente( boolean value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac( java.util.Date value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac = value ;
   }

   public String getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape ;
   }

   public void setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape( String value )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(0) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod = "" ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N = (byte)(1) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc = "" ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac = GXutil.nullDate() ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N = (byte)(1) ;
      gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N ;
   }

   public web.Sdtsdt_import_LegFam_sdt_import_LegFamItem Clone( )
   {
      return (web.Sdtsdt_import_LegFam_sdt_import_LegFamItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_import_LegFam_sdt_import_LegFamItem struct )
   {
      setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod(struct.getParcod());
      setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap(struct.getFamdiscap());
      setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc(struct.getFamnrodoc());
      setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan(struct.getFamtomadeducimpgan());
      setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente(struct.getFamadherente());
      if ( struct.gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N == 0 )
      {
         setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac(struct.getFamfecnac());
      }
      setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape(struct.getFamnomape());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_import_LegFam_sdt_import_LegFamItem getStruct( )
   {
      web.StructSdtsdt_import_LegFam_sdt_import_LegFamItem struct = new web.StructSdtsdt_import_LegFam_sdt_import_LegFamItem ();
      struct.setParcod(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod());
      struct.setFamdiscap(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap());
      struct.setFamnrodoc(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc());
      struct.setFamtomadeducimpgan(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan());
      struct.setFamadherente(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente());
      if ( gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N == 0 )
      {
         struct.setFamfecnac(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac());
      }
      struct.setFamnomape(getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_N ;
   protected byte gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan ;
   protected String gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod ;
   protected String gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac ;
   protected boolean gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap ;
   protected boolean gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape ;
}

